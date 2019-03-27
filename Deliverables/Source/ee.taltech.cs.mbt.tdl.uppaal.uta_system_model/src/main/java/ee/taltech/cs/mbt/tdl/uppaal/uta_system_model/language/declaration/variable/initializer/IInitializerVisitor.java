package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable.initializer.FlatInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable.initializer.StructuredInitializer;

public interface IInitializerVisitor<T> {
	T visitFlatInitializer(FlatInitializer flatInitializer);
	T visitStructuredInitializer(StructuredInitializer structuredInitializer);
}
