package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

public class EmptyStmtCtx extends AbsStatementCtx {
	@Override
	public <T> T accept(IStatementCtxVisitor<T> visitor) {
		return visitor.visitEmptyStatement(this);
	}
}
