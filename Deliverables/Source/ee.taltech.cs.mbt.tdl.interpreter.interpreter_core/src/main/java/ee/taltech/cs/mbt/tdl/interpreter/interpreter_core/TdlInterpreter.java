package ee.taltech.cs.mbt.tdl.interpreter.interpreter_core;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.TdlExpressionParser;
import ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners.NoOpErrorListener;
import ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners.NoOpProgressListener;
import ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners.IInterpretationErrorListener;
import ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners.IInterpretationProgressListener;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioComposer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioCompositionResults;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.BaseTrapsetsExtractor.InvalidBaseTrapsetDefinitionException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.UtaSerializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

// FIXME: Non-existent API; API layout should be informed by CLI, GUI implementations.
public class TdlInterpreter {
	public static TdlInterpreter getInstance() {
		return getInstance(null, null);
	}

	public static TdlInterpreter getInstance(IInterpretationErrorListener errorListener) {
		return getInstance(errorListener, null);
	}

	public static TdlInterpreter getInstance(IInterpretationErrorListener errorListener, IInterpretationProgressListener progressListener) {
		errorListener = errorListener == null
				? new NoOpErrorListener()
				: errorListener;
		progressListener = progressListener == null
				? new NoOpProgressListener()
				: progressListener;
		return new TdlInterpreter(errorListener, progressListener);
	}

	private IInterpretationErrorListener errorListener;
	private IInterpretationProgressListener progressListener;

	private TdlInterpreter(IInterpretationErrorListener errorListener, IInterpretationProgressListener progressListener) {
		this.errorListener = errorListener;
		this.progressListener = progressListener;
	}

	public void interpret(InputStream sutModelStream, InputStream expressionStream, OutputStream outStream) {
		try {
			TdlExpression expression;
			try {
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
				results = ScenarioComposer
						.newInstance(spec)
						.compose();
				progressListener.afterScenarioComposition(spec, results);
			} catch (InvalidBaseTrapsetDefinitionException ex) {
				errorListener.onScenarioCompositionFailure(ex);
				return;
			}

			Optional<UtaSystem> optScenarioSystem = results.getScenarioSystem();
			if (!optScenarioSystem.isPresent()) {
				progressListener.afterFullReduction(spec.getTdlExpression());
				return;
			}

			try {
				UtaSerializer.newInstance().serialize(optScenarioSystem.get(), outStream);
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
