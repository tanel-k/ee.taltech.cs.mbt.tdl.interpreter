package ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.listeners;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.base.ErrorListener.SyntaxError;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator.TdlGeneratorFactory;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.LiteralEliminationException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.NormalizationException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.BaseTrapsetsExtractor.BaseTrapsetDefinitionException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.EReturnStatus;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.listeners.IErrorListener;

import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Consumer;

public class PrintingErrorListener implements IErrorListener {
	private static void tryPrintExpression(TdlExpression expr, PrintStream out) {
		try {
			String expression = TdlGeneratorFactory.getInstance()
					.expressionGenerator()
					.generate(expr);
			out.println("Expression:");
			out.println(expression);
		} catch (GenerationException e) { /* Ignore */ }
	}

	private boolean printTraces;
	private PrintStream out;
	private Consumer<EReturnStatus> errorStatusHandler;

	private void handleFailure(Throwable t, EReturnStatus returnStatus) {
		if (printTraces) {
			out.println();
			t.printStackTrace(out);
		}
		errorStatusHandler.accept(returnStatus);
	}

	public PrintingErrorListener(boolean printTraces, PrintStream out, Consumer<EReturnStatus> errorStatusHandler) {
		this.printTraces = printTraces;
		this.out = out;
		this.errorStatusHandler = errorStatusHandler;
	}

	@Override
	public void onExpressionParseFailure(ParseException ex) {
		out.println("ERROR: TDL expression contains syntax error(s):");
		for (SyntaxError syntaxError : ex.getSyntaxErrors()) {
			out.println(syntaxError.toSingleLineMessage());
		}
		handleFailure(ex, EReturnStatus.EXPRESSION_PARSING_FAILED);
	}

	@Override
	public void onExpressionParseFailure(IOException ex) {
		onUnexpectedFailure(ex);
	}

	@Override
	public void onModelParseFailure(MarshallingException ex) {
		out.println("ERROR: Cannot unmarshal input system.");
		handleFailure(ex, EReturnStatus.MODEL_PARSING_FAILED);
	}

	@Override
	public void onModelParseFailure(InvalidSystemStructureException ex) {
		out.println("ERROR: Input system contains structural errors:");
		for (String errorMessage : ex.getErrorMessages()) {
			out.println(errorMessage);
		}
		handleFailure(ex, EReturnStatus.MODEL_PARSING_FAILED);
	}

	@Override
	public void onModelParseFailure(EmbeddedCodeSyntaxException ex) {
		out.println("ERROR: Invalid code snippet in input model:");
		out.println(ex.getOffendingCodeSnippet());
		out.println();
		out.println("Syntax errors:");
		for (SyntaxError syntaxError : ex.getSyntaxErrors()) {
			out.println(syntaxError.toSingleLineMessage());
		}
		handleFailure(ex, EReturnStatus.MODEL_PARSING_FAILED);
	}

	@Override
	public void onScenarioCompositionFailure(BaseTrapsetDefinitionException ex) {
		out.println("ERROR: " + ex.getMessage());
		handleFailure(ex, EReturnStatus.SCENARIO_COMPOSITION_FAILED);
	}

	@Override
	public void onScenarioCompositionFailure(NormalizationException ex) {
		out.println("ERROR: Unable to normalize TDL expression.");
		out.println(ex.getMessage());
		tryPrintExpression(ex.getExpression(), out);
		handleFailure(ex, EReturnStatus.INVALID_EXPRESSION);
	}

	@Override
	public void onScenarioCompositionFailure(LiteralEliminationException ex) {
		out.println("ERROR: Unable to eliminate Boolean literal from TDL expression.");
		out.println(ex.getMessage());
		tryPrintExpression(ex.getExpression(), out);
		handleFailure(ex, EReturnStatus.INVALID_EXPRESSION);
	}

	@Override
	public void onScenarioSerializationFailure(MarshallingException ex) {
		out.println("INTERNAL ERROR: Unable to marshal output system.");
		handleFailure(ex, EReturnStatus.SCENARIO_SERIALIZATION_FAILED);
	}

	@Override
	public void onScenarioSerializationFailure(SyntaxRepresentationException ex) {
		out.println("INTERNAL ERROR: Unable to generate embedded code snippet for:");
		out.println(ex.getClass().getSimpleName() + ":" + ex.getInvalidInstance());
		handleFailure(ex, EReturnStatus.SCENARIO_SERIALIZATION_FAILED);
	}

	@Override
	public void onScenarioSerializationFailure(InvalidSystemStructureException ex) {
		out.println("INTERNAL ERROR: Output system contains structural errors:");
		for (String errorMessage : ex.getErrorMessages()) {
			out.println(errorMessage);
		}
		handleFailure(ex, EReturnStatus.SCENARIO_SERIALIZATION_FAILED);
	}

	@Override
	public void onUnexpectedFailure(Throwable t) {
		out.println("INTERNAL ERROR: Unexpected " + t.getClass().getSimpleName() + ".");
		handleFailure(t, EReturnStatus.UNEXPECTED_ERROR);
	}
}
