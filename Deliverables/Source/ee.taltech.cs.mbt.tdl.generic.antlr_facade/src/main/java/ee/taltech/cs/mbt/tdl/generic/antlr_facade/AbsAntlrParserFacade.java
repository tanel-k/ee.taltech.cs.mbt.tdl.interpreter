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
		ParseTreeConverterListener extends ParseTreeListener
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

	private OutputType convertParseTree(ParseTree parseTree) throws ParseException {
		try {
			ParseTreeConverterListener converterListener = getConverterListener();
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(converterListener, parseTree);
			return getOutputFromConverter(converterListener);
		} catch (ParseTreeStructureException ex) {
			throw new ParseException(ex.getMessage(), ex);
		}
	}

	protected abstract ParserType getParserInstance(TokenStream tokenStream);
	protected abstract LexerType getLexerInstance(CharStream forInputStream);

	protected abstract ParseTree constructParseTree(ParserType parser);
	protected abstract ParseTreeConverterListener getConverterListener();
	protected abstract OutputType getOutputFromConverter(ParseTreeConverterListener fromConverter);

	protected ParserType getInputParser(InputStream in) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(in);

		LexerType lexer = getLexerInstance(input);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		ParserType parser = getParserInstance(tokenStream);
		return parser;
	}

	protected void configureParser(ParserType parser) {
		if (getErrorStrategyConfig() == null) {
			parser.setErrorHandler(new DefaultErrorStrategy());
		} else {
			parser.setErrorHandler(new ConfigurableAntlrErrorStrategy(getErrorStrategyConfig()));
		}

		parser.removeErrorListeners();
		getErrorListeners().stream()
				.map(DelegatingAntlrErrorListener::new)
				.forEach(parser::addErrorListener);
	}

	public AbsAntlrParserFacade() {
		this.errorStrategyConfig = new ErrorStrategyConfig();
		this.errorListeners = new LinkedList<>();
	}

	public List<ErrorListener> getErrorListeners() {
		return errorListeners;
	}

	public void addErrorListener(ErrorListener errorListener) {
		this.errorListeners.add(errorListener);
	}

	public ErrorStrategyConfig getErrorStrategyConfig() {
		return errorStrategyConfig;
	}

	public void setErrorStrategyConfig(ErrorStrategyConfig errorStrategyConfig) {
		this.errorStrategyConfig = errorStrategyConfig;
	}

	public OutputType parse(InputStream in) throws IOException, ParseException {
		ParserType parser = getInputParser(in);
		configureParser(parser);
		ParseTree parseTree = constructParseTree(parser);
		return convertParseTree(parseTree);
	}
}
