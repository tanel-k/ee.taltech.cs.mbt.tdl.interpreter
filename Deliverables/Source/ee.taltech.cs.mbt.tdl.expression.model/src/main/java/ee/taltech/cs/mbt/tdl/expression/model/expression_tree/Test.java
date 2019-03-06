package ee.taltech.cs.mbt.tdl.expression.model.expression_tree;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.leaf.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.BaseExpressionTreeVisitor;

public class Test {
	public static void main(String... args) {
		ExpressionTree tree = new ExpressionTree();
		TrapsetSymbolNode trA = new TrapsetSymbolNode("A");
		TrapsetSymbolNode trB = new TrapsetSymbolNode("B");
		TrapsetSymbolNode trC = new TrapsetSymbolNode("C");
		TrapsetSymbolNode trD = new TrapsetSymbolNode("D");
		RelativeComplementNode rc = new RelativeComplementNode();
		rc.setFirstOperand(trA);
		rc.setSecondOperand(trB);
		LinkedPairNode lp = new LinkedPairNode();
		lp.setFirstOperand(trC);
		lp.setSecondOperand(trD);
		UniversalQuantificationNode uq = new UniversalQuantificationNode();
		uq.setOperand(lp);
		ExistentialQuantificationNode eq = new ExistentialQuantificationNode();
		eq.setOperand(rc);
		LeadsToBoundedNode leadsTo = new LeadsToBoundedNode();
		leadsTo.setFirstOperand(uq);
		leadsTo.setSecondOperand(eq);
		tree.setRootNode(leadsTo);

		BaseExpressionTreeVisitor visitor = new BaseExpressionTreeVisitor() {
			@Override
			public void visitLeadsToBoundedNode(LeadsToBoundedNode leadsToBoundedNode) {
				System.out.println("leadsToBounded");
				visitChildren(leadsToBoundedNode);
			}

			@Override
			public void visitUniversalQuantificationNode(UniversalQuantificationNode universalQuantificationNode) {
				System.out.println("uni quantify");
				visitChildren(universalQuantificationNode);
			}

			@Override
			public void visitExistentialQuantificationNode(ExistentialQuantificationNode existentialQuantificationNode) {
				System.out.println("ex quantify");
				visitChildren(existentialQuantificationNode);
			}

			@Override
			public void visitLinkedPairNode(LinkedPairNode linkedPairNode) {
				System.out.println("linked pair");
				visitChildren(linkedPairNode);
			}

			@Override
			public void visitRelativeComplementNode(RelativeComplementNode relativeComplementNode) {
				System.out.println("relative complement");
				visitChildren(relativeComplementNode);
			}

			@Override
			public void visitTrapsetSymbolNode(TrapsetSymbolNode trapsetSymbolNode) {
				System.out.println(trapsetSymbolNode.getSymbol());
			}
		};

		visitor.visitTree(tree);
	}
}
