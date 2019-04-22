package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.RelativeComplementNode;

public interface ITrapsetExpressionVisitor<T> {
	T visitAbsoluteComplement(AbsoluteComplementNode node);
	T visitLinkedPair(LinkedPairNode node);
	T visitRelativeComplement(RelativeComplementNode node);
	T visitTrapsetWrapper(TrapsetWrapperNode node);
}
