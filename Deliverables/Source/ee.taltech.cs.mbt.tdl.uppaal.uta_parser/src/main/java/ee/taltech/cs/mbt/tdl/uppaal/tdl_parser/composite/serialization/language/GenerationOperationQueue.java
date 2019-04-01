package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.CodeGenerationException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class GenerationOperationQueue {
	private static class EnqueuedGenerationOperation<R> {
		private R object;
		private AbsSTGenerator<R> generator;
		private Consumer<String> resultConsumer;

		private R getObject() {
			return object;
		}

		private AbsSTGenerator<R> getGenerator() {
			return generator;
		}

		private Consumer<String> getResultConsumer() {
			return resultConsumer;
		}

		private EnqueuedGenerationOperation(R object, AbsSTGenerator<R> generator, Consumer<String> resultConsumer) {
			this.generator = generator;
			this.object = object;
			this.resultConsumer = resultConsumer;
		}
	}

	private Queue<EnqueuedGenerationOperation<?>> nestedQueue = new LinkedList<>();

	public <R> void enqueue(R object, AbsSTGenerator<R> generator, Consumer<String> resultConsumer) {
		nestedQueue.add(new EnqueuedGenerationOperation<>(object, generator, resultConsumer));
	}

	private <R> void execute(EnqueuedGenerationOperation<R> enqueuedParseOperation) throws CodeGenerationException {
		AbsSTGenerator<R> generator = enqueuedParseOperation.getGenerator();
		Consumer<String> consumer = enqueuedParseOperation.getResultConsumer();
		R object = enqueuedParseOperation.getObject();
		String code = generator.generate(object);
		consumer.accept(code);
	}

	public boolean hasNext() {
		return !nestedQueue.isEmpty();
	}

	private EnqueuedGenerationOperation<?> getNext() {
		return nestedQueue.poll();
	}

	public void executeAll() {
		boolean hasNext = hasNext();
		while (hasNext) {
			hasNext = executeNext();
		}
	}

	public boolean executeNext() {
		if (!hasNext())
			return false;

		EnqueuedGenerationOperation<?> dequeuedOp = getNext();
		try {
			execute(dequeuedOp);
		} catch (CodeGenerationException ex) {
			throw new RuntimeException(ex);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}

		return hasNext();
	}

}
