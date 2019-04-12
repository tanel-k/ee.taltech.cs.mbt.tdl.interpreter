package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.function;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.MultiValuedMap;
import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.BiTuple;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.Trapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.TrapsetTransitionLabel;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrapsetLabelingFunction {
	/**
	 * This wrapper treats {@link Trapset} instances as equal based on {@link Trapset#getTrapsetSymbol()} identity.
	 * It is used as the key type in {@link #labelMap} which essentially maps {@link Trapset} instances to sets of system edges.
	 */
	private static class TrapsetIdentityWrapper {
		private static TrapsetIdentityWrapper wrap(Trapset trapset) {
			return new TrapsetIdentityWrapper(trapset);
		}

		private Trapset wrappedTrapset;

		private TrapsetIdentityWrapper(Trapset trapset) {
			this.wrappedTrapset = trapset;
		}

		public Trapset getWrappedTrapset() {
			return wrappedTrapset;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + "{" + wrappedTrapset + "}";
		}

		@Override
		public int hashCode() {
			return Objects.hash(wrappedTrapset.getTrapsetSymbol());
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			if (!(obj instanceof TrapsetIdentityWrapper))
				return false;
			TrapsetIdentityWrapper other = (TrapsetIdentityWrapper) obj;
			return Objects.equals(other.wrappedTrapset, this.wrappedTrapset);
		}
	}

	/**
	 * Each trapset should be mapped to set of <b>unique</b> edges.<br/>
	 * This utility wrapper treats {@link TrapsetTransitionLabel} instances as equal based on transition identity.
	 * It is used as the value type in {@link #labelMap} which essentially maps trapsets to sets of {@link TrapsetTransitionLabel} instances.
	 */
	private static class LabelIdentityWrapper {
		private static LabelIdentityWrapper wrap(TrapsetTransitionLabel transition) {
			return new LabelIdentityWrapper(transition);
		}

		private TrapsetTransitionLabel wrappedLabeledTransition;

		private LabelIdentityWrapper(TrapsetTransitionLabel labeledTransition) {
			this.wrappedLabeledTransition = labeledTransition;
		}

		private TrapsetTransitionLabel getWrappedLabeledTransition() {
			return wrappedLabeledTransition;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + "{" + wrappedLabeledTransition + "}";
		}

		@Override
		public int hashCode() {
			return Objects.hash(wrappedLabeledTransition.getMarkedTransition());
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			if (!(obj instanceof LabelIdentityWrapper))
				return false;
			LabelIdentityWrapper other = (LabelIdentityWrapper) obj;
			return Objects.equals(
					other.wrappedLabeledTransition.getMarkedTransition(),
					this.wrappedLabeledTransition.getMarkedTransition()
			);
		}
	}

	private Map<Trapset, TrapsetIdentityWrapper> trapsetIdentityCache = new HashMap<>();
	private Map<TrapsetTransitionLabel, LabelIdentityWrapper> labelIdentityCache = new HashMap<>();
	private Map<TrapsetSymbolNode, TrapsetIdentityWrapper> mapTrapsetSymbolToIdentity = new HashMap<>();
	private MultiValuedMap<TrapsetIdentityWrapper, LabelIdentityWrapper, Set<LabelIdentityWrapper>> labelMap
			= new MultiValuedMap<>();

	private TrapsetIdentityWrapper identityWrap(Trapset trapset) {
		TrapsetIdentityWrapper trapsetId = trapsetIdentityCache.computeIfAbsent(trapset, TrapsetIdentityWrapper::wrap);
		mapTrapsetSymbolToIdentity.putIfAbsent(trapset.getTrapsetSymbol(), trapsetId);
		return trapsetId;
	}

	private LabelIdentityWrapper identityWrap(TrapsetTransitionLabel transitionLabel) {
		return labelIdentityCache.computeIfAbsent(transitionLabel, LabelIdentityWrapper::wrap);
	}

	public TrapsetLabelingFunction() { }

	public List<BiTuple<Trapset, Set<TrapsetTransitionLabel>>> getMappings() {
		return getMappingsAsStream().collect(Collectors.toList());
	}

	public Stream<BiTuple<Trapset, Set<TrapsetTransitionLabel>>> getMappingsAsStream() {
		return labelMap.keySet().stream()
				.map(k -> BiTuple.of(k.wrappedTrapset, getLabeledTransitions(k.wrappedTrapset)));
	}

	public Stream<BiTuple<Trapset, Stream<TrapsetTransitionLabel>>> getMappingsAsStreamComposition() {
		return labelMap.entrySet().stream()
				.map(e -> BiTuple.of(
						e.getKey().wrappedTrapset,
						e.getValue().stream().map(LabelIdentityWrapper::getWrappedLabeledTransition))
				);
	}

	private Stream<TrapsetTransitionLabel> getMappedLabelsAsStream(TrapsetIdentityWrapper trapsetId) {
		return labelMap.get(trapsetId).stream()
				.map(LabelIdentityWrapper::getWrappedLabeledTransition);
	}

	public Stream<TrapsetTransitionLabel> getMappedLabelsAsStream(Trapset trapset) {
		return getMappedLabelsAsStream(identityWrap(trapset));
	}

	private Set<TrapsetTransitionLabel> getLabeledTransitions(TrapsetIdentityWrapper trapsetId) {
		return getMappedLabelsAsStream(trapsetId)
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	public Set<TrapsetTransitionLabel> getLabeledTransitions(Trapset trapset) {
		return getLabeledTransitions(identityWrap(trapset));
	}

	public BiTuple<Trapset, Set<TrapsetTransitionLabel>> getMapping(TrapsetSymbolNode trapsetSymbol) {
		if (!mapTrapsetSymbolToIdentity.containsKey(trapsetSymbol))
			return null;
		TrapsetIdentityWrapper trapsetId = mapTrapsetSymbolToIdentity.get(trapsetSymbol);
		return BiTuple.of(trapsetId.getWrappedTrapset(), getLabeledTransitions(trapsetId));
	}

	/**
	 * @param trapset The trapset for which a mapping is to be added.
	 * @param label Contains the transition the trapset is mapped to.
	 * @return true if a mapping from <pre>trapsetSymbol</pre> to <pre>transition</pre> did not previously exist.
	 */
	public boolean addMapping(Trapset trapset, TrapsetTransitionLabel label) {
		Set<LabelIdentityWrapper> labeledTransitions = labelMap
				.computeIfAbsent(identityWrap(trapset), k -> new LinkedHashSet<>());
		return labeledTransitions.add(identityWrap(label));
	}

	public void addMapping(Trapset trapset) {
		labelMap.computeIfAbsent(identityWrap(trapset), k -> new LinkedHashSet<>());
	}

	public boolean hasMappings(Trapset trapset) {
		TrapsetIdentityWrapper trapsetId = TrapsetIdentityWrapper.wrap(trapset);
		return labelMap.containsKey(trapsetId)
				&& !labelMap.get(trapsetId).isEmpty();
	}

	public boolean hasMappings(TrapsetSymbolNode trapsetSymbol) {
		if (!mapTrapsetSymbolToIdentity.containsKey(trapsetSymbol))
			return false;
		TrapsetIdentityWrapper trapsetId = mapTrapsetSymbolToIdentity.get(trapsetSymbol);
		return labelMap.containsKey(trapsetId)
				&& !labelMap.get(trapsetId).isEmpty();
	}
}
