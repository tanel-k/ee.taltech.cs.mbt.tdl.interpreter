package ee.taltech.cs.mbt.tdl.commons.parser;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorListener.SyntaxError;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class AbsAntlrParser<ResultType> {
	public abstract AbsAntlrParserFacade<ResultType, ?, ?, ?> getFacade();

	public ResultType parseInput(String inputString) throws ParseException {
		return parseInput(inputString, StandardCharsets.UTF_8);
	}

	public ResultType parseInput(String inputString, Charset charset) throws ParseException {
		try {
			return parseInput(new ByteArrayInputStream(inputString.getBytes(charset)));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public ResultType parseInput(InputStream in) throws IOException, ParseException {
		return getFacade().parse(in);
	}
}