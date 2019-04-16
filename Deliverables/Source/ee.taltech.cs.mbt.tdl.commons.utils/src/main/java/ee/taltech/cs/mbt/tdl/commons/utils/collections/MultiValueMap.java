package ee.taltech.cs.mbt.tdl.commons.utils.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MultiValueMap<K, V, C extends Collection<V>> implements Map<K, C> {
	private LinkedHashMap<K, C> nestedMap;

	public MultiValueMap() {
		nestedMap = new LinkedHashMap<>();
	}

	public MultiValueMap(int initialCapacity) {
		nestedMap = new LinkedHashMap<>(initialCapacity);
	}

	@SuppressWarnings("unchecked")
	public MultiValueMap(Map<? extends K, ? extends C> map) {
		nestedMap = new LinkedHashMap<>(map);
	}

	public MultiValueMap(int initialCapacity, float loadFactor, boolean accessOrder) {
		nestedMap = new LinkedHashMap<>(initialCapacity, loadFactor, accessOrder);
	}

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
		return nestedMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object values) {
		return nestedMap.containsValue(values);
	}

	@Override
	public C get(Object key) {
		return nestedMap.get(key);
	}

	@Override
	public C put(K key, C values) {
		return nestedMap.put(key, values);
	}

	@Override
	public C remove(Object key) {
		return nestedMap.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends C> map) {
		nestedMap.putAll(map);
	}

	@Override
	public void clear() {
		nestedMap.clear();
	}

	@Override
	public Set<K> keySet() {
		return nestedMap.keySet();
	}

	@Override
	public Collection<C> values() {
		return nestedMap.values();
	}

	@Override
	public Set<Entry<K, C>> entrySet() {
		return nestedMap.entrySet();
	}

	@Override
	public C getOrDefault(Object key, C defaultValue) {
		return nestedMap.getOrDefault(key, defaultValue);
	}

	@Override
	public void forEach(BiConsumer<? super K, ? super C> action) {
		nestedMap.forEach(action);
	}

	@Override
	public void replaceAll(BiFunction<? super K, ? super C, ? extends C> function) {
		nestedMap.replaceAll(function);
	}

	@Override
	public C putIfAbsent(K key, C value) {
		return nestedMap.putIfAbsent(key, value);
	}

	@Override
	public boolean remove(Object key, Object value) {
		return nestedMap.remove(key, value);
	}

	@Override
	public boolean replace(K key, C oldValue, C newValue) {
		return nestedMap.replace(key, oldValue, newValue);
	}

	@Override
	public C replace(K key, C value) {
		return nestedMap.replace(key, value);
	}

	@Override
	public C computeIfAbsent(K key, Function<? super K, ? extends C> mappingFunction) {
		return nestedMap.computeIfAbsent(key, mappingFunction);
	}

	@Override
	public C computeIfPresent(K key, BiFunction<? super K, ? super C, ? extends C> remappingFunction) {
		return nestedMap.computeIfPresent(key, remappingFunction);
	}

	@Override
	public C compute(K key, BiFunction<? super K, ? super C, ? extends C> remappingFunction) {
		return nestedMap.compute(key, remappingFunction);
	}

	@Override
	public C merge(K key, C value, BiFunction<? super C, ? super C, ? extends C> remappingFunction) {
		return nestedMap.merge(key, value, remappingFunction);
	}

	@Override
	public int hashCode() {
		return nestedMap.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof MultiValueMap))
			return false;
		MultiValueMap other = (MultiValueMap) o;
		return Objects.equals(this.nestedMap, other.nestedMap);
	}
}
