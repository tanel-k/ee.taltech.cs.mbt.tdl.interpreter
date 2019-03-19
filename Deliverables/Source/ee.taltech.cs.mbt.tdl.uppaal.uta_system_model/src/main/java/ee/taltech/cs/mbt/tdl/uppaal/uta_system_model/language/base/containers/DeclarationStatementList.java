package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.containers;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class DeclarationStatementList extends AbsStatement implements Iterable<AbsDeclarationStatement> {
	private Set<AbsDeclarationStatement> declarations;

	public DeclarationStatementList() {
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
		if (!(obj instanceof DeclarationStatementList))
			return false;
		DeclarationStatementList other = (DeclarationStatementList) obj;
		return Objects.equals(other.declarations, this.declarations);
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitDeclarationList(this);
	}

	@Override
	public Iterator<AbsDeclarationStatement> iterator() {
		return declarations.iterator();
	}
}
