package ee.taltech.cs.mbt.tdl.commons.utils.strings;

import java.util.Iterator;

public class LineExtractor implements Iterator<String> {
	public static LineExtractor forString(String str) {
		return new LineExtractor(str);
	}

	private String str;

	private int lastIndex = 0;
	private int length;

	private LineExtractor(String str) {
		if (str == null)
			throw new IllegalArgumentException("Expecting a non-null string argument.");
		this.str = str;
		this.lastIndex = 0;
		this.length = str.length();
	}

	@Override
	public boolean hasNext() {
		return lastIndex < length;
	}

	@Override
	public String next() {
		String line;
		int nextIndex = str.indexOf('\n', lastIndex);

		if (nextIndex < 0) {
			line = str.substring(lastIndex);
			lastIndex = length;
		} else {
			line = str.substring(lastIndex, nextIndex);
			if (line.startsWith("\r")) {
				line = line.substring(1);
				nextIndex += 1;
			}
			lastIndex = nextIndex + 1;
		}

		return line;
	}
}
