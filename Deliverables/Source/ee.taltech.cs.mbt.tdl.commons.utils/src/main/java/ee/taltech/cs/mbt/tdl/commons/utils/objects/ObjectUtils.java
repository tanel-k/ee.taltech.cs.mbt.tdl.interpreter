package ee.taltech.cs.mbt.tdl.commons.utils.objects;

public class ObjectUtils {
	public static <T> T defaultObject(T obj, T defaultObj) {
		if (obj == null)
			return defaultObj;
		return obj;
	}
}
