package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.system_model;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.container.DeclarationSequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.system.UTASystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UTATemplate;

import java.util.Map;

public class UTASystemModel {
	private String name;
	private Map<String, UTATemplate> templateNameMap;
	private UTASystemDefinition systemDefinition;
	private DeclarationSequence globalDeclarations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public DeclarationSequence getGlobalDeclarations() {
		return globalDeclarations;
	}

	public void setGlobalDeclarations(DeclarationSequence globalDeclarations) {
		this.globalDeclarations = globalDeclarations;
	}
}
