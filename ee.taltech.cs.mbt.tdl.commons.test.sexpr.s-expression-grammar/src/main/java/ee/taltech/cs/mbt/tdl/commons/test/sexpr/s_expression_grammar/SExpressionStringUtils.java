package ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.strings.StringUtils;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SExpressionStringUtils {
	private static final Character DELIMITER = '"';
	private static final Set<Character> RESERVED_CHARS = CollectionUtils.newSet(
			'"', '(', ')', '.'
	);
	private static final Pattern ESCAPED_CHAR_PTTN = Pattern.compile("\\\\([\"().])");

	private static String escapeCharacter(Character chr) {
		return "\\" + chr;
	}

	public static String escape(String str) {
		return StringUtils.replaceCharacters(str, RESERVED_CHARS, SExpressionStringUtils::escapeCharacter);
	}

	public static String unescape(String str) {
		Matcher m = ESCAPED_CHAR_PTTN.matcher(str);
		return m.replaceAll("$1");
	}

	public static boolean shouldDelimit(String str) {
		return StringUtils.containsCharacters(str, RESERVED_CHARS);
	}

	public static String delimit(String str) {
		return DELIMITER + str + DELIMITER;
	}

	public static String undelimit(String str) {
		char first = str.charAt(0);
		if (DELIMITER.equals(first))
			str = str.substring(1);
		char last = str.charAt(str.length() - 1);
		if (DELIMITER.equals(last))
			str = str.substring(0, str.length() - 1);
		return str;
	}
}
