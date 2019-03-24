package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.container;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation.IDeclarationVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Container type for {@link VariableDeclaration} instances.
 */
public class VariableDeclarationList extends AbsDeclarationStatement {
	private List<VariableDeclaration> declarations = new LinkedList<>();

	public List<VariableDeclaration> getDeclarations() {
		return declarations;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> declarationVisitor) {
		return declarationVisitor.visitVariableDeclarationList(this);
	}
}
