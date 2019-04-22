package ee.taltech.cs.mbt.tdl.interpreter.interpreter_cli.interpretation_listeners;

import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator.TdlGeneratorFactory;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners.IInterpretationProgressListener;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioCompositionResults;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.io.PrintStream;

public class PrintingProgressListener implements IInterpretationProgressListener {
	private Flag completionFlag;
	private PrintStream out;

	public PrintingProgressListener(PrintStream out, Flag completionFlag) {
		this.out = out;
		this.completionFlag = completionFlag;
	}

	@Override
	public void beforeExpressionParsed() {
		if (out != null)
			out.println("Parsing TDL expression.");
	}

	@Override
	public void afterExpressionParsed(TdlExpression expression) {
		if (out != null)
			out.println("TDL expression successfully parsed.");
	}

	@Override
	public void beforeModelParsed() {
		if (out != null)
			out.println("Parsing SUT model.");
	}

	@Override
	public void afterModelParsed(UtaSystem sutModel) {
		if (out != null)
			out.println("SUT model successfully parsed.");
	}

	@Override
	public void beforeScenarioComposition(ScenarioSpecification specification) {
		if (out != null)
			out.println("Composing scenario.");
	}

	@Override
	public void afterScenarioComposition(ScenarioSpecification specification, ScenarioCompositionResults results) {
		if (out == null)
			return;
		out.println("Scenario composition successful.");
		if (!specification.getTdlExpression().equals(results.getTdlExpression())) {
			try {
				String reducedExpression = TdlGeneratorFactory.getInstance().expressionGenerator().generate(results.getTdlExpression());
				out.println("Expression reduced to:");
				out.println(reducedExpression);
			} catch (GenerationException e) { /* Doesn't matter. */ }
		}
	}

	@Override
	public void afterFullReduction(TdlExpression tdlExpression) {
		if (out != null)
			out.println("Progress halted; expression fully reduced.");
	}

	@Override
	public void beforeScenarioSerialized(UtaSystem scenarioModel) {
		if (out != null)
			out.println("Serializing scenario.");
	}

	@Override
	public void afterScenarioSerialized() {
		if (out != null)
			out.println("Scenario serialization successful.");
		completionFlag.set();
	}
}
