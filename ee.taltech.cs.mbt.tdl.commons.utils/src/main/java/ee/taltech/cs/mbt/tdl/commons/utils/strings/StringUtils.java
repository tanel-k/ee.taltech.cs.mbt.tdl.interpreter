package ee.taltech.cs.mbt.tdl.commons.utils.strings;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class StringUtils {
	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static String defaultString(String str, String defaultStr) {
		return !isEmpty(str) ? str : defaultStr;
	}

	public static boolean containsCharacters(String str, Character... characters) {
		return !isEmpty(str) && containsCharacters(str, CollectionUtils.arrayToSet(characters));
	}

	public static boolean containsCharacters(String str, Collection<Character> characters) {
		for (int i = 0; i < str.length(); i++) {
			if (characters.contains(str.charAt(i)))
				return true;
		}
		return false;
	}

	public static String replaceCharacters(String str, Map<Character, String> replacements) {
		return replaceCharacters(str, replacements.keySet(), replacements::get);
	}

	public static String replaceCharacters(String str, Set<Character> chars, Function<Character, String> remappingFunction) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			Character chr = str.charAt(i);
			if (chars.contains(chr)) {
				buf.append(remappingFunction.apply(chr));
			} else {
				buf.append(chr);
			}
		}
		return buf.toString();
	}

	public static LineIterator lineExtractor(String str) {
		return LineIterator.forString(str);
	}
}
