package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.common.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.ArrayIdentifierLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.AbsChannelRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.ChannelIdentifierRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.DefaultChannelPriorityRef;
import org.antlr.v4.runtime.tree.ErrorNode;

public class ChannelRefExpressionConverter extends UTALanguageBaseVisitor<AbsChannelRef>
		implements IParseTreeConverter<AbsChannelRef, ChannelRefExpressionContext>
{
	@Override
	public AbsChannelRef convert(ChannelRefExpressionContext rootContext) throws ParseTreeStructureException {
		return null;
	}

	@Override
	public AbsChannelRef visitErrorNode(ErrorNode node) {
		throw new ParseTreeStructureException(
			"Channel reference expression subtree contains an error node (" + node.getText() + ")."
		);
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
			AbsExpression lookupExpression = new ExpressionConverter().convert(exprCtx);
			arrayIdentifierLookup.getLookupExpressions().add(lookupExpression);
		}

		ChannelArrayLookup channelArrayLookup = new ChannelArrayLookup();
		channelArrayLookup.setArrayIdentifierLookup(arrayIdentifierLookup);
		return channelArrayLookup;
	}
}
