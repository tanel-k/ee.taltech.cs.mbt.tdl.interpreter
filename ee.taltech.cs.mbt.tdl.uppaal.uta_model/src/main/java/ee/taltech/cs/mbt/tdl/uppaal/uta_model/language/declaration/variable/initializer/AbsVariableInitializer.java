package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IInitializerVisitor;

/**
 * Represents an initializer for a variable declaration.<br/>
 * UPPAAL supports array/struct and flat expression initializers.
 */
public abstract class AbsVariableInitializer implements IDeepCloneable<AbsVariableInitializer> {
	public abstract <T> T accept(IInitializerVisitor<T> visitor);
}
