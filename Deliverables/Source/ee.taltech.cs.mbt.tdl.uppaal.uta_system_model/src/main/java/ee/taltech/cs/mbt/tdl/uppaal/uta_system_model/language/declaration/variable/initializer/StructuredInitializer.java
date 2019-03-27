package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable.initializer;

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
	public <T> T accept(IInitializerVisitor<T> visitor) {
		return visitor.visitStructuredInitializer(this);
	}
}
