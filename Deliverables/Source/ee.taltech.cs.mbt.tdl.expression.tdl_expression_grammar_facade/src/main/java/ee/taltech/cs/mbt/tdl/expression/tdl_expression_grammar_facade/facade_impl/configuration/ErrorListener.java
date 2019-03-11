package ee.taltech.cs.mbt.tdl.expression.tdl_expression_grammar_facade.facade_impl.configuration;

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
	}

	public void registerSyntaxError(SyntaxError error) { }

	public ErrorListener() { }
}
