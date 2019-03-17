package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.identifier;

import java.util.Objects;

public class Identifier {
	private String symbols;

	public Identifier() { }

	public Identifier(String symbols) {
		this.symbols = symbols;
	}

	public String getSymbols() {
		return symbols;
	}

	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSymbols());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Identifier))
			return false;
		Identifier other = (Identifier) obj;
		return Objects.equals(other.getSymbols(), this.getSymbols());
	}
}
