package ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.listeners;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.LiteralEliminationException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.NormalizationException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.BaseTrapsetsExtractor.BaseTrapsetDefinitionException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;

import java.io.IOException;

public class NoOpErrorListener implements IErrorListener {
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
	public void onScenarioCompositionFailure(BaseTrapsetDefinitionException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioCompositionFailure(NormalizationException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioCompositionFailure(LiteralEliminationException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioSerializationFailure(MarshallingException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioSerializationFailure(SyntaxRepresentationException ex) { /* Do nothing. */ }

	@Override
	public void onScenarioSerializationFailure(InvalidSystemStructureException ex) { /* Do nothing. */ }

	@Override
	public void onUnexpectedFailure(Throwable t) { /* Do nothing. */}
}
