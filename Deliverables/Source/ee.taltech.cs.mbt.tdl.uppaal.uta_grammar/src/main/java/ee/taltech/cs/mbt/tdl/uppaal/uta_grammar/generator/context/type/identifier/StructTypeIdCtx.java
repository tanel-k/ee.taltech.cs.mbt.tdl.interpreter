package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.nested.FieldDeclarationCtx;

import java.util.LinkedList;
import java.util.List;

public class StructTypeIdCtx extends AbsTypeIdentifierCtx {
	private List<FieldDeclarationCtx> fieldDeclarations = new LinkedList<>();

	public List<FieldDeclarationCtx> getFieldDeclarations() {
		return fieldDeclarations;
	}

	@Override
	public <T> T accept(ITypeIdCtxVisitor<T> visitor) {
		return visitor.visitStructTypeId(this);
	}
}
