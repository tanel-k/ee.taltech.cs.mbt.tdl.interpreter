package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IInitializerVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an UPPAAL array/struct initializer.<br/>
 * Example: <i>struct { int a; bool b; } s = { 2, true };</i>.<br/>
 */
public class StructuredVariableInitializer extends AbsVariableInitializer {
	private List<AbsVariableInitializer> initializers = new LinkedList<>();

	public List<AbsVariableInitializer> getInitializers() {
		return initializers;
	}

	@Override
	public <T> T accept(IInitializerVisitor<T> visitor) {
		return visitor.visitStructuredInitializer(this);
	}
}
