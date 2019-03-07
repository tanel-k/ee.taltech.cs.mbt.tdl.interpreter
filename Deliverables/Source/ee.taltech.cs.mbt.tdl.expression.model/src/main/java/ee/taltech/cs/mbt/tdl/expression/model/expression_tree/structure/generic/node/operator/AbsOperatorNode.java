package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbsOperatorNode<O extends AbsExpressionNode> extends AbsExpressionNode implements IOperator<O> {
	private int arity;
	private List<O> operandNodes;

	public void setOperand(int ordinal, O operand) {
		if (ordinal >= arity)
			throw new IllegalArgumentException("Attempted to set operand with out of bounds ordinal.");
		this.operandNodes.set(ordinal, operand);
	}

	public O getOperand(int ordinal) {
		if (ordinal >= arity)
			throw new IllegalArgumentException("Attempted to retrieve operand with out of bounds ordinal.");
		return this.operandNodes.get(ordinal);
	}

	public List<O> getOperandNodes() {
		return Collections.unmodifiableList(operandNodes);
	}

	private void init(int arity) {
		this.arity = arity;
		this.operandNodes = new ArrayList<>(Collections.nCopies(this.arity, null));
	}

	protected AbsOperatorNode() {
		/*
		 * Arity contract workaround (hack):
		 * ----------------------------------
		 * Operators can be binary, unary etc.
		 * Clients should not have to infer the arity of a concrete operator implementation - this information
		 * should be encoded in the contract of the implementation.
		 *
		 * However, look at the following approach:
		 *
		 *  abstract class AbsBinaryOperator extends AbsOperatorNode:
		 *      getFirstOperand()
		 *      getSecondOperand()
		 *      ...
		 *  abstract class AbsUnaryOperator extends AbsOperatorNode:
		 *      getOperand()
		 *
		 * It seems straight-forward.
		 *
		 * Now assume that we subclass AbsOperatorNode:
		 *  abstract class AbsLogicalOperatorNode extends AbsOperatorNode:
		 *      ...
		 *  abstract class AbsTrapsetOperatorNode extends AbsOperatorNode:
		 *      ...
		 *
		 * Good but these classes do not have an arity contract. Let's fix it by subclassing the AbsArityOperator classes:
		 *
		 *  abstract class AbsLogicalBinaryOperatorNode extends AbsBinaryOperator:
		 *      ...
		 *  abstract class AbsLogicalUnaryOperatorNode extends AbsUnaryOperator:
		 *      ...
		 *  (ditto for AbsTrapsetOperatorNode)
		 *
		 * But this way we have no AbsLogicalOperatorNode ancestor-class that we could generically reference.
		 * Additionally we need to have Abs{Unary|Binary}{Logical|Trapset|...}Operator subclasses for each arity subclass.
		 * Untenable once the number of Abs...OperatorNode classes grows.
		 *
		 * Another approach:
		 *
		 *  abstract class AbsLogicalOperatorNode extends AbsOperatorNode:
		 *      ...
		 *  abstract class AbsLogicalBinaryOperatorNode extends AbsLogicalOperatorNode, AbsBinaryOperator:
		 *      ...
		 *  abstract class AbsLogicalUnaryOperatorNode extends AbsLogicalOperatorNode, AbsUnaryOperator:
		 *     ...
		 *  (ditto for AbsTrapsetOperatorNode)
		 *
		 * This falls flat because multiple inheritance is not supported in Java.
		 * The solution here is use arity interfaces that provide default implementations for arity contract methods:
		 *
		 *  interface IOperator:
		 *      getOperator(...)
		 *      setOperator(...)
		 *
		 *  interface IBinaryOperator:
		 *      default getFirstOperator():
		 *          return getOperator(...)
		 *      default getSecondOperator():
		 *          return getOperator(...)
		 *
		 *  interface IUnaryOperator:
		 *      default getOperator():
		 *          return getOperator(...)
		 *
		 *  abstract class AbsOperatorNode extends IOperator:
		 *      ...
		 *
		 * The solution allows us to simply extend AbsOperatorNode in our abstract sub-classes.
		 * Concrete classes should use the IBinaryOperator or the IUnaryOperator interface to include an arity contract.
		 *
		 *   abstract class AbsLogicalOperatorNode extends AbsOperatorNode:
		 *       ...
		 *
		 *   class ImplicationNode extends AbsLogicalOperatorNode implements IBinaryOperator:
		 *      ...
		 *
		 * We are simulating multiple inheritance via Java defender methods.
		 * Note that this actually goes against the intended purpose of defenders and interfaces.
		 *
		 * The only problem is that AbsOperatorNode needs to have an initial arity when constructed.
		 * Interfaces cannot fix this easily.
		 * The solution is to define getOperatorArity() in IOperator and provide default impls in I{Binary|Unary}Operator.
		 * Then we can provide a default constructor that lacks the arity argument.
		 */
		init(this.getOperatorArity());
	}

	public AbsOperatorNode(int arity) {
		init(arity);
	}
}
