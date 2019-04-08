package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.ETypePrefix;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;

public class SampleSystemFactory {
	public static SampleSystemFactory newInstance() {
		return new SampleSystemFactory();
	}

	private UtaSystem system;

	public SampleSystemFactory() {
		this.system = new UtaSystem();
	}

	protected AbsDeclarationStatement newMAX_INTDecl() {
		BaseType baseType = new BaseType();
		baseType.setPrefix(ETypePrefix.CONSTANT);
		baseType.setTypeId(BaseTypeIdentifiers.INTEGER);
		Type type = new Type();
		type.setBaseType(baseType);
		NaturalNumberLiteral literal = NaturalNumberLiteral.of(32767);
		FlatVariableInitializer initializer = new FlatVariableInitializer();
		initializer.setExpression(literal);
		VariableDeclaration variableDeclaration = new VariableDeclaration();
		variableDeclaration.setIdentifier(Identifier.of("MAX_INT"));
		variableDeclaration.setInitializer(initializer);
		return variableDeclaration;
	}

	protected AbsDeclarationStatement newTDL_TIMEOUTDecl() {
		BaseType baseType = new BaseType();
		baseType.setPrefix(ETypePrefix.CONSTANT);
		baseType.setTypeId(BaseTypeIdentifiers.INTEGER);
		Type type = new Type();
		type.setBaseType(baseType);
		NaturalNumberLiteral literal = NaturalNumberLiteral.of(10000);
		FlatVariableInitializer initializer = new FlatVariableInitializer();
		initializer.setExpression(literal);
		VariableDeclaration variableDeclaration = new VariableDeclaration();
		variableDeclaration.setType(type);
		variableDeclaration.setIdentifier(Identifier.of("TDL_TIMEOUT"));
		variableDeclaration.setInitializer(initializer);
		return variableDeclaration;
	}


	public UtaSystem newSampleSystem() {
		CollectionUtils.addIfNonNull(
				system.getGlobalDeclarations(),
				newMAX_INTDecl()
		);
		CollectionUtils.addIfNonNull(
				system.getGlobalDeclarations(),
				newTDL_TIMEOUTDecl()
		);
		system.getTemplates();
		system.getSystemDefinition();
		return system;
	}
}
