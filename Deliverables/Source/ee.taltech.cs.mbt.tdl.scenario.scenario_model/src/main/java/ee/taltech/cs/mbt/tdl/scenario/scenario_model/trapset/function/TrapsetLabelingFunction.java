package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.function;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.MultiValuedMap;
import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.BiTuple;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.TrapsetDeclaration;
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
	 * This wrapper treats {@link TrapsetDeclaration} instances as equal based on {@link TrapsetDeclaration#getTrapsetSymbol()} identity.
	 * It is used as the key type in {@link #nestedMap} which essentially maps {@link TrapsetDeclaration} instances to sets of system edges.
	 */
	private static class TrapsetIdentityWrapper {
		private static TrapsetIdentityWrapper wrap(TrapsetDeclaration trapsetDeclaration) {
			return new TrapsetIdentityWrapper(trapsetDeclaration);
		}

		private TrapsetDeclaration wrappedDeclaration;

		private TrapsetIdentityWrapper(TrapsetDeclaration trapsetDeclaration) {
			this.wrappedDeclaration = trapsetDeclaration;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + "{" + wrappedDeclaration + "}";
		}

		@Override
		public int hashCode() {
			return Objects.hash(wrappedDeclaration.getTrapsetSymbol());
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
			return Objects.equals(other.wrappedDeclaration, this.wrappedDeclaration);
		}
	}

	/**
	 * Each trapset should be mapped to set of <b>unique</b> edges.<br/>
	 * This utility wrapper treats {@link TrapsetTransitionLabel} instances as equal based on transition identity.
	 * It is used as the value type in {@link #nestedMap} which essentially maps trapsets to sets of {@link TrapsetTransitionLabel} instances.
	 */
	private static class MappingIdentityWrapper {
		private static MappingIdentityWrapper wrap(TrapsetTransitionLabel transition) {
			return new MappingIdentityWrapper(transition);
		}

		private TrapsetTransitionLabel wrappedTransition;

		private MappingIdentityWrapper(TrapsetTransitionLabel wrappedTransition) {
			this.wrappedTransition = wrappedTransition;
		}

		private TrapsetTransitionLabel getWrappedTransition() {
			return wrappedTransition;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + "{" + wrappedTransition + "}";
		}

		@Override
		public int hashCode() {
			return Objects.hash(wrappedTransition.getMarkedTransition());
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			if (!(obj instanceof MappingIdentityWrapper))
				return false;
			MappingIdentityWrapper other = (MappingIdentityWrapper) obj;
			return Objects.equals(
					other.wrappedTransition.getMarkedTransition(),
					this.wrappedTransition.getMarkedTransition()
			);
		}
	}

	private Map<TrapsetDeclaration, TrapsetIdentityWrapper> trapsetIdentityCache = new HashMap<>();
	private Map<TrapsetTransitionLabel, MappingIdentityWrapper> mappingIdentityCache = new HashMap<>();
	private MultiValuedMap<
		TrapsetIdentityWrapper, MappingIdentityWrapper, Set<MappingIdentityWrapper>
	> nestedMap = new MultiValuedMap<>();

	private TrapsetIdentityWrapper identityWrap(TrapsetDeclaration trapsetDeclaration) {
		return trapsetIdentityCache.computeIfAbsent(trapsetDeclaration, TrapsetIdentityWrapper::wrap);
	}

	private MappingIdentityWrapper identityWrap(TrapsetTransitionLabel transitionLabel) {
		return mappingIdentityCache.computeIfAbsent(transitionLabel, MappingIdentityWrapper::wrap);
	}

	public TrapsetLabelingFunction() { }

	public List<BiTuple<TrapsetDeclaration, Set<TrapsetTransitionLabel>>> getMappings() {
		return getMappingsAsStream().collect(Collectors.toList());
	}

	public Stream<BiTuple<TrapsetDeclaration, Set<TrapsetTransitionLabel>>> getMappingsAsStream() {
		return nestedMap.keySet().stream()
				.map(k -> BiTuple.of(k.wrappedDeclaration, getMappedLabels(k.wrappedDeclaration)));
	}

	public Stream<BiTuple<TrapsetDeclaration, Stream<TrapsetTransitionLabel>>> getMappingsAsStreamComposition() {
		return nestedMap.entrySet().stream()
				.map(e -> BiTuple.of(
						e.getKey().wrappedDeclaration,
						e.getValue().stream().map(MappingIdentityWrapper::getWrappedTransition))
				);
	}

	public Set<TrapsetTransitionLabel> getMappedLabels(TrapsetDeclaration trapset) {
		return getMappedLabelsAsStream(trapset)
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	public Stream<TrapsetTransitionLabel> getMappedLabelsAsStream(TrapsetDeclaration trapset) {
		return nestedMap.get(TrapsetIdentityWrapper.wrap(trapset)).stream()
				.map(MappingIdentityWrapper::getWrappedTransition);
	}

	/**
	 * @param trapset The trapset for which a mapping is to be added.
	 * @param label Contains the transition the trapset is mapped to.
	 * @return true if a mapping from <pre>trapsetSymbol</pre> to <pre>transition</pre> did not previously exist.
	 */
	public boolean addMapping(TrapsetDeclaration trapset, TrapsetTransitionLabel label) {
		Set<MappingIdentityWrapper> labeledTransitions = nestedMap
				.computeIfAbsent(identityWrap(trapset), k -> new LinkedHashSet<>());
		return labeledTransitions.add(identityWrap(label));
	}

	public void addMapping(TrapsetDeclaration trapset) {
		nestedMap.computeIfAbsent(identityWrap(trapset), k -> new LinkedHashSet<>());
	}

	public boolean hasMappings(TrapsetDeclaration trapset) {
		TrapsetIdentityWrapper trapsetId = TrapsetIdentityWrapper.wrap(trapset);
		return nestedMap.containsKey(trapsetId)
				&& !nestedMap.get(trapsetId).isEmpty();
	}
}
