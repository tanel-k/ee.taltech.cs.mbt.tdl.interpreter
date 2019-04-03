package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.StructuredVariableInitializer;

public interface IInitializerVisitor<T> {
	T visitFlatInitializer(FlatVariableInitializer init);
	T visitStructuredInitializer(StructuredVariableInitializer init);
}
