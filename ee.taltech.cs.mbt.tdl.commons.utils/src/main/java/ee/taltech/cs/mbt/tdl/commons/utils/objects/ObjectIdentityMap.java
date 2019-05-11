package ee.taltech.cs.mbt.tdl.commons.utils.objects;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ObjectIdentityMap<K, V> implements Map<K, V> {
	private Map<ObjectIdentity<K>, V> nestedMap = new LinkedHashMap<>();

	@Override
	public int size() {
		return nestedMap.size();
	}

	@Override
	public boolean isEmpty() {
		return nestedMap.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return nestedMap.containsKey(ObjectIdentity.wrap(key));
	}

	@Override
	public boolean containsValue(Object value) {
		return nestedMap.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return nestedMap.get(ObjectIdentity.wrap(key));
	}

	@Override
	public V put(K key, V value) {
		return nestedMap.put(ObjectIdentity.wrap(key), value);
	}

	@Override
	public V remove(Object key) {
		return nestedMap.remove(ObjectIdentity.wrap(key));
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		m.entrySet().stream().forEachOrdered(e -> put(e.getKey(), e.getValue()));
	}

	@Override
	public void clear() {
		nestedMap.clear();
	}

	@Override
	public Set<K> keySet() {
		return nestedMap.keySet().stream()
				.map(ObjectIdentity::getWrappedInstance)
				.collect(Collectors.toSet());
	}

	@Override
	public Collection<V> values() {
		return nestedMap.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return nestedMap.entrySet().stream()
				.map(e -> new SimpleEntry<>(e.getKey().getWrappedInstance(), e.getValue()))
				.collect(Collectors.toSet());
	}

	@Override
	public V getOrDefault(Object key, V defaultValue) {
		return nestedMap.getOrDefault(ObjectIdentity.wrap(key), defaultValue);
	}

	@Override
	public void forEach(BiConsumer<? super K, ? super V> action) {
		nestedMap.entrySet().stream()
				.forEachOrdered(e -> action.accept(e.getKey().getWrappedInstance(), e.getValue()));
	}

	@Override
	public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
		nestedMap.replaceAll((k, v) -> function.apply(k.getWrappedInstance(), v));
	}

	@Override
	public V putIfAbsent(K key, V value) {
		return nestedMap.putIfAbsent(ObjectIdentity.wrap(key), value);
	}

	@Override
	public boolean remove(Object key, Object value) {
		return nestedMap.remove(ObjectIdentity.wrap(key), value);
	}

	@Override
	public boolean replace(K key, V oldValue, V newValue) {
		return nestedMap.replace(ObjectIdentity.wrap(key), oldValue, newValue);
	}

	@Override
	public V replace(K key, V value) {
		return nestedMap.replace(ObjectIdentity.wrap(key), value);
	}

	@Override
	public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
		return nestedMap.computeIfAbsent(ObjectIdentity.wrap(key), k -> mappingFunction.apply(k.getWrappedInstance()));
	}

	@Override
	public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return nestedMap.computeIfPresent(ObjectIdentity.wrap(key), (k, v) -> remappingFunction.apply(k.getWrappedInstance(), v));
	}

	@Override
	public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return nestedMap.compute(ObjectIdentity.wrap(key), (k, v) -> remappingFunction.apply(k.getWrappedInstance(), v));
	}

	@Override
	public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		return nestedMap.merge(ObjectIdentity.wrap(key), value, remappingFunction::apply);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getClass(), nestedMap);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof ObjectIdentityMap))
			return false;
		ObjectIdentityMap other = (ObjectIdentityMap) obj;
		return Objects.equals(other.nestedMap, this.nestedMap);
	}
}
