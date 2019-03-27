package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public abstract class AbsBinaryExprCtx extends AbsExpressionCtx {
	private AbsExpressionCtx leftChild;
	private AbsExpressionCtx rightChild;

	public AbsExpressionCtx getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(AbsExpressionCtx leftChild) {
		this.leftChild = leftChild;
	}

	public AbsExpressionCtx getRightChild() {
		return rightChild;
	}

	public void setRightChild(AbsExpressionCtx rightChild) {
		this.rightChild = rightChild;
	}
}
