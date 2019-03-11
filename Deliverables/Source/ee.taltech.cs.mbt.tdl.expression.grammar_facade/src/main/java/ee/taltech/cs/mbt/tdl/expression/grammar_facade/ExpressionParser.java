package ee.taltech.cs.mbt.tdl.expression.grammar_facade;

import ee.taltech.cs.mbt.tdl.expression.grammar_facade.facade_impl.ParserFacade;
import ee.taltech.cs.mbt.tdl.expression.grammar_facade.facade_impl.ParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;

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

	public ExpressionTree parseExpression(String expression) throws ParseException {
		return parseExpression(expression, StandardCharsets.UTF_8);
	}

	public ExpressionTree parseExpression(String expression, Charset charset) throws ParseException {
		try {
			return parseExpression(new ByteArrayInputStream(expression.getBytes(charset)));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public ExpressionTree parseExpression(InputStream in) throws IOException, ParseException {
		return parserFacade.parse(in);
	}
}
