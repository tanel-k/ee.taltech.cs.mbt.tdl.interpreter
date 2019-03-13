package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.templates;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.gui.generic.AbsUTAGuiPositionable;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.locations.UTALocation;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.transitions.UTATransitionGraph;

public class UTATemplate {
	public static class TemplateName extends AbsUTAGuiPositionable {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	private TemplateName name;
	private UTATemplateParameters parameters;
	private UTATemplateDeclarations declarations;
	private UTALocation initialLocation;
	private UTATransitionGraph transitionGraph;

	public UTATemplate() { }

	public TemplateName getName() {
		return name;
	}

	public void setName(TemplateName name) {
		this.name = name;
	}

	public UTATemplateParameters getParameters() {
		return parameters;
	}

	public void setParameters(UTATemplateParameters parameters) {
		this.parameters = parameters;
	}

	public UTATemplateDeclarations getDeclarations() {
		return declarations;
	}

	public void setDeclarations(UTATemplateDeclarations localDeclarations) {
		this.declarations = localDeclarations;
	}

	public UTALocation getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(UTALocation initialLocation) {
		this.initialLocation = initialLocation;
	}

	public UTATransitionGraph getTransitionGraph() {
		return transitionGraph;
	}

	public void setTransitionGraph(UTATransitionGraph transitionGraph) {
		this.transitionGraph = transitionGraph;
	}
}
