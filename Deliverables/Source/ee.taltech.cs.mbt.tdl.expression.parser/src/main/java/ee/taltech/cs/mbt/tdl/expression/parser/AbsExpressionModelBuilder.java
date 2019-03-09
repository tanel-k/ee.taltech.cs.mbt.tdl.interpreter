package ee.taltech.cs.mbt.tdl.expression.parser;

public abstract class AbsExpressionModelBuilder<ModelType> {
	public abstract ModelType build();

	public abstract AbsExpressionModelBuilder<ModelType> root();
	public abstract AbsExpressionModelBuilder<ModelType> childNode();
}
