package ee.taltech.cs.mbt.tdl.scenario.scenario_composer;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.TdlExpressionParser;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.specification.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.UtaSerializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class Test {
	public static void main(String... args)
			throws ParseException, MarshallingException, InvalidSystemStructureException,
			EmbeddedCodeSyntaxException, SyntaxRepresentationException {
		TdlExpression expression = TdlExpressionParser.getInstance().parseInput("#[>5]E(TS1;TS2)");
		UtaSystem system = UtaParser.newInstance().parse(Test.class.getResourceAsStream("/SampleSystem.xml"));
		ScenarioComposer composer = ScenarioComposer.newInstance(ScenarioSpecification.of(system, expression));
		composer.compose();
		UtaSerializer.newInstance().serialize(system, System.out);
	}
}
