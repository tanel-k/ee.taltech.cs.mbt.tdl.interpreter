package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.expression;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AdditionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AdditiveIdentityExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AdditiveInverseExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.BitwiseAndExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.BitwiseXorOrExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.BitwiseOrExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.CallExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.DisjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.DivisionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.EqualityExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.FieldAccessExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.TernaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.InequalityExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.LeftShiftExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.MaximumExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.MinimumExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ModuloExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.MultiplicationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.RightShiftExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.SubtractionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.PostfixDecrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.PostfixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.PrefixDecrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.PrefixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.GreaterThanOrEqualExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.GreaterThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.LessThanOrEqualExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.LessThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.logical.phrasal.PhrasalDisjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.logical.phrasal.PhrasalImplicationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.logical.phrasal.PhrasalNegation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.logical.quantification.EQuantificationType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.logical.quantification.QuantificationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.GroupedExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AssignmentWrapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsTernaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ExpressionConverter extends UtaLanguageBaseVisitor<AbsExpression> implements IParseTreeConverter<AbsExpression, ExpressionContext> {
	public static ExpressionConverter getInstance() {
		return INSTANCE;
	}

	private static final ExpressionConverter INSTANCE = new ExpressionConverter();

	private static final int BIN_EXPR_LEFT_CHILD = 0;
	private static final int BIN_EXPR_RIGHT_CHILD = 1;

	private static final int TERN_EXPR_LEFT_CHILD = 0;
	private static final int TERN_EXPR_MIDDLE_CHILD = 0;
	private static final int TERN_EXPR_RIGHT_CHILD = 2;

	private <ExprType extends AbsBinaryExprNode> ExprType visitBinaryExpression(
			ExprType binaryExpression,
			List<ExpressionContext> children)
	{
		binaryExpression.setRightChild(children.get(BIN_EXPR_RIGHT_CHILD).accept(this));
		binaryExpression.setLeftChild(children.get(BIN_EXPR_LEFT_CHILD).accept(this));
		return binaryExpression;
	}

	private <ExprType extends AbsTernaryExprNode> ExprType visitTernaryExpression(
			ExprType ternaryExpression,
			List<ExpressionContext> children)
	{
		ternaryExpression.setLeftChild(children.get(TERN_EXPR_LEFT_CHILD).accept(this));
		ternaryExpression.setMiddleChild(children.get(TERN_EXPR_MIDDLE_CHILD).accept(this));
		ternaryExpression.setRightChild(children.get(TERN_EXPR_RIGHT_CHILD).accept(this));
		return ternaryExpression;
	}

	private <ExprType extends AbsUnaryExprNode> ExprType visitUnaryExpression(
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
	public AbsExpression visitExpressionExistentialQuantification(ExpressionExistentialQuantificationContext ctx) {
		Identifier iterationVarName = new Identifier();
		iterationVarName.setText(ctx.IDENTIFIER_NAME().getText());

		Type<AbsTypeId> iterationVarType = TypeConverter.getInstance().convert(ctx.type());

		AbsExpression quantifiedExpression = ctx.expression().accept(this);

		QuantificationExpression<AbsTypeId> quantificationExpression = new QuantificationExpression<>();
		quantificationExpression.setQuantificationType(EQuantificationType.EXISTENTIAL);
		quantificationExpression.setIterationVariableType(iterationVarType);
		quantificationExpression.setIdentifierName(iterationVarName);
		quantificationExpression.setChild(quantifiedExpression);

		return quantificationExpression;
	}

	@Override
	public AbsExpression visitExpressionUniversalQuantification(ExpressionUniversalQuantificationContext ctx) {
		Identifier iterationVarName = new Identifier();
		iterationVarName.setText(ctx.IDENTIFIER_NAME().getText());

		Type<AbsTypeId> iterationVarType = TypeConverter.getInstance().convert(ctx.type());

		AbsExpression quantifiedExpression = ctx.expression().accept(this);

		QuantificationExpression<AbsTypeId> quantificationExpression = new QuantificationExpression<>();
		quantificationExpression.setQuantificationType(EQuantificationType.UNIVERSAL);
		quantificationExpression.setIterationVariableType(iterationVarType);
		quantificationExpression.setIdentifierName(iterationVarName);
		quantificationExpression.setChild(quantifiedExpression);

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
		return visitTernaryExpression(new TernaryExpression(), ctx.expression());
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
		return visitBinaryExpression(new BitwiseXorOrExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpLessThanOrEqual(ExpressionBinaryOpLessThanOrEqualContext ctx) {
		return visitBinaryExpression(new LessThanOrEqualExpression(), ctx.expression());
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
		return visitBinaryExpression(new BitwiseXorOrExpression(), ctx.expression());
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
		fieldAccessExpression.setIdentifier(visitIdentifier(ctx.IDENTIFIER_NAME()));
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
	public AbsExpression visitExpressionUnaryOpAdditiveInverse(ExpressionUnaryOpAdditiveInverseContext ctx) {
		return visitUnaryExpression(new AdditiveInverseExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionUnaryOpAdditiveIdentity(ExpressionUnaryOpAdditiveIdentityContext ctx) {
		return visitUnaryExpression(new AdditiveIdentityExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpDisjunctionPhrase(ExpressionBinaryOpDisjunctionPhraseContext ctx) {
		return visitBinaryExpression(new PhrasalDisjunctionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionBinaryOpGreaterThanOrEqual(ExpressionBinaryOpGreaterThanOrEqualContext ctx) {
		return visitBinaryExpression(new GreaterThanOrEqualExpression(), ctx.expression());
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
	public AbsExpression visitExpressionBinaryOpConjunction(ExpressionBinaryOpConjunctionContext ctx) {
		return visitBinaryExpression(new ConjunctionExpression(), ctx.expression());
	}

	@Override
	public AbsExpression visitExpressionAssignOpAddition(ExpressionAssignOpAdditionContext ctx) {
		return AssignmentWrapper.wrap(visitBinaryExpression(new AdditionExpression(), ctx.expression()));
	}

	@Override
	public AbsExpression visitExpressionIdentifierRef(ExpressionIdentifierRefContext ctx) {
		IdentifierExpression refExpression = new IdentifierExpression();
		refExpression.setIdentifier(visitIdentifier(ctx.IDENTIFIER_NAME()));
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

	private Identifier visitIdentifier(TerminalNode identifierTerminal) {
		Identifier identifier = new Identifier();
		identifier.setText(identifierTerminal.getText());
		return identifier;
	}
}
