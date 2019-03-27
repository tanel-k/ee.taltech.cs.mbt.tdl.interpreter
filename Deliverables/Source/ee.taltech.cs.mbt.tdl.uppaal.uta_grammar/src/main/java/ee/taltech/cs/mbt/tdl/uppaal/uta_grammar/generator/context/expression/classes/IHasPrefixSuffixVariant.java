package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes;

public interface IHasPrefixSuffixVariant {
	boolean isPrefix();
	void setPrefix(boolean prefix);

	boolean isSuffix();
	void setSuffix(boolean suffix);
}
