package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter.utils;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.LinkedTrapsetPairExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.RelativeTrapsetComplementExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.TrapsetExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TrapsetExpressionConverter extends TdlExpressionLanguageBaseVisitor<AbsDerivedTrapsetNode>
		implements IParseTreeConverter<AbsDerivedTrapsetNode, TrapsetExpressionContext> {
	public static TrapsetExpressionConverter getInstance() {
		return INSTANCE;
	}

	private static final TrapsetExpressionConverter INSTANCE = new TrapsetExpressionConverter();

	private TrapsetExpressionConverter() { }

	private TrapsetNode newTrapsetSymbol(TerminalNode node) {
		return TrapsetNode.of(node.getText());
	}

	@Override
	public AbsDerivedTrapsetNode convert(TrapsetExpressionContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public AbsDerivedTrapsetNode visitAbsoluteTrapsetComplementExpression(AbsoluteTrapsetComplementExpressionContext ctx) {
		AbsoluteComplementNode absoluteComplement = new AbsoluteComplementNode();
		absoluteComplement.getChildContainer().setChild(
				newTrapsetSymbol(ctx.TRAPSET_ID())
		);
		return absoluteComplement;
	}

	@Override
	public AbsDerivedTrapsetNode visitRelativeTrapsetComplementExpression(RelativeTrapsetComplementExpressionContext ctx) {
		RelativeComplementNode relativeComplement = new RelativeComplementNode();

		relativeComplement.getChildContainer()
				.setLeftChild(newTrapsetSymbol(ctx.TRAPSET_ID(0)))
				.setRightChild(newTrapsetSymbol(ctx.TRAPSET_ID(1)));

		return relativeComplement;
	}

	@Override
	public AbsDerivedTrapsetNode visitLinkedTrapsetPairExpression(LinkedTrapsetPairExpressionContext ctx) {
		LinkedPairNode linkedPair = new LinkedPairNode();

		linkedPair.getChildContainer()
				.setLeftChild(newTrapsetSymbol(ctx.TRAPSET_ID(0)))
				.setRightChild(newTrapsetSymbol(ctx.TRAPSET_ID(1)));

		return linkedPair;
	}
}
