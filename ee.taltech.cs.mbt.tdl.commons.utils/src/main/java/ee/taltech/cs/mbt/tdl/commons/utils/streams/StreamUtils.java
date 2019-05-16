package ee.taltech.cs.mbt.tdl.commons.utils.streams;

import ee.taltech.cs.mbt.tdl.commons.utils.functions.ITernaryFunction;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntGenerator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.Spliterators.AbstractSpliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {
	public static <A, B, R> Stream<R> zipSequential(Stream<A> streamA, Stream<B> streamB, ITernaryFunction<A, B, Integer, R> function) {
		streamA = streamA.sequential();
		streamB = streamB.sequential();

		Spliterator<A> splitterA = streamA.spliterator();
		Spliterator<B> splitterB = streamB.spliterator();

		int characteristics = splitterA.characteristics()
				& splitterB.characteristics()
				& (Spliterator.ORDERED | Spliterator.SIZED);

		final Iterator<A> itrA = Spliterators.iterator(splitterA);
		final Iterator<B> itrB = Spliterators.iterator(splitterB);

		final IntGenerator indexProvider = IntGenerator.newInstance(0);
		return StreamSupport.stream(new AbstractSpliterator<R>(Math.min(splitterA.estimateSize(), splitterB.estimateSize()), characteristics) {
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
