package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator.extractors;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.EquivalenceNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.GroupNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.IBounded;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairsNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.FalseNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.TrueNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.BinaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf.AbsLeafNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class ExpressionCtxExtractor implements IContextExtractor<TdlExpression>, ITdlExpressionVisitor<ContextBuilder> {
	public static ExpressionCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final ExpressionCtxExtractor INSTANCE = new ExpressionCtxExtractor();

	private ExpressionCtxExtractor() {}

	@Override
	public ContextBuilder extract(TdlExpression expression) {
		return expression.getRootNode().accept(this);
	}

	private ContextBuilder extractBoundCtx(Bound bound) {
		String boundTypeName;
		switch (bound.getBoundType()) {
		case LESS_THAN:
			boundTypeName = "lessThan";
			break;
		case GREATER_THAN:
			boundTypeName = "greaterThan";
			break;
		case GREATER_THAN_OR_EQUAL_TO:
			boundTypeName = "greaterThanOrEqualTo";
			break;
		case LESS_THAN_OR_EQUAL_TO:
			boundTypeName = "lessThanOrEqualTo";
			break;
		case EQUALS:
			boundTypeName = "equals";
			break;
		default:
			boundTypeName = "unknown";
			break;
		}

		return ContextBuilder.newBuilder(boundTypeName)
				.put("boundValue", bound.getBoundValue().toString());
	}

	private <
			C extends AbsExpressionNode,
			T extends AbsBooleanInternalNode<C, UnaryChildContainer<C>>
	> ContextBuilder visitUnaryBooleanNode(String name, T nodeInst) {
		ContextBuilder builder = ContextBuilder.newBuilder(name)
				.put("booleanNode", true)
				.put("negated", nodeInst.isNegated())
				.put("child", nodeInst.getChildContainer().getChild().accept(this));
		if (nodeInst instanceof IBounded) {
			Bound bound = ((IBounded) nodeInst).getBound();
			builder.put("bound", extractBoundCtx(bound));
		}
		return builder;
	}

	private <
			C extends AbsExpressionNode,
			T extends AbsBooleanInternalNode<C, BinaryChildContainer<C>>
	> ContextBuilder visitBinaryBooleanNode(String name, T nodeInst) {
		ContextBuilder builder = ContextBuilder.newBuilder(name)
				.put("booleanNode", true)
				.put("negated", nodeInst.isNegated())
				.put("leftChild", nodeInst.getChildContainer().getLeftChild().accept(this))
				.put("rightChild", nodeInst.getChildContainer().getRightChild().accept(this));
		if (nodeInst instanceof IBounded) {
			Bound bound = ((IBounded) nodeInst).getBound();
			builder.put("bound", extractBoundCtx(bound));
		}
		return builder;
	}

	private <
			T extends AbsTrapsetQuantifierNode
	> ContextBuilder visitTrapsetQuantifier(String name, T nodeInst) {
		return ContextBuilder.newBuilder(name)
				.put("trapsetQuantifier", true)
				.put("negated", nodeInst.isNegated())
				.put("domain", nodeInst.getChildContainer().getChild().accept(this));
	}

	private <
			T extends AbsTrapsetExpressionNode<BinaryChildContainer<TrapsetNode>>
	> ContextBuilder visitBinaryTrapsetExpressionNode(String name, T nodeInst) {
		return ContextBuilder.newBuilder(name)
				.put("trapsetExpression", true)
				.put("leftChild", nodeInst.getChildContainer().getLeftChild().accept(this))
				.put("rightChild", nodeInst.getChildContainer().getRightChild().accept(this));
	}

	private <
			T extends AbsTrapsetExpressionNode<UnaryChildContainer<TrapsetNode>>
	> ContextBuilder visitUnaryTrapsetExpressionNode(String name, T nodeInst) {
		return ContextBuilder.newBuilder(name)
				.put("trapsetExpression", true)
				.put("child", nodeInst.getChildContainer().getChild().accept(this));
	}

	private <
			T extends AbsLeafNode
	> ContextBuilder visitLeaf(String name) {
		return ContextBuilder.newBuilder(name)
				.put("leaf", true);
	}

	@Override
	public ContextBuilder visitBoundedRepetition(BoundedRepetitionNode node) {
		return visitUnaryBooleanNode("boundedRepetition", node);
	}

	@Override
	public ContextBuilder visitConjunction(ConjunctionNode node) {
		return visitBinaryBooleanNode("conjunction", node);
	}

	@Override
	public ContextBuilder visitDisjunction(DisjunctionNode node) {
		return visitBinaryBooleanNode("disjunction", node);
	}

	@Override
	public ContextBuilder visitEquivalence(EquivalenceNode node) {
		return visitBinaryBooleanNode("equivalence", node);
	}

	@Override
	public ContextBuilder visitLeadsTo(LeadsToNode node) {
		return visitBinaryBooleanNode("leadsTo", node);
	}

	@Override
	public ContextBuilder visitImplication(ImplicationNode node) {
		return visitBinaryBooleanNode("implication", node);
	}

	@Override
	public ContextBuilder visitBoundedLeadsTo(BoundedLeadsToNode node) {
		return visitBinaryBooleanNode("boundedLeadsTo", node);
	}

	@Override
	public ContextBuilder visitGroup(GroupNode node) {
		return visitUnaryBooleanNode("group", node);
	}

	@Override
	public ContextBuilder visitBooleanValueWrapper(BooleanValueWrapperNode node) {
		return visitUnaryBooleanNode("valueWrapper", node);
	}

	@Override
	public ContextBuilder visitExistentialQuantification(ExistentialQuantificationNode node) {
		return visitTrapsetQuantifier("existentialTrapsetQuantification", node);
	}

	@Override
	public ContextBuilder visitUniversalQuantification(UniversalQuantificationNode node) {
		return visitTrapsetQuantifier("universalTrapsetQuantification", node);
	}

	@Override
	public ContextBuilder visitTrapsetWrapper(TrapsetWrapperNode node) {
		return visitUnaryTrapsetExpressionNode("trapsetWrapper", node);
	}

	@Override
	public ContextBuilder visitAbsoluteComplement(AbsoluteComplementNode node) {
		return visitUnaryTrapsetExpressionNode("absoluteComplement", node);
	}

	@Override
	public ContextBuilder visitLinkedPairs(LinkedPairsNode node) {
		return visitBinaryTrapsetExpressionNode("linkedPairs", node);
	}

	@Override
	public ContextBuilder visitRelativeComplement(RelativeComplementNode node) {
		return visitBinaryTrapsetExpressionNode("relativeComplement", node);
	}

	@Override
	public ContextBuilder visitTrue(TrueNode node) {
		return visitLeaf("trueValue");
	}

	@Override
	public ContextBuilder visitFalse(FalseNode node) {
		return visitLeaf("falseValue");
	}

	@Override
	public ContextBuilder visitTrapset(TrapsetNode node) {
		return visitLeaf("trapsetName")
				.put("name", node.getName());
	}
}
