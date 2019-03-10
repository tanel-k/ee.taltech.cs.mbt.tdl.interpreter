package ee.taltech.cs.mbt.tdl.expression.grammar_facade.parsing;

import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageLexer;
import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageParser;
import ee.taltech.cs.mbt.tdl.expression.grammar_facade.runtime.ErrorListener;
import ee.taltech.cs.mbt.tdl.expression.grammar_facade.runtime.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class ParserFacade {
	private ErrorStrategyConfig errorStrategyConfig;
	private List<ErrorListener> errorListeners;

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

	public ExpressionTree parse(InputStream in) throws IOException {
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
		return new ParseTreeConverter()
			.convert(parseTree);
	}
}
