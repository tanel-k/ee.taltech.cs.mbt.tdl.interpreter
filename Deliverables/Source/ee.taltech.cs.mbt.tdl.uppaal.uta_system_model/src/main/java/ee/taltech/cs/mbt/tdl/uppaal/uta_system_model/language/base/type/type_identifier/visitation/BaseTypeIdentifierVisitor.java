package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.BooleanTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.ChannelTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.ClockTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BaseTypeIdentifiers.IntegerTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.BoundedIntegerTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.IdRefTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.ScalarTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.StructTypeIdentifier;

public class BaseTypeIdentifierVisitor implements ITypeIdentifierVisitor {
	@Override public void visitStructTypeIdentifier(StructTypeIdentifier structTypeIdentifier) { }
	@Override public void visitScalarTypeIdentifier(ScalarTypeIdentifier scalarTypeIdentifier) { }
	@Override public void visitIdRefTypeIdentifier(IdRefTypeIdentifier idRefTypeIdentifier) { }
	@Override public void visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeIdentifier boundedIntegerTypeIdentifier) { }
	@Override public void visitBooleanTypeIdentifier(BooleanTypeIdentifier booleanTypeIdentifier) { }
	@Override public void visitIntegerTypeIdentifier(IntegerTypeIdentifier integerTypeIdentifier) { }
	@Override public void visitChannelTypeIdentifier(ChannelTypeIdentifier channelTypeIdentifier) { }
	@Override public void visitClockTypeIdentifier(ClockTypeIdentifier clockTypeIdentifier) { }
}
