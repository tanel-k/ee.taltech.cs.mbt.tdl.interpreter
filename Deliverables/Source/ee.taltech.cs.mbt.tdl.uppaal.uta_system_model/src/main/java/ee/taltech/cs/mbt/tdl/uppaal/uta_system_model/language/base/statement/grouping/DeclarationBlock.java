package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class DeclarationBlock extends AbsStatement {
	private Set<AbsDeclarationStatement> declarations;

	public DeclarationBlock() {
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
		if (!(obj instanceof DeclarationBlock))
			return false;
		DeclarationBlock other = (DeclarationBlock) obj;
		return Objects.equals(other.declarations, this.declarations);
	}
}
