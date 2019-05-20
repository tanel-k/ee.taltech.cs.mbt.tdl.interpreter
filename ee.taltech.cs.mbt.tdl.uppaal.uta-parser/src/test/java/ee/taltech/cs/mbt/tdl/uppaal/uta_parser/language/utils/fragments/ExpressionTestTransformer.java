package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.AbsSExpressionNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.QuantificationExpression.EQuantificationType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.DeadlockLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.FalseLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.TrueLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

public class ExpressionTestTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements IExpressionVisitor<AbsSExpressionNode> {
		private SExpressionSequenceNode wrap(SExpressionSequenceNode seqNode) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("EXPR"))
					.addChild(seqNode);
		}

		@Override
		public AbsSExpressionNode visitArrayLookupExpr(ArrayLookupExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("[]"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitAdditionExpr(AdditionExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("+"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitDivisionExpr(DivisionExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("/"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitMaximumExpr(MaximumExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(">?"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitMinimumExpr(MinimumExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("<?"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitModuloExpr(ModuloExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("%"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitMultiplicationExpr(MultiplicationExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("*"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitAdditiveInverseExpr(AdditiveInverseExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("+EXPR"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitAdditiveIdentityExpr(AdditiveIdentityExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("-EXPR"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitSubtractionExpr(SubtractionExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("-"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitBitwiseAndExpr(BitwiseAndExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("&"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitBitwiseXorExpr(BitwiseXorExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("^"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitBitwiseOrExpr(BitwiseOrExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("|"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitLeftShiftExpr(LeftShiftExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("<<"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitRightShiftExpr(RightShiftExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(">>"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitPostfixDecrementExpr(PostfixDecrementExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("EXPR--"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitPostfixIncrementExpr(PostfixIncrementExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("EXPR++"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitPrefixDecrementExpr(PrefixDecrementExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("--EXPR"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitPrefixIncrementExpr(PrefixIncrementExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("++EXPR"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitAssignmentExpr(AssignmentExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("="))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitCallExpr(CallExpression expr) {
			SExpressionSequenceNode arguments = new SExpressionSequenceNode();
			for (AbsExpression argument : expr.getArguments()) {
				arguments.addChild(argument.accept(this));
			}
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("CALL"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
							.addChild(arguments)
					)
			);
		}

		@Override
		public AbsSExpressionNode visitGroupExpr(GroupedExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("()"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitTernaryExpr(TernaryExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("?:"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getMiddleChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitNegationExpr(NegationExpression expr) {
			String op = expr.isPhrase() ? "not" : "!";
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(op))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitEqualityExpr(EqualityExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("=="))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitDisjunctionExpr(DisjunctionExpression expr) {
			String op = expr.isPhrase() ? "or" : "||";
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(op))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitConjunctionExpr(ConjunctionExpression expr) {
			String op = expr.isPhrase() ? "and" : "&&";
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(op))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitFieldAccessExpr(FieldAccessExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("."))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(expr.getIdentifier().toString()))
							.addChild(expr.getChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitGreaterThanExpr(GreaterThanExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(">"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitLessThanExpr(LessThanExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("<"))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitGreaterThanOrEqualExpr(GreaterThanOrEqualExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(">="))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitLessThanOrEqualExpr(LessThanOrEqualExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("<="))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitInequalityExpr(InequalityExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("!="))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitImplicationExpr(ImplicationExpression expr) {
			String op = expr.isPhrase() ? "implies" : "->";
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(op))
					.addChild(new SExpressionSequenceNode()
							.addChild(expr.getLeftChild().accept(this))
							.addChild(expr.getRightChild().accept(this))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitQuantificationExpr(QuantificationExpression expr) {
			EQuantificationType type = expr.getQuantificationType();
			String op = type == EQuantificationType.EXISTENTIAL ? "exists" : "forall";
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString(op))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(expr.getIdentifierName().toString()))
							.addChild(((SExpressionSequenceNode) new TypeTestTransformer().transform(expr.getIterationVariableType())))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitIdentifierExpr(IdentifierExpression expr) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("ID"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(expr.getIdentifier().toString()))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitDeadlockLiteral(DeadlockLiteral literal) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("LITERAL"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString("DEADLOCK"))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitFalseLiteral(FalseLiteral literal) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("LITERAL"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString("FALSE"))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitTrueLiteral(TrueLiteral literal) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("LITERAL"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString("TRUE"))
					)
			);
		}

		@Override
		public AbsSExpressionNode visitNaturalNumberLiteral(NaturalNumberLiteral literal) {
			return wrap(new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("LITERAL"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(literal.getValue().toString()))
					)
			);
		}
	}

	@Override
	public Object transform(Object in) {
		AbsExpression expression = (AbsExpression) in;
		return expression.accept(new TransformerVisitor());
	}
}
