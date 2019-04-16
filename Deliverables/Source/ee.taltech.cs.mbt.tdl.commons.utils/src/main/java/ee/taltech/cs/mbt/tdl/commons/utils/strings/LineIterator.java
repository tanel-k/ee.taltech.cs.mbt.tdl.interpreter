package ee.taltech.cs.mbt.tdl.commons.utils.strings;

import java.util.Iterator;

public class LineIterator implements Iterator<String>, Iterable<String> {
	public static LineIterator forString(String str) {
		return new LineIterator(str);
	}

	private String str;

	private int lastIndex = 0;
	private int length;

	private LineIterator(String str) {
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

	@Override
	public Iterator<String> iterator() {
		return new LineIterator(str);
	}
}
