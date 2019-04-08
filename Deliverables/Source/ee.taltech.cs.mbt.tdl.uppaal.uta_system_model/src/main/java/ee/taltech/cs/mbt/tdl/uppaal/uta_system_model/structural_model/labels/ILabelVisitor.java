package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.InvariantLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SelectionLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SynchronizationLabel;

public interface ILabelVisitor<T> {
	T visitAssignments(AssignmentsLabel label);
	T visitComment(CommentLabel label);
	T visitGuard(GuardLabel label);
	T visitInvariant(InvariantLabel label);
	T visitSelection(SelectionLabel label);
	T visitSynchronization(SynchronizationLabel label);
}
