package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;

public interface ITrapsetQuantifierVisitor<T> {
	T visitExistential(ExistentialQuantificationNode quantifier);
	T visitUniversal(UniversalQuantificationNode quantifier);
}
