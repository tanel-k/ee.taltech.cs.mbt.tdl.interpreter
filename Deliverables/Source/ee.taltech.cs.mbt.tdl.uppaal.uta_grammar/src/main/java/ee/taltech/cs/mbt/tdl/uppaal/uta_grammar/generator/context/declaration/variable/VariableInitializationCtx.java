package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.initializer.AbsVarInitializerCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.variant.IdentifierNameVariantCtx;

public class VariableInitializationCtx extends AbsCodeGenerationCtx {
	private IdentifierNameVariantCtx nameVariant;
	private AbsVarInitializerCtx initializer;

	public IdentifierNameVariantCtx getNameVariant() {
		return nameVariant;
	}

	public void setNameVariant(IdentifierNameVariantCtx nameVariant) {
		this.nameVariant = nameVariant;
	}

	public AbsVarInitializerCtx getInitializer() {
		return initializer;
	}

	public void setInitializer(AbsVarInitializerCtx initializer) {
		this.initializer = initializer;
	}
}
