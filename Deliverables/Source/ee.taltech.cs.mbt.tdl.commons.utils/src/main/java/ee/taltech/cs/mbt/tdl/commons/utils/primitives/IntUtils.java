package ee.taltech.cs.mbt.tdl.commons.utils.primitives;

import java.util.Iterator;

public class IntUtils {
	public static class IntProvider implements Iterator<Integer>, Iterable<Integer> {
		public static IntProvider newInstance(Integer startValue) {
			return new IntProvider(startValue);
		}

		public static IntProvider newInstance() {
			return new IntProvider(0);
		}

		private IntProvider(Integer startValue) {
			this.currentValue = this.startValue = startValue;
		}

		private Integer startValue;
		private Integer currentValue;

		public Integer getCurrentValue() {
			return currentValue;
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
