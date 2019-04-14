package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter.utils.ExpressionConverter;

public class ExpressionTreeConverter implements IParseTreeConverter<TdlExpression, ExpressionContext> {
	public static ExpressionTreeConverter getInstance() {
		return INSTANCE;
	}

	private static final ExpressionTreeConverter INSTANCE = new ExpressionTreeConverter();

	private ExpressionTreeConverter() { }

	@Override
	public TdlExpression convert(ExpressionContext ctx) {
		AbsBooleanInternalNode rootNode = (AbsBooleanInternalNode) ExpressionConverter.getInstance().convert(ctx);
		TdlExpression tdlExpression = new TdlExpression();
		tdlExpression.setRootNode(rootNode);
		return tdlExpression;
	}
}
