package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorListener.SyntaxError;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

public class EmbeddedCodeSyntaxException extends Exception {
	private ParseException cause;
	private String offendingCodeSnippet;

	public EmbeddedCodeSyntaxException(String offendingCodeSnippet, ParseException ex) {
		super(ex);
		this.cause = ex;
		this.offendingCodeSnippet = offendingCodeSnippet;
	}

	public Collection<SyntaxError> getSyntaxErrors() {
		return cause.getSyntaxErrors();
	}

	public String getOffendingCodeSnippet() {
		return offendingCodeSnippet;
	}

	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		pw.println("Could not parse:");
		int i = 0;
		for (String line : getOffendingCodeSnippet().split("\\r?\\n")) {
			pw.println(++i + ": " + line);
		}

		if (!getSyntaxErrors().isEmpty()) {
			pw.println("Syntax errors:");
			for (SyntaxError syntaxError : getSyntaxErrors()) {
				pw.println(syntaxError.toSingleLineMessage());
			}
		}

		return sw.toString();
	}
}
