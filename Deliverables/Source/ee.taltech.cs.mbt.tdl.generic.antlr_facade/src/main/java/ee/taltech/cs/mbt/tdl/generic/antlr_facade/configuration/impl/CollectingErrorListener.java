package ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.impl;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base.ErrorListener;

import java.util.Collection;

public class CollectingErrorListener extends ErrorListener {
	private Collection<SyntaxError> errorStrings;

	public CollectingErrorListener(Collection<SyntaxError> errorStrings) {
		this.errorStrings = errorStrings;
	}

	@Override
	public void registerSyntaxError(SyntaxError error) {
		errorStrings.add(error);
	}
}
