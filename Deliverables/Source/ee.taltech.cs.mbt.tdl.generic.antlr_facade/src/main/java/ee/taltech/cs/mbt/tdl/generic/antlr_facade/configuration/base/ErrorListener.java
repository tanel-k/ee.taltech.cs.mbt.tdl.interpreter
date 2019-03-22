package ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorListener {
	public static class SyntaxError {
		private Object offendingSymbol;
		private int line;
		private int charPositionInLine;
		private String message;
		private Exception ex;

		public SyntaxError() { }

		public Object getOffendingSymbol() {
			return offendingSymbol;
		}

		public SyntaxError setOffendingSymbol(Object offendingSymbol) {
			this.offendingSymbol = offendingSymbol;
			return this;
		}

		public int getLine() {
			return line;
		}

		public SyntaxError setLine(int line) {
			this.line = line;
			return this;
		}

		public int getCharPositionInLine() {
			return charPositionInLine;
		}

		public SyntaxError setCharPositionInLine(int charPositionInLine) {
			this.charPositionInLine = charPositionInLine;
			return this;
		}

		public String getMessage() {
			return message;
		}

		public SyntaxError setMessage(String message) {
			this.message = message;
			return this;
		}

		public Exception getException() {
			return ex;
		}

		public SyntaxError setException(Exception ex) {
			this.ex = ex;
			return this;
		}

		@Override
		public String toString() {
			StringBuffer buf = new StringBuffer()
				.append("Syntax error: ").append(getMessage()).append("\n")
				.append("Line: ").append(getLine()).append("\n")
				.append("Offending symbol: ").append(getOffendingSymbol()).append("\n")
				.append("At position: ").append(getCharPositionInLine()).append("\n")
				.append("Trace:\n");
			if (getException() != null) {
				StringWriter writer = new StringWriter();
				PrintWriter printer = new PrintWriter(writer);
				getException().printStackTrace(printer);
				buf.append(writer.getBuffer());
			}
			return buf.toString();
		}
	}

	public void registerSyntaxError(SyntaxError error) { }

	public ErrorListener() { }
}
