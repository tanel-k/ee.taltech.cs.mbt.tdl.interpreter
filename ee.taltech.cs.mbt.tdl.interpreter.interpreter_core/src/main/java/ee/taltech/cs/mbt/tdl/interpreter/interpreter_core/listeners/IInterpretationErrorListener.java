package ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.BaseTrapsetsExtractor.InvalidBaseTrapsetDefinitionException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;

import java.io.IOException;

public interface IInterpretationErrorListener {
	void onExpressionParseFailure(IOException ex);
	void onExpressionParseFailure(ParseException ex);
	void onModelParseFailure(MarshallingException ex);
	void onModelParseFailure(InvalidSystemStructureException ex);
	void onModelParseFailure(EmbeddedCodeSyntaxException ex);
	void onScenarioCompositionFailure(InvalidBaseTrapsetDefinitionException ex);
	void onScenarioSerializationFailure(MarshallingException ex);
	void onScenarioSerializationFailure(SyntaxRepresentationException ex);
	void onScenarioSerializationFailure(InvalidSystemStructureException ex);
	void onUnexpectedFailure(Throwable t);
}
