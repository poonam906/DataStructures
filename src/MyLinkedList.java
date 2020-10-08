
public class MyLinkedList<T> implements MyList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	private class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E d, Node<E> n) {
			super();
			data = d;
			next = n;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public E getData() {
			return data;
		}
	}

	@Override
	public void append(T data) {
		Node<T> currentNode = new Node<T>(data, null);
		insertLast(currentNode);
		incrementSize();
	}

	private void insertLast(Node<T> currentNode) {
		if (head == null) {
			head = currentNode;
		} else {
			tail.setNext(currentNode);
		}
		tail = currentNode;
	}

	@Override
	public void insert(T data, int index) {
		Node<T> currentNode = new Node<T>(data, null);
		if (index == 0) {
			insertFirst(currentNode);
		} else if (index == getSize()) {
			insertLast(currentNode);
		} else {
			Node<T> prev = findNodeByIndex(index - 1);
			currentNode.setNext(prev.getNext());
			prev.setNext(currentNode);
		}
		incrementSize();
	}

	private Node<T> findNodeByIndex(int index) {
		int cur = 0;
		Node<T> result = head;
		if (index != 0) {
			if (index == getSize() - 1)
				result = tail;
			else {
				while (cur < index) {
					result = result.getNext();
					cur++;
				}
			}
		}
		return result;
	}

	private void insertFirst(Node<T> currentNode) {
		currentNode.setNext(head);
		head = currentNode;
	}

	@Override
	public T remove(int index) {
		T removedData = null;
		if (index == 0) {
			removedData = removeFirst();
		} else if (index == getSize() - 1) {
			removedData = removeLast();
		} else {
			Node<T> prev = findNodeByIndex(index - 1);
			Node<T> removedNode = prev.getNext();
			prev.setNext(removedNode.getNext());
			removedNode.setNext(null);
			removedData = removedNode.getData();
			decrementSize();
		}
		return removedData;
	}

	@Override
	public T removeFirst() {
		if (head == null) {
			throw new IllegalStateException();
		}

		Node<T> removedNode = head;
		if (tail == head) {
			tail = null;
		}
		head = head.getNext();
		decrementSize();

		return removedNode.getData();
	}

	@Override
	public T removeLast() {
		if (tail == null) {
			throw new IllegalStateException();
		}

		Node<T> removedNode = tail;
		tail = findNodeByIndex(getSize() - 2);
		tail.setNext(null);
		decrementSize();

		return removedNode.getData();
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= getSize())
			throw new IllegalArgumentException();
		return findNodeByIndex(index).getData();
	}

	@Override
	public T getFirst() {
		return head.getData();
	}

	@Override
	public T getLast() {
		return tail.getData();
	}

	@Override
	public int getSize() {
		return size;
	}

	private void incrementSize() {
		size = size + 1;
	}

	private void decrementSize() {
		size = size - 1;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[");
		if (head != null) {
			Node<T> cur = head;
			while (cur != tail) {
				result.append(cur.getData().toString());
				result.append(", ");
				cur = cur.getNext();
			}
			result.append(cur.getData());
		}
		result.append("]");
		return super.toString() + result.toString();
	}

}
