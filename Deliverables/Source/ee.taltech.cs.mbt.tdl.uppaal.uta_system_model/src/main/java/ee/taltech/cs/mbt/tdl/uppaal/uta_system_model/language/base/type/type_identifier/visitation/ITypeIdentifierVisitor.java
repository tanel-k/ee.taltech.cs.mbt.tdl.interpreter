package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.BooleanTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.ChannelTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.ClockTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.IntegerTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BoundedIntegerTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.IdRefTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.ScalarTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.StructTypeIdentifier;

public interface ITypeIdentifierVisitor<T> {
	T visitStructTypeIdentifier(StructTypeIdentifier identifier);
	T visitScalarTypeIdentifier(ScalarTypeIdentifier identifier);
	T visitIdRefTypeIdentifier(IdRefTypeIdentifier identifier);
	T visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeIdentifier identifier);
	T visitBooleanTypeIdentifier(BooleanTypeIdentifier identifier);
	T visitIntegerTypeIdentifier(IntegerTypeIdentifier identifier);
	T visitChannelTypeIdentifier(ChannelTypeIdentifier identifier);
	T visitClockTypeIdentifier(ClockTypeIdentifier identifier);
}
