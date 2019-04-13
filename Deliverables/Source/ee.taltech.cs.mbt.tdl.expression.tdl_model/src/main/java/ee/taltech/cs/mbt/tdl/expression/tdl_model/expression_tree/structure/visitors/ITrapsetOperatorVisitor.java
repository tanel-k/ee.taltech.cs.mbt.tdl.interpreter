package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_operator.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_operator.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_operator.RelativeComplementNode;

public interface ITrapsetOperatorVisitor<T> {
	T visitAbsoluteComplement(AbsoluteComplementNode operator);
	T visitLinkedPair(LinkedPairNode operator);
	T visitRelativeComplement(RelativeComplementNode operator);
}
