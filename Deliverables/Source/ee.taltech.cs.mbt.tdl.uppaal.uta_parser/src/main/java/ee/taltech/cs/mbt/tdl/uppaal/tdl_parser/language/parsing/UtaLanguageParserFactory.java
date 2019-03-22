package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorListener;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.UtaAntlrFacadeFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection.Selection;

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

	public AbsParser<AbsExpression> guardParser() {
		return new AbsParser<AbsExpression>() {
			@Override
			public AbsAntlrParserFacade<AbsExpression, ?, ?, ?> getFacade() {
				return facadeFactory.guardFacade();
			}
		};
	}

	public AbsParser<AbsExpression> invariantParser() {
		return new AbsParser<AbsExpression>() {
			@Override
			public AbsAntlrParserFacade<AbsExpression, ?, ?, ?> getFacade() {
				return facadeFactory.invariantFacade();
			}
		};
	}

	public AbsParser<List<AbsExpression>> updatesParser() {
		return new AbsParser<List<AbsExpression>>() {
			@Override
			public AbsAntlrParserFacade<List<AbsExpression>, ?, ?, ?> getFacade() {
				return facadeFactory.updatesFacade();
			}
		};
	}

	public AbsParser<List<ParameterDeclaration>> parameterListParser() {
		return new AbsParser<List<ParameterDeclaration>>() {
			@Override
			public AbsAntlrParserFacade<List<ParameterDeclaration>, ?, ?, ?> getFacade() {
				return facadeFactory.parametersFacade();
			}
		};
	}

	public AbsParser<SystemDefinition> systemDefinitionParser() {
		return new AbsParser<SystemDefinition>() {
			@Override
			public AbsAntlrParserFacade<SystemDefinition, ?, ?, ?> getFacade() {
				return facadeFactory.systemDefinitionFacade();
			}
		};
	}

	public AbsParser<List<Selection>> selectionParser() {
		return new AbsParser<List<Selection>>() {
			@Override
			public AbsAntlrParserFacade<List<Selection>, ?, ?, ?> getFacade() {
				return facadeFactory.selectionFacade();
			}
		};
	}

	public AbsParser<Synchronization> synchronizationParser() {
		return new AbsParser<Synchronization>() {
			@Override
			public AbsAntlrParserFacade<Synchronization, ?, ?, ?> getFacade() {
				return facadeFactory.synchronizationFacade();
			}
		};
	}

	public AbsParser<List<AbsDeclarationStatement>> declarationsParser() {
		return new AbsParser<List<AbsDeclarationStatement>>() {
			@Override
			public AbsAntlrParserFacade<List<AbsDeclarationStatement>, ?, ?, ?> getFacade() {
				return facadeFactory.declarationsFacade();
			}
		};
	}
}
