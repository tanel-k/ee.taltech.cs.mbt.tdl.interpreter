package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class ContextValidationResult implements Iterable<ValidationError> {
	private AbsValidationCtx sourceCtx;
	private List<ValidationError> errors = new LinkedList<>();

	public ContextValidationResult(AbsValidationCtx sourceCtx) {
		this.sourceCtx = sourceCtx;
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public AbsValidationCtx getSourceCtx() {
		return sourceCtx;
	}

	public List<ValidationError> getErrors() {
		return errors;
	}

	public ContextValidationResult addError(ValidationError error) {
		errors.add(error);
		return this;
	}

	public ContextValidationResult addErrors(Collection<ValidationError> errors) {
		this.errors.addAll(errors);
		return this;
	}

	public boolean addErrorIf(BooleanSupplier condition, Supplier<ValidationError> errorSupplier) {
		if (condition.getAsBoolean()) {
			addError(errorSupplier.get());
			return true;
		}
		return false;
	}

	@Override
	public Iterator<ValidationError> iterator() {
		return errors.iterator();
	}
}
