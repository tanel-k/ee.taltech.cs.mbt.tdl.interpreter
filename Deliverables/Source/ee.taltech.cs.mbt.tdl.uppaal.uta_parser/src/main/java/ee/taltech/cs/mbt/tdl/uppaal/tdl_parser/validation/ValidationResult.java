package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ValidationResult<RootCtxT extends AbsValidationCtx> implements Iterable<ValidationError> {
	private RootCtxT rootCtx;
	private Map<AbsValidationCtx, ContextValidationResult> contextsWithErrors = new HashMap<>();

	public ValidationResult(RootCtxT rootCtx) {
		this.rootCtx = rootCtx;
	}

	public RootCtxT getRootCtx() {
		return rootCtx;
	}

	public boolean hasErrors() {
		return !contextsWithErrors.isEmpty();
	}

	public Map<AbsValidationCtx, ContextValidationResult> getContextsWithErrors() {
		return contextsWithErrors;
	}

	public Stream<ValidationError> errorStream() {
		return getContextsWithErrors().values().stream()
			.map(ContextValidationResult::getErrors)
			.flatMap(List::stream);
	}

	public Iterator<ValidationError> errorIterator() {
		return errorStream().iterator();
	}

	@Override
	public Iterator<ValidationError> iterator() {
		return errorIterator();
	}
}
