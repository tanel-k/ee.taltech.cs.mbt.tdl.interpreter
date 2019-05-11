package ee.taltech.cs.mbt.tdl.user_interface.user_interface_core;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.TdlExpressionParser;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.LiteralEliminationException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.NormalizationException;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.listeners.NoOpErrorListener;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.listeners.NoOpProgressListener;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.listeners.IErrorListener;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.listeners.IProgressListener;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioComposer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioCompositionResults;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.BaseTrapsetsExtractor.BaseTrapsetDefinitionException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.UtaSerializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

public class TdlInterpreterUI {
	public static TdlInterpreterUI getInstance() {
		return getInstance(null, null);
	}

	public static TdlInterpreterUI getInstance(IErrorListener errorListener) {
		return getInstance(errorListener, null);
	}

	public static TdlInterpreterUI getInstance(IErrorListener errorListener, IProgressListener progressListener) {
		errorListener = errorListener == null
				? new NoOpErrorListener()
				: errorListener;
		progressListener = progressListener == null
				? new NoOpProgressListener()
				: progressListener;
		return new TdlInterpreterUI(errorListener, progressListener);
	}

	private IErrorListener errorListener;
	private IProgressListener progressListener;

	private TdlInterpreterUI(IErrorListener errorListener, IProgressListener progressListener) {
		this.errorListener = errorListener;
		this.progressListener = progressListener;
	}

	public void interpret(InputStream sutModelStream, InputStream expressionStream, OutputStream outStream) {
		try {
			TdlExpression expression;
			try {
				progressListener.beforeExpressionParsed();
				expression = TdlExpressionParser.getInstance().parseInput(expressionStream);
				progressListener.afterExpressionParsed(expression);
			} catch (IOException ex) {
				errorListener.onExpressionParseFailure(ex);
				return;
			} catch (ParseException ex) {
				errorListener.onExpressionParseFailure(ex);
				return;
			}

			UtaSystem sutModel;
			try {
				progressListener.beforeModelParsed();
				sutModel = UtaParser.newInstance().parse(sutModelStream);
				progressListener.afterModelParsed(sutModel);
			} catch (MarshallingException ex) {
				errorListener.onModelParseFailure(ex);
				return;
			} catch (InvalidSystemStructureException ex) {
				errorListener.onModelParseFailure(ex);
				return;
			} catch (EmbeddedCodeSyntaxException ex) {
				errorListener.onModelParseFailure(ex);
				return;
			}

			ScenarioSpecification spec = ScenarioSpecification.of(sutModel, expression);
			ScenarioCompositionResults results;
			try {
				progressListener.beforeScenarioComposition(spec);
				results = ScenarioComposer
						.newInstance(spec)
						.compose();
				progressListener.afterScenarioComposition(spec, results);
			} catch (BaseTrapsetDefinitionException ex) {
				errorListener.onScenarioCompositionFailure(ex);
				return;
			} catch (NormalizationException ex) {
				errorListener.onScenarioCompositionFailure(ex);
				return;
			} catch (LiteralEliminationException ex) {
				errorListener.onScenarioCompositionFailure(ex);
				return;
			}

			Optional<UtaSystem> optScenarioSystem = results.getScenarioSystem();
			if (!optScenarioSystem.isPresent()) {
				// This means there was nothing to generate the scenario from (trivial TDL expr).
				progressListener.onFullReduction(spec.getTdlExpression());
				return;
			}

			try {
				UtaSystem scenarioSystem = optScenarioSystem.get();
				progressListener.beforeScenarioSerialized(scenarioSystem);
				UtaSerializer.newInstance().serialize(scenarioSystem, outStream);
				progressListener.afterScenarioSerialized();
			} catch (MarshallingException ex) {
				errorListener.onScenarioSerializationFailure(ex);
			} catch (SyntaxRepresentationException ex) {
				errorListener.onScenarioSerializationFailure(ex);
			} catch (InvalidSystemStructureException ex) {
				errorListener.onScenarioSerializationFailure(ex);
			}
		} catch (Throwable t) {
			errorListener.onUnexpectedFailure(t);
		}
	}
}
