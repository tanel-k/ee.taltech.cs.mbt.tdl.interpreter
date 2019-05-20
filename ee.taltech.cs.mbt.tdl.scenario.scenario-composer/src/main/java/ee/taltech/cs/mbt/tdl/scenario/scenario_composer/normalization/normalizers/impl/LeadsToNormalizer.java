package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.NormalizationException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.AbsNormalizer;

public class LeadsToNormalizer extends AbsNormalizer<LeadsToNode> {
	public static LeadsToNormalizer getInstance() {
		return INSTANCE;
	}

	private static final LeadsToNormalizer INSTANCE = new LeadsToNormalizer();

	private LeadsToNormalizer() { }

	@Override
	public AbsBooleanInternalNode normalize(TdlExpression expression, LeadsToNode leadsTo) throws NormalizationException {
		if (!leadsTo.isNegated())
			return leadsTo;

		/*
		 * not(A ~> B): It is not the case that whenever A is satisfied, B will eventually be satisfied.
		 * Equivalently, either:
		 * a) A is never satisfied, or;
		 * b) whenever A is satisfied, it is not the case that B will be satisfied at a later point in time.
		 *
		 * We cannot simply write not(A) || A ~> not(B):
		 * Assume A does not hold, then the "||"-recognizer returns pretty much immediately.
		 * But there is nothing indicating that A cannot occur at a later point in time.
		 * Assume A holds, then we start the recognizer for not(B).
		 * When not(B) holds, the "~>"-recognizer returns.
		 * But there is nothing indicating that B won't begin to hold at a later point in time.
		 *
		 * In terms of the implementation, we would either have to wait for A to *never* occur or
		 * for B to *never* occur after A.
		 * The notion of 'waiting' is not well-defined here.
		 * We obviously cannot wait until the end of time.
		 * The TDL(TP) architecture described in the source article does not provide any structures
		 * which could support implementing this waiting logic.
		 *
		 * Recognizers have to do with recognizing configurations that may occur in trace sub-sequences -
		 * they are not designed to recognize when the test trace has concluded.
		 * Additionally, the concept of waiting becomes contradictory when we consider the fact that
		 * the TDL stopwatch automaton has a hard-coded timeout attached to it.
		 *
		 * As this is unimplementable based on the theoretical basis at the time of writing, our options are:
		 * * throw Exception;
		 * * replace with something meaningful.
		 *
		 * We'll throw an Exception as it is more informative.
		 */
		throw new NormalizationException("Negation of leads to is not supported.", leadsTo, expression);
	}
}
