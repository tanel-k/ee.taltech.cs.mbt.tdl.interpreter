package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;

import java.util.LinkedList;
import java.util.List;

public class StatementBlock extends AbsStatement {
	private List<AbsStatement> statements;

	public StatementBlock() {
		this.statements = new LinkedList<>();
	}

	public List<AbsStatement> getStatements() {
		return statements;
	}
}
