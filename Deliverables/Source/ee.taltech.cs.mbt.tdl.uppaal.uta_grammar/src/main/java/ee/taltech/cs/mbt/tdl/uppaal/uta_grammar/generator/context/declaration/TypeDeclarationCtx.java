package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.variant.IdentifierNameVariantCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.TypeCtx;

import java.util.LinkedList;
import java.util.List;

public class TypeDeclarationCtx extends AbsDeclarationCtx {
	private TypeCtx type;
	private List<IdentifierNameVariantCtx> nameVariants = new LinkedList<>();

	public TypeCtx getType() {
		return type;
	}

	public void setType(TypeCtx type) {
		this.type = type;
	}

	public List<IdentifierNameVariantCtx> getNameVariants() {
		return nameVariants;
	}

	@Override
	public <T> T accept(IDeclarationCtxVisitor<T> visitor) {
		return visitor.visitTypeDeclaration(this);
	}
}
