package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

import java.util.LinkedList;
import java.util.List;

public class UtaSelectLabel extends AbsUtaLabel<List<Selection>> {
	public static UtaSelectLabel of(List<Selection> expressions) {
		UtaSelectLabel inst = new UtaSelectLabel();
		inst.setContent(expressions == null ? new LinkedList<>() : expressions);
		return inst;
	}
}
