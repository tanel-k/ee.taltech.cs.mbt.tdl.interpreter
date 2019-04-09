package ee.taltech.cs.mbt.tdl.commons.utils.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class CollectionUtils {
	public static class CollectionBuilder<T> {
		private Collection<T> collection;

		public CollectionBuilder(Collection<T> collection) {
			this.collection = collection;
		}

		public CollectionBuilder<T> addIf(T item, Predicate<T> condition) {
			if (condition.test((item)))
				add(item);
			return this;
		}

		public CollectionBuilder<T> addIfNonNull(T item) {
			return addIf(item, Objects::nonNull);
		}

		public CollectionBuilder<T> add(T item) {
			collection.add(item);
			return this;
		}

		public CollectionBuilder<T> remove(T item) {
			collection.remove(item);
			return this;
		}

		public Collection<T> build() {
			return collection;
		}
	}

	public static <T> boolean addIfNonNull(Collection<T> collection, T item) {
		return addIf(collection, item, Objects::nonNull);
	}

	public static <T> boolean addIf(Collection<T> collection, T item, Predicate<T> condition) {
		if (condition.test(item)) {
			collection.add(item);
			return true;
		}
		return false;
	}

	public static <T> Set<T> newSet(T... items) {
		Set<T> set = new HashSet<>();
		for (T item : items)
			set.add(item);
		return set;
	}

	public static <T> CollectionBuilder<T> collectionBuilder() {
		return new CollectionBuilder<>(new LinkedList<>());
	}

	public static <T> CollectionBuilder<T> collectionBuilder(Collection<T> collection) {
		return new CollectionBuilder<>(collection);
	}
}
