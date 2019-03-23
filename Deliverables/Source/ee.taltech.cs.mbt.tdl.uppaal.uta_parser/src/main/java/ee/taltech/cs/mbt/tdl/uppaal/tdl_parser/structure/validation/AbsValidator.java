package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

	public void setFailFast(boolean failFast) {
		this.failFast = failFast;
	}

	@SuppressWarnings("unchecked")
	public List<ValidationError> validate() {
		List<ValidationError> validationErrors = new LinkedList<>();
		Queue<AbsValidationCtx> ctxQueue = new LinkedList<>();
		ctxQueue.add(getRootContext());
		while (!ctxQueue.isEmpty()) {
			AbsValidationCtx context = ctxQueue.poll();
			ContextValidationResult result = context.validate();
			if (result.hasErrors()) {
				validationErrors.addAll(result.getErrors());
				if (isFailFast())
					break;
			}
			ctxQueue.addAll(context.orderedChildContexts());
		}
		return validationErrors;
	}
}
