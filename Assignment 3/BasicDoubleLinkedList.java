import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * Creates a Double Linked List using Nodes and has methods that can add Nodes
 * to the front or end. Has 2 inner classes: Node and Iterator.
 * 
 * @author Saad Aulakh
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

	protected int size;
	protected Node head, tail;

	/**
	 * BasicDoubleLinkedList Constructor
	 */
	public BasicDoubleLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	/**
	 * Add data that is entered by the user to the end (tail) of the linked list.
	 * Increment size.
	 * 
	 * @param data - data entered by the user which will be added to the end of the
	 *             list
	 */
	public void addToEnd(T data) {
		Node temp = new Node(data, tail, null);
		if (tail != null) {
			tail.setNext(temp);
			tail = temp;
		} else {
			tail = temp;
			head = tail;
		}
		size++;
	}

	/**
	 * Return the data of the last node or null if there is no data.
	 * 
	 * @return data - data of the tail node
	 * @return null - if tail is null, return null
	 */
	public T getLast() {
		if (tail != null) {
			return tail.getData();
		}
		return null;
	}

	/**
	 * Return the data of the first node or null if there is no data.
	 * 
	 * @return data - data of the head node
	 * @return null - if head is null, return null
	 */
	public T getFirst() {
		if (head != null) {
			return head.getData();
		}
		return null;
	}

	/**
	 * Return the size of the linked list.
	 * 
	 * @return size - size of the list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Add data that is entered by the user to the front (head) of the linked list.
	 * Increment size.
	 * 
	 * @param data - data entered by the user which will be added to the front of
	 *             the list
	 */
	public void addToFront(T data) {
		Node temp = new Node(data, null, head);
		if (head != null) {
			head.setPrev(temp);
			head = temp;
		} else {
			head = temp;
			tail = head;
		}
		size++;
	}

	/**
	 * Remove the last element from the list and return it.
	 * 
	 * @return last - data of the tail node.
	 */
	public T retrieveLastElement() {
		// if tail is null, return null
		if (tail == null) {
			return null;
		}
		T last = tail.getData();

		// if size is only one, set head and tail BOTH to null
		if (size == 1) {
			head = null;
			tail = null;
			return last;
		}

		tail = tail.getPrev();
		tail.setNext(null);
		size--;
		return last;
	}

	/**
	 * Remove the first element from the list and return it.
	 * 
	 * @return last - data of the head node.
	 */
	public T retrieveFirstElement() {
		// if head is null return null
		if (head == null) {
			return null;
		}
		T first = head.getData();
		// if size is only one set head AND tail to null and return 'first'
		if (size == 1) {
			head = null;
			tail = null;
			return first;
		}

		head = head.getNext();
		head.setPrev(null);
		size--;
		return first;
	}

	/**
	 * Put all Nodes into an ArrayList and return the ArrayList.
	 * 
	 * @return list - all the Nodes in an ArrayList
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<>();
		Node current = head;

		while (current != null) {
			list.add(current.data);
			current = current.next;
		}
		return list;
	}

	/*
	  public Node remove(T targetData, Comparator<T> comparator) {
	 
	  Node currentNode = head; while (currentNode != null) { if
	  (comparator.compare(targetData, head.data) == 0) { head = head.getNext();
	 size--; return null; }
	 
	  else if (comparator.compare(targetData, tail.data) == 0) { tail = tail.prev;
	  size--; return null; } else if (comparator.compare(targetData,
	  currentNode.getData()) == 0) { currentNode = currentNode.next; size--; return
	  null; }
	 currentNode = currentNode.getNext(); } return null; }
	 */

	/**
	 * Removes a node that is specified by the user.
	 * 
	 * @param targetData - data that is to be removed
	 * @param comparator - comparator that is used to compare the data with each
	 *                   nodes data
	 * @return null
	 */
	public Node remove(T targetData, Comparator<T> comparator) {

        Node temp = new Node(targetData, null, null);
        

        Node currentNode = head;
        while (currentNode != null) {
            if (comparator.compare(temp.data, currentNode.getData()) == 0) {
            	if (currentNode.getPrev() != null)
            		currentNode.getPrev().setNext(currentNode.getNext());
                if(currentNode.getNext() != null)
                    currentNode.getNext().setPrev(currentNode.getPrev());
                if (comparator.compare(temp.data, head.getData()) == 0) {
                    head = head.getNext();
                    size--;
                    return temp;
                }

                else if (comparator.compare(temp.data, tail.getData()) == 0) {
                    tail = tail.getPrev();
                    size--;
                    return temp;
                }
                size--;
                
                return temp;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

	/**
	 * 
	 * creates an iterator with methods from the inner class
	 * DoubleLinkedListIterator
	 * 
	 * @return A list iterator with the methods from DoubleLinkedListIterator
	 */
	@Override
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DoubleLinkedListIterator();
	}

	/**
	 * Node class which has the attributes prev, next, and data. Used to create
	 * nodes that are put into the linked list.
	 * 
	 * @author Saad Aulakh
	 *
	 */
	protected class Node {
		T data;
		private Node prev;
		private Node next;

		/**
		 * Creates a node that has data for the previous node, next node, and its own
		 * data.
		 * 
		 * @param data - data for the node
		 * @param prev - previous node data
		 * @param next - next node data
		 */
		public Node(T data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		/**
		 * Returns the data of the current node that it is called for.
		 * 
		 * @return data - data of the current node
		 */
		public T getData() {
			return data;
		}

		/**
		 * Returns the data of the node previous of the node that it is called for.
		 * 
		 * @return prev - data of the previous node
		 */

		public Node getPrev() {
			return prev;
		}

		/**
		 * Returns the data of the node next of the node that it is called for.
		 * 
		 * @return next - data of the next node
		 */

		public Node getNext() {
			return next;
		}

		/**
		 * Sets the next for the node it is called for
		 * 
		 * @param next - data for next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * Sets the data for the node it is called for
		 * 
		 * @param data - data for current node
		 */
		public void setData(T data) {
			this.data = data;
		}

		/**
		 * Sets the previous for the node it is called for
		 * 
		 * @param prev - data for previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;
		}

	}

	/**
	 * 
	 * Class for a List Iterator which is used to iterate through the values in the
	 * Linked list.
	 * 
	 * @author Saad Aulakh
	 *
	 */
	protected class DoubleLinkedListIterator implements ListIterator<T> {

		private Node current;
		private Node last;

		DoubleLinkedListIterator() {
			current = head;
			last = null;
		}

		/**
		 *Checks if there is a next node
		 */
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		/**
		 *Iterates forward in the linked list
		 *@throws NoSuchElementException - if there is no previous element
		 */
		@Override
		public T next() throws NoSuchElementException {
			if (hasNext()) {
				last = current;
				current = current.getNext();
				return last.getData();
			}
			throw new NoSuchElementException();
		}

		/**
		 *Checks if there is a previous node
		 */
		@Override
		public boolean hasPrevious() {
			return last != null;
		}

		/**
		 *Iterates backwards in the linked list
		 *@throws NoSuchElementException - if there is no previous element
		 */
		@Override
		public T previous() throws NoSuchElementException {
			if (hasPrevious()) {
				current = last;
				last = last.getPrev();
				return current.getData();
			}
			throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
}
