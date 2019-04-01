package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.supplementary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public abstract class AbsConsumptionQueue<I, O, E extends Exception> {
	public interface IConsumableProducer<I, O, E extends Exception> {
		O map(I input) throws E;
	}

	public static class MappingOperation<I, O, E extends Exception> {
		private final I input;
		private final IConsumableProducer<I, O, E> mapping;
		private final Consumer<O> consumer;

		public MappingOperation(I input, IConsumableProducer<I, O, E> mapping, Consumer<O> consumer) {
			this.input = input;
			this.mapping = mapping;
			this.consumer = consumer;
		}
	}

	private Queue<MappingOperation<I, O, E>> queue = new LinkedList<>();

	protected MappingOperation<I, O, E> getNext() {
		return queue.poll();
	}

	protected void runOperation(MappingOperation<I, O, E> operation) throws E {
		I input = operation.input;
		O output = operation.mapping.map(input);
		operation.consumer.accept(output);
	}

	protected void enqueue(I input, IConsumableProducer<I, O, E> mapping, Consumer<O> consumer) {
		this.queue.add(new MappingOperation<>(input, mapping, consumer));
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public boolean executeNext() throws E {
		if (!hasNext())
			return false;

		MappingOperation<I, O, E> next = getNext();
		runOperation(next);

		return hasNext();
	}

	public void executeAll() throws E {
		boolean hasNext = hasNext();
		while (hasNext) {
			hasNext = executeNext();
		}
	}
}
