public class DoublyLinkedList<T> implements List<T> {
	private Node head, tail;
	private int numberOfElements;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		numberOfElements = 0;
	}
	
	@Override
	public void addLast(T item) {
		if(this.numberOfElements == 0) {
			Node newNode = new Node(item, null, null);
			this.head = newNode;
			this.tail = newNode;
			this.numberOfElements += 1;
		} else {
			Node newNode = new Node(item, null, this.tail);
			this.tail.next = newNode;
			this.tail = newNode;
			this.numberOfElements += 1;
		}
			
	}

	@Override
	public void addFirst(T item) {
		if(this.numberOfElements == 0) {
			Node newNode = new Node(item, null, null);
			this.head = newNode;
			this.tail = newNode;
			this.numberOfElements += 1;
		} else {
			Node newNode = new Node(item, this.head, null);
			this.head.previous = newNode;
			this.head = newNode;
			this.numberOfElements += 1;
		}	
	}

	@Override
	public T get(int position) {
		// TODO
		if(position < 0 || position >= this.numberOfElements) {
			return null;
		} else {
			Node currentNode = this.head;
			for(int i = 1; i <= position; i++) {
				currentNode = currentNode.next;
			}
			return currentNode.data;
		}
	}

	@Override
	public void print() {
		Node currentNode = this.head;
		if(currentNode == null) {
			System.out.println("[ ]");
		} else {
			String result = "[" + currentNode.data + ", ";
			while(currentNode.next != null) {
				currentNode = currentNode.next;
				result = result + currentNode.data + ", ";
			}
			System.out.println(result.substring(0, result.length() - 2) + "]");
		}
	}

	@Override
	public void printBackwards() {
		Node currentNode = this.tail;
		if(currentNode == null) {
			System.out.println("[ ]");
		} else {
			String result = "[" + currentNode.data + ", ";
			while(currentNode.previous != null) {
				currentNode = currentNode.previous;
				result = result + currentNode.data + ", ";
			}
			System.out.println(result.substring(0, result.length() - 2) + "]");
		}	
	}

	@Override
	public boolean remove(T item) {
		// TODO
		if(this.numberOfElements == 0) {
			return false;
		}
		boolean found = false;
		Node currentNode = this.head;
		if(currentNode.data == item) {
			found = true;
		} else {
			while(currentNode.next != null) {
				currentNode = currentNode.next;
				if(currentNode.data == item) {
					found = true;
					break;
				}
			}
		}
		if(!found) {
			return false;
		} else if(found && this.numberOfElements == 1){
			this.head = null;
			this.tail = null;
			this.numberOfElements -= 1;
			return true;
		} else {
			if(currentNode == this.head) {
				this.head.next.previous = null;
				this.head = this.head.next;
				this.numberOfElements -= 1;
			} else if(currentNode == this.tail) {
				this.tail.previous.next = null;
				this.tail = this.tail.previous;
				this.numberOfElements -= 1;
			} else {
				currentNode.previous.next = currentNode.next;
				currentNode.next.previous = currentNode.previous;
				this.numberOfElements -= 1;
			}
			return true;
		}
	}

	@Override
	public boolean isEmpty() {
		if(this.numberOfElements == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getLength() {
		return this.numberOfElements;
	}
	
	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next, previous;

		private Node(T data) {
			this(data,null,null);
		}

		private Node (T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.previous = prev;
		}
	}
}