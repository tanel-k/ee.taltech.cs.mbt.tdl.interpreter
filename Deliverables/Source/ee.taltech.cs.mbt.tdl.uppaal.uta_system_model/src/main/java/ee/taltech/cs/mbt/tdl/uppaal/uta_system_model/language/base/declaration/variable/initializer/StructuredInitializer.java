package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.visitation.IInitializerVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an UPPAAL array/struct initializer.<br/>
 * Example: <i>struct { int a; bool b; } s = { 2, true };</i>.<br/>
 */
public class StructuredInitializer extends AbsInitializer {
	private List<AbsInitializer> initializers = new LinkedList<>();

	public List<AbsInitializer> getInitializers() {
		return initializers;
	}

	@Override
	void accept(IInitializerVisitor visitor) {
		visitor.visitStructuredInitializer(this);
	}
}
