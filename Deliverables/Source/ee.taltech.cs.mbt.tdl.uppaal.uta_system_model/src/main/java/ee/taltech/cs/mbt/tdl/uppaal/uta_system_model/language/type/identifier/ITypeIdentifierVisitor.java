package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.BaseTypeIdentifiers.BooleanTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.BaseTypeIdentifiers.ChannelTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.BaseTypeIdentifiers.ClockTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.BaseTypeIdentifiers.IntegerTypeId;

public interface ITypeIdentifierVisitor<T> {
	T visitStructTypeIdentifier(StructTypeId identifier);
	T visitScalarTypeIdentifier(ScalarTypeId identifier);
	T visitIdRefTypeIdentifier(IdRefTypeId identifier);
	T visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId identifier);
	T visitBooleanTypeIdentifier(BooleanTypeId identifier);
	T visitIntegerTypeIdentifier(IntegerTypeId identifier);
	T visitChannelTypeIdentifier(ChannelTypeId identifier);
	T visitClockTypeIdentifier(ClockTypeId identifier);
}
