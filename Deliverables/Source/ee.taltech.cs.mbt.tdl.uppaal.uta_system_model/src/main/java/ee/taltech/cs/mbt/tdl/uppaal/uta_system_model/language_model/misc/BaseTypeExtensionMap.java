package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * A single line declaration of a field, variable, or type may actually contain more than one concrete declaration.<br/>
 * Essentially we have a sequence of unique {@link Identifier} instances which are linked to the same {@link BaseType} but may
 * have different data in the fields of {@link Type} (which provides its {@link BaseType} via {@link Type#getBaseType()}).<br/>
 * <br/>
 * {@link BaseTypeExtensionMap} encodes the scenario above and stores an internal map from {@link Identifier} instances to extensions of {@link Type}
 * ({@link BaseTypeExtension}) such that an extension will yield {@link BaseTypeExtensionMap#getBaseType()}
 * when its {@link Type#getBaseType()} method is called.<br/>
 * This means we can use {@link BaseTypeExtensionMap#setBaseType(BaseType)} to set current base type for all attached instances.
 */
public class BaseTypeExtensionMap implements Iterable<BaseTypeExtension>, IDeepCloneable<BaseTypeExtensionMap> {
	/**
	 * An extension of {@link Type} whose {@link BaseType} field is controlled from a parent {@link BaseTypeExtensionMap} instance.<br/>
	 */
	public static class BaseTypeExtension extends Type {
		private Identifier identifier;
		private BaseTypeExtensionMap parentMap;

		private BaseTypeExtension(Identifier identifier, BaseTypeExtensionMap parentMap) {
			this.identifier = identifier;
			this.parentMap = parentMap;
		}

		public BaseTypeExtensionMap getParentMap() {
			return parentMap;
		}

		/**
		 * @return the {@link Identifier} this instance is keyed under in the parent {@link BaseTypeExtensionMap}.
		 */
		public Identifier getIdentifier() {
			return identifier;
		}

		/**
		 * @return a copy of this instance that is no longer attached to a {@link BaseTypeExtensionMap}.
		 */
		public Type toDetachedInstance() {
			Type type = new Type();
			type.setReferenceType(isReferenceType());
			type.setBaseType(getBaseType().deepClone());
			getArrayModifiers()
					.stream()
					.forEachOrdered(m -> type.getArrayModifiers().add((AbsArrayModifier<?>) m.deepClone()));
			return type;
		}

		/**
		 * @return {@link BaseTypeExtensionMap#getBaseType()} from the parent {@link BaseTypeExtensionMap}.
		 */
		@Override
		public BaseType getBaseType() {
			return getParentMap().getBaseType();
		}

		/**
		 * This operation is not available.<br/>
		 * The base type is controlled from the parent {@link BaseTypeExtensionMap} instance.<br/>
		 * See also: {@link #getBaseType()}.
		 */
		@Override
		public BaseTypeExtension setBaseType(BaseType baseType) {
			throw new UnsupportedOperationException(
					"This field is controlled by the parent " + parentMap.getClass().getSimpleName() + " instance."
			);
		}
	}

	private BaseType baseType;
	private Map<Identifier, BaseTypeExtension> nestedMap = new LinkedHashMap<>();

	public BaseType getBaseType() {
		return baseType;
	}

	public BaseTypeExtensionMap setBaseType(BaseType baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * @return The {@link BaseTypeExtension} instance keyed under the identifier.<br/>
	 */
	public BaseTypeExtension getType(Identifier identifier) {
		return nestedMap.get(identifier);
	}

	/**
	 * @return The {@link BaseTypeExtension} instance keyed under the identifier (or a new instance if the aforementioned is null).
	 */
	public BaseTypeExtension getOrCreateType(Identifier identifier) {
		return nestedMap.computeIfAbsent(identifier, id -> new BaseTypeExtension(id, this));
	}

	public boolean contains(Identifier identifier) {
		return nestedMap.containsKey(identifier);
	}

	public boolean isEmpty() {
		return nestedMap.isEmpty();
	}

	public int size() {
		return nestedMap.size();
	}

	public void remove(Identifier identifier) {
		nestedMap.remove(identifier);
	}

	public Collection<BaseTypeExtension> collectionView() {
		return Collections.unmodifiableMap(nestedMap).values();
	}

	public Stream<BaseTypeExtension> streamView() {
		return collectionView().stream();
	}

	@Override
	public Iterator<BaseTypeExtension> iterator() {
		return collectionView().iterator();
	}

	@Override
	public BaseTypeExtensionMap deepClone() {
		BaseTypeExtensionMap clone = new BaseTypeExtensionMap();
		clone.setBaseType(getBaseType().deepClone());
		streamView().forEachOrdered(t -> {
			BaseTypeExtension typeClone = clone.getOrCreateType(t.getIdentifier());
			typeClone.setReferenceType(t.isReferenceType());
			t.getArrayModifiers().stream()
					.forEachOrdered(m -> typeClone.addArrayModifier((AbsArrayModifier<?>) m.deepClone()));
		});
		return clone;
	}
}
