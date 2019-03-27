package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.ErrorStrategyConfigFactory;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorListener;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.declaration.DeclarationSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.parameter.ParameterSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.SystemDefinitionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.template.AssignmentsConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.template.SelectionSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.template.SynchronizationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ParameterSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SelectionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemDefinitionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.LinkedList;
import java.util.List;

public class UtaAntlrFacadeFactory {
	public static UtaAntlrFacadeFactory newInstance() {
		return new UtaAntlrFacadeFactory();
	}

	private List<ErrorListener> errorListeners = new LinkedList<>();
	private ErrorStrategyConfig errorStrategyConfig = ErrorStrategyConfigFactory.failFastConfig();

	private UtaAntlrFacadeFactory() { }

	private <R, C extends ParseTree> AbsUtaAntlrParserFacade<R, C> configure(AbsUtaAntlrParserFacade<R, C> parserFacade) {
		parserFacade.getErrorListeners().clear();
		parserFacade.setErrorStrategyConfig(errorStrategyConfig);
		parserFacade.getErrorListeners().addAll(errorListeners);
		return parserFacade;
	}

	public ErrorStrategyConfig getErrorStrategyConfig() {
		return errorStrategyConfig;
	}

	public void setErrorStrategyConfig(ErrorStrategyConfig errorStrategyConfig) {
		this.errorStrategyConfig = errorStrategyConfig;
	}

	public List<ErrorListener> getErrorListeners() {
		return errorListeners;
	}

	public AbsUtaAntlrParserFacade<AbsExpression, ExpressionContext> invariantFacade() {
		return configure(new AbsUtaAntlrParserFacade<AbsExpression, ExpressionContext>() {
			@Override
			protected ExpressionContext getRootContext(UtaLanguageParser parser) {
				return parser.expression();
			}

			@Override
			protected IParseTreeConverter<AbsExpression, ExpressionContext> getConverter() {
				return ExpressionConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<AbsExpression, ExpressionContext> guardFacade() {
		return configure(new AbsUtaAntlrParserFacade<AbsExpression, ExpressionContext>() {
			@Override
			protected ExpressionContext getRootContext(UtaLanguageParser parser) {
				return parser.expression();
			}

			@Override
			protected IParseTreeConverter<AbsExpression, ExpressionContext> getConverter() {
				return ExpressionConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<SystemDefinition, SystemDefinitionContext> systemDefinitionFacade() {
		return configure(new AbsUtaAntlrParserFacade<SystemDefinition, SystemDefinitionContext>() {
			@Override
			protected SystemDefinitionContext getRootContext(UtaLanguageParser parser) {
				return parser.systemDefinition();
			}

			@Override
			protected IParseTreeConverter<SystemDefinition, SystemDefinitionContext> getConverter() {
				return SystemDefinitionConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<List<AbsExpression>, ExpressionSequenceContext> updatesFacade() {
		return configure(new AbsUtaAntlrParserFacade<List<AbsExpression>, ExpressionSequenceContext>() {
			@Override
			protected ExpressionSequenceContext getRootContext(UtaLanguageParser parser) {
				return parser.expressionSequence();
			}

			@Override
			protected IParseTreeConverter<List<AbsExpression>, ExpressionSequenceContext> getConverter() {
				return AssignmentsConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<List<Selection>, SelectionSequenceContext> selectionFacade() {
		return configure(new AbsUtaAntlrParserFacade<List<Selection>, SelectionSequenceContext>() {
			@Override
			protected SelectionSequenceContext getRootContext(UtaLanguageParser parser) {
				return parser.selectionSequence();
			}

			@Override
			protected IParseTreeConverter<List<Selection>, SelectionSequenceContext> getConverter() {
				return SelectionSequenceConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<Synchronization, SynchronizationContext> synchronizationFacade() {
		return configure(new AbsUtaAntlrParserFacade<Synchronization, SynchronizationContext>() {
			@Override
			protected SynchronizationContext getRootContext(UtaLanguageParser parser) {
				return parser.synchronization();
			}

			@Override
			protected IParseTreeConverter<Synchronization, SynchronizationContext> getConverter() {
				return SynchronizationConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<List<ParameterDeclaration>, ParameterSequenceContext> parametersFacade() {
		return configure(new AbsUtaAntlrParserFacade<List<ParameterDeclaration>, ParameterSequenceContext>() {
			@Override
			protected ParameterSequenceContext getRootContext(UtaLanguageParser parser) {
				return parser.parameterSequence();
			}

			@Override
			protected IParseTreeConverter<List<ParameterDeclaration>, ParameterSequenceContext> getConverter() {
				return ParameterSequenceConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<List<AbsDeclarationStatement>, DeclarationSequenceContext> declarationsFacade() {
		return configure(new AbsUtaAntlrParserFacade<List<AbsDeclarationStatement>, DeclarationSequenceContext>() {
			@Override
			protected DeclarationSequenceContext getRootContext(UtaLanguageParser parser) {
				return parser.declarationSequence();
			}

			@Override
			protected IParseTreeConverter<List<AbsDeclarationStatement>, DeclarationSequenceContext> getConverter() {
				return DeclarationSequenceConverter.getInstance();
			}
		});
	}
}
