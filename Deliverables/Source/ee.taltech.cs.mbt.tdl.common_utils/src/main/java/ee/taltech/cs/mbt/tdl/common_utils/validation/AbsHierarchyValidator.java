package ee.taltech.cs.mbt.tdl.common_utils.validation;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbsHierarchyValidator<ValidationContext extends AbsHierarchyValidationCtx> {
	private boolean failFast = true;
	private ValidationContext rootContext;

	public AbsHierarchyValidator(ValidationContext rootContext) {
		this.rootContext = rootContext;
	}

	public ValidationContext getRootContext() {
		return rootContext;
	}

	public boolean isFailFast() {
		return failFast;
	}

	public AbsHierarchyValidator<ValidationContext> setFailFast(boolean failFast) {
		this.failFast = failFast;
		return this;
	}

	@SuppressWarnings("unchecked")
	public ValidationResult<ValidationContext> validate() {
		ValidationResult<ValidationContext> result = new ValidationResult<>(getRootContext());
		Queue<AbsHierarchyValidationCtx> ctxQueue = new LinkedList<>();
		ctxQueue.add(getRootContext());
		while (!ctxQueue.isEmpty()) {
			AbsHierarchyValidationCtx ctx = ctxQueue.poll();
			ContextValidationResult ctxResult = ctx.validate();
			if (ctxResult.hasErrors()) {
				result.getContextsWithErrors().put(ctx, ctxResult);
				if (isFailFast())
					break;
			}
			ctxQueue.addAll(ctx.orderedChildContexts());
		}
		return result;
	}
}
