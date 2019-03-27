package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

public class UtaAssignmentsLabel extends AbsUtaLabel<List<AbsExpression>> {
	public static UtaAssignmentsLabel of(List<AbsExpression> expressions) {
		UtaAssignmentsLabel inst = new UtaAssignmentsLabel();
		inst.setContent(expressions == null ? new LinkedList<>() : expressions);
		return inst;
	}
}
