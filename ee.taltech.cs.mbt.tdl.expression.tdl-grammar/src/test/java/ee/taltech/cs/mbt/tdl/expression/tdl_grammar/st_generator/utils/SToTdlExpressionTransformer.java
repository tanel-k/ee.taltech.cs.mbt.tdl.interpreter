package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.ISExpressionVisitor;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.EBoundType;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairsNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.BinaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;

import java.math.BigInteger;

public class SToTdlExpressionTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements ISExpressionVisitor<AbsExpressionNode> {
		public static final int ORD_ZERO = 0;
		public static final int ORD_ONE = 1;
		public static final int ORD_TWO = 2;

		private void populateBinaryBooleanExprChildContainer(
				BinaryChildContainer<AbsBooleanInternalNode> childContainer, SExpressionSequenceNode node
		) {
			SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
			childContainer
					.setLeftChild((AbsBooleanInternalNode) childSequence.getChildren().get(ORD_ZERO).accept(this))
					.setRightChild((AbsBooleanInternalNode) childSequence.getChildren().get(ORD_ONE).accept(this));
		}

		private void populateUnaryBooleanExprChildContainer(
				UnaryChildContainer<AbsBooleanInternalNode> childContainer, SExpressionSequenceNode node
		) {
			SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
			childContainer
					.setChild((AbsBooleanInternalNode) childSequence.getChildren().get(ORD_ONE).accept(this));
		}

		private void populateTrapsetQuantifierChildContainer(
				UnaryChildContainer<AbsTrapsetExpressionNode> childContainer, SExpressionSequenceNode node
		) {
			SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
			Object transformedChild = childSequence.getChildren().get(ORD_ZERO).accept(this);
			if (transformedChild instanceof TrapsetNode) {
				TrapsetNode trapsetNode = (TrapsetNode) transformedChild;
				transformedChild = new TrapsetWrapperNode();
				((TrapsetWrapperNode) transformedChild).getChildContainer().setChild(trapsetNode);
			}
			childContainer.setChild((AbsTrapsetExpressionNode) transformedChild);
		}

		private void populateBinaryTrapsetExprChildContainer(
				BinaryChildContainer<TrapsetNode> childContainer, SExpressionSequenceNode node
		) {
			SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
			childContainer
					.setLeftChild((TrapsetNode) childSequence.getChildren().get(ORD_ZERO).accept(this))
					.setRightChild((TrapsetNode) childSequence.getChildren().get(ORD_ONE).accept(this));
		}

		private void populateUnaryTrapsetExprChildContainer(
				UnaryChildContainer<TrapsetNode> childContainer, SExpressionSequenceNode node
		) {
			SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
			childContainer.setChild((TrapsetNode) childSequence.getChildren().get(ORD_ZERO).accept(this));
		}

