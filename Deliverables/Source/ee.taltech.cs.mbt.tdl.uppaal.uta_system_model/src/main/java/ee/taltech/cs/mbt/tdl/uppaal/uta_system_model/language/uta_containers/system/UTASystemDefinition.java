package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.system;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.progress_measure.ProgressMeasureDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.uta_system.SystemDeclarationSequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.system.system_line.UTASystemLine;

public class UTASystemDefinition {
	private SystemDeclarationSequence declarations;
	private UTASystemLine systemLine;
	private ProgressMeasureDeclaration progressMeasureDeclaration;

	public SystemDeclarationSequence getDeclarations() {
		return declarations;
	}

	public void setDeclarations(SystemDeclarationSequence declarations) {
		this.declarations = declarations;
	}

	public UTASystemLine getSystemLine() {
		return systemLine;
	}

	public void setSystemLine(UTASystemLine systemLine) {
		this.systemLine = systemLine;
	}

	public ProgressMeasureDeclaration getProgressMeasureDeclaration() {
		return progressMeasureDeclaration;
	}

	public void setProgressMeasureDeclaration(ProgressMeasureDeclaration progressMeasureDeclaration) {
		this.progressMeasureDeclaration = progressMeasureDeclaration;
	}
}
