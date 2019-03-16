package ee.taltech.cs.mbt.tdl.expression.tdl_grammar_facade.facade_impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr.TDLExpressionLanguageLexer;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr.TDLExpressionLanguageParser;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar_facade.facade_impl.ParseTreeConversionListener.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar_facade.facade_impl.configuration.ErrorListener;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar_facade.facade_impl.configuration.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class ParserFacade {
	public static class ParseException extends Exception {
		private ParseException(String msg, Throwable t) { super(msg, t); }
		private ParseException(Throwable t) { this(t.getMessage(), t); }
	}

	private ErrorStrategyConfig errorStrategyConfig;
	private List<ErrorListener> errorListeners;

	private ExpressionTree convertParseTree(ParseTree parseTree) throws ParseTreeStructureException {
		ParseTreeConversionListener conversionListener = new ParseTreeConversionListener();

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(conversionListener, parseTree);

		return conversionListener.constructTree();
	}

	public ParserFacade() {
		this.errorStrategyConfig = new ErrorStrategyConfig();
		this.errorListeners = new LinkedList<>();
	}

	public ParserFacade addErrorListener(ErrorListener errorListener) {
		this.errorListeners.add(errorListener);
		return this;
	}

	public ParserFacade clearErrorListeners() {
		this.errorListeners.clear();
		return this;
	}

	public ErrorStrategyConfig getErrorStrategyConfig() {
		return errorStrategyConfig;
	}

	public ParserFacade removeErrorStrategyConfig() {
		return this.setErrorStrategyConfig(null);
	}

	public ParserFacade setErrorStrategyConfig(ErrorStrategyConfig errorStrategyConfig) {
		this.errorStrategyConfig = errorStrategyConfig;
		return this;
	}

	public ExpressionTree parse(InputStream in) throws IOException, ParseException {
		ANTLRInputStream input = new ANTLRInputStream(in);
		TDLExpressionLanguageLexer lexer = new TDLExpressionLanguageLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		TDLExpressionLanguageParser parser = new TDLExpressionLanguageParser(tokens);
		if (errorStrategyConfig == null) {
			parser.setErrorHandler(new DefaultErrorStrategy());
		} else {
			parser.setErrorHandler(new ConfigurableErrorStrategy(errorStrategyConfig));
		}

		parser.removeErrorListeners();
		errorListeners.stream()
			.map(DelegatingErrorListener::new)
			.forEach(parser::addErrorListener);

		ParseTree parseTree = parser.expression();
		try {
			return convertParseTree(parseTree);
		} catch (ParseTreeStructureException ex) {
			throw new ParseException(ex);
		}
	}
}
