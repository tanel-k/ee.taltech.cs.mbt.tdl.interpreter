package ee.taltech.cs.mbt.tdl.common_utils.strings;

public class StringUtils {
	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static String defaultString(String str, String defaultStr) {
		if (isEmpty(str))
			return defaultStr;
		return str;
	}
}
