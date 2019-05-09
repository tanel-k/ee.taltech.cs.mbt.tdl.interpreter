package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type.BaseTypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.IHasPhraseCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsTernaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.QuantificationExpression.EQuantificationType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.DeadlockLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.FalseLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.TrueLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

import java.util.Collection;
import java.util.Set;

public class ExpressionCtxExtractor implements IPicklerContextExtractor<AbsExpression>,
		IExpressionVisitor<ContextBuilder> {
	public static ExpressionCtxExtractor getInstance() {
		return new ExpressionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private ExpressionCtxExtractor() { }

	private ContextBuilder visitTernaryNode(String name, AbsTernaryExprNode expr) {
		requiredClasses.add(expr.getClass());
		return ContextBuilder.newBuilder(name)
				.put("leftChild", extract(expr.getLeftChild(), requiredClasses))
				.put("middleChild", extract(expr.getMiddleChild(), requiredClasses))
				.put("rightChild", extract(expr.getRightChild(), requiredClasses));
	}

	private ContextBuilder visitBinaryNode(String name, AbsBinaryExprNode expr) {
		requiredClasses.add(expr.getClass());
		boolean isAssignment = expr instanceof IHasAssignmentCounterpart
				&& ((IHasAssignmentCounterpart) expr).isAssignment();
		boolean isPhrase = expr instanceof IHasPhraseCounterpart
				&& ((IHasPhraseCounterpart) expr).isPhrase();
		return ContextBuilder.newBuilder(name)
				.put("leftChild", extract(expr.getLeftChild(), requiredClasses))
				.put("rightChild", extract(expr.getRightChild(), requiredClasses))
				.put("assignment", isAssignment)
				.put("phrase", isPhrase);
	}

	private ContextBuilder visitUnaryNode(String name, AbsUnaryExprNode expr) {
		requiredClasses.add(expr.getClass());
		boolean isPhrase = expr instanceof IHasPhraseCounterpart
				&& ((IHasPhraseCounterpart) expr).isPhrase();
		return ContextBuilder.newBuilder(name)
				.put("child", extract(expr.getChild(), requiredClasses))
				.put("phrase", isPhrase);
	}

	private ContextBuilder visitLiteral(String classifier) {
		return ContextBuilder.newBuilder(classifier)
				.put("literal", true);
	}

	@Override
	public ContextBuilder extract(AbsExpression expr) {
		return expr.accept(this);
	}

	@Override
	public ContextBuilder visitArrayLookupExpr(ArrayLookupExpression expr) {
		return visitBinaryNode("arrayLookup", expr);
	}

	@Override
	public ContextBuilder visitAdditionExpr(AdditionExpression expr) {
		return visitBinaryNode("addition", expr);
	}

	@Override
	public ContextBuilder visitDivisionExpr(DivisionExpression expr) {
		return visitBinaryNode("division", expr);
	}

	@Override
	public ContextBuilder visitMaximumExpr(MaximumExpression expr) {
		return visitBinaryNode("maximum", expr);
	}

	@Override
	public ContextBuilder visitMinimumExpr(MinimumExpression expr) {
		return visitBinaryNode("minimum", expr);
	}

	@Override
	public ContextBuilder visitModuloExpr(ModuloExpression expr) {
		return visitBinaryNode("modulo", expr);
	}

	@Override
	public ContextBuilder visitMultiplicationExpr(MultiplicationExpression expr) {
		return visitBinaryNode("multiplication", expr);
	}

	@Override
	public ContextBuilder visitAdditiveInverseExpr(AdditiveInverseExpression expr) {
		return visitUnaryNode("additiveInverse", expr);
	}

	@Override
	public ContextBuilder visitAdditiveIdentityExpr(AdditiveIdentityExpression expr) {
		return visitUnaryNode("additiveIdentity", expr);
	}

	@Override
	public ContextBuilder visitSubtractionExpr(SubtractionExpression expr) {
		return visitBinaryNode("subtraction", expr);
	}

	@Override
	public ContextBuilder visitBitwiseAndExpr(BitwiseAndExpression expr) {
		return visitBinaryNode("bitwiseAnd", expr);
	}

	@Override
	public ContextBuilder visitBitwiseXorExpr(BitwiseXorExpression expr) {
		return visitBinaryNode("bitwiseXor", expr);
	}

	@Override
	public ContextBuilder visitBitwiseOrExpr(BitwiseOrExpression expr) {
		return visitBinaryNode("bitwiseOr", expr);
	}

	@Override
	public ContextBuilder visitLeftShiftExpr(LeftShiftExpression expr) {
		return visitBinaryNode("leftShift", expr);
	}

	@Override
	public ContextBuilder visitRightShiftExpr(RightShiftExpression expr) {
		return visitBinaryNode("rightShift", expr);
	}

	@Override
	public ContextBuilder visitPostfixDecrementExpr(PostfixDecrementExpression expr) {
		return visitUnaryNode("postfixDecrement", expr);
	}

	@Override
	public ContextBuilder visitPostfixIncrementExpr(PostfixIncrementExpression expr) {
		return visitUnaryNode("postfixIncrement", expr);
	}

	@Override
	public ContextBuilder visitPrefixDecrementExpr(PrefixDecrementExpression expr) {
		return visitUnaryNode("prefixDecrement", expr);
	}

	@Override
	public ContextBuilder visitPrefixIncrementExpr(PrefixIncrementExpression expr) {
		return visitUnaryNode("prefixIncrement", expr);
	}

	@Override
	public ContextBuilder visitGroupExpr(GroupedExpression expr) {
		return visitUnaryNode("group", expr);
	}

	@Override
	public ContextBuilder visitAssignmentExpr(AssignmentExpression expr) {
		return visitBinaryNode("assignmentExpression", expr);
	}

	@Override
	public ContextBuilder visitCallExpr(CallExpression expr) {
		Collection<ContextBuilder> argCtxs = ExpressionCtxExtractor.getInstance()
				.extract(expr.getArguments(), requiredClasses);
		return visitUnaryNode("call", expr)
				.put("arguments", argCtxs);
	}

	@Override
	public ContextBuilder visitIdentifierExpr(IdentifierExpression expr) {
		requiredClasses.add(IdentifierExpression.class);
		return ContextBuilder.newBuilder("identifierExpression")
				.put("identifier", expr.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitTernaryExpr(TernaryExpression expr) {
		return visitTernaryNode("ternary", expr);
	}

	@Override
	public ContextBuilder visitNegationExpr(NegationExpression expr) {
		return visitUnaryNode("negation", expr);
	}

	@Override
	public ContextBuilder visitEqualityExpr(EqualityExpression expr) {
		return visitBinaryNode("equality", expr);
	}

	@Override
	public ContextBuilder visitDisjunctionExpr(DisjunctionExpression expr) {
		return visitBinaryNode("disjunction", expr);
	}

	@Override
	public ContextBuilder visitConjunctionExpr(ConjunctionExpression expr) {
		return visitBinaryNode("conjunction", expr);
	}

	@Override
	public ContextBuilder visitFieldAccessExpr(FieldAccessExpression expr) {
		requiredClasses.add(Identifier.class);
		return visitUnaryNode("fieldAccess", expr)
				.put("fieldIdentifier", expr.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitGreaterThanExpr(GreaterThanExpression expr) {
		return visitBinaryNode("greaterThan", expr);
	}

	@Override
	public ContextBuilder visitLessThanExpr(LessThanExpression expr) {
		return visitBinaryNode("lessThan", expr);
	}

	@Override
	public ContextBuilder visitGreaterThanOrEqualExpr(GreaterThanOrEqualExpression expr) {
		return visitBinaryNode("greaterThanOrEqual", expr);
	}

	@Override
	public ContextBuilder visitLessThanOrEqualExpr(LessThanOrEqualExpression expr) {
		return visitBinaryNode("lessThanOrEqual", expr);
	}

	@Override
	public ContextBuilder visitInequalityExpr(InequalityExpression expr) {
		return visitBinaryNode("inequality", expr);
	}

	@Override
	public ContextBuilder visitQuantificationExpr(QuantificationExpression expr) {
		requiredClasses.add(EQuantificationType.class);
		String name = "quantification";
		switch (expr.getQuantificationType()) {
		case UNIVERSAL:
			name = "universalQuantification";
			break;
		case EXISTENTIAL:
			name = "existentialQuantification";
			break;
		default:
			break;
		}
		ContextBuilder typeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(expr.getIterationVariableType(), requiredClasses);
		return visitUnaryNode(name, expr)
				.put("baseType", typeCtx)
				.put("loopVarName", expr.getIdentifierName().toString());
	}

	@Override
	public ContextBuilder visitImplicationExpr(ImplicationExpression expr) {
		return visitBinaryNode("implication", expr);
	}

	@Override
	public ContextBuilder visitDeadlockLiteral(DeadlockLiteral literal) {
		requiredClasses.add(LiteralConsts.class);
		return visitLiteral("deadlockLiteral");
	}

	@Override
	public ContextBuilder visitFalseLiteral(FalseLiteral literal) {
		requiredClasses.add(LiteralConsts.class);
		return visitLiteral("falseLiteral");
	}

	@Override
	public ContextBuilder visitTrueLiteral(TrueLiteral literal) {
		requiredClasses.add(LiteralConsts.class);
		return visitLiteral("trueLiteral");
	}

	@Override
	public ContextBuilder visitNaturalNumberLiteral(NaturalNumberLiteral literal) {
		requiredClasses.add(NaturalNumberLiteral.class);
		return visitLiteral("naturalNumberLiteral")
				.put("naturalNumber", literal.getValue().toString());
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
