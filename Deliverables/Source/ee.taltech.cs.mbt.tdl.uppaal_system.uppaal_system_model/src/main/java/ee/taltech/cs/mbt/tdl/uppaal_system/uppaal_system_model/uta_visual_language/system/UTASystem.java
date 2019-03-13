package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_visual_language.system;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_visual_language.templates.UTATemplate;

import java.util.Map;

public class UTASystem {
	private Map<String, UTATemplate> templateNameMap;
	private UTASystemDefinition systemDefinition;

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
}
