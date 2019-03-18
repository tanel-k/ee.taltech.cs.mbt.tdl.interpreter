package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.system;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;

import java.util.LinkedList;
import java.util.List;

public class UTASystemDeclarationList {
	private List<AbsDeclarationStatement> declarations;

	public UTASystemDeclarationList() {
		this.declarations = new LinkedList<>();
	}

	public List<AbsDeclarationStatement> getDeclarations() {
		return declarations;
	}
}
