package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.system;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.AbsDeclarationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.system.system_line.SystemLineCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.system.progress_measure.ProgressMeasureDeclCtx;

import java.util.LinkedList;
import java.util.List;

public class SystemDefinitionCtx extends AbsCodeGenerationCtx {
	private List<AbsDeclarationCtx> declarations = new LinkedList<>();
	private SystemLineCtx systemLine;
	private ProgressMeasureDeclCtx progressMeasure;

	public List<AbsDeclarationCtx> getDeclarations() {
		return declarations;
	}

	public SystemLineCtx getSystemLine() {
		return systemLine;
	}

	public void setSystemLine(SystemLineCtx systemLine) {
		this.systemLine = systemLine;
	}

	public ProgressMeasureDeclCtx getProgressMeasure() {
		return progressMeasure;
	}

	public void setProgressMeasure(ProgressMeasureDeclCtx progressMeasure) {
		this.progressMeasure = progressMeasure;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitSystemDefinition(this);
	}
}
