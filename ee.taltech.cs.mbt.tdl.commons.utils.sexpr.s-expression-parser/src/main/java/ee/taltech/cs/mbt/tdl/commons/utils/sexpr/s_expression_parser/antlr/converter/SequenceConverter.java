package ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.EmptySequenceContext;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.NonEmptySequenceContext;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.SequenceContext;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_model.nodes.SExpressionSequenceNode;

public class SequenceConverter extends SExpressionLanguageBaseVisitor<SExpressionSequenceNode>
		implements IParseTreeConverter<SExpressionSequenceNode, SequenceContext> {
	private static final SequenceConverter INSTANCE = new SequenceConverter();

	public static SequenceConverter getInstance() {
		return INSTANCE;
	}

	private SequenceConverter() { }

	@Override
	public SExpressionSequenceNode convert(SequenceContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public SExpressionSequenceNode visitEmptySequence(EmptySequenceContext ctx) {
		return new SExpressionSequenceNode();
	}

	@Override
	public SExpressionSequenceNode visitNonEmptySequence(NonEmptySequenceContext ctx) {
		SExpressionSequenceNode sequenceNode = new SExpressionSequenceNode();
		ctx.item().stream().forEachOrdered(
				itemCtx -> sequenceNode.getChildren().add(ItemConverter.getInstance().convert(itemCtx))
		);
		return sequenceNode;
	}
}
