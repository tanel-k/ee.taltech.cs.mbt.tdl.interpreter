package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IGuiPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UTALocation;

import java.util.LinkedHashSet;
import java.util.Set;

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

	private Set<ParameterDeclaration> parameters = new LinkedHashSet<>();
	private UTATransitionMap transitionMap;

	private UTALocation initialLocation;
	private Set<AbsDeclarationStatement> localDeclarations = new LinkedHashSet<>();

	public UTATemplate() { }

	public TemplateName getName() {
		return name;
	}

	public void setName(TemplateName name) {
		this.name = name;
	}

	public Set<ParameterDeclaration> getParameters() {
		return parameters;
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

	public Set<AbsDeclarationStatement> getLocalDeclarations() {
		return localDeclarations;
	}
}
