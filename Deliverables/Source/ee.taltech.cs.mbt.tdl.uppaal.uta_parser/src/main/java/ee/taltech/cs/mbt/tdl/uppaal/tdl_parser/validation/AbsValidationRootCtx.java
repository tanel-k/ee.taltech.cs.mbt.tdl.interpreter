package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation;

public abstract class AbsValidationRootCtx<ContextObjectT> extends AbsValidationCtx<ContextObjectT, AbsValidationRootCtx<ContextObjectT>> {
	public AbsValidationRootCtx(ContextObjectT ctxObj) {
		super(ctxObj);
	}
}
