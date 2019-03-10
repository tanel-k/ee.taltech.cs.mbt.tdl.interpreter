package ee.taltech.cs.mbt.tdl.expression.parser;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.parser.facade.GrammarFacade;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ExpressionParser {
	// FIXME: Adjust according to changes in GrammarFacade
	public ExpressionTree parseExpression(String expression, Charset charset) {
		try {
			return parseExpression(new ByteArrayInputStream(expression.getBytes(charset)));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public ExpressionTree parseExpression(InputStream in) throws IOException {
		return new GrammarFacade().parse(in);
	}
}
