package ee.taltech.cs.mbt.tdl.interpreter;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.TdlExpressionParser;
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

// FIXME: Provide appropriate API.
public class Interpreter {
	public static Interpreter getInstance() {
		return INSTANCE;
	}

	private static final Interpreter INSTANCE = new Interpreter();

	private Interpreter() { }

	public void interpret(InputStream sutModelStream, InputStream expressionStream, OutputStream outStream) {
		// TODO: Needs separate exception wrapper:
		TdlExpression expression;
		try {
			expression = TdlExpressionParser.getInstance().parseInput(expressionStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		// TODO: Needs separate exception wrapper:
		UtaSystem sutModel;
		try {
			sutModel = UtaParser.newInstance().parse(sutModelStream);
		} catch (MarshallingException e) {
			throw new RuntimeException(e);
		} catch (InvalidSystemStructureException e) {
			throw new RuntimeException(e);
		} catch (EmbeddedCodeSyntaxException e) {
			throw new RuntimeException(e);
		}

		// TODO: Needs separate exception wrapper:
		ScenarioCompositionResults results = null;
		try {
			results = ScenarioComposer
					.newInstance(ScenarioSpecification.of(sutModel, expression))
					.compose();
		} catch (InvalidBaseTrapsetDefinitionException e) {
			e.printStackTrace();
		}

		// TODO: Needs separate exception wrapper:
		try {
			UtaSerializer.newInstance().serialize(results.getScenarioSystem().get(), outStream);
		} catch (MarshallingException e) {
			throw new RuntimeException(e);
		} catch (SyntaxRepresentationException e) {
			throw new RuntimeException(e);
		} catch (InvalidSystemStructureException e) {
			throw new RuntimeException(e);
		}
	}
}
