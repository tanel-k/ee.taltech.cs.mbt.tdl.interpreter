package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;

public class IdentifierNameCtx extends AbsCodeGenerationCtx {
	private String nameString;

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitIdentifierName(this);
	}
}
