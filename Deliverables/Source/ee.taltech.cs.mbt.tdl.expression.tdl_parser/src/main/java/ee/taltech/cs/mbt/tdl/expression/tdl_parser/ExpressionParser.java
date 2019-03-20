package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr_facade.TDLAntlrParseTreeConverter;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ExpressionParser {
	private TDLAntlrParseTreeConverter parseTreeConverter;

	public ExpressionParser() {
		this(new TDLAntlrParseTreeConverter());
	}

	public ExpressionParser(TDLAntlrParseTreeConverter parseTreeConverter) {
		this.parseTreeConverter = parseTreeConverter;
	}

	public TDLAntlrParseTreeConverter getParseTreeConverter() {
		return parseTreeConverter;
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
		return parseTreeConverter.parse(in);
	}
}
