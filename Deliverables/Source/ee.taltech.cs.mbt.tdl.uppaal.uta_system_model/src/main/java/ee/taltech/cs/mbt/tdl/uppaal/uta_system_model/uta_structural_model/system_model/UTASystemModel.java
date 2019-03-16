package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.system_model;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.templates.UTATemplate;

import java.util.Map;

public class UTASystemModel {
	private Map<String, UTATemplate> templateNameMap;
	private UTASystemDefinition systemDefinition;
	private UTAGlobalDeclarations globalDeclarations;

	public Map<String, UTATemplate> getTemplateNameMap() {
		return templateNameMap;
	}

	public void setTemplateNameMap(Map<String, UTATemplate> templateNameMap) {
		this.templateNameMap = templateNameMap;
	}

	public UTASystemDefinition getSystemDefinition() {
		return systemDefinition;
	}

	public void setSystemDefinition(UTASystemDefinition systemDefinition) {
		this.systemDefinition = systemDefinition;
	}

	public UTAGlobalDeclarations getGlobalDeclarations() {
		return globalDeclarations;
	}

	public void setGlobalDeclarations(UTAGlobalDeclarations globalDeclarations) {
		this.globalDeclarations = globalDeclarations;
	}
}
