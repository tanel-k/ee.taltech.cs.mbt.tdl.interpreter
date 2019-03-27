package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier;

public class ClockTypeIdCtx extends AbsTypeIdentifierCtx {
	@Override
	public <T> T accept(ITypeIdCtxVisitor<T> visitor) {
		return visitor.visitClockTypeId(this);
	}
}
