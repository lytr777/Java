public class LinkedQueue extends AbstractQueue{

    private static class Node {
        Object value;
        Node prev, next;
        public Node(Node prev, Object value, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
        public Node() {
        }
    }

    private Node head, tail;
    private int size;

    public void enqueue(Object element) {
        assert element != null;
        size++;
        Node old = tail;
        Node newNode = new Node(tail, element, null);
        tail = newNode;
        if (old == null) {
            head = newNode;
        }
        else {
            old.next = newNode;
        }
    }

    public Object element() {
        assert size > 0;
        return head.value;
    }

    public Object dequeue() {
        assert size > 0;
        size--;
        Object result = head.value;
        Node next = head.next;
        head = head.next;
        if (next == null)
            tail = null;
        else
            head.prev = null;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public Object toArray() {
        Node result = head;
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = result.value;
            result = result.next;
        }
        return array;
    }
}
