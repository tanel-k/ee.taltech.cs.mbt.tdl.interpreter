package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.ItemContext;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.SequenceItemContext;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.StringItemContext;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes.AbsSExprNode;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes.SExprStringNode;

public class ItemConverter extends SExpressionLanguageBaseVisitor<AbsSExprNode>
		implements IParseTreeConverter<AbsSExprNode, ItemContext> {
	private static final ItemConverter INSTANCE = new ItemConverter();

	public static ItemConverter getInstance() {
		return INSTANCE;
	}

	private ItemConverter() { }

	@Override
	public AbsSExprNode convert(ItemContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public AbsSExprNode visitSequenceItem(SequenceItemContext ctx) {
		return SequenceConverter.getInstance().convert(ctx.sequence());
	}

	@Override
	public AbsSExprNode visitStringItem(StringItemContext ctx) {
		return new SExprStringNode().setString(
				StringConverter.getInstance().convert(ctx.string())
		);
	}
}
