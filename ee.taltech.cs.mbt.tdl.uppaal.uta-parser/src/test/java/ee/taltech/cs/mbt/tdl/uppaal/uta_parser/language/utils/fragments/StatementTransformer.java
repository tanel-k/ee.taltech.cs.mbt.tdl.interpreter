package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ConditionalStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.EmptyStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ReturnStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.DoWhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.ForLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.WhileLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IStatementVisitor;

public class StatementTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements IStatementVisitor<SExpressionSequenceNode> {
		@Override
		public SExpressionSequenceNode visitReturnStatement(ReturnStatement stmt) {
			// TODO
			stmt.getExpression();
			return null;
		}

		@Override
		public SExpressionSequenceNode visitExpressionStatement(ExpressionStatement stmt) {
			// TODO
			stmt.getExpression();
			return null;
		}

		@Override
		public SExpressionSequenceNode visitEmptyStatement(EmptyStatement stmt) {
			// TODO
			return null;
		}

		@Override
		public SExpressionSequenceNode visitConditionalStatement(ConditionalStatement stmt) {
			// TODO
			stmt.getCondition();
			stmt.getPrimaryStatement();
			stmt.getAlternativeStatement();
			return null;
		}

		@Override
		public SExpressionSequenceNode visitBlockStatement(StatementBlock stmt) {
			// TODO
			stmt.getDeclarations();
			stmt.getStatements();
			return null;
		}

		@Override
		public SExpressionSequenceNode visitWhileStatement(WhileLoop stmt) {
			// TODO
			stmt.getCondition();
			stmt.getStatement();
			return null;
		}

		@Override
		public SExpressionSequenceNode visitDoWhileStatement(DoWhileLoop stmt) {
			// TODO
			stmt.getCondition();
			stmt.getStatement();
			return null;
		}

		@Override
		public SExpressionSequenceNode visitForStatement(ForLoop stmt) {
			// TODO
			stmt.getInitializer();
			stmt.getCondition();
			stmt.getUpdate();
			stmt.getStatement();
			return null;
		}

		@Override
		public SExpressionSequenceNode visitIterationStatement(IterationLoop stmt) {
			// TODO
			stmt.getLoopVariable();
			stmt.getIteratedType();
			stmt.getStatement();
			return null;
		}
	}

	@Override
	public Object transform(Object in) {
		AbsStatement statement = (AbsStatement) in;
		return statement.accept(new TransformerVisitor());
	}
}
