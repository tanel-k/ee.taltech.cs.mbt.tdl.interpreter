package ee.taltech.cs.mbt.tdl.generic.parser;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public abstract class AbsParser<FacadeType extends AbsAntlrParserFacade<ResultType, ?, ? ,?, ?>, ResultType> {
	private FacadeType parserFacade;

	protected abstract FacadeType constructFacade();

	protected AbsParser() {
		this.parserFacade = constructFacade();
	}

	public FacadeType getParserFacade() {
		return parserFacade;
	}

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
		return parserFacade.parse(in);
	}
}