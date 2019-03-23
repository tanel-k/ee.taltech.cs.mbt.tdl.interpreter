package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbsValidator<ValidationContext extends AbsValidationCtx> {
	private boolean failFast = true;
	private ValidationContext rootContext;

	public AbsValidator(ValidationContext rootContext) {
		this.rootContext = rootContext;
	}

	public ValidationContext getRootContext() {
		return rootContext;
	}

	public boolean isFailFast() {
		return failFast;
	}

	public AbsValidator<ValidationContext> setFailFast(boolean failFast) {
		this.failFast = failFast;
		return this;
	}

	@SuppressWarnings("unchecked")
	public ValidationResult<ValidationContext> validate() {
		ValidationResult<ValidationContext> result = new ValidationResult<>(getRootContext());
		Queue<AbsValidationCtx> ctxQueue = new LinkedList<>();
		ctxQueue.add(getRootContext());
		while (!ctxQueue.isEmpty()) {
			AbsValidationCtx ctx = ctxQueue.poll();
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
