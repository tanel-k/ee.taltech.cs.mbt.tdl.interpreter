package ee.taltech.cs.mbt.tdl.common_utils.validation;

public abstract class AbsHierarchyRootValidationCtx<ContextObjectT> extends AbsHierarchyValidationCtx<ContextObjectT, AbsHierarchyRootValidationCtx<ContextObjectT>> {
	public AbsHierarchyRootValidationCtx(ContextObjectT ctxObj) {
		super(ctxObj);
	}
}
