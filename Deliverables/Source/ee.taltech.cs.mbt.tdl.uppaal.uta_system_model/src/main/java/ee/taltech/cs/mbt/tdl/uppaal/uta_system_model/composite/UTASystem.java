package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UTATemplate;

import java.util.Map;
import java.util.Set;

public class UTASystem {
	private String name;
	private Map<String, UTATemplate> templateNameMap;
	private SystemDefinition systemDefinition;
	private Set<AbsDeclarationStatement> globalDeclarations;

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

	public SystemDefinition getSystemDefinition() {
		return systemDefinition;
	}

	public void setSystemDefinition(SystemDefinition systemDefinition) {
		this.systemDefinition = systemDefinition;
	}

	public Set<AbsDeclarationStatement> getGlobalDeclarations() {
		return globalDeclarations;
	}
}
