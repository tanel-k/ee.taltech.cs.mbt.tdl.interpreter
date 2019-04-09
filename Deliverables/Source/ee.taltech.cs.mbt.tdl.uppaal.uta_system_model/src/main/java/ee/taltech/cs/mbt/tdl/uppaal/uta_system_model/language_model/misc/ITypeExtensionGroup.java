package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A common interface for language element groups where the grouped element implementations
 * refer to {@link Type} instances that share a common {@link BaseType}.<br/>
 * Type information is stored in the map yielded by {@link #getBaseTypeExtensionMap()}.
 *
 * @param <ParentType> The common parent of the grouped type and the group.
 * @param <GroupedType> The grouped type.
 */
public interface ITypeExtensionGroup<ParentType, GroupedType extends ParentType> {
	BaseTypeExtensionMap getBaseTypeExtensionMap();

	/**
	 * @param baseTypeExtension Type information that is attached to the instance returned by {@link #getBaseTypeExtensionMap()}.
	 * @return An independent {@link GroupedType} instance whose type is derived from the baseSharingType parameter.
	 */
	GroupedType mapToIndependent(BaseTypeExtension baseTypeExtension);

	/**
	 * @return A list of {@link GroupedType} instances that are independent from this group instance.
	 */
	default List<GroupedType> independentInstances() {
		return getBaseTypeExtensionMap().stream()
				.map(this::mapToIndependent)
				.collect(Collectors.toList());
	}

	/**
	 * @return if this group contains a single entry, the corresponding {@link GroupedType} instance (upcasted to {@link ParentType}),
	 * otherwise returns an empty {@link Optional}.
	 */
	default Optional<ParentType> getOnlyEntry() {
		return getBaseTypeExtensionMap().size() != 1
				? Optional.empty()
				: Optional.of(mapToIndependent(getBaseTypeExtensionMap().iterator().next()));
	}

	@SuppressWarnings("unchecked")
	default ParentType reduceToOnlyEntryIfApplicable() {
		return getOnlyEntry().orElse((ParentType) this);
	}

	default void remove(Identifier identifier) {
		getBaseTypeExtensionMap().remove(identifier);
	}
}
