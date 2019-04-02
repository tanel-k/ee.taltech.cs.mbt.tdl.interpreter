package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language;

import ee.taltech.cs.mbt.tdl.common_utils.collections.operations.IOperation;
import ee.taltech.cs.mbt.tdl.common_utils.collections.operations.OperationQueue;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language.GenerationQueue.GenerationOperation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.CodeGenerationException;

import java.util.Collection;
import java.util.function.Consumer;

public class GenerationQueue extends OperationQueue<GenerationOperation<?>, SyntaxRepresentationException> {
	@FunctionalInterface
	private interface ThrowingGenerator<O, E extends Exception> {
		public O execute() throws E;
	}

	public static class GenerationOperation<T> implements IOperation<SyntaxRepresentationException> {
		private ThrowingGenerator<String, SyntaxRepresentationException> generator;
		private Consumer<String> resultConsumer;

		public GenerationOperation(T representation, AbsSTGenerator<T> generator, Consumer<String> resultConsumer) {
			this.generator = () -> {
				try {
					return generator.generate(representation);
				} catch (CodeGenerationException ex) {
					throw new SyntaxRepresentationException(representation, ex);
				}
			};
			this.resultConsumer = resultConsumer;
		}

		public GenerationOperation(Collection<T> representations, AbsSTGenerator<T> generator, Consumer<String> resultConsumer) {
			this.generator = () -> {
				try {
					return generator.generate(representations);
				} catch (CodeGenerationException ex) {
					throw new SyntaxRepresentationException(representations, ex);
				}
			};
			this.resultConsumer = resultConsumer;
		}

		@Override
		public void execute() throws SyntaxRepresentationException {
			String code = this.generator.execute();
			this.resultConsumer.accept(code);
		}
	}

	public <T> void enqueue(T input, AbsSTGenerator<T> generator, Consumer<String> consumer) {
		enqueue(new GenerationOperation<>(input, generator, consumer));
	}

	public <T> void enqueue(Collection<T> inputs, AbsSTGenerator<T> generator, Consumer<String> consumer) {
		enqueue(new GenerationOperation<>(inputs, generator, consumer));
	}
}
