package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.supplementary.AbsConsumptionQueue;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.CodeGenerationException;

import java.util.function.Consumer;

public class GenerationQueue extends AbsConsumptionQueue<Object, String, CodeGenerationException> {
	public static class GenerationMapping<T> implements IMapping<T, String, CodeGenerationException> {
		@SuppressWarnings("unchecked")
		private static <T> GenerationMapping<Object> wrapGeneric(AbsSTGenerator<T> parser) {
			return (GenerationMapping<Object>) new GenerationMapping<>(parser);
		}

		public static <T> GenerationMapping<T> wrap(AbsSTGenerator<T> parser) {
			return new GenerationMapping<>(parser);
		}

		private AbsSTGenerator<T> generator;

		@Override
		public String map(T input) throws CodeGenerationException {
			return this.generator.generate(input);
		}

		public GenerationMapping(AbsSTGenerator<T> generator) {
			this.generator = generator;
		}
	}

	public <T> void enqueue(T input, AbsSTGenerator<T> generator, Consumer<String> consumer) {
		super.enqueue(input, GenerationMapping.wrapGeneric(generator), consumer);
	}
}
