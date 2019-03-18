package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types;

public class BaseTypeIdentifiers {
	public static final String ID_BOOLEAN = "Boolean";
	public static final String ID_INTEGER = "Integer";
	public static final String ID_CHANNEL = "Channel";

	public static final AbsTypeIdentifier BOOLEAN = new AbsTypeIdentifier(ID_BOOLEAN) {};
	public static final AbsTypeIdentifier INTEGER = new AbsTypeIdentifier(ID_INTEGER) {};
	public static final AbsTypeIdentifier CHANNEL = new AbsTypeIdentifier(ID_CHANNEL) {};
}
