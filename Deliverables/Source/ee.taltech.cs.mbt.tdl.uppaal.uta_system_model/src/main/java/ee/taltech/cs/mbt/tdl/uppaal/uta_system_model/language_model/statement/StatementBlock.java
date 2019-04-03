package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IStatementVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a block of statements in an UPPAAL function.<br/>
 * Similar to a Java code block; see syntax below:<br/>
 * <pre>
 * Block ::= '{' Declarations Statement* '}'
 * </pre>
 * Note that declarations (if there are any), must occur prior to statements.<br/>
 */
public class StatementBlock extends AbsStatement {
	private List<AbsDeclarationStatement> declarations = new LinkedList<>();
	private List<AbsStatement> statements = new LinkedList<>();

	public List<AbsStatement> getStatements() {
		return statements;
	}

	public List<AbsDeclarationStatement> getDeclarations() {
		return declarations;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitBlockStatement(this);
	}
}
