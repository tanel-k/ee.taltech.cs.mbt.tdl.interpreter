package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.logical.AbsLogicalOperatorNode;

public abstract class ExpressionTreeVisitor
	extends AbsExpressionTreeVisitor<ExpressionTree, AbsLogicalOperatorNode<?>>
{
}
