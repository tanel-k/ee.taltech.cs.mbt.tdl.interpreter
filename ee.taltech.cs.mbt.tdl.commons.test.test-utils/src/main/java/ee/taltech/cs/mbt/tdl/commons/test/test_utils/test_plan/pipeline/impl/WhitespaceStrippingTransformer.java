package ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.impl;

import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.commons.utils.strings.StringUtils;

public class WhitespaceStrippingTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		return StringUtils.stripWhitespace((String) in);
	}
}
