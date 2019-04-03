package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

public class SyntaxRepresentationException extends Exception {
	private Object invalidInstance;

	private static String getMessage(Object invalidInstance) {
		if (invalidInstance instanceof Collection) {
			Collection<?> coll = (Collection<?>) invalidInstance;
			if (coll.size() > 0) {
				Object firstInst = coll.iterator().next();
				return "Unable to serialize: collection of <"
							+ (firstInst == null ? "null" : firstInst.getClass().getName())
						+ ">";
			}
		}
		return "Unable to serialize: " + invalidInstance.getClass().getName();
	}

	public SyntaxRepresentationException(Object invalidInstance, Throwable cause) {
		super(getMessage(invalidInstance), cause);
		this.invalidInstance = invalidInstance;
	}

	public Object getInvalidInstance() {
		return invalidInstance;
	}

	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		pw.println(getMessage());
		if (getCause() != null)
			getCause().printStackTrace(pw);

		return sw.toString();
	}
}
