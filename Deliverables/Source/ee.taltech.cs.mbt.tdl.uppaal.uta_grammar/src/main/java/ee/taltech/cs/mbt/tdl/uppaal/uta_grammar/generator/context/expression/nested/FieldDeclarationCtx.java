package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.nested;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.variant.IdentifierNameVariantCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.TypeCtx;

import java.util.LinkedList;
import java.util.List;

public class FieldDeclarationCtx extends AbsCodeGenerationCtx {
	private TypeCtx type;
	private List<IdentifierNameVariantCtx> identifierNameVariants = new LinkedList<>();

	public TypeCtx getType() {
		return type;
	}

	public void setType(TypeCtx type) {
		this.type = type;
	}

	public List<IdentifierNameVariantCtx> getIdentifierNameVariants() {
		return identifierNameVariants;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitFieldDeclaration(this);
	}
}
