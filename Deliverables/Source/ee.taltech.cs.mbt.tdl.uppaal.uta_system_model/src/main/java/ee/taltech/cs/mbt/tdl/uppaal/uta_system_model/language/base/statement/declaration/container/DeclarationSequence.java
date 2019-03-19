package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.container;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;

import java.util.LinkedHashSet;
import java.util.Set;

public class DeclarationSequence {
	private Set<AbsDeclarationStatement> declarationStatements = new LinkedHashSet<>();

	public Set<AbsDeclarationStatement> getDeclarationStatements() {
		return declarationStatements;
	}
}
