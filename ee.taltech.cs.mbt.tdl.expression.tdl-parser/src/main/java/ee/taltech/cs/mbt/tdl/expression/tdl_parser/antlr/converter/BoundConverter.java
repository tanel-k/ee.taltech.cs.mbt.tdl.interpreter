package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.BoundOverNaturalsContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.EqualityBoundContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.GreaterThanBoundContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.GreaterThanOrEqBoundContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.LessThanBoundContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.LessThanOrEqBoundContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.EBoundType;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigInteger;

public class BoundConverter extends TdlExpressionLanguageBaseVisitor<Bound>
		implements IParseTreeConverter<Bound, BoundOverNaturalsContext> {
	public static BoundConverter getInstance() {
		return INSTANCE;
	}

	private static final BoundConverter INSTANCE = new BoundConverter();

	private Bound newBound(EBoundType type, TerminalNode intNode) {
		Bound bound = new Bound();
		bound.setBoundType(type);
		bound.setBoundValue(new BigInteger(intNode.getText()));
		return bound;
	}

	private BoundConverter() { }

	@Override
	public Bound convert(BoundOverNaturalsContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public Bound visitEqualityBound(EqualityBoundContext ctx) {
		return newBound(EBoundType.EQUALS, ctx.NATURAL_NUMBER());
	}

	@Override
	public Bound visitGreaterThanBound(GreaterThanBoundContext ctx) {
		return newBound(EBoundType.GREATER_THAN, ctx.NATURAL_NUMBER());
	}

	@Override
	public Bound visitGreaterThanOrEqBound(GreaterThanOrEqBoundContext ctx) {
		return newBound(EBoundType.GREATER_THAN_OR_EQUAL_TO, ctx.NATURAL_NUMBER());
	}

	@Override
	public Bound visitLessThanBound(LessThanBoundContext ctx) {
		return newBound(EBoundType.LESS_THAN, ctx.NATURAL_NUMBER());
	}

	@Override
	public Bound visitLessThanOrEqBound(LessThanOrEqBoundContext ctx) {
		return newBound(EBoundType.LESS_THAN_OR_EQUAL_TO, ctx.NATURAL_NUMBER());
	}
}
