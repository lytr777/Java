//I: size >= 0 && queue[0..size - 1] != null
public class ArrayQueue extends AbstractQueue{
	private int h, t;
	private Object[] queue = new Object[20];

	public void enqueue(Object element) {
		//pre: element != null
		assert element != null;
		ensureCapacity(size() + 1);
		queue[t] = element;
		t = (t + 1) % queue.length;
		//post: queue[size'] = element && size = size' + 1
	}

	public void push(Object element) {
		// pre: element != null
		assert element != null;
		ensureCapacity(size() + 1);
		if (h > 0)
			h--;
		else
			h = queue.length - 1;
		queue[h] = element;
		// post: size == size' + 1 && queue[0] = element && queue[0...size' - 1] = queue[1...size']
	}

	private void ensureCapacity(int capacity) {
		if (capacity < queue.length)
			return;
		Object[] newQueue = new Object[2 * capacity];
		for (int i = 0; i < size(); i++)
			newQueue[i] = queue[(h + i) % queue.length];
		h = 0;
		t = queue.length - 1;
		queue = newQueue;
	}

	public Object element() {
		//pre: size > 0;
		assert size() > 0;
		return queue[h];
		//post result = queue[0]
	}

	public Object peek() {
		//pre: size > 0;
		assert size() > 0;
		if (t > 0)
			return queue[t - 1];
		else
			return queue[queue.length - 1];
		//post result = queue[size - 1]
	}

	public Object dequeue() {
		//pre: size > 0; 
		assert size() > 0;
		Object first = queue[h];
		queue[h] = null;
		h = (h + 1) % queue.length;
		return first;
		//post: size = size' - 1 && result = queue[0] && queue[0...size' - 1] = queue[1...size']
	}

	public Object remove() {
		//pre: size() > 0
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
		//post: size = size' - 1 && result = queue[size]
	}

	public void clear() {
		//pre: true
		for (int i = 0; i < size(); i++)
			queue[h + i] = null;
		h = 0;
		t = 0;
		//post: size = 0;
	}

	public boolean isEmpty() {
		//pre: true
			return size() == 0;
		//post: result = (size == 0);
	}

	public int size() {
		//pre: true;
		if (t >= h)
			return t - h;
		else
			return queue.length - h + t; 
		//result = size;
	}

	public Object toArray() {
		//pre: true;
		Object[] array = new Object[size()];
		for (int i = 0; i < size(); i++)
			array[i] = queue[(h + i) % queue.length];
		return array;
		//post: result = queue;
	}
}