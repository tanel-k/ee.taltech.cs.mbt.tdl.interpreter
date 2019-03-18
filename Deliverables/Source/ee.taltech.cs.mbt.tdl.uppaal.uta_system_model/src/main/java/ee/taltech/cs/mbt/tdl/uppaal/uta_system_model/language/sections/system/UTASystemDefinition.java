package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.sections.system;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.sections.system.declaration.container.UTASystemDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.sections.system.progress_measure.ProgressMeasureDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.sections.system.system_line.UTASystemLine;

public class UTASystemDefinition {
	private UTASystemDeclarationList declarations;
	private UTASystemLine systemLine;
	private ProgressMeasureDeclaration progressMeasureDeclaration;

	public UTASystemDeclarationList getDeclarations() {
		return declarations;
	}

	public void setDeclarations(UTASystemDeclarationList declarations) {
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
