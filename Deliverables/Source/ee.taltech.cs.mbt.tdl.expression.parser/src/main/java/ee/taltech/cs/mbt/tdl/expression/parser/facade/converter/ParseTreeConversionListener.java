package ee.taltech.cs.mbt.tdl.expression.parser.facade.converter;

import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageBaseListener;
import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageParser.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.modifier.EBoundType;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Stack;

class ParseTreeConversionListener extends TDLExpressionLanguageBaseListener {
	private ExpressionTree expressionTree;
	private AbsLogicalOperatorNode rootNode;
	private Stack<AbsOperatorNode> operatorCache = new Stack<>();
	private Stack<Stack<AbsExpressionNode>> operandCache = new Stack<>();
	private boolean negationFlag = false;

	private Bound extractBound(ParseTree tree) {
		return new BoundVisitor().visit(tree);
	}

	private void handleOperatorNodeEntry(AbsOperatorNode operatorNode) {
		if (operatorNode instanceof AbsLogicalOperatorNode) {
			AbsLogicalOperatorNode logicalOperatorNode = (AbsLogicalOperatorNode) operatorNode;
			logicalOperatorNode.setNegated(negationFlag);
			negationFlag = false;

			if (rootNode == null)
				rootNode = logicalOperatorNode;
		}

		if (!operandCache.isEmpty()) {
			operandCache.peek().add(operatorNode);
		}

		operandCache.push(new Stack<>());
		operatorCache.push(operatorNode);
	}

	@SuppressWarnings("unchecked")
	private void handleOperatorNodeExit() {
		if (operatorCache.isEmpty())
			return;
		AbsOperatorNode operatorNode = operatorCache.pop();

		if (operandCache.isEmpty())
			return;

		int ordinal = 0;
		Stack<AbsExpressionNode> operands = operandCache.pop();
		while (!operands.isEmpty()) {
			AbsExpressionNode expressionNode = operands.pop();
			expressionNode.setParentNode(operatorNode);
			operatorNode.getOperandContainer().setOperand(ordinal++, expressionNode);
		}

		operandCache.pop();
	}

	private void visitTrapsetSymbols(List<TerminalNode> trapsetTerminals) {
		for (TerminalNode trapsetSymbolTerminal : trapsetTerminals) {
			visitTrapsetSymbol(trapsetSymbolTerminal);
		}
	}

	private void visitTrapsetSymbol(TerminalNode trapsetSymbolTerminal) {
		operandCache.peek().add(new TrapsetSymbolNode(trapsetSymbolTerminal.getText()));
	}

	public AbsLogicalOperatorNode getRootNode() {
		AbsLogicalOperatorNode rootNode = this.rootNode;
		reset();
		return rootNode;
	}

	public void reset() {
		this.negationFlag = false;
		this.operandCache = new Stack<>();
		this.operatorCache = new Stack<>();
		this.rootNode = null;
	}

	@Override
	public void enterNegatedExpression(NegatedExpressionContext ctx) {
		this.negationFlag = Boolean.TRUE;
	}

	@Override
	public void exitNegatedExpression(NegatedExpressionContext ctx) {
		this.negationFlag = Boolean.FALSE;
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

	private static class BoundVisitor extends TDLExpressionLanguageBaseVisitor<Bound> {

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
}
