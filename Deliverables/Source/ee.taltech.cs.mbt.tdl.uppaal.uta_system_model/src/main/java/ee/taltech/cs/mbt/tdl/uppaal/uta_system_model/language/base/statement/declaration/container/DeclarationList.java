package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.container;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class DeclarationList {
	private Set<AbsDeclarationStatement> declarations;

	public DeclarationList() {
		this.declarations = new LinkedHashSet<>();
	}

	public Set<AbsDeclarationStatement> getDeclarations() {
		return declarations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDeclarations());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DeclarationList))
			return false;
		DeclarationList other = (DeclarationList) obj;
		return Objects.equals(other.declarations, this.declarations);
	}
}
