package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.initializer.AbsVarInitializerCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.initializer.IVariableInitializerCtxVisitor;

import java.util.LinkedList;
import java.util.List;

public class StructuredVarInitializerCtx extends AbsVarInitializerCtx {
	private List<AbsVarInitializerCtx> nestedInitializers = new LinkedList<>();

	public List<AbsVarInitializerCtx> getNestedInitializers() {
		return nestedInitializers;
	}

	@Override
	public <T> T accept(IVariableInitializerCtxVisitor<T> visitor) {
		return visitor.visitStructuredVariableInitializer(this);
	}
}
