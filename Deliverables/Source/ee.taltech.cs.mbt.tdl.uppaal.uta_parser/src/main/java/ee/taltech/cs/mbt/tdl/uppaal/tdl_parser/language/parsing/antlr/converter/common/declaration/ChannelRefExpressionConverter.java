package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.channel_priority.channel_reference.AbsChannelRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.channel_priority.channel_reference.ChannelIdentifierRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.channel_priority.channel_reference.DefaultChannelPriorityRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.ArrayIdentifierLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;

public class ChannelRefExpressionConverter extends UtaLanguageBaseVisitor<AbsChannelRef>
		implements IParseTreeConverter<AbsChannelRef, ChannelRefExpressionContext>
{
	public static ChannelRefExpressionConverter getInstance() {
		return INSTANCE;
	}

	private static final ChannelRefExpressionConverter INSTANCE = new ChannelRefExpressionConverter();

	private ChannelRefExpressionConverter() { }

	@Override
	public AbsChannelRef convert(ChannelRefExpressionContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public AbsChannelRef visitChannelDefaultPriorityExpr(ChannelDefaultPriorityExprContext ctx) {
		return DefaultChannelPriorityRef.INSTANCE;
	}

	@Override
	public AbsChannelRef visitChannelIdentifierNameExpr(ChannelIdentifierNameExprContext ctx) {
		IdentifierName identifierName = new IdentifierName();
		identifierName.setName(ctx.IDENTIFIER_NAME().getText());
		ChannelIdentifierRef channelIdentifierRef = new ChannelIdentifierRef();
		channelIdentifierRef.setIdentifierName(identifierName);
		return channelIdentifierRef;
	}

	@Override
	public AbsChannelRef visitChannelArrayLookupExr(ChannelArrayLookupExrContext ctx) {
		ArrayIdentifierLookupContext arrayAccessCtx = ctx.arrayIdentifierLookup();

		IdentifierName identifierName = new IdentifierName();
		identifierName.setName(arrayAccessCtx.IDENTIFIER_NAME().getText());

		ArrayIdentifierLookup arrayIdentifierLookup = new ArrayIdentifierLookup();
		arrayIdentifierLookup.setIdentifierName(identifierName);

		for (ExpressionContext exprCtx : arrayAccessCtx.expression()) {
			AbsExpression lookupExpression = ExpressionConverter.getInstance().convert(exprCtx);
			arrayIdentifierLookup.getLookupExpressions().add(lookupExpression);
		}

		ChannelArrayLookup channelArrayLookup = new ChannelArrayLookup();
		channelArrayLookup.setArrayIdentifierLookup(arrayIdentifierLookup);
		return channelArrayLookup;
	}
}
