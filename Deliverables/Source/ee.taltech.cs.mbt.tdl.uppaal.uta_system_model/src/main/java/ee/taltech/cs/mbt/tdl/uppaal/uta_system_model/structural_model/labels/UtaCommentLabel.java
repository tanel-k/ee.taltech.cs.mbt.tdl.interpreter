package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

public class UtaCommentLabel extends AbsUtaLabel<String> {
	public static UtaCommentLabel of(String comment) {
		UtaCommentLabel inst = new UtaCommentLabel();
		inst.setContent(comment == null ? "" : comment);
		return inst;
	}
}
