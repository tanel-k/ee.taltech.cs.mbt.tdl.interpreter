package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.declaration;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ArrayVariableLookupContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelArrayLookupContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelIdentifierReferenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelReferenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DefaultChannelReferenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.ChannelIdentifierReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.DefaultChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.ArrayVariableLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression.ExpressionConverter;

public class ChannelReferenceConverter extends UtaLanguageBaseVisitor<AbsChannelReference>
		implements IParseTreeConverter<AbsChannelReference, ChannelReferenceContext> {
	public static ChannelReferenceConverter getInstance() {
		return INSTANCE;
	}

	private static final ChannelReferenceConverter INSTANCE = new ChannelReferenceConverter();

	private ChannelReferenceConverter() { }

	@Override
	public AbsChannelReference convert(ChannelReferenceContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public AbsChannelReference visitDefaultChannelReference(DefaultChannelReferenceContext ctx) {
		return DefaultChannelReference.getInstance();
	}

	@Override
	public AbsChannelReference visitChannelIdentifierReference(ChannelIdentifierReferenceContext ctx) {
		return new ChannelIdentifierReference()
				.setIdentifier(Identifier.of(ctx.IDENTIFIER_NAME().getText()));
	}

	@Override
	public AbsChannelReference visitChannelArrayLookup(ChannelArrayLookupContext ctx) {
		ArrayVariableLookupContext arrayAccessCtx = ctx.arrayVariableLookup();

		Identifier identifier = Identifier.of(arrayAccessCtx.IDENTIFIER_NAME().getText());

		ArrayVariableLookup arrayVariableLookup = new ArrayVariableLookup();
		arrayVariableLookup.setIdentifier(identifier);

		for (ExpressionContext exprCtx : arrayAccessCtx.expression()) {
			AbsExpression lookupExpression = ExpressionConverter.getInstance().convert(exprCtx);
			arrayVariableLookup.getLookupExpressions().add(lookupExpression);
		}

		return new ChannelArrayLookup()
				.setArrayVariableLookup(arrayVariableLookup);
	}
}
