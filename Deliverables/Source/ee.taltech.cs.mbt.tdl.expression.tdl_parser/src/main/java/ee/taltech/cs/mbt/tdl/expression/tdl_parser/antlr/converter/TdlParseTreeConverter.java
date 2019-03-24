package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageBaseListener;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.EBoundType;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Stack;

public class TdlParseTreeConverter extends TdlExpressionLanguageBaseListener
	implements IParseTreeConverter<ExpressionTree, ExpressionContext>
{
	private static class RuntimeConversionException extends RuntimeException {
		public RuntimeConversionException(String msg) {
			super(msg);
		}
	}

	private AbsLogicalOperatorNode rootNode;
	private Stack<AbsOperatorNode> parentStack = new Stack<>();
	private Stack<Stack<AbsExpressionNode>> childFrameStack = new Stack<>();
	private boolean negateNextLogicalOperation = false;

	@Override
	public ExpressionTree convert(ExpressionContext rootContext) throws ConversionException {
		try {
			new ParseTreeWalker().walk(this, rootContext);
			return getResult();
		} catch (RuntimeConversionException ex) {
			throw new ConversionException(ex.getMessage());
		}
	}

	@Override
	public void reset() {
		this.rootNode = null;
		this.parentStack.clear();
		this.childFrameStack.clear();
		this.negateNextLogicalOperation = false;
	}

	private ExpressionTree getResult() throws ConversionException {
		if (getRootNode() == null) {
			throw new ConversionException("Parse tree is rootless.");
		}
		return new ExpressionTree(getRootNode());
	}

	private static class BoundVisitor extends TdlExpressionLanguageBaseVisitor<Bound> {
		private Bound bound = new Bound();

		@Override
		public Bound visitLessThanOrEqBound(LessThanOrEqBoundContext ctx) {
			bound.setBoundType(EBoundType.LESS_THAN_OR_EQUAL_TO);
			return bound;
		}

		@Override
		public Bound visitLessThanBound(LessThanBoundContext ctx) {
			bound.setBoundType(EBoundType.LESS_THAN);
			return bound;
		}

		@Override
		public Bound visitGreaterThanOrEqBound(GreaterThanOrEqBoundContext ctx) {
			bound.setBoundType(EBoundType.GREATER_THAN_OR_EQUAL_TO);
			return bound;
		}

		@Override
		public Bound visitGreaterThanBound(GreaterThanBoundContext ctx) {
			bound.setBoundType(EBoundType.GREATER_THAN);
			return bound;
		}

		@Override
		public Bound visitEqualityBound(EqualityBoundContext ctx) {
			bound.setBoundType(EBoundType.EQUALS);
			return bound;
		}
	}

	private Bound extractBound(ParseTree tree) {
		return new BoundVisitor().visit(tree);
	}

	private void handleOperatorNodeEntry(AbsOperatorNode operatorNode) {
		if (operatorNode instanceof AbsLogicalOperatorNode) {
			AbsLogicalOperatorNode logicalOperatorNode = (AbsLogicalOperatorNode) operatorNode;
			logicalOperatorNode.setNegated(negateNextLogicalOperation);
			negateNextLogicalOperation = false;

			if (rootNode == null)
				rootNode = logicalOperatorNode;
		}

		if (!childFrameStack.isEmpty()) {
			childFrameStack.peek().add(operatorNode);
		}

		childFrameStack.push(new Stack<>());
		parentStack.push(operatorNode);
	}

	private void handleOperatorNodeExit() {
		if (parentStack.isEmpty())
			return;

		AbsOperatorNode parentNode = parentStack.pop();
		if (childFrameStack.isEmpty())
			return;

		int arity = parentNode.getOperandContainer().getArity();
		int ordinal = arity - 1;
		Stack<AbsExpressionNode> children = childFrameStack.pop();
		if (children.size() != arity) {
			throw new RuntimeConversionException(
				"Operator node " + parentNode.getClass().getName()
				+ " with arity " + arity
				+ " has been supplied with " + children.size() + " operands."
			);
		}

		while (!children.isEmpty()) {
			AbsExpressionNode childNode = children.pop();
			childNode.setParentNode(parentNode);
			try {
				parentNode.getOperandContainer().setOperand(ordinal, childNode);
				ordinal--;
			} catch (ClassCastException cse) {
				throw new RuntimeConversionException(
						"Expression node " + childNode.getClass().getName()
						+ " cannot be an operand of " + parentNode.getClass().getName()
						+ " at ordinal " + ordinal + "."
					);
			}
		}
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		throw new RuntimeConversionException("Parse tree contains an error node (" + node.getText() + ").");
	}

	private void visitTrapsetSymbols(List<TerminalNode> trapsetTerminals) {
		for (TerminalNode trapsetSymbolTerminal : trapsetTerminals) {
			visitTrapsetSymbol(trapsetSymbolTerminal);
		}
	}

	private void visitTrapsetSymbol(TerminalNode trapsetSymbolTerminal) {
		childFrameStack.peek().add(new TrapsetSymbolNode(trapsetSymbolTerminal.getText()));
	}

	AbsLogicalOperatorNode getRootNode() {
		return this.rootNode;
	}

	@Override
	public void enterNegatedExpression(NegatedExpressionContext ctx) {
		this.negateNextLogicalOperation = Boolean.TRUE;
	}

	@Override
	public void exitNegatedExpression(NegatedExpressionContext ctx) {
		this.negateNextLogicalOperation = Boolean.FALSE;
	}

	@Override
	public void enterLeadsToExpression(LeadsToExpressionContext ctx) {
		handleOperatorNodeEntry(new LeadsToNode());
	}

	@Override
	public void exitLeadsToExpression(LeadsToExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterImplicativeExpression(ImplicativeExpressionContext ctx) {
		handleOperatorNodeEntry(new ImplicationNode());
	}

	@Override
	public void exitImplicativeExpression(ImplicativeExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterConjunctiveExpression(ConjunctiveExpressionContext ctx) {
		handleOperatorNodeEntry(new ConjunctionNode());
	}

	@Override
	public void exitConjunctiveExpression(ConjunctiveExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterDisjunctiveExpression(DisjunctiveExpressionContext ctx) {
		handleOperatorNodeEntry(new DisjunctionNode());
	}

	@Override
	public void exitDisjunctiveExpression(DisjunctiveExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterEquivalenceExpression(EquivalenceExpressionContext ctx) {
		handleOperatorNodeEntry(new EquivalenceNode());
	}

	@Override
	public void exitEquivalenceExpression(EquivalenceExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterConditionalRepetitionExpression(ConditionalRepetitionExpressionContext ctx) {
		BoundedRepetitionNode boundedRepetitionNode = new BoundedRepetitionNode();
		boundedRepetitionNode.setBound(extractBound(ctx.boundOverNaturals()));
		handleOperatorNodeEntry(boundedRepetitionNode);
	}

	@Override
	public void exitConditionalRepetitionExpression(ConditionalRepetitionExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterTimeBoundedLeadsToExpression(TimeBoundedLeadsToExpressionContext ctx) {
		BoundedLeadsToNode boundedLeadsToNode = new BoundedLeadsToNode();
		boundedLeadsToNode.setBound(extractBound(ctx.boundOverNaturals()));
		handleOperatorNodeEntry(boundedLeadsToNode);
	}

	@Override
	public void exitTimeBoundedLeadsToExpression(TimeBoundedLeadsToExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterUniversalTrapsetExpression(UniversalTrapsetExpressionContext ctx) {
		handleOperatorNodeEntry(new UniversalQuantificationNode());
	}

	@Override
	public void exitUniversalTrapsetExpression(UniversalTrapsetExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterExistentialTrapsetExpression(ExistentialTrapsetExpressionContext ctx) {
		handleOperatorNodeEntry(new ExistentialQuantificationNode());
	}

	@Override
	public void exitExistentialTrapsetExpression(ExistentialTrapsetExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterAbsoluteTrapsetComplementExpression(AbsoluteTrapsetComplementExpressionContext ctx) {
		handleOperatorNodeEntry(new AbsoluteComplementNode());
		visitTrapsetSymbol(ctx.TRAPSET_ID());
	}

	@Override
	public void exitAbsoluteTrapsetComplementExpression(AbsoluteTrapsetComplementExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterRelativeTrapsetComplementExpression(RelativeTrapsetComplementExpressionContext ctx) {
		handleOperatorNodeEntry(new RelativeComplementNode());
		visitTrapsetSymbols(ctx.TRAPSET_ID());
	}

	@Override
	public void exitRelativeTrapsetComplementExpression(RelativeTrapsetComplementExpressionContext ctx) {
		handleOperatorNodeExit();
	}

	@Override
	public void enterLinkedTrapsetPairExpression(LinkedTrapsetPairExpressionContext ctx) {
		handleOperatorNodeEntry(new LinkedPairNode());
		visitTrapsetSymbols(ctx.TRAPSET_ID());
	}

	@Override
	public void exitLinkedTrapsetPairExpression(LinkedTrapsetPairExpressionContext ctx) {
		handleOperatorNodeExit();
	}
}
