package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.contexts;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.access.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.arithmetic.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.binary.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PostfixDecrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PostfixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PrefixDecrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid.PrefixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals.KeywordLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.*;
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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.visitation.IExpressionVisitor;

import java.util.Map;

public class TestGenerator implements IExpressionVisitor<Map<String, Object>> {
	@Override
	public Map<String, Object> visitArrayLookup(ArrayLookupExpression arrayLookup) {
		return null;
	}

	@Override
	public Map<String, Object> visitAddition(AdditionExpression addition) {
		return null;
	}

	@Override
	public Map<String, Object> visitDivision(DivisionExpression division) {
		return null;
	}

	@Override
	public Map<String, Object> visitMaximum(MaximumExpression maximum) {
		return null;
	}

	@Override
	public Map<String, Object> visitMinimum(MinimumExpression minimum) {
		return null;
	}

	@Override
	public Map<String, Object> visitModulo(ModuloExpression modulo) {
		return null;
	}

	@Override
	public Map<String, Object> visitMultiplication(MultiplicationExpression multiplication) {
		return null;
	}

	@Override
	public Map<String, Object> visitAdditiveInverse(AdditiveInverseExpression negative) {
		return null;
	}

	@Override
	public Map<String, Object> visitAdditiveIdentity(AdditiveIdentityExpression positive) {
		return null;
	}

	@Override
	public Map<String, Object> visitSubtraction(SubtractionExpression subtraction) {
		return null;
	}

	@Override
	public Map<String, Object> visitBitwiseAnd(BitwiseAndExpression bitwiseAnd) {
		return null;
	}

	@Override
	public Map<String, Object> visitBitwiseExclusiveOr(BitwiseExclusiveOrExpression bitwiseExclusiveOr) {
		return null;
	}

	@Override
	public Map<String, Object> visitBitwiseOr(BitwiseOrExpression bitwiseOr) {
		return null;
	}

	@Override
	public Map<String, Object> visitLeftShift(LeftShiftExpression leftShift) {
		return null;
	}

	@Override
	public Map<String, Object> visitRightShift(RightShiftExpression rightShift) {
		return null;
	}

	@Override
	public Map<String, Object> visitPostfixDecrement(PostfixDecrementExpression postfixDecrement) {
		return null;
	}

	@Override
	public Map<String, Object> visitPostfixIncrement(PostfixIncrementExpression postfixIncrement) {
		return null;
	}

	@Override
	public Map<String, Object> visitPrefixDecrement(PrefixDecrementExpression prefixDecrement) {
		return null;
	}

	@Override
	public Map<String, Object> visitPrefixIncrement(PrefixIncrementExpression prefixIncrement) {
		return null;
	}

	@Override
	public Map<String, Object> visitKeyword(KeywordLiteral keyword) {
		return null;
	}

	@Override
	public Map<String, Object> visitNaturalNumber(NaturalNumberLiteral number) {
		return null;
	}

	@Override
	public Map<String, Object> visitGroup(GroupedExpression group) {
		return null;
	}

	@Override
	public Map<String, Object> visitAssignment(AssignmentExpression assignment) {
		return null;
	}

	@Override
	public Map<String, Object> visitCall(CallExpression call) {
		return null;
	}

	@Override
	public Map<String, Object> visitIdentifierRef(IdentifierRefExpression identifierRef) {
		return null;
	}

	@Override
	public Map<String, Object> visitIfElse(IfElseExpression ifElseTernary) {
		return null;
	}

	@Override
	public Map<String, Object> visitNegation(NegationExpression negation) {
		return null;
	}

	@Override
	public Map<String, Object> visitEquality(EqualityExpression equality) {
		return null;
	}

	@Override
	public Map<String, Object> visitDisjunction(DisjunctionExpression disjunction) {
		return null;
	}

	@Override
	public Map<String, Object> visitConjunction(ConjunctionExpression conjunction) {
		return null;
	}

	@Override
	public Map<String, Object> visitQuantification(QuantificationExpression quantification) {
		return null;
	}

	@Override
	public Map<String, Object> visitFieldAccess(FieldAccessExpression fieldAccess) {
		return null;
	}

	@Override
	public Map<String, Object> visitGreaterThan(GreaterThanExpression greaterThan) {
		return null;
	}

	@Override
	public Map<String, Object> visitLessThan(LessThanExpression lessThan) {
		return null;
	}

	@Override
	public Map<String, Object> visitGTE(GTEExpression greaterThanOrEqual) {
		return null;
	}

	@Override
	public Map<String, Object> visitLTE(LTEExpression lessThanOrEqual) {
		return null;
	}

	@Override
	public Map<String, Object> visitPhrasalConjunction(PhrasalConjunctionExpression conjunction) {
		return null;
	}

	@Override
	public Map<String, Object> visitPhrasalDisjunction(PhrasalDisjunctionExpression disjunction) {
		return null;
	}

	@Override
	public Map<String, Object> visitPhrasalImplication(PhrasalImplicationExpression implication) {
		return null;
	}

	@Override
	public Map<String, Object> visitPhrasalNegation(PhrasalNegation negation) {
		negation.getChild();
		return null;
	}

	@Override
	public Map<String, Object> visitAssignmentWrapper(AssignmentWrapper assignmentWrapper) {
		return null;
	}

	@Override
	public Map<String, Object> visitInequality(InequalityExpression inequalityExpression) {
		return null;
	}
}
