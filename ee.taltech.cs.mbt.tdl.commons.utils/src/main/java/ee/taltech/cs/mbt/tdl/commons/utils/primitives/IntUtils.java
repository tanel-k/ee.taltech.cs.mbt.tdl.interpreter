package ee.taltech.cs.mbt.tdl.commons.utils.primitives;

import java.util.Iterator;

public class IntUtils {
	public static class IntIterator implements Iterator<Integer>, Iterable<Integer> {
		public static final int DEFAULT_START_VALUE = 0;

		public static IntIterator newInstance(Integer startValue) {
			return new IntIterator(startValue);
		}

		public static IntIterator newInstance() {
			return new IntIterator(DEFAULT_START_VALUE);
		}

		private IntIterator(Integer startValue) {
			this.currentValue = (this.startValue = startValue);
		}

		private Integer startValue;
		private Integer currentValue;

		public Integer getCurrentValue() {
			return currentValue;
		}

		public void reset() {
			currentValue = startValue;
		}

		@Override
		public boolean hasNext() {
			return currentValue < Integer.MAX_VALUE;
		}

		@Override
		public Integer next() {
			return currentValue++;
		}

		@Override
		public Iterator<Integer> iterator() {
			return newInstance(startValue);
		}
	}
}