		@Override
		public AbsExpressionNode visitSequence(SExpressionSequenceNode node) {
			SExpressionStringNode stringNode = (SExpressionStringNode) node.getChildren().get(ORD_ZERO);
			AbsExpressionNode expressionNode = null;
			switch (stringNode.getString()) {
			case "==>": {
				expressionNode = new ImplicationNode();
				populateBinaryBooleanExprChildContainer(((ImplicationNode) expressionNode).getChildContainer(), node);
				break;
			}
			case "<=>": {
				expressionNode = new EquivalenceNode();
				populateBinaryBooleanExprChildContainer(((EquivalenceNode) expressionNode).getChildContainer(), node);
				break;
			}
			case "||": {
				expressionNode = new DisjunctionNode();
				populateBinaryBooleanExprChildContainer(((DisjunctionNode) expressionNode).getChildContainer(), node);
				break;
			}
			case "&&": {
				expressionNode = new ConjunctionNode();
				populateBinaryBooleanExprChildContainer(((ConjunctionNode) expressionNode).getChildContainer(), node);
				break;
			}
			case "~>": {
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
				if (childSequence.getChildren().size() == 2) {
					expressionNode = new LeadsToNode();
					populateBinaryBooleanExprChildContainer(((LeadsToNode) expressionNode).getChildContainer(), node);
				} else {
					expressionNode = new BoundedLeadsToNode();
					((BoundedLeadsToNode) expressionNode).setBound(
							visitBound((SExpressionSequenceNode) childSequence.getChildren().get(ORD_ZERO))
					);
					((BoundedLeadsToNode) expressionNode).getChildContainer()
							.setLeftChild((AbsBooleanInternalNode) childSequence.getChildren().get(ORD_ONE).accept(this))
							.setRightChild((AbsBooleanInternalNode) childSequence.getChildren().get(ORD_TWO).accept(this));
				}
				break;
			}
			case "#": {
				expressionNode = new BoundedRepetitionNode();
				populateUnaryBooleanExprChildContainer(((BoundedRepetitionNode) expressionNode).getChildContainer(), node);
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
				((BoundedRepetitionNode) expressionNode).setBound(
						visitBound((SExpressionSequenceNode) childSequence.getChildren().get(ORD_ZERO))
				);
				break;
			}
			case "~": {
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
				expressionNode = childSequence.accept(this);
				((AbsBooleanInternalNode) expressionNode).setNegated(true);
				break;
			}
			case "()": {
				expressionNode = new GroupNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(ORD_ONE);
				((GroupNode) expressionNode).getChildContainer()
						.setChild((AbsBooleanInternalNode) childSequence.accept(this));
				break;
			}
			case "A": {
				expressionNode = new UniversalQuantificationNode();
				populateTrapsetQuantifierChildContainer(((UniversalQuantificationNode) expressionNode).getChildContainer(), node);
				break;
			}
			case "E": {
				expressionNode = new ExistentialQuantificationNode();
				populateTrapsetQuantifierChildContainer(((ExistentialQuantificationNode) expressionNode).getChildContainer(), node);
				break;
			}
			case "!": {
				expressionNode = new AbsoluteComplementNode();
				populateUnaryTrapsetExprChildContainer(((AbsoluteComplementNode) expressionNode).getChildContainer(), node);
				break;
			}
			case ";": {
				expressionNode = new LinkedPairsNode();
				populateBinaryTrapsetExprChildContainer(((LinkedPairsNode) expressionNode).getChildContainer(), node);
				break;
			}
			case "\\": {
				expressionNode = new RelativeComplementNode();
				populateBinaryTrapsetExprChildContainer(((RelativeComplementNode) expressionNode).getChildContainer(), node);
				break;
			}
			default:
				break;
			}
			return expressionNode;
		}

		private Bound visitBound(SExpressionSequenceNode node) {
			Bound bound = new Bound();
			String boundTypeStr = ((SExpressionStringNode) node.getChildren().get(ORD_ZERO)).getString();
			String boundValueStr = ((SExpressionStringNode) node.getChildren().get(ORD_ONE)).getString();
			switch (boundTypeStr) {
			case "<":
				bound.setBoundType(EBoundType.LESS_THAN);
				break;
			case "<=":
				bound.setBoundType(EBoundType.LESS_THAN_OR_EQUAL_TO);
				break;
			case "=":
				bound.setBoundType(EBoundType.EQUALS);
				break;
			case ">":
				bound.setBoundType(EBoundType.GREATER_THAN);
				break;
			case ">=":
				bound.setBoundType(EBoundType.GREATER_THAN_OR_EQUAL_TO);
				break;
			}
			bound.setBoundValue(new BigInteger(boundValueStr));
			return bound;
		}

		@Override
		public AbsExpressionNode visitString(SExpressionStringNode node) {
			AbsExpressionNode expressionNode;
			switch (node.getString()) {
			case "TRUE":
				expressionNode = BooleanValueWrapperNode.trueWrapper();
				break;
			case "FALSE":
				expressionNode = BooleanValueWrapperNode.falseWrapper();
				break;
			default:
				expressionNode = TrapsetNode.of(node.getString());
				break;
			}
			return expressionNode;
		}
	}

	@Override
	public Object transform(Object in) {
		SExpression sExpression = (SExpression) in;
		AbsExpressionNode root = sExpression.getRoot().accept(new TransformerVisitor());
		TdlExpression expression = new TdlExpression();
		expression.setRootNode((AbsBooleanInternalNode) root);
		return expression;
	}
}
