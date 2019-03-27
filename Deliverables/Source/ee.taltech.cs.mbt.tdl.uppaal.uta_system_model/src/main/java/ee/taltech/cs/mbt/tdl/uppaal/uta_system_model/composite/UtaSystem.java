package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UtaTemplate;

import java.util.*;

public class UtaSystem {
	private Map<String, UtaTemplate> templateNameMap = new HashMap<>();
	private SystemDefinition systemDefinition;
	private List<AbsDeclarationStatement> globalDeclarations;

	public UtaSystem() {}

	public Map<String, UtaTemplate> getTemplateMap() {
		return templateNameMap;
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
