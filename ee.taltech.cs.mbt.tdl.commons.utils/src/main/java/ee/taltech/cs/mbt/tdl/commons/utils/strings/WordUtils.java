package ee.taltech.cs.mbt.tdl.commons.utils.strings;

public class WordUtils {
	public static String capitalize(String str) {
		if (StringUtils.isEmpty(str))
			return str;
		String first = str.substring(0, 1).toUpperCase();
		return str.length() == 1 ? first : (first + str.substring(1));
	}
}
