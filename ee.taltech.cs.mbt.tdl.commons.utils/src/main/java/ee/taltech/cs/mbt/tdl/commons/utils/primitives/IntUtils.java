package ee.taltech.cs.mbt.tdl.commons.utils.primitives;

import java.util.Iterator;

public class IntUtils {
	public static class IntGenerator implements Iterator<Integer>, Iterable<Integer> {
		public static final int DEFAULT_START_VALUE = 0;

		public static IntGenerator newInstance(Integer startValue) {
			return new IntGenerator(startValue);
		}

		public static IntGenerator newInstance() {
			return new IntGenerator(DEFAULT_START_VALUE);
		}

		private IntGenerator(Integer startValue) {
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
			this.currentValue = startValue;
			return this;
		}
	}
}
