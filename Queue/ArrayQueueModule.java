public class ArrayQueueModule {
	private static int h, t;
	private static Object[] queue = new Object[20];

	public static void enqueue(Object element) {
		assert element != null;
		ensureCapacity(size() + 1);
		queue[t] = element;
		t = (t + 1) % queue.length;
	}

	public static void push(Object element) {
		assert element != null;
		ensureCapacity(size() + 1);
		if (h > 0)
			queue[--h] = element;
		else {
			h = queue.length - 1;
			queue[h] = element;
		}
	}

	private static void ensureCapacity(int capacity) {
		if (capacity < queue.length)
			return;
		Object[] newQueue = new Object[2 * size()];
		for (int i = 0; i < size(); i++)
			newQueue[i] = queue[(h + i) % queue.length];
		h = 0;
		t = queue.length - 1;
		queue = newQueue;
	}

	public static Object element() {
		assert size() > 0;
		return queue[h];
	}

	public static Object peek() {
		assert size() > 0;
		if (t > 0)
			return queue[t - 1];
		else
			return queue[queue.length - 1];
	}

	public static Object dequeue() {
		assert size() > 0;
		Object first = queue[h];
		queue[h] = null;
		h = (h + 1) % queue.length;
		return first;
	}

	public static Object remove() {
		assert size() > 0;
		Object last;
		if (t > 0) {
			last = queue[--t];
			queue[t] = null;
		}
		else {
			t = queue.length - 1;
			last = queue[t];
			queue[t] = null;
		}
		return last;
	}

	public static void clear() {
		for (int i = 0; i < size(); i++)
			queue[h + i] = null;
		h = 0;
		t = 0;
	}

	public static boolean isEmpty() {
			return size() == 0;
	}

	public static int size() {
		if (t >= h)
			return t - h;
		else
			return queue.length - h + t;
	}

	public static Object toArray() {
		Object[] array = new Object[size()];
		for (int i = 0; i < size(); i++)
			array[i] = queue[(h + i) % queue.length];
		return array;
	}
}