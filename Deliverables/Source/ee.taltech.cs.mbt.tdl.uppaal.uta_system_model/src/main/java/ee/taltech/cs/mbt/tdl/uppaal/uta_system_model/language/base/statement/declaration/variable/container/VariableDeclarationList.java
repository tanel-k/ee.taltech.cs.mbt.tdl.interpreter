package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.container;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class VariableDeclarationList extends AbsDeclarationStatement {
	private List<VariableDeclaration> declarations = new LinkedList<>();

	public List<VariableDeclaration> getDeclarations() {
		return declarations;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitVariableDeclarations(this);
	}
}
