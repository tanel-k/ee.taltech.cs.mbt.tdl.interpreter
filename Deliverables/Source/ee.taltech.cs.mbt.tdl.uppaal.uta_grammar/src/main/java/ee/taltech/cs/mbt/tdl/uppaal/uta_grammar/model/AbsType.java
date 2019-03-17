package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.model;

public abstract class AbsType {
	private String name;

	public String getName() {
		return name;
	}

	public AbsType(String name) {
		this.name = name;
	}
}
