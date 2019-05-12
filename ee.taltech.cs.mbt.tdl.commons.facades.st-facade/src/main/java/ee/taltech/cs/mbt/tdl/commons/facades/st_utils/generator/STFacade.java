package ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import org.stringtemplate.v4.AutoIndentWriter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STWriter;
import org.stringtemplate.v4.misc.STMessage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class STFacade {
	private static final String ROOT_CONTEXT_NAME = "ctx";
	private static final String ROOT_ITERABLE_NAME = "iterable";

	public static class InvalidSTFormatException extends Exception {
		private InvalidSTFormatException(String msg, Throwable cause) {
			super(msg, cause);
		}
	}

	public static class STRenderingException extends Exception {
		private ST st;
		private List<STRenderingException> wrappedExceptions = new LinkedList<>();

		private STRenderingException(ST st, String msg, Throwable cause) {
			super(msg, cause);
			this.st = st;
		}

		private STRenderingException(Collection<STRenderingException> wrappedExceptions) {
			this.wrappedExceptions.addAll(wrappedExceptions);
		}

		public ST getSt() {
			return st;
		}

		public boolean wrapsOtherRenderingExceptions() {
			return !getWrappedExceptions().isEmpty();
		}

		public List<STRenderingException> getWrappedExceptions() {
			return Collections.unmodifiableList(wrappedExceptions);
		}

		@Override
		public String toString() {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			if (wrapsOtherRenderingExceptions()) {
				pw.println("StringTemplate rendering exceptions:");
				int i = 0;
				for (STRenderingException wrappedEx : getWrappedExceptions()) {
					pw.println("Exception #" + ++i);
					pw.println(wrappedEx.toString());
				}
			} else {
				pw.println("Template: " + st.getName());
				pw.println("Message: " + getMessage());
				if (getCause() != null) {
					pw.println("Cause:");
					getCause().printStackTrace(pw);
				}
			}

			return sw.toString();
		}
	}

	private static class RecorderListener implements STErrorListener {
		private List<STRenderingException> recordedExceptions = new LinkedList<>();

		private STRenderingException toSingleException() {
			if (recordedExceptions.isEmpty())
				throw new IllegalStateException("No exceptions have been recorded.");
			if (recordedExceptions.size() == 1)
				return recordedExceptions.get(0);
			return new STRenderingException(recordedExceptions);
		}

		private boolean hasErrors() {
			return !getRecordedExceptions().isEmpty();
		}

		private List<STRenderingException> getRecordedExceptions() {
			return recordedExceptions;
		}

		private STRenderingException mapMessage(STMessage stMessage) {
			String msg = String.format(stMessage.error.message, stMessage.arg, stMessage.arg2, stMessage.arg3);
			return new STRenderingException(stMessage.self, msg, stMessage.cause);
		}

		private void recordException(STMessage stMessage) {
			getRecordedExceptions().add(mapMessage(stMessage));
		}

		@Override
		public void compileTimeError(STMessage stMessage) {
			recordException(stMessage);
		}

		@Override
		public void runTimeError(STMessage stMessage) {
			recordException(stMessage);
		}

		@Override
		public void IOError(STMessage stMessage) {
			recordException(stMessage);
		}

		@Override
		public void internalError(STMessage stMessage) {
			recordException(stMessage);
		}
	}

	public static STFacade wrap(ST st) {
		if (st == null)
			throw new IllegalArgumentException("Expecting an ST instance.");
		return new STFacade(st);
	}

	private ST st;
	private boolean rootContextReady = false;

	private STFacade(ST st) {
		this.st = st;
	}

	private ST getST() {
		return st;
	}

	private boolean isRootContextReady() {
		return rootContextReady;
	}

	private void setRootContextReady(boolean rootContextReady) {
		this.rootContextReady = rootContextReady;
	}

	public void setRootContext(ContextBuilder rootBuilder) throws InvalidSTFormatException {
		reset();

		try {
			getST().add(ROOT_CONTEXT_NAME, rootBuilder.getContextMap());
		} catch (IllegalArgumentException ex) {
			throw new InvalidSTFormatException("Failed to set context attribute " + ROOT_CONTEXT_NAME + ".", ex);
		}

		setRootContextReady(true);
	}

	public void setRootIterable(Collection<ContextBuilder> rootBuilders) throws InvalidSTFormatException {
		reset();

		Collection<?> contexts = rootBuilders.stream().map(ContextBuilder::getContextMap).collect(Collectors.toList());
		try {
			getST().add(ROOT_ITERABLE_NAME, contexts);
		} catch (IllegalArgumentException ex) {
			throw new InvalidSTFormatException("Failed to set context attribute " + ROOT_ITERABLE_NAME + ".", ex);
		}

		setRootContextReady(true);
	}

	public void reset() {
		if (getST().getAttribute(ROOT_CONTEXT_NAME) != null)
			getST().remove(ROOT_CONTEXT_NAME);
		if (getST().getAttribute(ROOT_ITERABLE_NAME) != null)
			getST().remove(ROOT_ITERABLE_NAME);

		setRootContextReady(false);
	}

	public String render() throws STRenderingException {
		if (!isRootContextReady())
			throw new IllegalStateException("Root context is not set.");
		RecorderListener listener = new RecorderListener();

		StringWriter out = new StringWriter();
		STWriter wr = new AutoIndentWriter(out);

		getST().write(wr, listener);

		if (listener.hasErrors()) {
			STRenderingException ex = listener.toSingleException();
			throw ex;
		}

		return out.toString();
	}
}
