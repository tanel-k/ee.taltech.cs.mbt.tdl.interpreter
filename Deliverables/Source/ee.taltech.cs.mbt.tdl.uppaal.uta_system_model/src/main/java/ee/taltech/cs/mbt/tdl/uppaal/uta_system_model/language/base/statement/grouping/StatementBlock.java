package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.visitation.IStatementVisitor;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Represents a block of statements in an UPPAAL function.<br/>
 * Similar to a Java code block; see syntax below:<br/>
 * <pre>
 * Block ::= '{' Declarations Statement* '}'
 * </pre>
 * Note that declarations (if there are any), must occur prior to statements.<br/>
 */
public class StatementBlock extends AbsStatement {
	private Set<AbsDeclarationStatement> declarations = new LinkedHashSet<>();
	private List<AbsStatement> statements = new LinkedList<>();

	public List<AbsStatement> getStatements() {
		return statements;
	}

	public Set<AbsDeclarationStatement> getDeclarations() {
		return declarations;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitBlock(this);
	}
}
