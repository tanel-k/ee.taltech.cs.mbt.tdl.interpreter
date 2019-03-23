package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsValidationCtx<CtxObjectT, ParentCtxT extends AbsValidationCtx> {
	private ParentCtxT parentCtx;
	private CtxObjectT contextObject;
	private Map<String, Object> objectMap = new HashMap<>();
	private Map<String, Collection<Object>> collectionMap = new HashMap<>();

	public AbsValidationCtx(CtxObjectT contextObject) {
		this(contextObject, null);
	}

	public AbsValidationCtx(CtxObjectT contextObject, ParentCtxT parentCtx) {
		this.contextObject = contextObject;
		this.parentCtx = parentCtx;
	}

	public Map<String, Object> getObjectMap() {
		return objectMap;
	}

	public Map<String, Collection<Object>> getCollectionMap() {
		return collectionMap;
	}

	protected String qualifyKey(String key) {
		return getClass().getName() + ":" + key;
	}

	protected void prepareForValidation() { }
	protected abstract void performValidation(ContextValidationResult results);

	public final boolean isRoot() {
		return parentCtx == null;
	}

	public final ParentCtxT getParentContext() {
		return parentCtx;
	}

	public final CtxObjectT getContextObject() {
		return contextObject;
	}

	public abstract Collection<AbsValidationCtx> orderedChildContexts();

	public ContextValidationResult validate() {
		prepareForValidation();
		ContextValidationResult validationResult = new ContextValidationResult(this);
		performValidation(validationResult);
		return validationResult;
	}
}
