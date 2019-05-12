package ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.nodes;

public interface ISExpressionVisitor<T> {
	T visitSequence(SExpressionSequenceNode node);
	T visitString(SExpressionStringNode node);
}
