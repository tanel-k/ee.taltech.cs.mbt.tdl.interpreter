package ee.taltech.cs.mbt.tdl.commons.antlr_facade;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.ErrorListenerFactory;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.ErrorStrategyConfigFactory;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorListener;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorListener.SyntaxError;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorStrategyConfig.RecognitionExceptionWrapper;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.bridge.ConfigurableAntlrErrorStrategy;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.bridge.DelegatingAntlrErrorListener;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter.ConversionException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

public abstract class AbsAntlrParserFacade<OutputType, ParserType extends Parser, RootContextType extends ParseTree> {
	public static class ParseException extends Exception {
		public ParseException(Throwable t) { super(t); }
		public ParseException(String msg, Throwable t) { super(msg, t); }

		@Override
		public String toString() {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			String msg = getMessage();
			if (msg == null && getCause() != null)
				msg = getCause().getMessage();

			pw.println(msg);
			if (getCause() != null) {
				pw.println("Cause:" );
				getCause().printStackTrace(pw);
			}
			pw.println();

			return sw.toString();
		}
	}

	private ErrorStrategyConfig errorStrategyConfig = ErrorStrategyConfigFactory.defaultConfig();
	private List<ErrorListener> errorListeners = new LinkedList<>();
	private List<SyntaxError> syntaxErrors = new LinkedList<>();

	private OutputType convertParseTree(RootContextType parseTree) throws ParseException {
		try {
			IParseTreeConverter<OutputType, RootContextType> converter = getConverter();
			return converter.convert(parseTree);
		} catch (ConversionException ex) {
			throw new ParseException(ex.getMessage(), ex);
		}
	}

	protected abstract ParserType getParserInstance(TokenStream tokenStream);
	protected abstract Lexer getLexerInstance(CharStream forInputStream);
	protected abstract RootContextType getRootContext(ParserType parser);
	protected abstract IParseTreeConverter<OutputType, RootContextType> getConverter();

	protected ParserType getInputParser(InputStream in) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(in);

		Lexer lexer = getLexerInstance(input);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		ParserType parser = getParserInstance(tokenStream);
		return parser;
	}

	protected void appendSyntaxErrorCollector(ParserType parser) {
		clearSyntaxErrors();
		ErrorListener collectorListener = ErrorListenerFactory.collectingListener(syntaxErrors);
		parser.addErrorListener(new DelegatingAntlrErrorListener(collectorListener));
	}

	protected void clearSyntaxErrors() {
		syntaxErrors.clear();
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

		appendSyntaxErrorCollector(parser);
	}

	public AbsAntlrParserFacade() { }

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

	public List<SyntaxError> getSyntaxErrors() {
		return syntaxErrors;
	}

	public OutputType parse(InputStream in) throws IOException, ParseException {
		try {
			ParserType parser = getInputParser(in);
			configureParser(parser);
			RootContextType rootContext = getRootContext(parser);
			return convertParseTree(rootContext);
		} catch (IOException | ParseException ex) {
			throw ex;
		} catch (RecognitionException | RecognitionExceptionWrapper ex) {
			throw new ParseException(ex);
		} catch (Throwable t) {
			throw new ParseException("Unexpected error.", t);
		}
	}
}
