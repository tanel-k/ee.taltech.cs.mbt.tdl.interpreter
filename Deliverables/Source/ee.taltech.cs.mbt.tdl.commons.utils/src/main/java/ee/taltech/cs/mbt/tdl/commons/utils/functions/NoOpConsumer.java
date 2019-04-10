package ee.taltech.cs.mbt.tdl.commons.utils.functions;

import java.util.function.Consumer;

public class NoOpConsumer implements Consumer<Object> {
	public static NoOpConsumer getInstance() {
		return INSTANCE;
	}

	public static final NoOpConsumer INSTANCE = new NoOpConsumer();

	private NoOpConsumer() { }

	@Override
	public void accept(Object t) { /* Do nothing. */ }
}
