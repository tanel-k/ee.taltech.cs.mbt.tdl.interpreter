package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.modifier;

public enum EBoundType {
	EQUALS("="),
	LESS_THAN("<"),
	GREATER_THAN(">"),
	GREATER_THAN_OR_EQUAL_TO(">="),
	LESS_THAN_OR_EQUAL_TO("<=");

	String symbolicName;

	public String getSymbolicName() {
		return symbolicName;
	}

	EBoundType(String symbolicName) {
		this.symbolicName = symbolicName;
	}
}
