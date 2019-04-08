package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.ILabelVisitor;

import java.util.LinkedList;
import java.util.List;

public class AssignmentsLabel extends AbsUtaLabel<List<AbsExpression>> {
	public static AssignmentsLabel of(List<AbsExpression> expressions) {
		AssignmentsLabel inst = new AssignmentsLabel();
		inst.setContent(expressions == null ? new LinkedList<>() : expressions);
		return inst;
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitAssignments(this);
	}
}
