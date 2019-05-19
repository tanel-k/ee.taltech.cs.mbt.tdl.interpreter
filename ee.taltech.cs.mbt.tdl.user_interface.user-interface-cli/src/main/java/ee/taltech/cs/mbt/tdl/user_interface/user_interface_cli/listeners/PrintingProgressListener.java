package ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.listeners;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.commons.utils.strings.WordUtils;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator.TdlGeneratorFactory;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.ScenarioCompositionResults;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.listeners.IProgressListener;

import java.io.PrintStream;

public class PrintingProgressListener implements IProgressListener {
	private Flag completionFlag;
	private PrintStream out;
	private PrintStream err;

	public PrintingProgressListener(PrintStream out, PrintStream err, Flag completionFlag) {
		this.out = out;
		this.err = err;
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
		if (!specification.getTdlExpression().equals(results.getExpression())) {
			try {
				String reducedExpression = TdlGeneratorFactory.getInstance().expressionGenerator().generate(results.getExpression());
				out.println("Expression reduced to:");
				out.println(reducedExpression);
			} catch (GenerationException e) { /* Doesn't matter. */ }
		}
	}

	@Override
	public void onFullReduction(TdlExpression tdlExpression) {
		if (err != null)  {
			tdlExpression.getRootBooleanWrapper().ifPresent(w ->
					err.println(
							"WARNING: Progress halted; expression fully reduced to `"
									+ WordUtils.capitalize(String.valueOf(w.wrapsTrue())) + "`."
					)
			);
		}
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
