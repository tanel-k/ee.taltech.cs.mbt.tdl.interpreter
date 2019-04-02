package ee.taltech.cs.mbt.tdl.common_utils.collections;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public class CollectionUtils {
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
}
