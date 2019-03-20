package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer.visitation.IInitializerVisitor;

public abstract class AbsInitializer {
	abstract void accept(IInitializerVisitor visitor);
}
