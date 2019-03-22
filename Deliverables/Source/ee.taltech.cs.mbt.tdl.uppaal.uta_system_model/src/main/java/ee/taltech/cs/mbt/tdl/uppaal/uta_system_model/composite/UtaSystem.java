package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UtaTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UtaSystem {
	private String name;
	private Map<String, UtaTemplate> templateNameMap = new HashMap<>();
	private SystemDefinition systemDefinition;
	private Set<AbsDeclarationStatement> globalDeclarations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, UtaTemplate> getTemplateMap() {
		return templateNameMap;
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
