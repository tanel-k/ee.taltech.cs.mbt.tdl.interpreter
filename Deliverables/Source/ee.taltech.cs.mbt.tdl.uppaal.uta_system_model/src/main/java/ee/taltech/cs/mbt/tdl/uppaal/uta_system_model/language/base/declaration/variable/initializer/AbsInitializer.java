package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.visitation.IInitializerVisitor;

/**
 * Represents an initializer for a variable declaration.<br/>
 * UPPAAL supports array/struct and flat expression initializers.
 */
public abstract class AbsInitializer {
	abstract void accept(IInitializerVisitor visitor);
}
