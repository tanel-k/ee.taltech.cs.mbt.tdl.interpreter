package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.BooleanTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.ChannelTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.ClockTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.IntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.ScalarTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.struct.StructTypeId;

public interface ITypeIdentifierVisitor<T> {
	T visitStructTypeIdentifier(StructTypeId id);
	T visitScalarTypeIdentifier(ScalarTypeId id);
	T visitIdRefTypeIdentifier(CustomTypeId id);
	T visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId id);
	T visitBooleanTypeIdentifier(BooleanTypeId id);
	T visitIntegerTypeIdentifier(IntegerTypeId id);
	T visitChannelTypeIdentifier(ChannelTypeId id);
	T visitClockTypeIdentifier(ClockTypeId id);
}
