package ee.taltech.cs.mbt.tdl.expression.parser;

import ee.taltech.cs.mbt.tdl.expression.grammar_facade.parsing.ParserFacade;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;

import javax.swing.text.html.parser.Parser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ExpressionParser {
	private ParserFacade parserFacade;

	public ExpressionParser() {
		this(new ParserFacade());
	}

	public ExpressionParser(ParserFacade parserFacade) {
		this.parserFacade = parserFacade;
	}

	public ParserFacade getParserFacade() {
		return parserFacade;
	}

	public ExpressionTree parseExpression(String expression) {
		return parseExpression(expression, StandardCharsets.UTF_8);
	}

	public ExpressionTree parseExpression(String expression, Charset charset) {
		try {
			return parseExpression(new ByteArrayInputStream(expression.getBytes(charset)));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public ExpressionTree parseExpression(InputStream in) throws IOException {
		return parserFacade.parse(in);
	}
}
