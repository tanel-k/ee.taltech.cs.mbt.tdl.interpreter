package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic;

/**
 * Marker interface for expression nodes which have an
 * assignment variant.<br/>
 * <br/>
 * For example:<br/>
 * <pre>
 * a + b is a regular addition operator
 * a += b is the counterpart add-and-assign operator
 * </pre>
 * <br/>
 * It is more convenient to use this marker interface
 * rather than add duplicate classes.
 */
public interface IHasAssignmentCounterpart {
	boolean isAssignment();
	IHasAssignmentCounterpart setAssignment(boolean assignment);
}
