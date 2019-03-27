package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.literal;

public interface ILiteralVisitor<T> {
	T visitDeadlockLiteral(DeadlockLiteralCtx ctx);
	T visitFalseLiteral(FalseLiteralCtx ctx);
	T visitTrueLiteral(TrueLiteralCtx ctx);
	T visitNaturalNumberLiteral(NaturalNumberLiteralCtx ctx);
	T visitIdentifierNameLiteral(IdentifierNameLiteralCtx ctx);
}
