package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.ErrorStrategyConfigFactory;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorListener;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.declaration.DeclarationsConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.SystemDefinitionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.template.TemplateParameterListConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition.SynchronizationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition.SelectionSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition.AssignmentsConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection.Selection;
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
			protected ExpressionContext getRootContext(UTALanguageParser parser) {
				return parser.utaLocationInvariantExpression().expression();
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
			protected ExpressionContext getRootContext(UTALanguageParser parser) {
				return parser.utaLocationInvariantExpression().expression();
			}

			@Override
			protected IParseTreeConverter<AbsExpression, ExpressionContext> getConverter() {
				return ExpressionConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<SystemDefinition, UtaSystemDefinitionContext> systemDefinitionFacade() {
		return configure(new AbsUtaAntlrParserFacade<SystemDefinition, UtaSystemDefinitionContext>() {
			@Override
			protected UtaSystemDefinitionContext getRootContext(UTALanguageParser parser) {
				return parser.utaSystemDefinition();
			}

			@Override
			protected IParseTreeConverter<SystemDefinition, UtaSystemDefinitionContext> getConverter() {
				return SystemDefinitionConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<List<AbsExpression>, UtaTransitionUpdateListContext> updatesFacade() {
		return configure(new AbsUtaAntlrParserFacade<List<AbsExpression>, UtaTransitionUpdateListContext>() {
			@Override
			protected UtaTransitionUpdateListContext getRootContext(UTALanguageParser parser) {
				return parser.utaTransitionUpdateList();
			}

			@Override
			protected IParseTreeConverter<List<AbsExpression>, UtaTransitionUpdateListContext> getConverter() {
				return AssignmentsConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<List<Selection>, UtaTransitionSelectionSequenceContext> selectionFacade() {
		return configure(new AbsUtaAntlrParserFacade<List<Selection>, UtaTransitionSelectionSequenceContext>() {
			@Override
			protected UtaTransitionSelectionSequenceContext getRootContext(UTALanguageParser parser) {
				return parser.utaTransitionSelectionSequence();
			}

			@Override
			protected IParseTreeConverter<List<Selection>, UtaTransitionSelectionSequenceContext> getConverter() {
				return SelectionSequenceConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<Synchronization, UtaTransitionSynchronizationContext> synchronizationFacade() {
		return configure(new AbsUtaAntlrParserFacade<Synchronization, UtaTransitionSynchronizationContext>() {
			@Override
			protected UtaTransitionSynchronizationContext getRootContext(UTALanguageParser parser) {
				return parser.utaTransitionSynchronization();
			}

			@Override
			protected IParseTreeConverter<Synchronization, UtaTransitionSynchronizationContext> getConverter() {
				return SynchronizationConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<List<ParameterDeclaration>, UtaTemplateParameterListContext> parametersFacade() {
		return configure(new AbsUtaAntlrParserFacade<List<ParameterDeclaration>, UtaTemplateParameterListContext>() {
			@Override
			protected UtaTemplateParameterListContext getRootContext(UTALanguageParser parser) {
				return parser.utaTemplateParameterList();
			}

			@Override
			protected IParseTreeConverter<List<ParameterDeclaration>, UtaTemplateParameterListContext> getConverter() {
				return TemplateParameterListConverter.getInstance();
			}
		});
	}

	public AbsUtaAntlrParserFacade<List<AbsDeclarationStatement>, UtaDeclarationsContext> declarationsFacade() {
		return configure(new AbsUtaAntlrParserFacade<List<AbsDeclarationStatement>, UtaDeclarationsContext>() {
			@Override
			protected UtaDeclarationsContext getRootContext(UTALanguageParser parser) {
				return parser.utaDeclarations();
			}

			@Override
			protected IParseTreeConverter<List<AbsDeclarationStatement>, UtaDeclarationsContext> getConverter() {
				return DeclarationsConverter.getInstance();
			}
		});
	}
}
