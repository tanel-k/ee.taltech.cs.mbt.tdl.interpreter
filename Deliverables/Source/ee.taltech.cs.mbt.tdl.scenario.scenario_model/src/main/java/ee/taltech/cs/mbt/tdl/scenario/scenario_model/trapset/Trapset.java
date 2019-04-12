package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.AbsVariableDeclaration;

public class Trapset {
	public static Trapset of(TrapsetSymbolNode trapsetSymbol, AbsVariableDeclaration sourceDeclaration) {
		return new Trapset(trapsetSymbol, sourceDeclaration);
	}

	private TrapsetSymbolNode trapsetSymbol;
	private AbsVariableDeclaration sourceDeclaration;

	public TrapsetSymbolNode getTrapsetSymbol() {
		return trapsetSymbol;
	}

	public AbsVariableDeclaration getSourceDeclaration() {
		return sourceDeclaration;
	}

	private Trapset(TrapsetSymbolNode trapsetSymbol, AbsVariableDeclaration sourceDeclaration) {
		this.trapsetSymbol = trapsetSymbol;
		this.sourceDeclaration = sourceDeclaration;
	}

	@Override
	public String toString() {
		String declStr = sourceDeclaration.toString();
		return getClass().getSimpleName() + "(" + trapsetSymbol + ";" + declStr + ")";
	}
}
