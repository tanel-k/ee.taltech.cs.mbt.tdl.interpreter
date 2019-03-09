package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.arity;

public interface IOperator<O> {
	int ARITY_UNARY = 1;
	int ARITY_BINARY = 2;

	int ORDINAL_FIRST = 0;
	int ORDINAL_SECOND = 1;

	O getOperand(int ordinal);
	void setOperand(int ordinal, O operator);

	int getArity();
}
