package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.IMergeable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.LinkedList;
import java.util.List;

public class UtaSystem implements IMergeable<UtaSystem>, IDeepCloneable<UtaSystem> {
	private List<AbsDeclarationStatement> declarations = new LinkedList<>();
	private List<Template> templates = new LinkedList<>();
	private SystemDefinition systemDefinition;

	public UtaSystem() {}

	public List<AbsDeclarationStatement> getDeclarations() {
		return declarations;
	}

	public UtaSystem setDeclarations(List<AbsDeclarationStatement> declarations) {
		this.declarations = declarations != null
				? declarations
				: this.declarations;
		return this;
	}

	public List<Template> getTemplates() {
		return templates;
	}

	public UtaSystem setTemplates(List<Template> templates) {
		this.templates = templates != null
				? templates
				: this.templates;
		return this;
	}

	public SystemDefinition getSystemDefinition() {
		return systemDefinition;
	}

	public void setSystemDefinition(SystemDefinition systemDefinition) {
		this.systemDefinition = systemDefinition;
	}

	@Override
	public void merge(UtaSystem other) {
		declarations.addAll(other.declarations);
		templates.addAll(other.templates);

		if (other.systemDefinition != null) {
			systemDefinition = systemDefinition != null
					? systemDefinition
					: new SystemDefinition();
			systemDefinition.merge(other.systemDefinition);
		}
	}

	@Override
	public UtaSystem deepClone() {
		UtaSystem clone = new UtaSystem();

		declarations.stream()
				.forEachOrdered(d -> clone.declarations.add(d.deepClone()));
		templates.stream()
				.forEachOrdered(t -> clone.templates.add(t.deepClone()));

		clone.systemDefinition = systemDefinition != null
				? systemDefinition.deepClone()
				: null;

		return clone;
	}
}
