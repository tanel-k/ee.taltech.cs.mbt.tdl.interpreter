package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.prefix;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.prefix.BroadcastTypePrefixCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.prefix.ConstantTypePrefixCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.prefix.UrgentTypePrefixCtx;

public interface ITypePrefixCtxVisitor<T> {
	T visitBroadcastTypePrefix(BroadcastTypePrefixCtx ctx);
	T visitConstantTypePrefix(ConstantTypePrefixCtx ctx);
	T visitUrgentTypePrefix(UrgentTypePrefixCtx ctx);
}
