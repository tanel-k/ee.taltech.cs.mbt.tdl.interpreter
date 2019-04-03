package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.traversal;

public interface IVisitableNode {
	default void accept(IExpressionTreeVisitor visitor) {}
}
