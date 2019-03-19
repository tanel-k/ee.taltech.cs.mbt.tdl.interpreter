package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.containers.DeclarationStatementList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

import java.util.LinkedList;
import java.util.List;

public class StatementBlock extends AbsStatement {
	private DeclarationStatementList declarations;
	private List<AbsStatement> statements = new LinkedList<>();

	public List<AbsStatement> getStatements() {
		return statements;
	}

	public DeclarationStatementList getDeclarations() {
		return declarations;
	}

	public void setDeclarations(DeclarationStatementList declarations) {
		this.declarations = declarations;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitStatementBlock(this);
	}
}
