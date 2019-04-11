package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.function;

import com.sun.javafx.geom.Edge;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.MultiValuedMap;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.TrapsetDeclaration;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.TrapsetTransitionLabel;

import java.util.LinkedHashSet;
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

		private MappingIdentityWrapper(TrapsetTransitionLabel wrappedTransition) {}

		private TrapsetTransitionLabel getWrappedTransition() {
			return wrappedTransition;
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

	private MultiValuedMap<TrapsetIdentityWrapper, MappingIdentityWrapper, Set<MappingIdentityWrapper>> nestedMap
			= new MultiValuedMap<>();

	public Set<TrapsetTransitionLabel> getMappedLabels(TrapsetDeclaration trapset) {
		return getMappedLabelsAsStream(trapset)
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	public Stream<TrapsetTransitionLabel> getMappedLabelsAsStream(TrapsetDeclaration trapset) {
		TrapsetIdentityWrapper wrappedTrapset = TrapsetIdentityWrapper.wrap(trapset);
		return nestedMap.get(wrappedTrapset).stream()
				.map(MappingIdentityWrapper::getWrappedTransition);
	}

	/**
	 * @param trapset The trapset for which a mapping is to be added.
	 * @param label Contains the transition the trapset is mapped to.
	 * @return true if a mapping from <pre>trapsetSymbol</pre> to <pre>transition</pre> already exists.
	 */
	public boolean addMapping(TrapsetDeclaration trapset, TrapsetTransitionLabel label) {
		TrapsetIdentityWrapper wrappedTrapset = TrapsetIdentityWrapper.wrap(trapset);
		Set<MappingIdentityWrapper> labeledTransitions = nestedMap
				.computeIfAbsent(wrappedTrapset, k -> new LinkedHashSet<>());
		return labeledTransitions.add(
				MappingIdentityWrapper.wrap(label)
		);
	}

	public boolean hasMappings(TrapsetDeclaration trapset) {
		TrapsetIdentityWrapper wrappedTrapset = TrapsetIdentityWrapper.wrap(trapset);
		return nestedMap.containsKey(wrappedTrapset)
				&& !nestedMap.get(wrappedTrapset).isEmpty();
	}
}
