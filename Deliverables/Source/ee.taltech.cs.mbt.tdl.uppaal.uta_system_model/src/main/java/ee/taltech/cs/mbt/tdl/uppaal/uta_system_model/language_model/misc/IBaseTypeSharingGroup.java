package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap.BaseSharingType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface IBaseTypeSharingGroup<ParentType, GroupedType extends ParentType> {
	BaseSharingTypeMap<Identifier> getBaseSharingTypeMap();
	GroupedType mapToIndependent(BaseSharingType<Identifier> extendedType);

	default List<GroupedType> independentInstances() {
		return getBaseSharingTypeMap().stream()
				.map(this::mapToIndependent)
				.collect(Collectors.toList());
	}

	default Optional<ParentType> getOnlyEntry() {
		return getBaseSharingTypeMap().size() != 1
				? Optional.empty()
				: Optional.of(mapToIndependent(getBaseSharingTypeMap().iterator().next()));
	}
}
