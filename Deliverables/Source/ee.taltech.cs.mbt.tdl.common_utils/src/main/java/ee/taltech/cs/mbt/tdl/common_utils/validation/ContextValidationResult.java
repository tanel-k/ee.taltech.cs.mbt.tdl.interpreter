package ee.taltech.cs.mbt.tdl.common_utils.validation;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class ContextValidationResult implements Iterable<ValidationError> {
	private String fullyQualifiedContextName;
	private AbsHierarchyValidationCtx sourceCtx;
	private List<ValidationError> errors = new LinkedList<>();

	public ContextValidationResult(AbsHierarchyValidationCtx sourceCtx) {
		this.sourceCtx = sourceCtx;
	}

	private String capitalize(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	protected String constructFullyQualifiedName() {
		StringBuilder sb = new StringBuilder(capitalize(getSourceCtx().getName()));
		AbsHierarchyValidationCtx ctx = getSourceCtx().getParentContext();
		while (ctx != null) {
			sb.append(" in ").append(ctx.getName());
			ctx = ctx.getParentContext();
		}
		return (fullyQualifiedContextName = sb.toString());
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public String getQualifiedContextName() {
		return fullyQualifiedContextName == null
			? (fullyQualifiedContextName = constructFullyQualifiedName())
			: fullyQualifiedContextName;
	}

	public AbsHierarchyValidationCtx getSourceCtx() {
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

	public boolean addErrorMessageIf(BooleanSupplier condition, Supplier<String> msgProvider) {
		return addErrorIf(
			condition,
			() -> ValidationError.forMessage(getQualifiedContextName() + ": " + msgProvider.get() + ".")
		);
	}

	@Override
	public Iterator<ValidationError> iterator() {
		return errors.iterator();
	}
}
