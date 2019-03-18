package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.template.transition;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types.AbsTypeIdentifier;

import java.util.LinkedList;
import java.util.List;

public class UTATransitionSelectionList {
	public static class Selection<TypeIdentifier extends AbsTypeIdentifier> {
		private Identifier variable;
		private Type<TypeIdentifier> selectionSourceType;

		public Identifier getVariable() {
			return variable;
		}

		public void setVariable(Identifier variable) {
			this.variable = variable;
		}

		public Type<TypeIdentifier> getSelectionSourceType() {
			return selectionSourceType;
		}

		public void setSelectionSourceType(Type<TypeIdentifier> selectionSourceType) {
			this.selectionSourceType = selectionSourceType;
		}
	}

	private List<Selection> selections;

	public UTATransitionSelectionList() {
		this.selections = new LinkedList<>();
	}

	public List<Selection> getSelections() {
		return selections;
	}
}
