package ee.taltech.cs.mbt.tdl.scenario.scenario_model.source;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.MultiValuedMap;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrapsetLabelingFunction {
	/**
	 * Represents a trapset labeling in a TDL source project.<br/>
	 * A trapset label is an assignment expression where:
	 * <ul>
	 *   <li>the LHS is an array access expression that specifies an entry in a trapset flag array;</li>
	 *   <li>the RHS is an update function for the specified flag.</li>
	 * </ul>
	 */
	public static class TransitionTrapsetLabel {
		public static TransitionTrapsetLabel of(Transition markedTransition, AssignmentExpression originExpression) {
			return new TransitionTrapsetLabel(markedTransition, originExpression);
		}

		private Transition markedTransition;
		private AssignmentExpression originExpression;

		public AssignmentExpression getOriginExpression() {
			return originExpression;
		}

		public Transition getMarkedTransition() {
			return markedTransition;
		}

		private TransitionTrapsetLabel(Transition markedTransition, AssignmentExpression originExpression) {
			this.markedTransition = markedTransition;
			this.originExpression = originExpression;
		}
	}

	/**
	 * Each trapset should be mapped to set of <b>unique</b> edges.<br/>
	 * This utility wrapper treats {@link TransitionTrapsetLabel} instances as equal based on transition identity.
	 * It is used as the value type in {@link #nestedMap} which essentially maps trapsets to sets of {@link TransitionTrapsetLabel} instances.
	 */
	private static class LabelingIdentityWrapper {
		public static LabelingIdentityWrapper wrap(TransitionTrapsetLabel transition) {
			return new LabelingIdentityWrapper(transition);
		}

		private TransitionTrapsetLabel wrappedTransition;

		private LabelingIdentityWrapper(TransitionTrapsetLabel wrappedTransition) {}

		public TransitionTrapsetLabel getWrappedTransition() {
			return wrappedTransition;
		}

		@Override
		public int hashCode() {
			return Objects.hash(wrappedTransition.markedTransition);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			if (!(obj instanceof LabelingIdentityWrapper))
				return false;
			LabelingIdentityWrapper other = (LabelingIdentityWrapper) obj;
			return Objects.equals(other.wrappedTransition, this.wrappedTransition);
		}
	}

	private MultiValuedMap<TrapsetSymbolNode, LabelingIdentityWrapper, Set<LabelingIdentityWrapper>> nestedMap
			= new MultiValuedMap<>();

	public Collection<TransitionTrapsetLabel> getMappedLabels(TrapsetSymbolNode trapsetSymbol) {
		return getMappedLabelsAsStream(trapsetSymbol)
				.collect(Collectors.toList());
	}

	public Stream<TransitionTrapsetLabel> getMappedLabelsAsStream(TrapsetSymbolNode trapsetSymbol) {
		return nestedMap.get(trapsetSymbol).stream()
				.map(LabelingIdentityWrapper::getWrappedTransition);
	}

	/**
	 * @param trapset The trapset for which a mapping is to be added.
	 * @param transition The transition that is labeled with the trapset.
	 * @param originExpression The assignment that declares the mapping in a source project.
	 * @return true if a mapping from <pre>trapsetSymbol</pre> to <pre>transition</pre> already exists.
	 */
	public boolean addMapping(TrapsetSymbolNode trapset, Transition transition, AssignmentExpression originExpression) {
		Set<LabelingIdentityWrapper> labeledTransitions = nestedMap
				.computeIfAbsent(trapset, k -> new LinkedHashSet<>());
		return labeledTransitions.add(
				LabelingIdentityWrapper.wrap(
						TransitionTrapsetLabel.of(transition, originExpression)
				)
		);
	}
}
