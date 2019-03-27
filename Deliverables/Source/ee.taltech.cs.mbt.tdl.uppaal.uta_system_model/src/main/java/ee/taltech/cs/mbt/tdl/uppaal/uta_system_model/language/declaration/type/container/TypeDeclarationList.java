package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.type.container;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.IDeclarationVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;

import java.util.*;

/**
 * Container type for {@link TypeDeclaration} instances.
 */
 @Deprecated
public class TypeDeclarationList extends AbsDeclarationStatement implements Iterable<TypeDeclaration<AbsTypeId>> {
	private List<TypeDeclaration<AbsTypeId>> typeDeclarations = new LinkedList<>();

	public List<TypeDeclaration<AbsTypeId>> getDeclarations() {
		return typeDeclarations;
	}

	@Override
	public Iterator<TypeDeclaration<AbsTypeId>> iterator() {
		return typeDeclarations.iterator();
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> declarationVisitor) {
		return declarationVisitor.visitTypeDeclarationList(this);
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
		if (!(obj instanceof TypeDeclarationList))
			return false;
		TypeDeclarationList other = (TypeDeclarationList) obj;
		return Objects.equals(other.typeDeclarations, this.typeDeclarations);
	}
}
