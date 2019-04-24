package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.InvariantLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.SelectionLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.SynchronizationLabel;

public interface ILabelVisitor<T> {
	T visitAssignments(AssignmentsLabel label);
	T visitComment(CommentLabel label);
	T visitGuard(GuardLabel label);
	T visitInvariant(InvariantLabel label);
	T visitSelection(SelectionLabel label);
	T visitSynchronization(SynchronizationLabel label);
}
