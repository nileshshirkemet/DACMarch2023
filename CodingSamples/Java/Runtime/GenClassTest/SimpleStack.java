//SimpleStack is a generic class with type-parameter E
class SimpleStack<E> {

	//inner member class - a class defined inside another class 
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
}

