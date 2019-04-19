package ee.taltech.cs.mbt.tdl.interpreter;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.TdlExpressionParser;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.ScenarioComposer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.specification.ScenarioSpecification;
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

public class Interpreter {
	public static Interpreter getInstance() {
		return INSTANCE;
	}

	private static final Interpreter INSTANCE = new Interpreter();

	private Interpreter() { }

	public void interpret(InputStream sutModelStream, InputStream expressionStream, OutputStream outStream) {
		TdlExpression expression;
		try {
			expression = TdlExpressionParser.getInstance().parseInput(expressionStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

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

		UtaSystem scenarioModel = ScenarioComposer
				.newInstance(ScenarioSpecification.of(sutModel, expression))
				.compose();

		try {
			UtaSerializer.newInstance().serialize(scenarioModel, outStream);
		} catch (MarshallingException e) {
			throw new RuntimeException(e);
		} catch (SyntaxRepresentationException e) {
			throw new RuntimeException(e);
		} catch (InvalidSystemStructureException e) {
			throw new RuntimeException(e);
		}
	}
}
