public class ArrayQueueADT {
	private int h, t;
	private Object[] queue = new Object[20];

	public static void enqueue(ArrayQueueADT queue, Object element) {
		assert element != null;
		ensureCapacity(queue, size(queue) + 1);
		queue.queue[queue.t] = element;
		queue.t = (queue.t + 1) % queue.queue.length;
	}

	public static void push(ArrayQueueADT queue, Object element) {
		assert element != null;
		ensureCapacity(queue, size(queue) + 1);
		if (queue.h > 0)
			queue.queue[--queue.h] = element;
		else {
			queue.h = queue.queue.length - 1;
			queue.queue[queue.h] = element;
		}
	}

	private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
		if (capacity < queue.queue.length)
			return;
		Object[] newQueue = new Object[2 * size(queue)];
		for (int i = 0; i < size(queue); i++)
			newQueue[i] = queue.queue[(queue.h + i) % queue.queue.length];
		queue.h = 0;
		queue.t = queue.queue.length - 1;
		queue.queue = newQueue;
	}

	public static Object element(ArrayQueueADT queue) {
		assert size(queue) > 0;
		return queue.queue[queue.h];
	}

	public static Object peek(ArrayQueueADT queue) {
		assert size(queue) > 0;
		if (queue.t > 0)
			return queue.queue[queue.t - 1];
		else
			return queue.queue[queue.queue.length - 1];
	}

	public static Object dequeue(ArrayQueueADT queue) {
		assert size(queue) > 0;
		Object first = queue.queue[queue.h];
		queue.queue[queue.h] = null;
		queue.h = (queue.h + 1) % queue.queue.length;
		return first;
	}

	public static Object remove(ArrayQueueADT queue) {
		assert size(queue) > 0;
		Object last;
		if (queue.t > 0) {
			last = queue.queue[--queue.t];
			queue.queue[queue.t] = null;
		}
		else {
			queue.t = queue.queue.length - 1;
			last = queue.queue[queue.t];
			queue.queue[queue.t] = null;
		}
		return last;
	}

	public static void clear(ArrayQueueADT queue) {
		for (int i = 0; i < size(queue); i++)
			queue.queue[queue.h + i] = null;
		queue.h = 0;
		queue.t = 0;
	}

	public static boolean isEmpty(ArrayQueueADT queue) {
			return size(queue) == 0;
	}

	public static int size(ArrayQueueADT queue) {
		if (queue.t >= queue.h)
			return queue.t - queue.h;
		else
			return queue.queue.length - queue.h + queue.t;
	}

		public static Object toArray(ArrayQueueADT queue) {
		Object[] array = new Object[size(queue)];
		for (int i = 0; i < size(queue); i++)
			array[i] = queue.queue[(queue.h + i) % queue.queue.length];
		return array;
	}
}