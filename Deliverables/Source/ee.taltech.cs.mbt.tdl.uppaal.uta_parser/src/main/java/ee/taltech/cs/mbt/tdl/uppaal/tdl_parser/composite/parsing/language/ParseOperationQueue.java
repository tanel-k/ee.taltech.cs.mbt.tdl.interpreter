package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.generic.parser.AbsAntlrParser;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class ParseOperationQueue {
	private static class EnqueuedParseOperation<R> {
		private String codeSnippet;
		private AbsAntlrParser<R> parser;
		private Consumer<R> resultConsumer;

		private String getCodeSnippet() {
			return codeSnippet;
		}

		private AbsAntlrParser<R> getParser() {
			return parser;
		}

		private Consumer<R> getResultConsumer() {
			return resultConsumer;
		}

		private EnqueuedParseOperation(String codeSnippet, AbsAntlrParser<R> parser, Consumer<R> resultConsumer) {
			this.parser = parser;
			this.codeSnippet = codeSnippet;
			this.resultConsumer = resultConsumer;
		}
	}

	private Queue<EnqueuedParseOperation<?>> nestedQueue = new LinkedList<>();

	public <R> void enqueue(String code, AbsAntlrParser<R> parser, Consumer<R> resultConsumer) {
		nestedQueue.add(new EnqueuedParseOperation<>(code, parser, resultConsumer));
	}

	private <R> void execute(EnqueuedParseOperation<R> enqueuedParseOperation) throws ParseException {
		AbsAntlrParser<R> parser = enqueuedParseOperation.getParser();
		Consumer<R> consumer = enqueuedParseOperation.getResultConsumer();
		String code = enqueuedParseOperation.getCodeSnippet();
		R codeObject = parser.parseInput(code);
		consumer.accept(codeObject);
	}

	public boolean hasNext() {
		return !nestedQueue.isEmpty();
	}

	private EnqueuedParseOperation<?> getNext() {
		return nestedQueue.poll();
	}

	public void executeAll() throws InvalidEmbeddedCodeException {
		boolean hasNext = hasNext();
		while (hasNext) {
			hasNext = executeNext();
		}
	}

	public boolean executeNext() throws InvalidEmbeddedCodeException {
		if (!hasNext())
			return false;

		EnqueuedParseOperation<?> dequeuedOp = getNext();
		try {
			execute(dequeuedOp);

			if (dequeuedOp.getParser().hasSyntaxErrors())
				throw new InvalidEmbeddedCodeException(dequeuedOp.getCodeSnippet(), dequeuedOp.getParser().getSyntaxErrors());

		} catch (ParseException ex) {
			throw new InvalidEmbeddedCodeException(dequeuedOp.getCodeSnippet(), dequeuedOp.getParser().getSyntaxErrors(), ex);
		} catch (Throwable t) {
			throw new InvalidEmbeddedCodeException(dequeuedOp.getCodeSnippet(), t);
		}

		return hasNext();
	}
}
