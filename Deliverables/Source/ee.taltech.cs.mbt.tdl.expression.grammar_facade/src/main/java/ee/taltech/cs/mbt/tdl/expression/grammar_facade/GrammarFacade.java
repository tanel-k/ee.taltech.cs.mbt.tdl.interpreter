package ee.taltech.cs.mbt.tdl.expression.grammar_facade;

import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageLexer;
import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageParser;
import ee.taltech.cs.mbt.tdl.expression.grammar_facade.bridge.ParseTreeConverter;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;

public class GrammarFacade {
	public GrammarFacade() { }

	public ExpressionTree parse(InputStream in) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(in);
		TDLExpressionLanguageLexer lexer = new TDLExpressionLanguageLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TDLExpressionLanguageParser parser = new TDLExpressionLanguageParser(tokens);

		// FIXME: error listeners
		// FIXME: error recovery
		// FIXME: (exceptions)
		parser.removeErrorListeners();
		parser.addErrorListener(new DiagnosticErrorListener());
		parser.addErrorListener(new BaseErrorListener() {
		});

		ParseTree parseTree = parser.expression();
		return new ParseTreeConverter().convert(parseTree);
	}
}
