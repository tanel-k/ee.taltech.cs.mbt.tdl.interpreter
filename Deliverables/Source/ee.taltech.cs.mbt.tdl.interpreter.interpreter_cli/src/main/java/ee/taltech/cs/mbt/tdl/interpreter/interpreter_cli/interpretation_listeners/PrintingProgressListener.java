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
	public void afterExpressionParsed(TdlExpression expression) {
		if (out == null)
			return;
		out.println("Expression successfully parsed.");
	}

	@Override
	public void afterModelParsed(UtaSystem model) {
		if (out == null)
			return;
		out.println("SUT model successfully parsed.");
	}

	@Override
	public void afterScenarioComposition(ScenarioSpecification parameters, ScenarioCompositionResults results) {
		if (out == null)
			return;
		out.println("Scenario composition successful.");
		if (!parameters.getTdlExpression().equals(results.getTdlExpression())) {
			try {
				String reducedExpression = TdlGeneratorFactory.getInstance().expressionGenerator().generate(results.getTdlExpression());
				out.println("Expression reduced to:");
				out.println(reducedExpression);
			} catch (GenerationException e) { /* Doesn't matter. */ }
		}
	}

	@Override
	public void afterFullReduction(TdlExpression tdlExpression) {
		if (out == null)
			return;
		out.println("Progress halted; expression fully reduced.");
	}

	@Override
	public void afterScenarioSerialized() {
		if (out != null)
			out.println("Scenario serialization successful.");
		completionFlag.set();
	}
}
