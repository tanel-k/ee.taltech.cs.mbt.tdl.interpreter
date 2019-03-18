package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.container.DeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

import java.util.LinkedList;
import java.util.List;

public class StatementBlock extends AbsStatement {
	private DeclarationList declarations;
	private List<AbsStatement> statements;

	public StatementBlock() {
		this.statements = new LinkedList<>();
		this.declarations = new DeclarationList();
	}

	public List<AbsStatement> getStatements() {
		return statements;
	}

	public DeclarationList getDeclarations() {
		return declarations;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitStatementBlock(this);
	}
}
