package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.EmptySequenceContext;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.NonEmptySequenceContext;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.SequenceContext;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes.SExprSequenceNode;

public class SequenceConverter extends SExpressionLanguageBaseVisitor<SExprSequenceNode>
		implements IParseTreeConverter<SExprSequenceNode, SequenceContext> {
	private static final SequenceConverter INSTANCE = new SequenceConverter();

	public static SequenceConverter getInstance() {
		return INSTANCE;
	}

	private SequenceConverter() { }

	@Override
	public SExprSequenceNode convert(SequenceContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public SExprSequenceNode visitEmptySequence(EmptySequenceContext ctx) {
		return new SExprSequenceNode();
	}

	@Override
	public SExprSequenceNode visitNonEmptySequence(NonEmptySequenceContext ctx) {
		SExprSequenceNode sequenceNode = new SExprSequenceNode();
		ctx.item().stream().forEachOrdered(
				itemCtx -> sequenceNode.getChildren().add(ItemConverter.getInstance().convert(itemCtx))
		);
		return sequenceNode;
	}
}
