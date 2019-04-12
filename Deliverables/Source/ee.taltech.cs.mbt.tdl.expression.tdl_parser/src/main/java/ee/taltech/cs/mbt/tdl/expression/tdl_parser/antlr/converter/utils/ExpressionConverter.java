package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter.utils;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

public class ExpressionConverter extends TdlExpressionLanguageBaseVisitor<AbsExpressionNode>
		implements IParseTreeConverter<AbsExpressionNode, ExpressionContext> {
	public static ExpressionConverter getInstance() {
		return INSTANCE;
	}

	private static final ExpressionConverter INSTANCE = new ExpressionConverter();

	private ExpressionConverter() { }

	@Override
	public AbsExpressionNode convert(ExpressionContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public AbsExpressionNode visitLeadsToExpression(LeadsToExpressionContext ctx) {
		LeadsToNode leadsTo = new LeadsToNode();
		leadsTo.getOperandContainer().setLeftOperand(
				(AbsLogicalOperatorNode) ctx.expression(0).accept(this)
		);
		leadsTo.getOperandContainer().setRightOperand(
				(AbsLogicalOperatorNode) ctx.expression(1).accept(this)
		);
		return leadsTo;
	}

	@Override
	public AbsExpressionNode visitImplicativeExpression(ImplicativeExpressionContext ctx) {
		ImplicationNode implication = new ImplicationNode();
		implication.getOperandContainer().setLeftOperand(
				(AbsLogicalOperatorNode) ctx.expression(0).accept(this)
		);
		implication.getOperandContainer().setRightOperand(
				(AbsLogicalOperatorNode) ctx.expression(1).accept(this)
		);
		return implication;
	}

	@Override
	public AbsExpressionNode visitGroupedExpression(GroupedExpressionContext ctx) {
		GroupNode group = new GroupNode();
		group.getOperandContainer().setOperand(
				(AbsLogicalOperatorNode) ctx.expression().accept(this)
		);
		return group;
	}

	@Override
	public AbsExpressionNode visitConjunctiveExpression(ConjunctiveExpressionContext ctx) {
		ConjunctionNode conjunction = new ConjunctionNode();
		conjunction.getOperandContainer().setLeftOperand(
				(AbsLogicalOperatorNode) ctx.expression(0).accept(this)
		);
		conjunction.getOperandContainer().setRightOperand(
				(AbsLogicalOperatorNode) ctx.expression(1).accept(this)
		);
		return conjunction;
	}

	@Override
	public AbsExpressionNode visitDisjunctiveExpression(DisjunctiveExpressionContext ctx) {
		DisjunctionNode disjunction = new DisjunctionNode();
		disjunction.getOperandContainer().setLeftOperand(
				(AbsLogicalOperatorNode) ctx.expression(0).accept(this)
		);
		disjunction.getOperandContainer().setRightOperand(
				(AbsLogicalOperatorNode) ctx.expression(1).accept(this)
		);
		return disjunction;
	}

	@Override
	public AbsExpressionNode visitEquivalenceExpression(EquivalenceExpressionContext ctx) {
		EquivalenceNode equivalence = new EquivalenceNode();
		equivalence.getOperandContainer().setLeftOperand(
				(AbsLogicalOperatorNode) ctx.expression(0).accept(this)
		);
		equivalence.getOperandContainer().setRightOperand(
				(AbsLogicalOperatorNode) ctx.expression(1).accept(this)
		);
		return equivalence;
	}

	@Override
	public AbsExpressionNode visitNegatedExpression(NegatedExpressionContext ctx) {
		AbsLogicalOperatorNode logicalOperator = (AbsLogicalOperatorNode) ctx.expression().accept(this);
		logicalOperator.setNegated(true);
		return logicalOperator;
	}

	@Override
	public AbsExpressionNode visitConditionalRepetitionExpression(ConditionalRepetitionExpressionContext ctx) {
		BoundedRepetitionNode boundedRepetition = new BoundedRepetitionNode();
		boundedRepetition.setBound(BoundConverter.getInstance().convert(ctx.boundOverNaturals()));
		boundedRepetition.getOperandContainer().setOperand(
				(AbsLogicalOperatorNode) ctx.expression().accept(this)
		);
		return boundedRepetition;
	}

	@Override
	public AbsExpressionNode visitTimeBoundedLeadsToExpression(TimeBoundedLeadsToExpressionContext ctx) {
		BoundedLeadsToNode boundedLeadsTo = new BoundedLeadsToNode();
		boundedLeadsTo.setBound(BoundConverter.getInstance().convert(ctx.boundOverNaturals()));
		boundedLeadsTo.getOperandContainer().setLeftOperand(
				(AbsLogicalOperatorNode) ctx.expression(0).accept(this)
		);
		boundedLeadsTo.getOperandContainer().setRightOperand(
				(AbsLogicalOperatorNode) ctx.expression(1).accept(this)
		);
		return boundedLeadsTo;
	}

	@Override
	public AbsExpressionNode visitUniversalTrapsetExpression(UniversalTrapsetExpressionContext ctx) {
		UniversalQuantificationNode universalQuantification = new UniversalQuantificationNode();
		universalQuantification.getOperandContainer().setOperand(
				TrapsetExpressionConverter.getInstance().convert(ctx.trapsetExpression())
		);
		return universalQuantification;
	}

	@Override
	public AbsExpressionNode visitExistentialTrapsetExpression(ExistentialTrapsetExpressionContext ctx) {
		ExistentialQuantificationNode existentialQuantification = new ExistentialQuantificationNode();
		existentialQuantification.getOperandContainer().setOperand(
				TrapsetExpressionConverter.getInstance().convert(ctx.trapsetExpression())
		);
		return existentialQuantification;
	}
}
