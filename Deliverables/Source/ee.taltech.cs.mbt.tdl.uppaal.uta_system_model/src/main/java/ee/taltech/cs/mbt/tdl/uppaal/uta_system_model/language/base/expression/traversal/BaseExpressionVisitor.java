package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.access.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.arithmetic.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.binary.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PostfixDecrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PostfixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PrefixDecrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PrefixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals.KeywordLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.DisjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.EqualityExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality.GTEExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality.GreaterThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality.LTEExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality.LessThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.phrasal.PhrasalConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.phrasal.PhrasalDisjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.phrasal.PhrasalImplicationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.phrasal.PhrasalNegation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.quantification.QuantificationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.structural.GroupedExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AssignmentWrapper;

public class BaseExpressionVisitor implements IExpressionVisitor {
	@Override public void visitArrayLookup(ArrayLookupExpression arrayLookup) { }
	@Override public void visitAddition(AdditionExpression addition) { }
	@Override public void visitDivision(DivisionExpression division) { }
	@Override public void visitMaximum(MaximumExpression maximum) { }
	@Override public void visitMinimum(MinimumExpression minimum) { }
	@Override public void visitModulo(ModuloExpression modulo) { }
	@Override public void visitMultiplication(MultiplicationExpression multiplication) { }
	@Override public void visitNegative(NegativeExpression negative) { }
	@Override public void visitPositive(PositiveExpression positive) { }
	@Override public void visitSubtraction(SubtractionExpression subtraction) { }
	@Override public void visitBitwiseAnd(BitwiseAndExpression bitwiseAnd) { }
	@Override public void visitBitwiseExclusiveOr(BitwiseExclusiveOrExpression bitwiseExclusiveOr) { }
	@Override public void visitBitwiseOr(BitwiseOrExpression bitwiseOr) { }
	@Override public void visitLeftShift(LeftShiftExpression leftShift) { }
	@Override public void visitRightShift(RightShiftExpression rightShift) { }
	@Override public void visitPostfixDecrement(PostfixDecrementExpression postfixDecrement) { }
	@Override public void visitPostfixIncrement(PostfixIncrementExpression postfixIncrement) { }
	@Override public void visitPrefixDecrement(PrefixDecrementExpression prefixDecrement) { }
	@Override public void visitPrefixIncrement(PrefixIncrementExpression prefixIncrement) { }
	@Override public void visitKeyword(KeywordLiteral keyword) { }
	@Override public void visitNaturalNumber(NaturalNumberLiteral number) { }
	@Override public void visitGroup(GroupedExpression group) { }
	@Override public void visitAssignment(AssignmentExpression assignment) { }
	@Override public void visitCall(CallExpression call) { }
	@Override public void visitIdentifierRef(IdentifierRefExpression identifierRef) { }
	@Override public void visitIfElse(IfElseExpression ifElseTernary) { }
	@Override public void visitNegation(NegationExpression negation) { }
	@Override public void visitEquality(EqualityExpression equality) { }
	@Override public void visitDisjunction(DisjunctionExpression disjunction) { }
	@Override public void visitConjunction(ConjunctionExpression conjunction) { }
	@Override public void visitQuantification(QuantificationExpression quantification) { }
	@Override public void visitFieldAccess(FieldAccessExpression fieldAccess) { }
	@Override public void visitGreaterThan(GreaterThanExpression greaterThan) { }
	@Override public void visitLessThan(LessThanExpression lessThan) { }
	@Override public void visitGTE(GTEExpression greaterThanOrEqual) { }
	@Override public void visitLTE(LTEExpression lessThanOrEqual) { }
	@Override public void visitPhrasalConjunction(PhrasalConjunctionExpression conjunction) { }
	@Override public void visitPhrasalDisjunction(PhrasalDisjunctionExpression disjunction) { }
	@Override public void visitPhrasalImplication(PhrasalImplicationExpression implication) { }
	@Override public void visitPhrasalNegation(PhrasalNegation negation) { }
	@Override public void visitAssignmentWrapper(AssignmentWrapper assignmentWrapper) { }
}
