package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.literal;

public class DeadlockLiteralCtx extends AbsLiteralCtx {
	@Override
	public <T> T accept(ILiteralVisitor<T> visitor) {
		return visitor.visitDeadlockLiteral(this);
	}
}
