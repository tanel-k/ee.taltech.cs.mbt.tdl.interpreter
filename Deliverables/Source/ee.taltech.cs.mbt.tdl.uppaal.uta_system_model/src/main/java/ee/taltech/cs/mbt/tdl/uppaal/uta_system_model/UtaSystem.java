package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UtaSystem {
	private Map<String, Template> templateMap = new HashMap<>();
	private SystemDefinition systemDefinition;
	private List<AbsDeclarationStatement> globalDeclarations;

	public UtaSystem() {}

	public Map<String, Template> getTemplateMap() {
		return templateMap;
	}

	public SystemDefinition getSystemDefinition() {
		return systemDefinition;
	}

	public void setSystemDefinition(SystemDefinition systemDefinition) {
		this.systemDefinition = systemDefinition;
	}

	public List<AbsDeclarationStatement> getGlobalDeclarations() {
		return (globalDeclarations == null)
			? (globalDeclarations = new LinkedList<>())
			: globalDeclarations;
	}

	public void setGlobalDeclarations(List<AbsDeclarationStatement> globalDeclarations) {
		this.globalDeclarations = globalDeclarations;
	}
}
