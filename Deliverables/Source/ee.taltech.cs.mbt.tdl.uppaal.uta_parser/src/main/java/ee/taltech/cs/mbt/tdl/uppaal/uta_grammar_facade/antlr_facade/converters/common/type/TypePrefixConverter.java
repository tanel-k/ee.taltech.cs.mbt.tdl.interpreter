package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.ETypePrefix;
import org.antlr.v4.runtime.tree.ErrorNode;

public class TypePrefixConverter extends UTALanguageBaseVisitor<ETypePrefix>
	implements IParseTreeConverter<ETypePrefix, TypePrefixContext> {
	@Override
	public ETypePrefix convert(TypePrefixContext rootContext) throws ParseTreeStructureException {
		ETypePrefix typePrefix;
		if ((typePrefix = rootContext.accept(this)) == null)
			typePrefix = ETypePrefix.NONE;
		return typePrefix;
	}

	@Override
	public ETypePrefix visitErrorNode(ErrorNode node) {
		throw new ParseTreeStructureException(
			"Type prefix subtree contains an error node (" + node.getText() + ")."
		);
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
