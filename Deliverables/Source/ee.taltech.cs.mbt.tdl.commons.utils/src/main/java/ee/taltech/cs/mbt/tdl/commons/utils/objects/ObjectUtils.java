package ee.taltech.cs.mbt.tdl.commons.utils.objects;

public class ObjectUtils {
	public static <T> T defaultObject(T obj, T defaultObj) {
		if (obj == null)
			return defaultObj;
		return obj;
	}

	public static <T> T firstEquivalent(T comparisonObj, T... candidates) {
		for (T candidate : candidates) {
			if (comparisonObj.equals(candidate))
				return candidate;
		}
		return null;
	}
}
