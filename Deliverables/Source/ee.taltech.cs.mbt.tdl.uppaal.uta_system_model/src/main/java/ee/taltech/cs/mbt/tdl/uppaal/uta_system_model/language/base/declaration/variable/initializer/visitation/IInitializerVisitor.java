package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.FlatInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.StructuredInitializer;

public interface IInitializerVisitor {
	void visitFlatInitializer(FlatInitializer flatInitializer);
	void visitStructuredInitializer(StructuredInitializer structuredInitializer);
}
