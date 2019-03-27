package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.literal.AbsLiteralCtx;

public interface IExpressionCtxVisitor<T> {
	T visitUniversalQuantificationExpr(UniversalQuantificationExprCtx ctx);
	T visitTernaryExpr(TernaryExprCtx ctx);
	T visitSubtractionExpr(SubtractionExprCtx ctx);
	T visitRightShiftExpr(RightShiftExprCtx ctx);
	T visitNegationExpr(NegationExprCtx ctx);
	T visitMultiplicationExpr(MultiplicationExprCtx ctx);
	T visitModuloExpr(ModuloExprCtx ctx);
	T visitMinExpr(MinExprCtx ctx);
	T visitMaxExpr(MaxExprCtx ctx);
	T visitLessThanOrEqualExpr(LessThanOrEqualExprCtx ctx);
	T visitLessThanExpr(LessThanExprCtx ctx);
	T visitLeftShiftExpr(LeftShiftExprCtx ctx);
	T visitInequalityExpr(InequalityExprCtx ctx);
	T visitGroupedExpr(GroupedExprCtx groupedExprCtx);
	T visitGreaterThanOrEqualExpr(GreaterThanOrEqualExprCtx ctx);
	T visitGreaterThanExpr(GreaterThanExprCtx ctx);
	T visitFieldAccessExpr(FieldAccessExprCtx ctx);
	T visitExistentialQuantificationExpr(ExistentialQuantificationExprCtx ctx);
	T visitEqualityExpr(EqualityExrCtx ctx);
	T visitDivisionExpr(DivisionExprCtx ctx);
	T visitDisjunctionExpr(DisjunctionExprCtx ctx);
	T visitConjunctionExpr(ConjunctionExprCtx ctx);
	T visitCallExpr(CallExprCtx ctx);
	T visitBitwiseXorExpr(BitwiseXorExprCtx ctx);
	T visitBitwiseOrExpr(BitwiseOrExprCtx ctx);
	T visitBitwiseAndExpr(BitwiseAndExprCtx ctx);
	T visitAssignmentExpr(AssignmentExprCtx ctx);
	T visitArrayLookupExpr(ArrayLookupExprCtx ctx);
	T visitAdditionExpr(AdditionExprCtx ctx);
	T visitLiteral(AbsLiteralCtx absLiteralCtx);
}
