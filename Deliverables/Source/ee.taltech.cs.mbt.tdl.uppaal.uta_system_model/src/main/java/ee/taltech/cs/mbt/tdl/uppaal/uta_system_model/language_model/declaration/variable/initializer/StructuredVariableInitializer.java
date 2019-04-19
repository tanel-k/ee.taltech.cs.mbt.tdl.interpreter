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

	public StructuredVariableInitializer addInitializer(AbsVariableInitializer initializer) {
		getInitializers().add(initializer);
		return this;
	}

	@Override
	public <T> T accept(IInitializerVisitor<T> visitor) {
		return visitor.visitStructuredInitializer(this);
	}

	@Override
	public StructuredVariableInitializer deepClone() {
		StructuredVariableInitializer clone = new StructuredVariableInitializer();
		initializers.stream().forEachOrdered(
				i -> clone.initializers.add(i.deepClone())
		);
		return clone;
	}
}
