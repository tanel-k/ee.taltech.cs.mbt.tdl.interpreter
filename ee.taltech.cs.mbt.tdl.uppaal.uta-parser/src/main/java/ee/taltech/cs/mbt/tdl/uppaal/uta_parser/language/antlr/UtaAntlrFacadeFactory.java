package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.ErrorStrategyConfigFactory;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.base.ErrorListener;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.base.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ParameterSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SelectionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemDefinitionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Selection;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.declaration.DeclarationSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.parameter.ParameterSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.system.SystemDefinitionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.template.AssignmentsConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.template.SelectionSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.template.SynchronizationConverter;
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

	private <R, C extends ParseTree> AbsUtaAntlrFacade<R, C> configure(AbsUtaAntlrFacade<R, C> parserFacade) {
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

	public AbsUtaAntlrFacade<AbsExpression, ExpressionContext> invariantFacade() {
		return configure(new AbsUtaAntlrFacade<AbsExpression, ExpressionContext>() {
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

	public AbsUtaAntlrFacade<AbsExpression, ExpressionContext> guardFacade() {
		return configure(new AbsUtaAntlrFacade<AbsExpression, ExpressionContext>() {
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

	public AbsUtaAntlrFacade<SystemDefinition, SystemDefinitionContext> systemDefinitionFacade() {
		return configure(new AbsUtaAntlrFacade<SystemDefinition, SystemDefinitionContext>() {
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

	public AbsUtaAntlrFacade<List<AbsExpression>, ExpressionSequenceContext> updatesFacade() {
		return configure(new AbsUtaAntlrFacade<List<AbsExpression>, ExpressionSequenceContext>() {
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

	public AbsUtaAntlrFacade<List<Selection>, SelectionSequenceContext> selectionFacade() {
		return configure(new AbsUtaAntlrFacade<List<Selection>, SelectionSequenceContext>() {
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

	public AbsUtaAntlrFacade<Synchronization, SynchronizationContext> synchronizationFacade() {
		return configure(new AbsUtaAntlrFacade<Synchronization, SynchronizationContext>() {
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

	public AbsUtaAntlrFacade<List<ParameterDeclaration>, ParameterSequenceContext> parametersFacade() {
		return configure(new AbsUtaAntlrFacade<List<ParameterDeclaration>, ParameterSequenceContext>() {
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

	public AbsUtaAntlrFacade<List<AbsDeclarationStatement>, DeclarationSequenceContext> declarationsFacade() {
		return configure(new AbsUtaAntlrFacade<List<AbsDeclarationStatement>, DeclarationSequenceContext>() {
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
