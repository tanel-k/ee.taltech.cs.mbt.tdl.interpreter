package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.st_generator.extractors;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.SExpressionStringUtils;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes.ISExpressionVisitor;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes.SExpressionStringNode;

import java.util.List;
import java.util.stream.Collectors;

public class SExpressionContextExtractor implements IContextExtractor<SExpression>, ISExpressionVisitor<ContextBuilder> {
	public static SExpressionContextExtractor getInstance() {
		return INSTANCE;
	}

	private static final SExpressionContextExtractor INSTANCE = new SExpressionContextExtractor();

	@Override
	public ContextBuilder extract(SExpression inst) {
		return ContextBuilder.newBuilder()
				.put("root", inst.getRoot().accept(this));
	}

	@Override
	public ContextBuilder visitSequence(SExpressionSequenceNode node) {
		List<ContextBuilder> items = node.getChildren().stream()
				.map(n -> n.accept(this))
				.collect(Collectors.toList());
		return ContextBuilder.newBuilder("sequence")
				.put("items", items);
	}

	@Override
	public ContextBuilder visitString(SExpressionStringNode node) {
		String str = node.getString();
		if (SExpressionStringUtils.shouldDelimit(str)) {
			str = SExpressionStringUtils.escape(str);
			str = SExpressionStringUtils.delimit(str);
			return ContextBuilder.newBuilder()
					.put("delimited", true)
					.put("str", str);
		}
		return ContextBuilder.newBuilder()
				.put("str", SExpressionStringUtils.escape(str));
	}
}
