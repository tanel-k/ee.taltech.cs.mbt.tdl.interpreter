package ee.taltech.cs.mbt.tdl.commons.utils.validation;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
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
		StringBuilder sb = new StringBuilder();
		AbsHierarchyValidationCtx ctx = getSourceCtx();
		LinkedList<AbsHierarchyValidationCtx> validationCtxs = new LinkedList<>();

		while (ctx != null) {
			validationCtxs.addFirst(ctx);
			ctx = ctx.getParentContext();
		}

		for (AbsHierarchyValidationCtx ctxRef : validationCtxs) {
			sb.append("/").append(capitalize(ctxRef.getName()));
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
