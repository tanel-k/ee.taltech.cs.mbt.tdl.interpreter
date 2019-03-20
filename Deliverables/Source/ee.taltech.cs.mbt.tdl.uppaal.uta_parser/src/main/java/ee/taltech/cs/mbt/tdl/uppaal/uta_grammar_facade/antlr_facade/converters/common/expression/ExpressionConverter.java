package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.expression;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.access.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.arithmetic.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.binary.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PostfixDecrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PostfixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PrefixDecrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PrefixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality.GTEExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality.GreaterThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality.LTEExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality.LessThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.phrasal.PhrasalDisjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.phrasal.PhrasalImplicationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.phrasal.PhrasalNegation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.quantification.EQuantificationType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.quantification.QuantificationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.structural.GroupedExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AssignmentWrapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsTernaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ExpressionConverter extends UTALanguageBaseVisitor<AbsExpression>
	implements IParseTreeConverter<AbsExpression, ExpressionContext>
{
	private static final int BIN_EXPR_LEFT_CHILD = 0;
	private static final int BIN_EXPR_RIGHT_CHILD = 1;

	private static final int TERN_EXPR_LEFT_CHILD = 0;
	private static final int TERN_EXPR_MIDDLE_CHILD = 0;
	private static final int TERN_EXPR_RIGHT_CHILD = 2;

	private <ExprType extends AbsBinaryExpression> ExprType visitBinaryExpression(
			ExprType binaryExpression,
			List<ExpressionContext> children)
	{
		binaryExpression.setRightChild(children.get(BIN_EXPR_RIGHT_CHILD).accept(this));
		binaryExpression.setLeftChild(children.get(BIN_EXPR_LEFT_CHILD).accept(this));
		return binaryExpression;
	}

	private <ExprType extends AbsTernaryExpression> ExprType visitTernaryExpression(
			ExprType ternaryExpression,
			List<ExpressionContext> children)
	{
		ternaryExpression.setLeftChild(children.get(TERN_EXPR_LEFT_CHILD).accept(this));
		ternaryExpression.setMiddleChild(children.get(TERN_EXPR_MIDDLE_CHILD).accept(this));
		ternaryExpression.setRightChild(children.get(TERN_EXPR_RIGHT_CHILD).accept(this));
		return ternaryExpression;
	}

	private <ExprType extends AbsUnaryExpression> ExprType visitUnaryExpression(
			ExprType unaryExpression,
			ExpressionContext child)
	{
		unaryExpression.setChild(child.accept(this));
		return unaryExpression;
	}

	public ExpressionConverter() { }

	@Override
	public AbsExpression convert(ExpressionContext rootContext) throws ParseTreeStructureException {
		return rootContext.accept(this);
	}

	@Override
	public AbsExpression visitErrorNode(ErrorNode node) {
		throw new ParseTreeStructureException(
			"Expression subtree contains an error node (" + node.getText() + ")."
		);
	}

	@Override
	public AbsExpression visitExpressionExistentialQuantification(ExpressionExistentialQuantificationContext ctx) {
		IdentifierName iterationVarName = new IdentifierName();
		iterationVarName.setName(ctx.IDENTIFIER_NAME().getText());

		Type<AbsTypeIdentifier> iterationVarType = ctx.type().accept(new TypeConverter());

		AbsExpression quantifiedExpression = ctx.expression().accept(this);

		QuantificationExpression<AbsTypeIdentifier> quantificationExpression = new QuantificationExpression<>();
		quantificationExpression.setQuantificationType(EQuantificationType.EXISTENTIAL);
		quantificationExpression.setIterationVariableType(iterationVarType);
		quantificationExpression.setIdentifierName(iterationVarName);
		quantificationExpression.setChild(quantificationExpression);

		return quantificationExpression;
	}

	@Override
	public AbsExpression visitExpressionUniversalQuantification(ExpressionUniversalQuantificationContext ctx) {
		IdentifierName iterationVarName = new IdentifierName();
		iterationVarName.setName(ctx.IDENTIFIER_NAME().getText());

		Type<AbsTypeIdentifier> iterationVarType = ctx.type().accept(new TypeConverter());

		AbsExpression quantifiedExpression = ctx.expression().accept(this);

		QuantificationExpression<AbsTypeIdentifier> quantificationExpression = new QuantificationExpression<>();
		quantificationExpression.setQuantificationType(EQuantificationType.UNIVERSAL);
		quantificationExpression.setIterationVariableType(iterationVarType);
		quantificationExpression.setIdentifierName(iterationVarName);
		quantificationExpression.setChild(quantificationExpression);

		return quantificationExpression;
	}

	@Override
	public AbsExpression visitExpressionBinaryOpMultiplication(ExpressionBinaryOpMultiplicationContext ctx) {
		return visitBinaryExpression(new MultiplicationExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpBitwiseAnd(ExpressionAssignOpBitwiseAndContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new BitwiseAndExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionBinaryOpGreaterThan(ExpressionBinaryOpGreaterThanContext ctx) {
		return visitBinaryExpression(new GreaterThanExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpMultiplication(ExpressionAssignOpMultiplicationContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new MultiplicationExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionBinaryOpMaximum(ExpressionBinaryOpMaximumContext ctx) {
		return visitBinaryExpression(new MaximumExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionDecrementAndGet(ExpressionDecrementAndGetContext ctx) {
		return visitUnaryExpression(new PrefixDecrementExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionCall(ExpressionCallContext ctx) {
		CallExpression callExpression = new CallExpression();
		if (ctx.argumentList() != null) {
			for (ExpressionContext argumentCtx : ctx.argumentList().expression()) {
				callExpression.getArgumentList().add(argumentCtx.accept(this));
			}
		}
		return visitUnaryExpression(callExpression, ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionTernary(ExpressionTernaryContext ctx) {
		return visitTernaryExpression(new IfElseExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpEqual(ExpressionBinaryOpEqualContext ctx) {
		return visitBinaryExpression(new EqualityExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpModulo(ExpressionAssignOpModuloContext ctx) {
		return visitBinaryExpression(new ModuloExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpBitwiseXOR(ExpressionAssignOpBitwiseXORContext ctx) {
		return visitBinaryExpression(new BitwiseExclusiveOrExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpLessThanOrEqual(ExpressionBinaryOpLessThanOrEqualContext ctx) {
		return visitBinaryExpression(new LTEExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpRightShift(ExpressionBinaryOpRightShiftContext ctx) {
		return visitBinaryExpression(new RightShiftExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpConjunctionPhrase(ExpressionBinaryOpConjunctionPhraseContext ctx) {
		return visitBinaryExpression(new ConjunctionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionUnaryOpNegatedPhrase(ExpressionUnaryOpNegatedPhraseContext ctx) {
		return visitUnaryExpression(new PhrasalNegation(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpLessThan(ExpressionBinaryOpLessThanContext ctx) {
		return visitBinaryExpression(new LessThanExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpSubtraction(ExpressionAssignOpSubtractionContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new SubtractionExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionBinaryOpLeftShift(ExpressionBinaryOpLeftShiftContext ctx) {
		return visitBinaryExpression(new LeftShiftExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpSubtraction(ExpressionBinaryOpSubtractionContext ctx) {
		return visitBinaryExpression(new SubtractionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpDisjunction(ExpressionBinaryOpDisjunctionContext ctx) {
		return visitBinaryExpression(new DisjunctionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpBitwiseXOR(ExpressionBinaryOpBitwiseXORContext ctx) {
		return visitBinaryExpression(new BitwiseExclusiveOrExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpBitwiseAnd(ExpressionBinaryOpBitwiseAndContext ctx) {
		return visitBinaryExpression(new BitwiseAndExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionGetAndIncrement(ExpressionGetAndIncrementContext ctx) {
		return visitUnaryExpression(new PostfixIncrementExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpMinimum(ExpressionBinaryOpMinimumContext ctx) {
		return visitBinaryExpression(new MinimumExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionFieldAccess(ExpressionFieldAccessContext ctx) {
		FieldAccessExpression fieldAccessExpression = new FieldAccessExpression();
		fieldAccessExpression.setIdentifierName(visitIdentifier(ctx.IDENTIFIER_NAME()));
		return visitUnaryExpression(fieldAccessExpression, ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpBitwiseOr(ExpressionBinaryOpBitwiseOrContext ctx) {
		return visitBinaryExpression(new BitwiseOrExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionIncrementAndGet(ExpressionIncrementAndGetContext ctx) {
		return visitUnaryExpression(new PrefixIncrementExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpAddition(ExpressionBinaryOpAdditionContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new AdditionExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionAssignOpRightShift(ExpressionAssignOpRightShiftContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new RightShiftExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionUnaryOpNegated(ExpressionUnaryOpNegatedContext ctx) {
		return visitUnaryExpression(new NegationExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpDivision(ExpressionBinaryOpDivisionContext ctx) {
		return visitBinaryExpression(new DivisionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpNotEqual(ExpressionBinaryOpNotEqualContext ctx) {
		return visitBinaryExpression(new InequalityExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpBitwiseOr(ExpressionAssignOpBitwiseOrContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new BitwiseOrExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionAssignOpDivision(ExpressionAssignOpDivisionContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new DivisionExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionGrouped(ExpressionGroupedContext ctx) {
		return visitUnaryExpression(new GroupedExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionArrayLookup(ExpressionArrayLookupContext ctx) {
		return visitBinaryExpression(new ArrayLookupExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionUnaryOpNegative(ExpressionUnaryOpNegativeContext ctx) {
		return visitUnaryExpression(new NegativeExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpDisjunctionPhrase(ExpressionBinaryOpDisjunctionPhraseContext ctx) {
		return visitBinaryExpression(new PhrasalDisjunctionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpGreaterThanOrEqual(ExpressionBinaryOpGreaterThanOrEqualContext ctx) {
		return visitBinaryExpression(new GTEExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpLeftShift(ExpressionAssignOpLeftShiftContext ctx) {
		return visitBinaryExpression(new MultiplicationExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpModulo(ExpressionBinaryOpModuloContext ctx) {
		return visitBinaryExpression(new ModuloExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOp(ExpressionAssignOpContext ctx) {
		return visitBinaryExpression(new AssignmentExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpImplicationPhrase(ExpressionBinaryOpImplicationPhraseContext ctx) {
		return visitBinaryExpression(new PhrasalImplicationExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionGetAndDecrement(ExpressionGetAndDecrementContext ctx) {
		return visitUnaryExpression(new PostfixDecrementExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionUnaryOpPositive(ExpressionUnaryOpPositiveContext ctx) {
		return visitUnaryExpression(new PositiveExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpConjunction(ExpressionBinaryOpConjunctionContext ctx) {
		return visitBinaryExpression(new ConjunctionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpAddition(ExpressionAssignOpAdditionContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new AdditionExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionIdentifierRef(ExpressionIdentifierRefContext ctx) {
		IdentifierRefExpression refExpression = new IdentifierRefExpression();
		refExpression.setIdentifierName(visitIdentifier(ctx.IDENTIFIER_NAME()));
		return refExpression;
	}

	@Override
	public AbsExpression visitExpressionNaturalNumber(ExpressionNaturalNumberContext ctx) {
		return NaturalNumberLiteral.of(ctx.NATURAL_NUMBER().getText());
	}

	@Override
	public AbsExpression visitExpressionDeadlockLiteral(ExpressionDeadlockLiteralContext ctx) {
		return LiteralConsts.DEADLOCK;
	}

	@Override
	public AbsExpression visitExpressionFalseLiteral(ExpressionFalseLiteralContext ctx) {
		return LiteralConsts.FALSE;
	}

	@Override
	public AbsExpression visitExpressionTrueLiteral(ExpressionTrueLiteralContext ctx) {
		return LiteralConsts.TRUE;
	}

	private IdentifierName visitIdentifier(TerminalNode identifierTerminal) {
		IdentifierName identifierName = new IdentifierName();
		identifierName.setName(identifierTerminal.getText());
		return identifierName;
	}
}
