import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	private Comparator<T> comparator;

	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void add(T data) {
		//if it is the first node being added, add to front
		if (size == 0) {
			super.addToFront(data);
			return;
		}
		
		if (comparator.compare(head.getData(), data) > 0 || comparator.compare(tail.getData(), data) == 0) {
			super.addToFront(data);
			return;
		}
		if (comparator.compare(tail.getData(), data) < 0 || comparator.compare(head.getData(), data) == 0) {
			super.addToEnd(data);
			return;
		}
		
		Node currentNode = head;
		Node temp;
		//loops until it places the node in the right spot
		while (true) {
			if(comparator.compare(currentNode.getData(), data) >= 0)
			{
				temp = new Node(data, currentNode.getPrev(), currentNode);
				//sets next of previous node to temp
				currentNode.getPrev().setNext(temp);
				//sets prev of current node to temp 
				currentNode.setPrev(temp);
				size++;
				break;
			}
			currentNode = currentNode.getNext();
			
		}
		
	}
	
        
	
    
	

	@Override
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return super.getLast();
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return super.getFirst();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}

	@Override
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	@Override
	public T retrieveLastElement() {
		// TODO Auto-generated method stub
		return super.retrieveLastElement();
	}

	@Override
	public T retrieveFirstElement() {
		// TODO Auto-generated method stub
		return super.retrieveFirstElement();
	}

	@Override
	public ArrayList<T> toArrayList() {
		// TODO Auto-generated method stub
		return super.toArrayList();
	}

	@Override
	public BasicDoubleLinkedList<T>.Node remove(T targetData, Comparator<T> comparator) {
		// TODO Auto-generated method stub
		return super.remove(targetData, comparator);

	}

	@Override
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return super.iterator();
	}

}
