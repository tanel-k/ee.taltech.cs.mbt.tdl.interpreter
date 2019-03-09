package ee.taltech.cs.mbt.tdl.expression.parser;

public class Director {
	private Builder builder;

	public Builder getBuilder() {
		return builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	public void build() {
		for (Object o : new Object[]{ null, null }) {
			this.builder.buildPart(o);
		}
	}

	public Director() { }
}
