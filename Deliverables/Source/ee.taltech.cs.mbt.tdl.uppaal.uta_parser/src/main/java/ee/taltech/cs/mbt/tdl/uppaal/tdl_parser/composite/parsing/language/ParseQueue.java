package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.generic.parser.AbsAntlrParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.supplementary.AbsConsumptionQueue;

import java.util.function.Consumer;

public class ParseQueue extends AbsConsumptionQueue<String, Object, InvalidEmbeddedCodeException> {
	public static class ParseConsumableProducer<T> implements IConsumableProducer<String, T, InvalidEmbeddedCodeException> {
		@SuppressWarnings("unchecked")
		private static <T> ParseConsumableProducer<Object> downCastWrap(AbsAntlrParser<T> parser) {
			return (ParseConsumableProducer<Object>) wrap(parser);
		}

		public static <T> ParseConsumableProducer<T> wrap(AbsAntlrParser<T> parser) {
			return new ParseConsumableProducer<>(parser);
		}

		private final AbsAntlrParser<T> parser;

		@Override
		public T map(String input) throws InvalidEmbeddedCodeException {
			try {
				T output = parser.parseInput(input);
				if (parser.hasSyntaxErrors()) {
					throw new InvalidEmbeddedCodeException(input, parser.getSyntaxErrors());
				}
				return output;
			} catch (ParseException ex) {
				throw new InvalidEmbeddedCodeException(input, parser.getSyntaxErrors(), ex);
			}
		}

		private ParseConsumableProducer(AbsAntlrParser<T> parser) {
			this.parser = parser;
		}
	}

	@SuppressWarnings("unchecked")
	public <R> void enqueue(String input, AbsAntlrParser<R> parser, Consumer<R> consumer) {
		super.enqueue(input, ParseConsumableProducer.downCastWrap(parser), (Consumer<Object>) consumer);
	}
}
