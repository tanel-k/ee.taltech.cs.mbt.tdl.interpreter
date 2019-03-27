package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier;

public class IntegerTypeIdCtx extends AbsTypeIdentifierCtx {
	@Override
	public <T> T accept(ITypeIdCtxVisitor<T> visitor) {
		return visitor.visitIntegerTypeId(this);
	}
}
