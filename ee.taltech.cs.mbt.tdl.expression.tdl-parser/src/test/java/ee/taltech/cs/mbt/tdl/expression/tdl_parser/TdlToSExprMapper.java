package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.commons.test_utils.junit.junit_utils.Mapper;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.nodes.AbsSExpressionNode;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairsNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.FalseNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.TrueNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class TdlToSExprMapper implements Mapper {
	private class MapperVisitor implements ITdlExpressionVisitor<AbsSExpressionNode> {
		private SExpressionSequenceNode wrapIfNegated(SExpressionSequenceNode sequenceNode, AbsBooleanInternalNode booleanNode) {
			if (booleanNode.isNegated()) {
				return new SExpressionSequenceNode()
						.addChild(new SExpressionStringNode().setString("~"))
						.addChild(sequenceNode);
			}
			return sequenceNode;
		}

		@Override
		public AbsSExpressionNode visitGroup(GroupNode node) {
			return wrapIfNegated(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("()"))
					.addChild(node.getChildContainer().getChild().accept(this)), node);
		}

		@Override
		public AbsSExpressionNode visitConjunction(ConjunctionNode node) {
			return wrapIfNegated(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("&&"))
					.addChild(new SExpressionSequenceNode()
							.addChild(node.getChildContainer().getLeftChild().accept(this))
							.addChild(node.getChildContainer().getRightChild().accept(this))
					), node);
		}

		@Override
		public AbsSExpressionNode visitDisjunction(DisjunctionNode node) {
			return wrapIfNegated(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("||"))
					.addChild(new SExpressionSequenceNode()
							.addChild(node.getChildContainer().getLeftChild().accept(this))
							.addChild(node.getChildContainer().getRightChild().accept(this))
					), node);
		}

		@Override
		public AbsSExpressionNode visitEquivalence(EquivalenceNode node) {
			return wrapIfNegated(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("<=>"))
					.addChild(new SExpressionSequenceNode()
							.addChild(node.getChildContainer().getLeftChild().accept(this))
							.addChild(node.getChildContainer().getRightChild().accept(this))
					), node);
		}

		@Override
		public AbsSExpressionNode visitLeadsTo(LeadsToNode node) {
			return wrapIfNegated(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("~>"))
					.addChild(new SExpressionSequenceNode()
							.addChild(node.getChildContainer().getLeftChild().accept(this))
							.addChild(node.getChildContainer().getRightChild().accept(this))
					), node);
		}

		@Override
		public AbsSExpressionNode visitImplication(ImplicationNode node) {
			return wrapIfNegated(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("==>"))
					.addChild(new SExpressionSequenceNode()
							.addChild(node.getChildContainer().getLeftChild().accept(this))
							.addChild(node.getChildContainer().getRightChild().accept(this))
					), node);
		}

		private SExpressionSequenceNode visitBound(Bound bound) {
			String boundString = null;
			switch (bound.getBoundType()) {
				case LESS_THAN_OR_EQUAL_TO:
					boundString = "<=";
					break;
				case LESS_THAN:
					boundString = "<";
					break;
				case EQUALS:
					boundString = "=";
					break;
				case GREATER_THAN_OR_EQUAL_TO:
					boundString = ">=";
					break;
				case GREATER_THAN:
					boundString = ">";
					break;
				default:
					break;
			}
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(boundString))
					.addChild(new SExpressionStringNode().setString(bound.getBoundValue().toString()));
		}

		@Override
		public AbsSExpressionNode visitBoundedLeadsTo(BoundedLeadsToNode node) {
			return wrapIfNegated(
					new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString("~>"))
							.addChild(new SExpressionSequenceNode()
									.addChild(visitBound(node.getBound()))
									.addChild(node.getChildContainer().getLeftChild().accept(this))
									.addChild(node.getChildContainer().getRightChild().accept(this))
							),
					node
			);
		}

		@Override
		public AbsSExpressionNode visitBoundedRepetition(BoundedRepetitionNode node) {
			return wrapIfNegated(
					new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString("#"))
							.addChild(new SExpressionSequenceNode()
									.addChild(visitBound(node.getBound()))
									.addChild(node.getChildContainer().getChild().accept(this))
							),
					node
			);
		}

		@Override
		public AbsSExpressionNode visitExistentialQuantification(ExistentialQuantificationNode node) {
			return wrapIfNegated(
					new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString("E"))
							.addChild(new SExpressionSequenceNode().addChild(node.getChildContainer().getChild().accept(this))),
					node
			);
		}

		@Override
		public AbsSExpressionNode visitUniversalQuantification(UniversalQuantificationNode node) {
			return wrapIfNegated(
					new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString("A"))
							.addChild(new SExpressionSequenceNode().addChild(node.getChildContainer().getChild().accept(this))),
					node
			);
		}

		@Override
		public AbsSExpressionNode visitAbsoluteComplement(AbsoluteComplementNode node) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("!"))
					.addChild(
							new SExpressionSequenceNode().addChild(
									node.getChildContainer().getChild().accept(this)
							)
					);
		}

		@Override
		public AbsSExpressionNode visitLinkedPairs(LinkedPairsNode node) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(";"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild(node.getChildContainer().getLeftChild().accept(this))
									.addChild(node.getChildContainer().getRightChild().accept(this))
					);
		}

		@Override
		public AbsSExpressionNode visitRelativeComplement(RelativeComplementNode node) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("\\"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild(node.getChildContainer().getLeftChild().accept(this))
									.addChild(node.getChildContainer().getRightChild().accept(this))
					);
		}

		@Override
		public AbsSExpressionNode visitTrapset(TrapsetNode node) {
			return new SExpressionStringNode().setString(node.getName());
		}

		@Override
		public AbsSExpressionNode visitFalse(FalseNode node) {
			return new SExpressionStringNode().setString("FALSE");
		}

		@Override
		public AbsSExpressionNode visitTrue(TrueNode node) {
			return new SExpressionStringNode().setString("TRUE");
		}

		@Override
		public AbsSExpressionNode visitBooleanValueWrapper(BooleanValueWrapperNode node) {
			return node.getChildContainer().getChild().accept(this);
		}

		@Override
		public AbsSExpressionNode visitTrapsetWrapper(TrapsetWrapperNode node) {
			return node.getChildContainer().getChild().accept(this);
		}
	}

	@Override
	public Object map(Object in) {
		if (!(in instanceof TdlExpression))
			throw new IllegalArgumentException(
					"Expected TdlExpression, received " + in.getClass().getSimpleName() + "."
			);
		AbsSExpressionNode sExpr = ((TdlExpression) in).getRootNode().accept(new MapperVisitor());
		return new SExpression().setRoot((SExpressionSequenceNode) sExpr);
	}
}
