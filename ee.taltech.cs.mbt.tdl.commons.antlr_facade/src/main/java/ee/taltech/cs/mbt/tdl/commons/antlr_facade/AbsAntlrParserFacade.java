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
import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectUtils;
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
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbsAntlrParserFacade<OutputType, ParserType extends Parser, LexerType extends Lexer, RootContextType extends ParseTree> {
	public static class ParseException extends Exception {
		private Collection<SyntaxError> syntaxErrors = new LinkedList<>();

		private ParseException(List<SyntaxError> syntaxErrors) {
			this(syntaxErrors, null);
		}

		private ParseException(Collection<SyntaxError> syntaxErrors, Throwable t) {
			super(t);
			this.syntaxErrors.addAll(ObjectUtils.defaultObject(syntaxErrors, Collections.emptyList()));
		}

		public Collection<SyntaxError> getSyntaxErrors() {
			return syntaxErrors;
		}

		@Override
		public String toString() {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			pw.println("Parsing failed.");

			if (!getSyntaxErrors().isEmpty()) {
				pw.println("Syntax errors:");
				for (SyntaxError syntaxError : getSyntaxErrors()) {
					pw.println(syntaxError.toSingleLineMessage());
				}
			}

			if (getCause() != null) {
				pw.println("Cause:");
				getCause().printStackTrace(pw);
			}

			return sw.toString();
		}
	}

	private ErrorStrategyConfig errorStrategyConfig = ErrorStrategyConfigFactory.defaultConfig();
	private List<ErrorListener> errorListeners = new LinkedList<>();
	private LinkedList<SyntaxError> parserSyntaxErrors = new LinkedList<>();
	private LinkedList<SyntaxError> lexerSyntaxErrors = new LinkedList<>();

	private OutputType convertParseTree(RootContextType parseTree) {
		IParseTreeConverter<OutputType, RootContextType> converter = getConverter();
		return converter.convert(parseTree);
	}

	public AbsAntlrParserFacade() { }

	protected abstract ParserType getParserInstance(TokenStream tokenStream);
	protected abstract LexerType getLexerInstance(CharStream forInputStream);
	protected abstract RootContextType getRootContext(ParserType parser);
	protected abstract IParseTreeConverter<OutputType, RootContextType> getConverter();

	protected List<SyntaxError> getLexerSyntaxErrors() {
		return lexerSyntaxErrors;
	}

	protected List<SyntaxError> getParserSyntaxErrors() {
		return parserSyntaxErrors;
	}

	protected LexerType getInputLexer(InputStream in) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(in);
		return getLexerInstance(input);
	}

	protected ParserType getInputParser(LexerType lexer) {
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		return getParserInstance(tokenStream);
	}

	protected void appendParseErrorCollector(ParserType parser) {
		clearParseErrors();
		ErrorListener collectorListener = ErrorListenerFactory.collectingListener(parserSyntaxErrors);
		parser.addErrorListener(new DelegatingAntlrErrorListener(collectorListener));
	}

	protected void clearParseErrors() {
		parserSyntaxErrors.clear();
	}

	protected void appendSyntaxErrorCollector(LexerType lexer) {
		clearSyntaxErrors();
		ErrorListener collectorListener = ErrorListenerFactory.collectingListener(lexerSyntaxErrors);
		lexer.addErrorListener(new DelegatingAntlrErrorListener(collectorListener));
	}

	protected void clearSyntaxErrors() {
		lexerSyntaxErrors.clear();
	}

	protected void configureLexer(LexerType lexer) {
		// Error handling is only available for the parser.
		lexer.removeErrorListeners();
		appendSyntaxErrorCollector(lexer);
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
				.forEachOrdered(parser::addErrorListener);

		appendParseErrorCollector(parser);
	}

	protected List<SyntaxError> getAggregateSyntaxErrors() {
		LinkedList<SyntaxError> mergedErrors = new LinkedList<>();
		mergedErrors.addAll(getLexerSyntaxErrors());
		mergedErrors.addAll(getParserSyntaxErrors());
		return mergedErrors;
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
		try {
			LexerType lexer = getInputLexer(in);
			configureLexer(lexer);

			ParserType parser = getInputParser(lexer);
			configureParser(parser);

			RootContextType rootContext = getRootContext(parser);

			if (!getParserSyntaxErrors().isEmpty()) {
				// Syntax errors are captured during recovery.
				// They are only useful if recovery fails (i.e. when parserSyntaxErrors isn't empty).
				throw new ParseException(getAggregateSyntaxErrors());
			}

			return convertParseTree(rootContext);
		} catch (IOException | ParseException ex) {
			throw ex;
		} catch (RecognitionException | RecognitionExceptionWrapper ex) {
			throw new ParseException(getAggregateSyntaxErrors(), ex);
		} catch (Throwable t) {
			throw new RuntimeException("Unexpected error occurred during parsing.", t);
		}
	}
}
