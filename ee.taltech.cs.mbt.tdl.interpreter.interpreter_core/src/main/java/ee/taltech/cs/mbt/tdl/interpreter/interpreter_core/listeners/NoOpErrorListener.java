package ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.BaseTrapsetsExtractor.InvalidBaseTrapsetDefinitionException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;

import java.io.IOException;

public class NoOpErrorListener implements IInterpretationErrorListener {
	@Override
	public void onExpressionParseFailure(IOException ex) { /* Do nothing. */ }

	@Override
	public void onExpressionParseFailure(ParseException ex) { /* Do nothing. */ }

	@Override
	public void onModelParseFailure(MarshallingException ex) { /* Do nothing. */ }

	@Override
	public void onModelParseFailure(InvalidSystemStructureException ex) { /* Do nothing. */ }

	@Override
	public void onModelParseFailure(EmbeddedCodeSyntaxException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioCompositionFailure(InvalidBaseTrapsetDefinitionException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioSerializationFailure(MarshallingException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioSerializationFailure(SyntaxRepresentationException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioSerializationFailure(InvalidSystemStructureException ex) { /* Do nothing. */ }

	@Override
	public void onUnexpectedFailure(Throwable t) { /* Do nothing. */}
}
