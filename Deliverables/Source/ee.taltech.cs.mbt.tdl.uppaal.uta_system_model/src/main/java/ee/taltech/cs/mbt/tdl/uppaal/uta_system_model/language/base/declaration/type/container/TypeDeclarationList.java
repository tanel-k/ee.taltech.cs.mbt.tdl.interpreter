package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.container;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation.IDeclarationVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.*;

/**
 * Container type for {@link TypeDeclaration} instances.
 */
public class TypeDeclarationList extends AbsDeclarationStatement implements Iterable<TypeDeclaration<AbsTypeIdentifier>> {
	private List<TypeDeclaration<AbsTypeIdentifier>> typeDeclarations = new LinkedList<>();

	public List<TypeDeclaration<AbsTypeIdentifier>> getDeclarations() {
		return typeDeclarations;
	}

	@Override
	public Iterator<TypeDeclaration<AbsTypeIdentifier>> iterator() {
		return typeDeclarations.iterator();
	}

	@Override
	public void accept(IDeclarationVisitor declarationVisitor) {
		declarationVisitor.visitTypeDeclarationList(this);
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
