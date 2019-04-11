package ee.taltech.cs.mbt.tdl.commons.utils.operations;

import java.util.LinkedList;
import java.util.Queue;

public class OperationQueue<O extends IOperation<E>, E extends Exception> {
	private Queue<O> queue = new LinkedList<>();

	public void enqueue(O op) {
		queue.add(op);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public boolean hasNext() {
		return !isEmpty();
	}

	public O dequeueNext() {
		return queue.poll();
	}

	public boolean executeNext() throws E {
		if (!hasNext())
			return false;

		O next = dequeueNext();
		next.execute();

		return hasNext();
	}

	public void executeRemaining() throws E {
		boolean hasNext = hasNext();
		while (hasNext)
			hasNext = executeNext();
	}
}
