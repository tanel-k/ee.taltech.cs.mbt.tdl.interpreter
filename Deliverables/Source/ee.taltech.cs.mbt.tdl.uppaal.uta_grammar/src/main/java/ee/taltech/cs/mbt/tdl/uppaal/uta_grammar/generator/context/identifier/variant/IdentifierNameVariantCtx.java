package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.variant;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.array_modifier.AbsArraySizeModCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.IdentifierNameCtx;

import java.util.LinkedList;
import java.util.List;

public class IdentifierNameVariantCtx extends AbsCodeGenerationCtx {
	private IdentifierNameCtx identifierName;
	private List<AbsArraySizeModCtx> arraySizeModifiers = new LinkedList<>();

	public IdentifierNameCtx getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierNameCtx identifierName) {
		this.identifierName = identifierName;
	}

	public List<AbsArraySizeModCtx> getArraySizeModifiers() {
		return arraySizeModifiers;
	}
}
