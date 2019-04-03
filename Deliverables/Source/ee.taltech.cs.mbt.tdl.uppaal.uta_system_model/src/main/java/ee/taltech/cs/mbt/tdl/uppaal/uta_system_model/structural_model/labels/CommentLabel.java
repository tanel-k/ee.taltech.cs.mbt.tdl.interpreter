package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

public class CommentLabel extends AbsUtaLabel<String> {
	public static CommentLabel of(String comment) {
		CommentLabel inst = new CommentLabel();
		inst.setContent(comment == null ? "" : comment);
		return inst;
	}
}
