package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.system.system_line;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;

import java.util.LinkedList;
import java.util.List;

public class SystemLineCtx extends AbsCodeGenerationCtx {
	private List<ProcessRefGroupCtx> processReferenceGroups = new LinkedList<>();

	public List<ProcessRefGroupCtx> getProcessReferenceGroups() {
		return processReferenceGroups;
	}
}
