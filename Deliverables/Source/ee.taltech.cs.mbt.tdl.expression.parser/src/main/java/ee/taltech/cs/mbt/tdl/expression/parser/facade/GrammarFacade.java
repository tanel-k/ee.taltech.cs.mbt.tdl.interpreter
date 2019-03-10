package ee.taltech.cs.mbt.tdl.expression.parser.facade;

import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageLexer;
import ee.taltech.cs.mbt.tdl.expression.grammar.antlr.TDLExpressionLanguageParser;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.parser.facade.converter.IConverter;
import ee.taltech.cs.mbt.tdl.expression.parser.facade.converter.ParseTreeConverter;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;

public class GrammarFacade {
	private IConverter<ParseTree, ExpressionTree> converter;

	public GrammarFacade() {
	}

	public ExpressionTree parse(InputStream in) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(in);
		TDLExpressionLanguageLexer lexer = new TDLExpressionLanguageLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TDLExpressionLanguageParser parser = new TDLExpressionLanguageParser(tokens);

		parser.removeErrorListeners();
		parser.addErrorListener(new DiagnosticErrorListener());
		parser.addErrorListener(new BaseErrorListener() {
		});

		ParseTree parseTree = parser.expression();
		return this.getConverter().convert(parseTree);
	}

	public IConverter<ParseTree, ExpressionTree> getConverter() {
		return converter;
	}

	public void setConverter(IConverter<ParseTree, ExpressionTree> converter) {
		this.converter = converter;
	}
}
