package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language;

import ee.taltech.cs.mbt.tdl.common_utils.collections.operations.IOperation;
import ee.taltech.cs.mbt.tdl.common_utils.collections.operations.OperationQueue;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.generic.parser.AbsAntlrParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language.ParseQueue.ParseOperation;

import java.util.function.Consumer;

public class ParseQueue extends OperationQueue<ParseOperation<?>, EmbeddedCodeSyntaxException> {
	public static class ParseOperation<T> implements IOperation<EmbeddedCodeSyntaxException> {
		private String code;
		private Consumer<T> resultConsumer;
		private AbsAntlrParser<T> parser;

		public ParseOperation(String code, AbsAntlrParser<T> parser, Consumer<T> resultConsumer) {
			this.code = code;
			this.parser = parser;
			this.resultConsumer = resultConsumer;
		}

		@Override
		public void execute() throws EmbeddedCodeSyntaxException {
			try {
				T output = parser.parseInput(code);
				resultConsumer.accept(output);
				if (parser.hasSyntaxErrors()) {
					throw new EmbeddedCodeSyntaxException(code, parser.getSyntaxErrors());
				}
			} catch (ParseException ex) {
				throw new EmbeddedCodeSyntaxException(code, parser.getSyntaxErrors(), ex);
			}
		}
	}

	public <T> void enqueue(String input, AbsAntlrParser<T> parser, Consumer<T> resultConsumer) {
		enqueue(new ParseOperation<>(input, parser, resultConsumer));
	}
}
