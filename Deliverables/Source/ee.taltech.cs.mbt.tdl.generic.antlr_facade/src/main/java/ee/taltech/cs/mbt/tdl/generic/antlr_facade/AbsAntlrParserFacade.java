package ee.taltech.cs.mbt.tdl.generic.antlr_facade;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.ErrorListener;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.ErrorStrategyConfig;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public abstract class AbsAntlrParserFacade<
		OutputType,
		LexerType extends Lexer,
		ParserType extends Parser,
		ExtractorListenerType extends ParseTreeListener
	> {
	public static class ParseTreeStructureException extends RuntimeException {
		public ParseTreeStructureException(String msg) { super(msg); }
	}

	public static class ParseException extends Exception {
		public ParseException(String msg, Throwable t) { super(msg, t); }
		public ParseException(Throwable t) { this(t.getMessage(), t); }
	}

	private ErrorStrategyConfig errorStrategyConfig;
	private List<ErrorListener> errorListeners;

	private OutputType walkParseTree(ParseTree parseTree) throws ParseTreeStructureException {
		ExtractorListenerType extractorListener = getExtractorListener();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(extractorListener, parseTree);
		return getOutputFromExtractor(extractorListener);
	}

	protected abstract ParserType getParserInstance(TokenStream tokenStream);
	protected abstract LexerType getLexerInstance(CharStream forInputStream);

	protected abstract ParseTree constructParseTree(ParserType parser);
	protected abstract ExtractorListenerType getExtractorListener();
	protected abstract OutputType getOutputFromExtractor(ExtractorListenerType fromConverter);

	public AbsAntlrParserFacade() {
		this.errorStrategyConfig = new ErrorStrategyConfig();
		this.errorListeners = new LinkedList<>();
	}

	public void addErrorListener(ErrorListener errorListener) {
		this.errorListeners.add(errorListener);
	}

	public void clearErrorListeners() {
		this.errorListeners.clear();
	}

	public ErrorStrategyConfig getErrorStrategyConfig() {
		return errorStrategyConfig;
	}

	public void setErrorStrategyConfig(ErrorStrategyConfig errorStrategyConfig) {
		this.errorStrategyConfig = errorStrategyConfig;
	}

	public OutputType parse(InputStream in) throws IOException, ParseException {
		ANTLRInputStream input = new ANTLRInputStream(in);

		LexerType lexer = getLexerInstance(input);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		ParserType parser = getParserInstance(tokenStream);

		if (errorStrategyConfig == null) {
			parser.setErrorHandler(new DefaultErrorStrategy());
		} else {
			parser.setErrorHandler(new ConfigurableErrorStrategy(errorStrategyConfig));
		}

		parser.removeErrorListeners();
		errorListeners.stream()
				.map(DelegatingErrorListener::new)
				.forEach(parser::addErrorListener);

		ParseTree parseTree = constructParseTree(parser);

		try {
			return walkParseTree(parseTree);
		} catch (ParseTreeStructureException ex) {
			throw new ParseException(ex);
		}
	}
}
