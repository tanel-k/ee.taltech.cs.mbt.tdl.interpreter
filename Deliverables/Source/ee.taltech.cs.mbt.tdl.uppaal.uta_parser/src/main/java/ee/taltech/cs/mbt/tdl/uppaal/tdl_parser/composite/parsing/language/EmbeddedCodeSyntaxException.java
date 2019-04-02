package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorListener.SyntaxError;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmbeddedCodeSyntaxException extends Exception {
	private List<SyntaxError> syntaxErrors = new LinkedList<>();
	private String offendingCodeSnippet;

	public EmbeddedCodeSyntaxException(String offendingCodeSnippet, Throwable cause) {
		this(offendingCodeSnippet, Collections.emptyList(), cause);
	}

	public EmbeddedCodeSyntaxException(String offendingCodeSnippet, List<SyntaxError> syntaxErrors) {
		this(offendingCodeSnippet, syntaxErrors, null);
	}

	public EmbeddedCodeSyntaxException(String offendingCodeSnippet, List<SyntaxError> syntaxErrors, Throwable cause) {
		super(cause);
		this.offendingCodeSnippet = offendingCodeSnippet;
		this.syntaxErrors.addAll(syntaxErrors);
	}

	public List<SyntaxError> getSyntaxErrors() {
		return syntaxErrors;
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
				pw.println(syntaxError.getLine() + ":" + syntaxError.getCharPositionInLine() + " - " + syntaxError.getMessage());
			}
		} else if (getCause() != null) {
			pw.println("Cause:");
			getCause().printStackTrace(pw);
		}

		return sw.toString();
	}
}
