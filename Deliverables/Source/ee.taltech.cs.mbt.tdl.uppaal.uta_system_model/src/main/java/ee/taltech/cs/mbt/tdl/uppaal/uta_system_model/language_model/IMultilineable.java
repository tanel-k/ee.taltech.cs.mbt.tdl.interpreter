package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model;

import java.util.Collection;

public interface IMultilineable<T> {
	Collection<T> decompress();
	IMultilineable<T> compress(T inst);
}
