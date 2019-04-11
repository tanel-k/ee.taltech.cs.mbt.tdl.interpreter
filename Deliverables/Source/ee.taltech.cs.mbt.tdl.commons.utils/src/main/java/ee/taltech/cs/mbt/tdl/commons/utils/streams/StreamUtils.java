package ee.taltech.cs.mbt.tdl.commons.utils.streams;

import ee.taltech.cs.mbt.tdl.commons.utils.functions.ITernaryFunction;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.Spliterators.AbstractSpliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {
	private static class IndexProvider {
		public static IndexProvider newInstance() {
			return new IndexProvider(0);
		}

		private IndexProvider(Integer startValue) {
			this.currentIndex = startValue;
		}

		private Integer currentIndex;

		public Integer getCurrentIndex() {
			return currentIndex;
		}

		public Integer next() {
			return currentIndex++;
		}
	}

	public static <A, B, R> Stream<R> zipSequential(Stream<A> streamA, Stream<B> streamB, ITernaryFunction<A, B, Integer, R> function) {
		streamA = streamA.sequential();
		streamB = streamB.sequential();

		Spliterator<A> splitrA = streamA.spliterator();
		Spliterator<B> splitrB = streamB.spliterator();

		int characteristics = splitrA.characteristics()
				& splitrB.characteristics()
				& (Spliterator.ORDERED | Spliterator.SIZED);

		final Iterator<A> itrA = Spliterators.iterator(splitrA);
		final Iterator<B> itrB = Spliterators.iterator(splitrB);

		final IndexProvider indexProvider = IndexProvider.newInstance();
		return StreamSupport.stream(new AbstractSpliterator<R>(Math.min(splitrA.estimateSize(), splitrB.estimateSize()), characteristics) {
			public boolean tryAdvance(Consumer<? super R> action) {
				if (itrA.hasNext() && itrB.hasNext()) {
					action.accept(function.apply(itrA.next(), itrB.next(), indexProvider.next()));
					return true;
				} else {
					return false;
				}
			}
		}, false);
	}
}
