package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IInitializerVisitor;

/**
 * Represents an initializer for a variable declaration.<br/>
 * UPPAAL supports array/struct and flat expression initializers.
 */
public abstract class AbsVariableInitializer {
	public abstract <T> T accept(IInitializerVisitor<T> visitor);
}
