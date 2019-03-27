package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.system.progress_measure;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

import java.util.LinkedList;
import java.util.List;

public class ProgressMeasureDeclCtx extends AbsCodeGenerationCtx {
	private List<AbsExpressionCtx> expressions = new LinkedList<>();

	public List<AbsExpressionCtx> getExpressions() {
		return expressions;
	}
}
