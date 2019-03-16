package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.labels.generic.AbsUTAGuiLabel;

public class UTAInvariantLabel extends AbsUTAGuiLabel<String> {
	public static final String LABEL_TYPE = "INVARIANT";

	public UTAInvariantLabel() {
		super(LABEL_TYPE);
	}
}
// TODO