package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier.*;

public interface ITypeIdCtxVisitor<T> {
	T visitBooleanTypeId(BooleanTypeIdCtx ctx);
	T visitBoundedIntegerTypeId(BoundedIntegerTypeIdCtx ctx);
	T visitClockTypeId(ClockTypeIdCtx ctx);
	T visitIntegerTypeId(IntegerTypeIdCtx ctx);
	T visitScalarTypeId(ScalarTypeIdCtx ctx);
	T visitStructTypeId(StructTypeIdCtx ctx);
	T visitVariableBasedTypeId(VariableBasedTypeIdCtx ctx);
}
