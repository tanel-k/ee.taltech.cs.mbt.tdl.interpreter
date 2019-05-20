package ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.ItemContext;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.SequenceItemContext;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.StringItemContext;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.AbsSExpressionNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageBaseVisitor;

public class ItemConverter extends SExpressionLanguageBaseVisitor<AbsSExpressionNode>
		implements IParseTreeConverter<AbsSExpressionNode, ItemContext> {
	private static final ItemConverter INSTANCE = new ItemConverter();

	public static ItemConverter getInstance() {
		return INSTANCE;
	}

	private ItemConverter() { }

	@Override
	public AbsSExpressionNode convert(ItemContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public AbsSExpressionNode visitSequenceItem(SequenceItemContext ctx) {
		return SequenceConverter.getInstance().convert(ctx.sequence());
	}

	@Override
	public AbsSExpressionNode visitStringItem(StringItemContext ctx) {
		return new SExpressionStringNode().setString(
				StringConverter.getInstance().convert(ctx.string())
		);
	}
}
