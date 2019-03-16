package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.labels.generic.AbsUTAGuiLabel;

public class UTACommentLabel extends AbsUTAGuiLabel<String> {
	public static final String LABEL_TYPE = "COMMENT";

	public UTACommentLabel() {
		super(LABEL_TYPE);
	}
}
// TODO