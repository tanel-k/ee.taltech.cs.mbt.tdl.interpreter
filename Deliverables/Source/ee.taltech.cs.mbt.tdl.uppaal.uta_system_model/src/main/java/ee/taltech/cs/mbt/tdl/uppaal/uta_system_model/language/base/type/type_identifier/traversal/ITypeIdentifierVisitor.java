package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.traversal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.BooleanTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.ChannelTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.ClockTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.IntegerTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BoundedIntegerTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.IdRefTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.ScalarTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.StructTypeIdentifier;

public interface ITypeIdentifierVisitor {
	void visitStructTypeIdentifier(StructTypeIdentifier structTypeIdentifier);
	void visitScalarTypeIdentifier(ScalarTypeIdentifier scalarTypeIdentifier);
	void visitIdRefTypeIdentifier(IdRefTypeIdentifier idRefTypeIdentifier);
	void visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeIdentifier boundedIntegerTypeIdentifier);
	void visitBooleanTypeIdentifier(BooleanTypeIdentifier booleanTypeIdentifier);
	void visitIntegerTypeIdentifier(IntegerTypeIdentifier integerTypeIdentifier);
	void visitChannelTypeIdentifier(ChannelTypeIdentifier channelTypeIdentifier);
	void visitClockTypeIdentifier(ClockTypeIdentifier clockTypeIdentifier);
}
