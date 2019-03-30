package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap.BaseSharingType;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class BaseSharingTypeMap<K> implements Iterable<BaseSharingType<K>>, IDeepCloneable<BaseSharingTypeMap<K>> {
	public static class BaseSharingType<K> extends Type {
		private K key;
		private BaseSharingTypeMap<K> parentMap;

		private BaseSharingType(K key, BaseSharingTypeMap<K> parentMap) {
			this.key = key;
			this.parentMap = parentMap;
		}

		public K getKey() {
			return key;
		}

		public Type toDetachedInstance() {
			Type type = new Type();
			type.setByReference(isByReference());
			type.setBaseType(getBaseType().deepClone());
			getArrayModifiers().stream()
					.map(AbsArrayModifier::deepClone)
					.forEach(type.getArrayModifiers()::add);
			return type;
		}

		@Override
		public BaseType getBaseType() {
			return parentMap.getBaseType();
		}

		@Override
		public void setBaseType(BaseType baseType) {
			throw new UnsupportedOperationException(
					"This field is controlled by the parent " + parentMap.getClass().getName() + " instance."
			);
		}
	}

	private BaseType baseType;
	private Map<K, BaseSharingType<K>> nestedMap = new LinkedHashMap<>();

	public BaseType getBaseType() {
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	public BaseSharingType<K> getConcreteType(K key) {
		return nestedMap.get(key);
	}

	public BaseSharingType<K> getOrCreateConcreteType(K key) {
		return nestedMap.computeIfAbsent(key, k -> new BaseSharingType<>(key, this));
	}

	public boolean contains(K key) {
		return nestedMap.containsKey(key);
	}

	public boolean isEmpty() {
		return nestedMap.isEmpty();
	}

	public int size() {
		return nestedMap.size();
	}

	public void remove(K key) {
		nestedMap.remove(key);
	}

	public Stream<BaseSharingType<K>> stream() {
		return Collections.unmodifiableMap(nestedMap).values().stream();
	}

	@Override
	public Iterator<BaseSharingType<K>> iterator() {
		return stream().iterator();
	}

	@Override
	public BaseSharingTypeMap<K> deepClone() {
		BaseSharingTypeMap<K> clone = new BaseSharingTypeMap<>();
		clone.setBaseType(getBaseType().deepClone());
		stream().forEach(t -> {
			BaseSharingType<K> type = clone.getOrCreateConcreteType(t.getKey());
			t.getArrayModifiers().stream()
					.map(AbsArrayModifier::deepClone)
					.forEach(type.getArrayModifiers()::add);
		});
		return clone;
	}
}
