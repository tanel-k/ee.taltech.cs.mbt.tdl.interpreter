package ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline;

import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.impl.ConfigurableTransformer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SimpleTransformationPipeline {
	private List<ConfigurableTransformer> configurableTransformers = new LinkedList<>();
	private List<ISimpleTransformer> transformers = new LinkedList<>();

	public void addTransformer(ISimpleTransformer transformer) {
		transformers.add(transformer);
	}

	public void addConfigurableTranformer(ConfigurableTransformer transformer) {
		configurableTransformers.add(transformer);
		transformers.add(transformer);
	}

	public List<ConfigurableTransformer> getConfigurableTransformers() {
		return Collections.unmodifiableList(configurableTransformers);
	}

	public Object transform(Object in) {
		Object out = in;
		for (ISimpleTransformer transformer : transformers) {
			out = transformer.transform(out);
		}
		return out;
	}
}
