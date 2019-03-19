package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.containers.ParameterDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.container.DeclarationSequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IGuiPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UTALocation;

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

	private ParameterDeclarationList parameters;
	private UTATransitionMap transitionMap;

	private UTALocation initialLocation;
	private DeclarationSequence localDeclarations;

	public UTATemplate() { }

	public TemplateName getName() {
		return name;
	}

	public void setName(TemplateName name) {
		this.name = name;
	}

	public ParameterDeclarationList getParameters() {
		return parameters;
	}

	public void setParameters(ParameterDeclarationList parameters) {
		this.parameters = parameters;
	}

	public UTALocation getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(UTALocation initialLocation) {
		this.initialLocation = initialLocation;
	}

	public UTATransitionMap getTransitionMap() {
		return transitionMap;
	}

	public void setTransitionMap(UTATransitionMap transitionMap) {
		this.transitionMap = transitionMap;
	}

	public DeclarationSequence getLocalDeclarations() {
		return localDeclarations;
	}

	public void setLocalDeclarations(DeclarationSequence localDeclarations) {
		this.localDeclarations = localDeclarations;
	}
}
