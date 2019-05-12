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

import java.math.BigInteger;

public class SToTdlExpressionTransformer implements ISimpleTransformer {
	/*
	 * ==>
	 * <=>
	 * ||
	 *
	 * &&
	 * A
	 * E
	 * ~>
	 * ~> [...]
	 * # [>|>=|=|<|<= number]
	 * TS...
	 * !
	 * ;
	 * \
	 * FALSE|TRUE
	 */
	private class TransformerVisitor implements ISExpressionVisitor<AbsExpressionNode> {
		@Override
		public AbsExpressionNode visitSequence(SExpressionSequenceNode node) {
			SExpressionStringNode stringNode = (SExpressionStringNode) node.getChildren().get(0);
			AbsExpressionNode expressionNode = null;
			switch (stringNode.getString()) {
			case "==>": {
				expressionNode = new ImplicationNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				((ImplicationNode) expressionNode).getChildContainer()
						.setLeftChild((AbsBooleanInternalNode) childSequence.getChildren().get(0).accept(this))
						.setRightChild((AbsBooleanInternalNode) childSequence.getChildren().get(1).accept(this));
				break;
			}
			case "<=>": {
				expressionNode = new EquivalenceNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				((EquivalenceNode) expressionNode).getChildContainer()
						.setLeftChild((AbsBooleanInternalNode) childSequence.getChildren().get(0).accept(this))
						.setRightChild((AbsBooleanInternalNode) childSequence.getChildren().get(1).accept(this));
				break;
			}
			case "||": {
				expressionNode = new DisjunctionNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				((DisjunctionNode) expressionNode).getChildContainer()
						.setLeftChild((AbsBooleanInternalNode) childSequence.getChildren().get(0).accept(this))
						.setRightChild((AbsBooleanInternalNode) childSequence.getChildren().get(1).accept(this));
				break;
			}
			case "&&": {
				expressionNode = new ConjunctionNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				((ConjunctionNode) expressionNode).getChildContainer()
						.setLeftChild((AbsBooleanInternalNode) childSequence.getChildren().get(0).accept(this))
						.setRightChild((AbsBooleanInternalNode) childSequence.getChildren().get(1).accept(this));
				break;
			}
			case "~>": {
				// FIXME (bound).
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				if (childSequence.getChildren().size() == 2) {
					expressionNode = new LeadsToNode();
					((LeadsToNode) expressionNode).getChildContainer()
							.setLeftChild((AbsBooleanInternalNode) childSequence.getChildren().get(0).accept(this))
							.setRightChild((AbsBooleanInternalNode) childSequence.getChildren().get(1).accept(this));
				} else {
					expressionNode = new BoundedLeadsToNode();
					((BoundedLeadsToNode) expressionNode).setBound(
							visitBound((SExpressionSequenceNode) childSequence.getChildren().get(0))
					);
					((BoundedLeadsToNode) expressionNode).getChildContainer()
							.setLeftChild((AbsBooleanInternalNode) childSequence.getChildren().get(1).accept(this))
							.setRightChild((AbsBooleanInternalNode) childSequence.getChildren().get(2).accept(this));
				}
				break;
			}
			case "#": {
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				expressionNode = new BoundedRepetitionNode();
				((BoundedRepetitionNode) expressionNode).setBound(
						visitBound((SExpressionSequenceNode) childSequence.getChildren().get(0))
				);
				((BoundedRepetitionNode) expressionNode).getChildContainer()
						.setChild((AbsBooleanInternalNode) childSequence.getChildren().get(1).accept(this));
				break;
			}
			case "~": {
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				expressionNode = childSequence.accept(this);
				((AbsBooleanInternalNode) expressionNode).setNegated(true);
				break;
			}
			case "()": {
				expressionNode = new GroupNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				((GroupNode) expressionNode).getChildContainer()
						.setChild((AbsBooleanInternalNode) childSequence.accept(this));
				break;
			}
			case "A": {
				expressionNode = new UniversalQuantificationNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				Object transformedChild = childSequence.getChildren().get(0).accept(this);
				if (transformedChild instanceof TrapsetNode) {
					TrapsetNode trapsetNode = (TrapsetNode) transformedChild;
					transformedChild = new TrapsetWrapperNode();
					((TrapsetWrapperNode) transformedChild).getChildContainer().setChild(trapsetNode);
				}
				((UniversalQuantificationNode) expressionNode).getChildContainer()
						.setChild((AbsTrapsetExpressionNode) transformedChild);
				break;
			}
			case "E": {
				expressionNode = new ExistentialQuantificationNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				Object transformedChild = childSequence.getChildren().get(0).accept(this);
				if (transformedChild instanceof TrapsetNode) {
					TrapsetNode trapsetNode = (TrapsetNode) transformedChild;
					transformedChild = new TrapsetWrapperNode();
					((TrapsetWrapperNode) transformedChild).getChildContainer().setChild(trapsetNode);
				}
				((ExistentialQuantificationNode) expressionNode).getChildContainer()
						.setChild((AbsTrapsetExpressionNode) transformedChild);
				break;
			}
			case "!": {
				expressionNode = new AbsoluteComplementNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				((AbsoluteComplementNode) expressionNode).getChildContainer()
						.setChild((TrapsetNode) childSequence.getChildren().get(0).accept(this));
				break;
			}
			case ";": {
				expressionNode = new LinkedPairsNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				((LinkedPairsNode) expressionNode).getChildContainer()
						.setLeftChild((TrapsetNode) childSequence.getChildren().get(0).accept(this))
						.setRightChild((TrapsetNode) childSequence.getChildren().get(1).accept(this));
				break;
			}
			case "\\": {
				expressionNode = new RelativeComplementNode();
				SExpressionSequenceNode childSequence = (SExpressionSequenceNode) node.getChildren().get(1);
				((RelativeComplementNode) expressionNode).getChildContainer()
						.setLeftChild((TrapsetNode) childSequence.getChildren().get(0).accept(this))
						.setRightChild((TrapsetNode) childSequence.getChildren().get(1).accept(this));
				break;
			}
			default:
				break;
			}
			return expressionNode;
		}

		private Bound visitBound(SExpressionSequenceNode node) {
			Bound bound = new Bound();
			String boundTypeStr = ((SExpressionStringNode) node.getChildren().get(0)).getString();
			String boundValueStr = ((SExpressionStringNode) node.getChildren().get(1)).getString();
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
