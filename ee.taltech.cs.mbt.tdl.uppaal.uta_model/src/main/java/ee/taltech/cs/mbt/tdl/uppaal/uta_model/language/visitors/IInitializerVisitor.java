package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.StructuredVariableInitializer;

public interface IInitializerVisitor<T> {
	T visitFlatInitializer(FlatVariableInitializer init);
	T visitStructuredInitializer(StructuredVariableInitializer init);
}
