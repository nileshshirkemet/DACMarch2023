import java.util.Iterator;

class SimpleStack<E> implements Iterable<E> {

	class Node {
		E element;
		Node below;

		Node(E item) {
			element = item;
			below = top;
		}
	}

	private Node top;

	public void push(E item) {
		top = new Node(item);
	}

	public E pop() {
		E item = top.element;
		top = top.below;
		return item;
	}

	public boolean empty() {
		return top == null;
	}

	public Iterator<E> iterator() {
		//instantiating an inner local anonymous class which implements 
		//the Iterator iterface
		return new Iterator<E>(){
			
			Node current = top;

			public boolean hasNext() {
				return current != null;
			}

			public E next() {
				E item = current.element;
				current = current.below;
				return item;
			}
		};
	}
}

