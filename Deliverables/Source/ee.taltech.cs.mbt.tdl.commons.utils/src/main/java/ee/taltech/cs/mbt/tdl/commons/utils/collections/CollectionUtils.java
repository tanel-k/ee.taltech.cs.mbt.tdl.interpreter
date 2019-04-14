package ee.taltech.cs.mbt.tdl.commons.utils.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class CollectionUtils {
	public static class CollectionBuilder<T, C extends Collection<T>> {
		private C collection;

		public CollectionBuilder(C collection) {
			this.collection = collection;
		}

		public CollectionBuilder<T, C> addIf(T item, Predicate<T> condition) {
			if (condition.test((item)))
				add(item);
			return this;
		}

		public CollectionBuilder<T, C> addIfNonNull(T item) {
			return addIf(item, Objects::nonNull);
		}

		public CollectionBuilder<T, C> add(T item) {
			collection.add(item);
			return this;
		}

		public CollectionBuilder<T, C> add(T... items) {
			for (T item : items) {
				collection.add(item);
			}
			return this;
		}

		public CollectionBuilder<T, C> remove(T item) {
			collection.remove(item);
			return this;
		}

		public C build() {
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

	public static <T> Set<T> newSet(Collection<T> from) {
		return new HashSet<>(from);
	}

	public static <T> Set<T> newSet(T... items) {
		Set<T> set = new HashSet<>();
		for (T item : items)
			set.add(item);
		return set;
	}

	public static <T> List<T> newList(T... items) {
		List<T> list = new LinkedList<>();
		for (T item : items)
			list.add(item);
		return list;
	}

	public static <T> void addAll(Collection<T> collection, T... items) {
		collection.addAll(Arrays.asList(items));
	}

	public static <T> CollectionBuilder<T, LinkedList<T>> collectionBuilder() {
		return new CollectionBuilder<>(new LinkedList<>());
	}

	public static <T, C extends Collection<T>> CollectionBuilder<T, C> collectionBuilder(C collection) {
		return new CollectionBuilder<>(collection);
	}
}
