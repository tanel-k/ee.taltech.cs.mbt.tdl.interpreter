package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsTernaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.QuantificationExpression.EQuantificationType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.type.BaseTypeConverter;

import java.util.List;

public class ExpressionConverter extends UtaLanguageBaseVisitor<AbsExpression>
		implements IParseTreeConverter<AbsExpression, ExpressionContext> {
	public static ExpressionConverter getInstance() {
		return INSTANCE;
	}

	private static final ExpressionConverter INSTANCE = new ExpressionConverter();

	private static final int BIN_EXPR_LEFT_CHILD = 0;
	private static final int BIN_EXPR_RIGHT_CHILD = 1;

	private static final int TERN_EXPR_LEFT_CHILD = 0;
	private static final int TERN_EXPR_MIDDLE_CHILD = 1;
	private static final int TERN_EXPR_RIGHT_CHILD = 2;

	private <ExprType extends AbsBinaryExprNode> ExprType visitBinaryNode(
			ExprType binaryExpression,
			List<ExpressionContext> children)
	{
		binaryExpression.setRightChild(children.get(BIN_EXPR_RIGHT_CHILD).accept(this));
		binaryExpression.setLeftChild(children.get(BIN_EXPR_LEFT_CHILD).accept(this));
		return binaryExpression;
	}

	private <ExprType extends AbsTernaryExprNode> ExprType visitTernaryNode(
			ExprType ternaryExpression,
			List<ExpressionContext> children)
	{
		ternaryExpression.setLeftChild(children.get(TERN_EXPR_LEFT_CHILD).accept(this));
		ternaryExpression.setMiddleChild(children.get(TERN_EXPR_MIDDLE_CHILD).accept(this));
		ternaryExpression.setRightChild(children.get(TERN_EXPR_RIGHT_CHILD).accept(this));
		return ternaryExpression;
	}

	private <ExprType extends AbsUnaryExprNode> ExprType visitUnaryNode(
			ExprType unaryExpression,
			ExpressionContext child)
	{
		unaryExpression.setChild(child.accept(this));
		return unaryExpression;
	}

	private ExpressionConverter() { }

	@Override
	public AbsExpression convert(ExpressionContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public AbsExpression visitQuantificationExpression(QuantificationExpressionContext ctx) {
		Identifier iterationVarName = Identifier.of(ctx.IDENTIFIER_NAME().getText());

		BaseType iterationVarType = BaseTypeConverter.getInstance().convert(ctx.type());
		AbsExpression quantifiedExpression = ctx.expression().accept(this);
		EQuantificationType quantType = ctx.PHRASE_EXISTS() != null
				? EQuantificationType.EXISTENTIAL
				: EQuantificationType.UNIVERSAL;

		QuantificationExpression quantificationExpression = new QuantificationExpression()
				.setQuantificationType(quantType)
				.setIterationVariableType(iterationVarType)
				.setIdentifierName(iterationVarName);
		quantificationExpression.setChild(quantifiedExpression);

		return quantificationExpression;
	}

	@Override
	public AbsExpression visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
		return visitBinaryNode(new MultiplicationExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitGreaterThanExpression(GreaterThanExpressionContext ctx) {
		return visitBinaryNode(new GreaterThanExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitMaximumExpression(MaximumExpressionContext ctx) {
		return visitBinaryNode(new MaximumExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitPrefixDecrementExpression(PrefixDecrementExpressionContext ctx) {
		return visitUnaryNode(new PrefixDecrementExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitCallExpression(CallExpressionContext ctx) {
		CallExpression callExpression = new CallExpression();
		if (ctx.argumentSequence() != null) {
			callExpression.getArguments().addAll(
					ArgumentSequenceConverter.getInstance().convert(ctx.argumentSequence())
			);
		}
		return visitUnaryNode(callExpression, ctx.expression());
	}

	@Override
	public AbsExpression visitTernaryExpression(TernaryExpressionContext ctx) {
		return visitTernaryNode(new TernaryExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitEqualityExpression(EqualityExpressionContext ctx) {
		return visitBinaryNode(new EqualityExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitLessThanOrEqualExpression(LessThanOrEqualExpressionContext ctx) {
		return visitBinaryNode(new LessThanOrEqualExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitRightShiftExpression(RightShiftExpressionContext ctx) {
		return visitBinaryNode(new RightShiftExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitConjunctionExpression(ConjunctionExpressionContext ctx) {
		ConjunctionExpression conjunction = new ConjunctionExpression();
		if (ctx.PHRASE_AND() != null)
			conjunction.setPhrase(true);
		return visitBinaryNode(conjunction, ctx.expression());
	}

	@Override
	public AbsExpression visitLessThanExpression(LessThanExpressionContext ctx) {
		return visitBinaryNode(new LessThanExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitLeftShiftExpression(LeftShiftExpressionContext ctx) {
		return visitBinaryNode(new LeftShiftExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitSubtractionExpression(SubtractionExpressionContext ctx) {
		return visitBinaryNode(new SubtractionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitAdditionExpression(AdditionExpressionContext ctx) {
		return visitBinaryNode(new AdditionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitDisjunctionExpression(DisjunctionExpressionContext ctx) {
		DisjunctionExpression disjunction = new DisjunctionExpression();
		if (ctx.PHRASE_OR() != null)
			disjunction.setPhrase(true);
		return visitBinaryNode(disjunction, ctx.expression());
	}

	@Override
	public AbsExpression visitBitwiseXorExpression(BitwiseXorExpressionContext ctx) {
		return visitBinaryNode(new BitwiseXorExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitBitwiseAndExpression(BitwiseAndExpressionContext ctx) {
		return visitBinaryNode(new BitwiseAndExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitPostfixIncrementExpression(PostfixIncrementExpressionContext ctx) {
		return visitUnaryNode(new PostfixIncrementExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitMinimumExpression(MinimumExpressionContext ctx) {
		return visitBinaryNode(new MinimumExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitFieldAccessExpression(FieldAccessExpressionContext ctx) {
		FieldAccessExpression fieldAccessExpression = new FieldAccessExpression();
		fieldAccessExpression.setIdentifier(Identifier.of(ctx.IDENTIFIER_NAME().getText()));
		return visitUnaryNode(fieldAccessExpression, ctx.expression());
	}

	@Override
	public AbsExpression visitBitwiseOrExpression(BitwiseOrExpressionContext ctx) {
		return visitBinaryNode(new BitwiseOrExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitPrefixIncrementExpression(PrefixIncrementExpressionContext ctx) {
		return visitUnaryNode(new PrefixIncrementExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitNegationExpression(NegationExpressionContext ctx) {
		return visitUnaryNode(new NegationExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitDivisionExpression(DivisionExpressionContext ctx) {
		return visitBinaryNode(new DivisionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitInequalityExpression(InequalityExpressionContext ctx) {
		return visitBinaryNode(new InequalityExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionGroup(ExpressionGroupContext ctx) {
		return visitUnaryNode(new GroupedExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitArrayLookupExpression(ArrayLookupExpressionContext ctx) {
		return visitBinaryNode(new ArrayLookupExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitAdditiveInverseExpression(AdditiveInverseExpressionContext ctx) {
		return visitUnaryNode(new AdditiveInverseExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitAdditiveIdentityExpression(AdditiveIdentityExpressionContext ctx) {
		return visitUnaryNode(new AdditiveIdentityExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitGreaterThanOrEqualExpression(GreaterThanOrEqualExpressionContext ctx) {
		return visitBinaryNode(new GreaterThanOrEqualExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitModuloExpression(ModuloExpressionContext ctx) {
		return visitBinaryNode(new ModuloExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitAssignmentExpression(AssignmentExpressionContext ctx) {
		return visitBinaryNode(new AssignmentExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitImplicationExpression(ImplicationExpressionContext ctx) {
		ImplicationExpression implication = new ImplicationExpression();
		if (ctx.PHRASE_IMPLY() != null)
			implication.setPhrase(true);
		return visitBinaryNode(implication, ctx.expression());
	}

	@Override
	public AbsExpression visitPostfixDecrementExpression(PostfixDecrementExpressionContext ctx) {
		return visitUnaryNode(new PostfixDecrementExpression(), ctx.expression());
	}

	private <R extends AbsExpression & IHasAssignmentCounterpart> R toAssignment(R expr) {
		expr.setAssignment(true);
		return expr;
	}

	@Override
	public AbsExpression visitAdditionAssignmentExpr(AdditionAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new AdditionExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitBitwiseXorAssignmentExpr(BitwiseXorAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new BitwiseXorExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitDivisionAssignmentExpr(DivisionAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new DivisionExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitRightShiftAssignmentExpr(RightShiftAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new RightShiftExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitSubtractionAssignmentExpr(SubtractionAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new SubtractionExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitBitwiseAndAssignmentExpr(BitwiseAndAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new BitwiseAndExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitMultiplicationAssignmentExpr(MultiplicationAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new MultiplicationExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitModuloAssignmentExpr(ModuloAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new ModuloExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitBitwiseOrAssignmentExpr(BitwiseOrAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new BitwiseOrExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitLeftShiftAssignmentExpr(LeftShiftAssignmentExprContext ctx) {
		return toAssignment(visitBinaryNode(new MultiplicationExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitIdentifierExpression(IdentifierExpressionContext ctx) {
		return IdentifierExpression.of(ctx.IDENTIFIER_NAME().toString());
	}

	@Override
	public AbsExpression visitNaturalNumberLiteral(NaturalNumberLiteralContext ctx) {
		return NaturalNumberLiteral.of(ctx.NATURAL_NUMBER().getText());
	}

	@Override
	public AbsExpression visitDeadlockLiteral(DeadlockLiteralContext ctx) {
		return LiteralConsts.DEADLOCK;
	}

	@Override
	public AbsExpression visitFalseLiteral(FalseLiteralContext ctx) {
		return LiteralConsts.FALSE;
	}

	@Override
	public AbsExpression visitTrueLiteral(TrueLiteralContext ctx) {
		return LiteralConsts.TRUE;
	}
}
