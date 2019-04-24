package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.BooleanTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.ChannelTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.ClockTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.IntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.ScalarTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.StructTypeId;

public interface ITypeIdentifierVisitor<T> {
	T visitStructTypeIdentifier(StructTypeId id);
	T visitScalarTypeIdentifier(ScalarTypeId id);
	T visitCustomTypeIdentifier(CustomTypeId id);
	T visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId id);
	T visitBooleanTypeIdentifier(BooleanTypeId id);
	T visitIntegerTypeIdentifier(IntegerTypeId id);
	T visitChannelTypeIdentifier(ChannelTypeId id);
	T visitClockTypeIdentifier(ClockTypeId id);
}
