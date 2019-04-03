package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorListener;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.commons.parser.AbsAntlrParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.AbsUtaAntlrFacade;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.UtaAntlrFacadeFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;

import java.util.List;

public class UtaLanguageParserFactory {
	public static UtaLanguageParserFactory newInstance(UtaAntlrFacadeFactory facadeFactory) {
		return new UtaLanguageParserFactory(facadeFactory);
	}

	public static UtaLanguageParserFactory newInstance() {
		return new UtaLanguageParserFactory(UtaAntlrFacadeFactory.newInstance());
	}

	private UtaAntlrFacadeFactory facadeFactory;

	private UtaLanguageParserFactory(UtaAntlrFacadeFactory facadeFactory) {
		this.facadeFactory = facadeFactory;
	}

	public List<ErrorListener> getErrorListeners() {
		return facadeFactory.getErrorListeners();
	}

	public ErrorStrategyConfig getErrorStrategyConfig() {
		return facadeFactory.getErrorStrategyConfig();
	}

	public void setErrorStrategyConfig(ErrorStrategyConfig errorStrategyConfig) {
		facadeFactory.setErrorStrategyConfig(errorStrategyConfig);
	}

	public AbsAntlrParser<AbsExpression> guardParser() {
		return new AbsAntlrParser<AbsExpression>() {
			AbsUtaAntlrFacade<AbsExpression, ?> facade;

			@Override
			public AbsAntlrParserFacade<AbsExpression, ?, ?> getFacade() {
				return facade == null
					? facade = facadeFactory.guardFacade()
					: facade;
			}
		};
	}

	public AbsAntlrParser<AbsExpression> invariantParser() {
		return new AbsAntlrParser<AbsExpression>() {
			AbsUtaAntlrFacade<AbsExpression, ?> facade;

			@Override
			public AbsAntlrParserFacade<AbsExpression, ?, ?> getFacade() {
				return facade == null
						? (facade = facadeFactory.invariantFacade())
						: facade;
			}
		};
	}

	public AbsAntlrParser<List<AbsExpression>> assignmentsParser() {
		return new AbsAntlrParser<List<AbsExpression>>() {
			AbsUtaAntlrFacade<List<AbsExpression>, ?> facade;

			@Override
			public AbsAntlrParserFacade<List<AbsExpression>, ?, ?> getFacade() {
				return facade == null
						? (facade = facadeFactory.updatesFacade())
						: facade;
			}
		};
	}

	public AbsAntlrParser<List<ParameterDeclaration>> parameterListParser() {
		return new AbsAntlrParser<List<ParameterDeclaration>>() {
			AbsUtaAntlrFacade<List<ParameterDeclaration>, ?> facade;

			@Override
			public AbsAntlrParserFacade<List<ParameterDeclaration>, ?, ?> getFacade() {
				return facade == null
						? (facade = facadeFactory.parametersFacade())
						: facade;
			}
		};
	}

	public AbsAntlrParser<SystemDefinition> systemDefinitionParser() {
		return new AbsAntlrParser<SystemDefinition>() {
			AbsUtaAntlrFacade<SystemDefinition, ?> facade;

			@Override
			public AbsAntlrParserFacade<SystemDefinition, ?, ?> getFacade() {
				return facade == null
						? (facade = facadeFactory.systemDefinitionFacade())
						: facade;
			}
		};
	}

	public AbsAntlrParser<List<Selection>> selectionParser() {
		return new AbsAntlrParser<List<Selection>>() {
			AbsUtaAntlrFacade<List<Selection>, ?> facade;

			@Override
			public AbsAntlrParserFacade<List<Selection>, ?, ?> getFacade() {
				return facade == null
						? (facade = facadeFactory.selectionFacade())
						: facade;
			}
		};
	}

	public AbsAntlrParser<Synchronization> synchronizationParser() {
		return new AbsAntlrParser<Synchronization>() {
			AbsUtaAntlrFacade<Synchronization, ?> facade;

			@Override
			public AbsAntlrParserFacade<Synchronization, ?, ?> getFacade() {
				return facade == null
						? (facade = facadeFactory.synchronizationFacade())
						: facade;
			}
		};
	}

	public AbsAntlrParser<List<AbsDeclarationStatement>> declarationsParser() {
		return new AbsAntlrParser<List<AbsDeclarationStatement>>() {
			AbsUtaAntlrFacade<List<AbsDeclarationStatement>, ?> facade;

			@Override
			public AbsAntlrParserFacade<List<AbsDeclarationStatement>, ?, ?> getFacade() {
				return facade == null
						? (facade = facadeFactory.declarationsFacade())
						: facade;
			}
		};
	}
}
