package ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.impl;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorListener;

public class NoOpErrorListener extends ErrorListener {
	@Override
	public void registerSyntaxError(SyntaxError error) { /* Do nothing */ }
}
