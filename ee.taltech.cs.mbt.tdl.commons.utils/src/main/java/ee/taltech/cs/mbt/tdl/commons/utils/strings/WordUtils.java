package ee.taltech.cs.mbt.tdl.commons.utils.strings;

public class WordUtils {
	public static String capitalize(String str) {
		if (StringUtils.isEmpty(str))
			return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
