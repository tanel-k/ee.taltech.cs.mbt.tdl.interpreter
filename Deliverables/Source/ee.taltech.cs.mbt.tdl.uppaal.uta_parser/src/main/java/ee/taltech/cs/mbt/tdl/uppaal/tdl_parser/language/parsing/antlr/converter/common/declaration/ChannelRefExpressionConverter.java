package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.ChannelIdentifierRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.DefaultChannelPriorityRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.ArrayVariableLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;

public class ChannelRefExpressionConverter extends UtaLanguageBaseVisitor<AbsChannelReference>
		implements IParseTreeConverter<AbsChannelReference, ChannelRefExpressionContext>
{
	public static ChannelRefExpressionConverter getInstance() {
		return INSTANCE;
	}

	private static final ChannelRefExpressionConverter INSTANCE = new ChannelRefExpressionConverter();

	private ChannelRefExpressionConverter() { }

	@Override
	public AbsChannelReference convert(ChannelRefExpressionContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public AbsChannelReference visitChannelDefaultPriorityExpr(ChannelDefaultPriorityExprContext ctx) {
		return DefaultChannelPriorityRef.INSTANCE;
	}

	@Override
	public AbsChannelReference visitChannelIdentifierNameExpr(ChannelIdentifierNameExprContext ctx) {
		Identifier identifier = new Identifier();
		identifier.setName(ctx.IDENTIFIER_NAME().getText());
		ChannelIdentifierRef channelIdentifierRef = new ChannelIdentifierRef();
		channelIdentifierRef.setIdentifierName(identifier);
		return channelIdentifierRef;
	}

	@Override
	public AbsChannelReference visitChannelArrayLookupExr(ChannelArrayLookupExrContext ctx) {
		ArrayIdentifierLookupContext arrayAccessCtx = ctx.arrayIdentifierLookup();

		Identifier identifier = new Identifier();
		identifier.setName(arrayAccessCtx.IDENTIFIER_NAME().getText());

		ArrayVariableLookup arrayVariableLookup = new ArrayVariableLookup();
		arrayVariableLookup.setIdentifier(identifier);

		for (ExpressionContext exprCtx : arrayAccessCtx.expression()) {
			AbsExpression lookupExpression = ExpressionConverter.getInstance().convert(exprCtx);
			arrayVariableLookup.getLookupExpressions().add(lookupExpression);
		}

		ChannelArrayLookup channelArrayLookup = new ChannelArrayLookup();
		channelArrayLookup.setArrayIdentifierLookup(arrayVariableLookup);
		return channelArrayLookup;
	}
}
