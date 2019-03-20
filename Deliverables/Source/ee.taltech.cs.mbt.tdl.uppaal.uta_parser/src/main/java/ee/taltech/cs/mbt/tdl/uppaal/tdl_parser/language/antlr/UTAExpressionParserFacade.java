package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.generic.AbsUTAParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public abstract class UTAExpressionParserFacade
	extends AbsUTAParserFacade<AbsExpression, ExpressionContext, ExpressionConverter>
{
	public static class UTAGuardParserFacade extends UTAExpressionParserFacade {
		@Override
		protected ExpressionContext getRootContext(UTALanguageParser parser) {
			return parser.utaTransitionGuardExpression().expression();
		}
	}

	public static class UTAInvariantParserFacade extends UTAExpressionParserFacade {
		@Override
		protected ExpressionContext getRootContext(UTALanguageParser parser) {
			return parser.utaLocationInvariantExpression().expression();
		}
	}

	@Override
	protected ExpressionConverter getConverter() {
		return new ExpressionConverter();
	}
}
