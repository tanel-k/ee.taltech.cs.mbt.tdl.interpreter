package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.AbsDeclarationCtx;

import java.util.LinkedList;
import java.util.List;

public class StatementBlockCtx extends AbsStatementCtx {
	private List<AbsDeclarationCtx> declarations = new LinkedList<>();
	private List<AbsStatementCtx> statements = new LinkedList<>();

	public List<AbsDeclarationCtx> getDeclarations() {
		return declarations;
	}

	public List<AbsStatementCtx> getStatements() {
		return statements;
	}

	@Override
	public <T> T accept(IStatementCtxVisitor<T> visitor) {
		return visitor.visitStatementBlock(this);
	}
}
