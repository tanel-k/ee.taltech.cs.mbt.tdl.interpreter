package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectUtils;
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
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.DeclarationListToSExprTransformer;

public class StatementTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements IStatementVisitor<SExpressionSequenceNode> {
		@Override
		public SExpressionSequenceNode visitReturnStatement(ReturnStatement stmt) {
			SExpressionSequenceNode returnedExprSeq = null;
			if (stmt.getExpression() != null) {
				returnedExprSeq = (SExpressionSequenceNode) new ExpressionTransformer().transform(stmt.getExpression());
			}
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("RETURNSTMT"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild(ObjectUtils.defaultObject(returnedExprSeq, SExpressionSequenceNode::new))
					);
		}

		@Override
		public SExpressionSequenceNode visitExpressionStatement(ExpressionStatement stmt) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("EXPRSTMT"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(stmt.getExpression()))
					);
		}

		@Override
		public SExpressionSequenceNode visitEmptyStatement(EmptyStatement stmt) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("EMPTYSTMT"));
		}

		@Override
		public SExpressionSequenceNode visitConditionalStatement(ConditionalStatement stmt) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("IFSTMT"))
					.addChild(
							new SExpressionSequenceNode()
								.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(stmt.getCondition()))
								.addChild(stmt.getPrimaryStatement().accept(this))
								.addChild(stmt.getAlternativeStatement() != null
										? stmt.getAlternativeStatement().accept(this)
										: new SExpressionSequenceNode())
					);
		}

		@Override
		public SExpressionSequenceNode visitBlockStatement(StatementBlock stmt) {
			SExpressionSequenceNode stmtSeqNode = new SExpressionSequenceNode();
			for (AbsStatement nestedStmt : stmt.getStatements()) {
				stmtSeqNode.addChild(nestedStmt.accept(this));
			}
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("BLOCKSTMT"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild((SExpressionSequenceNode) new DeclarationListToSExprTransformer().transform(stmt.getDeclarations()))
									.addChild(stmtSeqNode)
					);
		}

		@Override
		public SExpressionSequenceNode visitWhileStatement(WhileLoop stmt) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("WHILESTMT"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(stmt.getCondition()))
									.addChild(stmt.getStatement().accept(this))
					);
		}

		@Override
		public SExpressionSequenceNode visitDoWhileStatement(DoWhileLoop stmt) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("DOWHILESTMT"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(stmt.getCondition()))
									.addChild(stmt.getStatement().accept(this))
					);
		}

		@Override
		public SExpressionSequenceNode visitForStatement(ForLoop stmt) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("FORLOOPSTMT"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(stmt.getInitializer()))
									.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(stmt.getCondition()))
									.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(stmt.getUpdate()))
									.addChild(stmt.getStatement().accept(this))
					);
		}

		@Override
		public SExpressionSequenceNode visitIterationStatement(IterationLoop stmt) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("FORINSTMT"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild(new SExpressionStringNode().setString(stmt.getLoopVariable().toString()))
									.addChild((SExpressionSequenceNode) new BaseTypeTransformer().transform(stmt.getIteratedType()))
									.addChild(stmt.getStatement().accept(this))
					);
		}
	}

	@Override
	public Object transform(Object in) {
		AbsStatement statement = (AbsStatement) in;
		return statement.accept(new TransformerVisitor());
	}
}
