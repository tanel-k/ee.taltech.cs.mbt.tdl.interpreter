package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type.BaseTypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.IHasPhraseCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsTernaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.DeadlockLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.FalseLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.TrueLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

import java.util.Collection;

public class ExpressionCtxExtractor implements IContextExtractor<AbsExpression>, IExpressionVisitor<ContextBuilder> {
	public static ExpressionCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final ExpressionCtxExtractor INSTANCE = new ExpressionCtxExtractor();

	private ContextBuilder visitTernaryNode(String name, AbsTernaryExprNode expr) {
		return ContextBuilder.newBuilder(name)
				.put("leftChild", expr.getLeftChild().accept(this))
				.put("middleChild", expr.getMiddleChild().accept(this))
				.put("rightChild", expr.getRightChild().accept(this));
	}

	private ContextBuilder visitBinaryNode(String name, AbsBinaryExprNode expr) {
		boolean isAssignment = expr instanceof IHasAssignmentCounterpart
				&& ((IHasAssignmentCounterpart) expr).isAssignment();
		boolean isPhrase = expr instanceof IHasPhraseCounterpart
				&& ((IHasPhraseCounterpart) expr).isPhrase();
		return ContextBuilder.newBuilder(name)
				.put("leftChild", expr.getLeftChild().accept(this))
				.put("rightChild", expr.getRightChild().accept(this))
				.put("assignment", isAssignment)
				.put("phrase", isPhrase);
	}

	private ContextBuilder visitUnaryNode(String name, AbsUnaryExprNode expr) {
		boolean isPhrase = expr instanceof IHasPhraseCounterpart
				&& ((IHasPhraseCounterpart) expr).isPhrase();
		return ContextBuilder.newBuilder(name)
				.put("child", expr.getChild().accept(this))
				.put("phrase", isPhrase);
	}

	private ContextBuilder visitLiteral(String classifier) {
		return ContextBuilder.newBuilder(classifier)
				.put("literal", true);
	}

	private ExpressionCtxExtractor() { }

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
	public ContextBuilder visitImplicationExpr(ImplicationExpression expr) {
		return visitBinaryNode("implication", expr);
	}

	@Override
	public ContextBuilder visitDeadlockLiteral(DeadlockLiteral literal) {
		return visitLiteral("deadlockLiteral");
	}

	@Override
	public ContextBuilder visitFalseLiteral(FalseLiteral literal) {
		return visitLiteral("falseLiteral");
	}

	@Override
	public ContextBuilder visitTrueLiteral(TrueLiteral literal) {
		return visitLiteral("trueLiteral");
	}

	@Override
	public ContextBuilder visitNaturalNumberLiteral(NaturalNumberLiteral literal) {
		return visitLiteral("naturalNumberLiteral")
				.put("naturalNumber", literal.getValue());
	}

	@Override
	public ContextBuilder visitCallExpr(CallExpression expr) {
		Collection<ContextBuilder> argumentCtxs = this.extract(expr.getArguments());
		return visitUnaryNode("call", expr)
				.put("arguments", argumentCtxs);
	}

	@Override
	public ContextBuilder visitIdentifierExpr(IdentifierExpression expr) {
		return ContextBuilder.newBuilder()
				.put("identifier", true)
				.put("identifierValue", expr.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitFieldAccessExpr(FieldAccessExpression expr) {
		return visitUnaryNode("fieldAccess", expr)
				.put("identifierValue", expr.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitQuantificationExpr(QuantificationExpression expr) {
		String classifier = "quantification";
		switch (expr.getQuantificationType()) {
		case EXISTENTIAL:
			classifier = "existentialQuantification";
			break;
		case UNIVERSAL:
			classifier = "universalQuantification";
			break;
		}
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance().extract(expr.getIterationVariableType());
		return visitUnaryNode(classifier, expr)
				.put("baseType", baseTypeCtx)
				.put("identifierValue", expr.getIdentifierName().toString());
	}
}
