
/**
 * A class implementing a Deque using single linked chain
 */

public final class SingleLinkedDeque<T> implements DequeInterface<T> {
	// member variables
	private Node frontNode;
	private Node backNode;
	
	public SingleLinkedDeque() {
		frontNode = null;
		backNode = null;
	}
	
	/** Adds a new entry to the front/back of this dequeue.
	 @param newEntry  An object to be added. */
	public void addToFront(T newEntry) {
		Node newNode = new Node(newEntry, null);
		
		if(isEmpty())
			backNode = newNode;
		else
			frontNode.setNextNode(newNode);
		
		frontNode = newNode;
	}
	
	public void addToBack(T newEntry) {
		Node newNode = new Node(newEntry, null);
		
		if(isEmpty())
			frontNode = newNode;
		else
			backNode.setNextNode(newNode);
		
		backNode = newNode;
	}
	
	/** Removes and returns the front/back entry of this dequeue.
	 @return  The object at the front/back of the dequeue.
	 @throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T removeFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		
		T front = getFront();
		
		frontNode.setData(null);
		frontNode = frontNode.getNextNode();
		
		if(frontNode == null)
			backNode = null;
		
		return front;
	}
	
	public T removeBack() {
		if(isEmpty())
			throw new EmptyQueueException();
		
		T back = getBack();
		
		backNode.setData(null);
		backNode = backNode.getNextNode();
		
		if(backNode == null)
			frontNode = null;
		
		return back;
	}
	
	/** Retrieves the front/back entry of this dequeue.
	 @return  The object at the front/back of the dequeue.
	 @throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		
		return frontNode.getData();
	}
	
	public T getBack() {
		if (isEmpty())
			throw new EmptyQueueException();
		
		return backNode.getData();
	}

	/**  Detects whether this dequeue is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return (frontNode == null && backNode == null);
	}

	/**  Removes all entries from this dequeue. */
	public void clear() {
		frontNode = null;
		backNode = null;
	}
	
	/** Node class */
	private class Node {
		private T data;
		private Node next;
		
		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() {
			return data;
		}
		
		private void setData(T newData) {
			data = newData;
		}
		
		public Node getNextNode() {
			return next;
		}
		
		private void setNextNode(Node newNode) {
			next = newNode;
		}
		
	}
	
}
