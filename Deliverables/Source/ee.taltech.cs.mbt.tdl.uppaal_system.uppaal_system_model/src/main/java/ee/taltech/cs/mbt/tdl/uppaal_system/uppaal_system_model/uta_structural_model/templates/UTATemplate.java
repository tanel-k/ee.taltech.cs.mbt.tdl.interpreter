package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.templates;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.gui.IGuiPositionable;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.locations.UTALocation;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.transitions.UTATransitionGraph;

public class UTATemplate {
	public static class TemplateName implements IGuiPositionable {
		private String name;
		private GuiCoordinates guiCoordinates;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public GuiCoordinates getGuiCoordinates() {
			return guiCoordinates;
		}

		@Override
		public void setGuiCoordinates(GuiCoordinates guiCoordinates) {
			this.guiCoordinates = guiCoordinates;
		}
	}

	private TemplateName name;
	private UTALocation initialLocation;
	private UTATemplateParameters parameters;
	private UTATransitionGraph transitionGraph;
	private UTATemplateDeclarations declarations;

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
