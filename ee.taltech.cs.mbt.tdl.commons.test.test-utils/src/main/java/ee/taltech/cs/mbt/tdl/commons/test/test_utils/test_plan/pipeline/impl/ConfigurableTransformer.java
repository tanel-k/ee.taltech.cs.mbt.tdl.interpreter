package ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.impl;

import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;

import java.util.function.Function;

public class ConfigurableTransformer implements ISimpleTransformer {
	private Function<Object, Object> transformFunction;

	@Override
	public Object transform(Object in) {
		return transformFunction.apply(in);
	}

	public Function<Object, Object> getTransformFunction() {
		return transformFunction;
	}

	public void setTransformFunction(Function<Object, Object> transformFunction) {
		this.transformFunction = transformFunction;
	}
}
