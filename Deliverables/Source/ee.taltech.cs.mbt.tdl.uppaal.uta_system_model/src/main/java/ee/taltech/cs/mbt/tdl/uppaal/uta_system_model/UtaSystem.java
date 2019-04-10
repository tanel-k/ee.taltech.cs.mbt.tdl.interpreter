package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.LinkedList;
import java.util.List;

public class UtaSystem {
	private List<AbsDeclarationStatement> globalDeclarations;
	private List<Template> templates;
	private SystemDefinition systemDefinition;

	public UtaSystem() {}

	public List<AbsDeclarationStatement> getDeclarations() {
		return globalDeclarations == null
				? (globalDeclarations = new LinkedList<>())
				: globalDeclarations;
	}

	public UtaSystem setDeclarations(List<AbsDeclarationStatement> globalDeclarations) {
		this.globalDeclarations = globalDeclarations;
		return this;
	}

	public List<Template> getTemplates() {
		return templates == null
				? (templates = new LinkedList<>())
				: templates;
	}

	public UtaSystem setTemplates(List<Template> templates) {
		this.templates = templates;
		return this;
	}

	public SystemDefinition getSystemDefinition() {
		return systemDefinition;
	}

	public void setSystemDefinition(SystemDefinition systemDefinition) {
		this.systemDefinition = systemDefinition;
	}
}
