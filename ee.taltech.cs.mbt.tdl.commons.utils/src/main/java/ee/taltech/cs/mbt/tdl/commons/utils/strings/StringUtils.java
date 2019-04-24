package ee.taltech.cs.mbt.tdl.commons.utils.strings;

public class StringUtils {
	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static String defaultString(String str, String defaultStr) {
		if (isEmpty(str))
			return defaultStr;
		return str;
	}

	public static LineIterator lineExtractor(String str) {
		return LineIterator.forString(str);
	}
}
