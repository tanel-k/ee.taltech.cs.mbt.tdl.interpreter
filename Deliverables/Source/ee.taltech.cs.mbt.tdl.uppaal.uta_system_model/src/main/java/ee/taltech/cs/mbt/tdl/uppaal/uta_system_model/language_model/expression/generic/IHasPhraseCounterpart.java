package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic;

public interface IHasPhraseCounterpart {
	boolean isPhrase();
	IHasPhraseCounterpart setPhrase(boolean phrase);
}
