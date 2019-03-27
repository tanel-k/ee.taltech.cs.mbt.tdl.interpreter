package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.prefix;

public class ConstantTypePrefixCtx extends AbsTypePrefixCtx {
	@Override
	public <T> T accept(ITypePrefixCtxVisitor<T> visitor) {
		return visitor.visitConstantTypePrefix(this);
	}
}
