package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.ETypePrefix;

public class TypePrefixConverter extends UtaLanguageBaseVisitor<ETypePrefix>
	implements IParseTreeConverter<ETypePrefix, TypePrefixContext> {
	public static TypePrefixConverter getInstance() {
		return INSTANCE;
	}

	private static final TypePrefixConverter INSTANCE = new TypePrefixConverter();

	private TypePrefixConverter() { }

	@Override
	public ETypePrefix convert(TypePrefixContext rootContext) {
		ETypePrefix typePrefix;
		if (rootContext == null || (typePrefix = rootContext.accept(this)) == null)
			typePrefix = ETypePrefix.NONE;
		return typePrefix;
	}

	@Override
	public ETypePrefix visitTypePrefixBroadcast(TypePrefixBroadcastContext ctx) {
		return ETypePrefix.BROADCAST;
	}

	@Override
	public ETypePrefix visitTypePrefixMeta(TypePrefixMetaContext ctx) {
		return ETypePrefix.META;
	}

	@Override
	public ETypePrefix visitTypePrefixConstant(TypePrefixConstantContext ctx) {
		return ETypePrefix.CONSTANT;
	}

	@Override
	public ETypePrefix visitTypePrefixUrgent(TypePrefixUrgentContext ctx) {
		return ETypePrefix.URGENT;
	}
}
