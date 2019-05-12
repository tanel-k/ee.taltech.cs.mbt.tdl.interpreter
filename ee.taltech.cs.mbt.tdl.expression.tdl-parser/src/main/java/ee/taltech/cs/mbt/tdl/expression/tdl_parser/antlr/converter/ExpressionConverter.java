package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.ConditionalRepetitionExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.ConjunctiveExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.DisjunctiveExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.EquivalenceExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.ExistentialTrapsetExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.GroupedExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.ImplicativeExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.LeadsToExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.NegatedExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.TimeBoundedLeadsToExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.UniversalTrapsetExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.EquivalenceNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.GroupNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
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
		leadsTo.getChildContainer().setLeftChild(
				(AbsBooleanInternalNode) ctx.expression(0).accept(this)
		);
		leadsTo.getChildContainer().setRightChild(
				(AbsBooleanInternalNode) ctx.expression(1).accept(this)
		);
		return leadsTo;
	}

	@Override
	public AbsExpressionNode visitImplicativeExpression(ImplicativeExpressionContext ctx) {
		ImplicationNode implication = new ImplicationNode();
		implication.getChildContainer().setLeftChild(
				(AbsBooleanInternalNode) ctx.expression(0).accept(this)
		);
		implication.getChildContainer().setRightChild(
				(AbsBooleanInternalNode) ctx.expression(1).accept(this)
		);
		return implication;
	}

	@Override
	public AbsExpressionNode visitGroupedExpression(GroupedExpressionContext ctx) {
		GroupNode group = new GroupNode();
		group.getChildContainer().setChild(
				(AbsBooleanInternalNode) ctx.expression().accept(this)
		);
		return group;
	}

	@Override
	public AbsExpressionNode visitConjunctiveExpression(ConjunctiveExpressionContext ctx) {
		ConjunctionNode conjunction = new ConjunctionNode();
		conjunction.getChildContainer().setLeftChild(
				(AbsBooleanInternalNode) ctx.expression(0).accept(this)
		);
		conjunction.getChildContainer().setRightChild(
				(AbsBooleanInternalNode) ctx.expression(1).accept(this)
		);
		return conjunction;
	}

	@Override
	public AbsExpressionNode visitDisjunctiveExpression(DisjunctiveExpressionContext ctx) {
		DisjunctionNode disjunction = new DisjunctionNode();
		disjunction.getChildContainer().setLeftChild(
				(AbsBooleanInternalNode) ctx.expression(0).accept(this)
		);
		disjunction.getChildContainer().setRightChild(
				(AbsBooleanInternalNode) ctx.expression(1).accept(this)
		);
		return disjunction;
	}

	@Override
	public AbsExpressionNode visitEquivalenceExpression(EquivalenceExpressionContext ctx) {
		EquivalenceNode equivalence = new EquivalenceNode();
		equivalence.getChildContainer().setLeftChild(
				(AbsBooleanInternalNode) ctx.expression(0).accept(this)
		);
		equivalence.getChildContainer().setRightChild(
				(AbsBooleanInternalNode) ctx.expression(1).accept(this)
		);
		return equivalence;
	}

	@Override
	public AbsExpressionNode visitNegatedExpression(NegatedExpressionContext ctx) {
		AbsBooleanInternalNode logicalOperator = (AbsBooleanInternalNode) ctx.expression().accept(this);
		logicalOperator.setNegated(true);
		return logicalOperator;
	}

	@Override
	public AbsExpressionNode visitConditionalRepetitionExpression(ConditionalRepetitionExpressionContext ctx) {
		BoundedRepetitionNode boundedRepetition = new BoundedRepetitionNode();
		boundedRepetition.setBound(BoundConverter.getInstance().convert(ctx.boundOverNaturals()));
		boundedRepetition.getChildContainer().setChild(
				(AbsBooleanInternalNode) ctx.expression().accept(this)
		);
		return boundedRepetition;
	}

	@Override
	public AbsExpressionNode visitTimeBoundedLeadsToExpression(TimeBoundedLeadsToExpressionContext ctx) {
		BoundedLeadsToNode boundedLeadsTo = new BoundedLeadsToNode();
		boundedLeadsTo.setBound(BoundConverter.getInstance().convert(ctx.boundOverNaturals()));
		boundedLeadsTo.getChildContainer().setLeftChild(
				(AbsBooleanInternalNode) ctx.expression(0).accept(this)
		);
		boundedLeadsTo.getChildContainer().setRightChild(
				(AbsBooleanInternalNode) ctx.expression(1).accept(this)
		);
		return boundedLeadsTo;
	}

	@Override
	public AbsExpressionNode visitUniversalTrapsetExpression(UniversalTrapsetExpressionContext ctx) {
		UniversalQuantificationNode universalQuantification = new UniversalQuantificationNode();
		universalQuantification.getChildContainer().setChild(
				TrapsetExpressionConverter.getInstance().convert(ctx.trapsetExpression())
		);
		return universalQuantification;
	}

	@Override
	public AbsExpressionNode visitExistentialTrapsetExpression(ExistentialTrapsetExpressionContext ctx) {
		ExistentialQuantificationNode existentialQuantification = new ExistentialQuantificationNode();
		existentialQuantification.getChildContainer().setChild(
				TrapsetExpressionConverter.getInstance().convert(ctx.trapsetExpression())
		);
		return existentialQuantification;
	}
}
