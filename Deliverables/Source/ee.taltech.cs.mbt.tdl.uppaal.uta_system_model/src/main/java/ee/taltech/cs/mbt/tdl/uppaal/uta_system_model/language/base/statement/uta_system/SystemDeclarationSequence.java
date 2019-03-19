package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.uta_system;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;

import java.util.LinkedHashSet;
import java.util.Set;

public class SystemDeclarationSequence {
	private Set<AbsDeclarationStatement> declarationStatements;

	public SystemDeclarationSequence() {
		this.declarationStatements = new LinkedHashSet<>();
	}

	public Set<AbsDeclarationStatement> getDeclarationStatements() {
		return declarationStatements;
	}
}
