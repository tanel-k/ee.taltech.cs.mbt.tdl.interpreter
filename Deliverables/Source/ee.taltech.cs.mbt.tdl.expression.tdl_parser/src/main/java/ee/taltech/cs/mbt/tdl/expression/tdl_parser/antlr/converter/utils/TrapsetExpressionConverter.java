package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter.utils;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.LinkedTrapsetPairExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.RelativeTrapsetComplementExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.TrapsetExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TrapsetExpressionConverter extends TdlExpressionLanguageBaseVisitor<AbsTrapsetOperatorNode>
		implements IParseTreeConverter<AbsTrapsetOperatorNode, TrapsetExpressionContext> {
	public static TrapsetExpressionConverter getInstance() {
		return INSTANCE;
	}

	private static final TrapsetExpressionConverter INSTANCE = new TrapsetExpressionConverter();

	private TrapsetExpressionConverter() { }

	private TrapsetSymbolNode newTrapsetSymbol(TerminalNode node) {
		return TrapsetSymbolNode.of(node.getText());
	}

	@Override
	public AbsTrapsetOperatorNode convert(TrapsetExpressionContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public AbsTrapsetOperatorNode visitAbsoluteTrapsetComplementExpression(AbsoluteTrapsetComplementExpressionContext ctx) {
		AbsoluteComplementNode absoluteComplement = new AbsoluteComplementNode();
		absoluteComplement.getOperandContainer().setOperand(
				newTrapsetSymbol(ctx.TRAPSET_ID())
		);
		return absoluteComplement;
	}

	@Override
	public AbsTrapsetOperatorNode visitRelativeTrapsetComplementExpression(RelativeTrapsetComplementExpressionContext ctx) {
		RelativeComplementNode relativeComplement = new RelativeComplementNode();

		relativeComplement.getOperandContainer()
				.setLeftOperand(newTrapsetSymbol(ctx.TRAPSET_ID(0)))
				.setRightOperand(newTrapsetSymbol(ctx.TRAPSET_ID(1)));

		return relativeComplement;
	}

	@Override
	public AbsTrapsetOperatorNode visitLinkedTrapsetPairExpression(LinkedTrapsetPairExpressionContext ctx) {
		LinkedPairNode linkedPair = new LinkedPairNode();

		linkedPair.getOperandContainer()
				.setLeftOperand(newTrapsetSymbol(ctx.TRAPSET_ID(0)))
				.setRightOperand(newTrapsetSymbol(ctx.TRAPSET_ID(1)));

		return linkedPair;
	}
}
