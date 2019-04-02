package ee.taltech.cs.mbt.tdl.common_utils.objects;

public class ObjectUtils {
	public static <T> T defaultObject(T obj, T defaultObj) {
		if (obj == null)
			return defaultObj;
		return obj;
	}
}
