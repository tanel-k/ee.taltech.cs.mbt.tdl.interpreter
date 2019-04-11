package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;

public class TrapsetDeclaration {
	public static TrapsetDeclaration of(TrapsetSymbolNode trapsetSymbol, VariableDeclaration sourceDeclaration) {
		return new TrapsetDeclaration(trapsetSymbol, sourceDeclaration);
	}

	private TrapsetSymbolNode trapsetSymbol;
	private VariableDeclaration sourceDeclaration;

	public TrapsetSymbolNode getTrapsetSymbol() {
		return trapsetSymbol;
	}

	public VariableDeclaration getSourceDeclaration() {
		return sourceDeclaration;
	}

	private TrapsetDeclaration(TrapsetSymbolNode trapsetSymbol, VariableDeclaration sourceDeclaration) {
		this.trapsetSymbol = trapsetSymbol;
		this.sourceDeclaration = sourceDeclaration;
	}
}
