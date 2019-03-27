package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.system.system_line;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;

import java.util.LinkedList;
import java.util.List;

public class ProcessRefGroupCtx extends AbsCodeGenerationCtx {
	private List<ProcessRefCtx> processReferences = new LinkedList<>();

	public List<ProcessRefCtx> getProcessReferences() {
		return processReferences;
	}
}
