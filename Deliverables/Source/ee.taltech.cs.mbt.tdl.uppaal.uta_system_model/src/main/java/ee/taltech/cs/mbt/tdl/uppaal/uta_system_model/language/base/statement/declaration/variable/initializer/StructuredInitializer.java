package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer.visitation.IInitializerVisitor;

import java.util.LinkedList;
import java.util.List;

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
