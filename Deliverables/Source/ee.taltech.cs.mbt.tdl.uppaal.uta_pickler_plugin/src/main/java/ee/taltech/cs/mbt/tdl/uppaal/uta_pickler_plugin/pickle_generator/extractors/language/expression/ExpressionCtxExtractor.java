package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.DeadlockLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.FalseLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.TrueLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

import java.util.Set;

public class ExpressionCtxExtractor implements IPicklerContextExtractor<AbsExpression>,
		IExpressionVisitor<ContextBuilder> {
	public static ExpressionCtxExtractor getInstance() {
		return new ExpressionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private ExpressionCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsExpression expr) {
		return expr.accept(this);
	}

	@Override
	public ContextBuilder visitArrayLookupExpr(ArrayLookupExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitAdditionExpr(AdditionExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitDivisionExpr(DivisionExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitMaximumExpr(MaximumExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitMinimumExpr(MinimumExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitModuloExpr(ModuloExpression modulo) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitMultiplicationExpr(MultiplicationExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitAdditiveInverseExpr(AdditiveInverseExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitAdditiveIdentityExpr(AdditiveIdentityExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitSubtractionExpr(SubtractionExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitBitwiseAndExpr(BitwiseAndExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitBitwiseXorExpr(BitwiseXorExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitBitwiseOrExpr(BitwiseOrExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitLeftShiftExpr(LeftShiftExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitRightShiftExpr(RightShiftExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitPostfixDecrementExpr(PostfixDecrementExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitPostfixIncrementExpr(PostfixIncrementExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitPrefixDecrementExpr(PrefixDecrementExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitPrefixIncrementExpr(PrefixIncrementExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitGroupExpr(GroupedExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitAssignmentExpr(AssignmentExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitCallExpr(CallExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitIdentifierExpr(IdentifierExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitTernaryExpr(TernaryExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitNegationExpr(NegationExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitEqualityExpr(EqualityExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitDisjunctionExpr(DisjunctionExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitConjunctionExpr(ConjunctionExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitFieldAccessExpr(FieldAccessExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitGreaterThanExpr(GreaterThanExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitLessThanExpr(LessThanExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitGreaterThanOrEqualExpr(GreaterThanOrEqualExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitLessThanOrEqualExpr(LessThanOrEqualExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitInequalityExpr(InequalityExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitQuantificationExpr(QuantificationExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitImplicationExpr(ImplicationExpression expr) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitDeadlockLiteral(DeadlockLiteral literal) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitFalseLiteral(FalseLiteral literal) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitTrueLiteral(TrueLiteral literal) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitNaturalNumberLiteral(NaturalNumberLiteral literal) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
