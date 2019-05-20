package ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.impl;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.base.ErrorListener;

import java.util.Collection;

public class CollectingErrorListener extends ErrorListener {
	private Collection<SyntaxError> syntaxErrors;

	public CollectingErrorListener(Collection<SyntaxError> syntaxErrors) {
		this.syntaxErrors = syntaxErrors;
	}

	@Override
	public void registerSyntaxError(SyntaxError error) {
		syntaxErrors.add(error);
	}
}
