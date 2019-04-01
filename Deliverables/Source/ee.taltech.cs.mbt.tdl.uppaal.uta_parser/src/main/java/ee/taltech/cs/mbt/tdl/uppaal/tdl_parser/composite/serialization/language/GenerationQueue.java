package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.supplementary.AbsConsumptionQueue;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.CodeGenerationException;

import java.util.Collection;
import java.util.function.Consumer;

public class GenerationQueue extends AbsConsumptionQueue<Object, String, CodeGenerationException> {
	public static class GenerationConsumableProducer<T> implements IConsumableProducer<T, String, CodeGenerationException> {
		@SuppressWarnings("unchecked")
		private static <T> GenerationConsumableProducer<Object> downCastWrap(AbsSTGenerator<T> parser) {
			return (GenerationConsumableProducer<Object>) wrap(parser);
		}

		public static <T> GenerationConsumableProducer<T> wrap(AbsSTGenerator<T> parser) {
			return new GenerationConsumableProducer<>(parser);
		}

		private AbsSTGenerator<T> generator;

		@Override
		public String map(T input) throws CodeGenerationException {
			return this.generator.generate(input);
		}

		public GenerationConsumableProducer(AbsSTGenerator<T> generator) {
			this.generator = generator;
		}
	}

	public <T> void enqueue(T input, AbsSTGenerator<T> generator, Consumer<String> consumer) {
		super.enqueue(input, GenerationConsumableProducer.downCastWrap(generator), consumer);
	}

	public <T> void enqueue(Collection<T> inputs, AbsSTGenerator<T> generator, Consumer<String> consumer) {
		super.enqueue(inputs, GenerationConsumableProducer.downCastWrap(generator), consumer);
	}
}
