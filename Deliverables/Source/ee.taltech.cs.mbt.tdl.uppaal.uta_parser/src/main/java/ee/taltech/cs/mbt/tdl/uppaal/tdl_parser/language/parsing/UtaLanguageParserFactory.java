package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorListener;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.generic.parser.AbsAntlrParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.UtaAntlrFacadeFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.template.Selection;

import java.util.List;

public class UtaLanguageParserFactory {
	public static UtaLanguageParserFactory newInstance() {
		return new UtaLanguageParserFactory();
	}

	private UtaAntlrFacadeFactory facadeFactory = UtaAntlrFacadeFactory.newInstance();

	private UtaLanguageParserFactory() { }

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
			@Override
			public AbsAntlrParserFacade<AbsExpression, ?, ?> getFacade() {
				return facadeFactory.guardFacade();
			}
		};
	}

	public AbsAntlrParser<AbsExpression> invariantParser() {
		return new AbsAntlrParser<AbsExpression>() {
			@Override
			public AbsAntlrParserFacade<AbsExpression, ?, ?> getFacade() {
				return facadeFactory.invariantFacade();
			}
		};
	}

	public AbsAntlrParser<List<AbsExpression>> assignmentsParser() {
		return new AbsAntlrParser<List<AbsExpression>>() {
			@Override
			public AbsAntlrParserFacade<List<AbsExpression>, ?, ?> getFacade() {
				return facadeFactory.updatesFacade();
			}
		};
	}

	public AbsAntlrParser<List<ParameterDeclaration>> parameterListParser() {
		return new AbsAntlrParser<List<ParameterDeclaration>>() {
			@Override
			public AbsAntlrParserFacade<List<ParameterDeclaration>, ?, ?> getFacade() {
				return facadeFactory.parametersFacade();
			}
		};
	}

	public AbsAntlrParser<SystemDefinition> systemDefinitionParser() {
		return new AbsAntlrParser<SystemDefinition>() {
			@Override
			public AbsAntlrParserFacade<SystemDefinition, ?, ?> getFacade() {
				return facadeFactory.systemDefinitionFacade();
			}
		};
	}

	public AbsAntlrParser<List<Selection>> selectionParser() {
		return new AbsAntlrParser<List<Selection>>() {
			@Override
			public AbsAntlrParserFacade<List<Selection>, ?, ?> getFacade() {
				return facadeFactory.selectionFacade();
			}
		};
	}

	public AbsAntlrParser<Synchronization> synchronizationParser() {
		return new AbsAntlrParser<Synchronization>() {
			@Override
			public AbsAntlrParserFacade<Synchronization, ?, ?> getFacade() {
				return facadeFactory.synchronizationFacade();
			}
		};
	}

	public AbsAntlrParser<List<AbsDeclarationStatement>> declarationsParser() {
		return new AbsAntlrParser<List<AbsDeclarationStatement>>() {
			@Override
			public AbsAntlrParserFacade<List<AbsDeclarationStatement>, ?, ?> getFacade() {
				return facadeFactory.declarationsFacade();
			}
		};
	}
}
