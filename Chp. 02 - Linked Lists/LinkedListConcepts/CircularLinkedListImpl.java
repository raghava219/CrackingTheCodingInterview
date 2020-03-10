package LinkedListConcepts;

public class CircularLinkedListImpl { 
	
	private CLLNode lastNode = null;
	private int size = 0;
	
	public void createCircularLinkedList() {
		CLLNode first = new CLLNode(1);
		CLLNode second = new CLLNode(5);
		CLLNode third = new CLLNode(10);
		CLLNode fourth = new CLLNode(15);
		
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		fourth.setNext(first);
		
		lastNode = fourth;
		
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return null == lastNode;
	}
	
	public void printList(){
		if(lastNode == null) {
			return;
		}
		CLLNode firstNode = lastNode.getNext();
		System.out.print(" Head->");
		// End node of list node will point to Null
		while(firstNode != lastNode){ 
			System.out.print(firstNode.getData());
			System.out.print("->");
			firstNode = firstNode.getNext();
		}
		System.out.print(firstNode.getData());
	}
	
	//https://youtu.be/uKsMwAl8Yi8
	public void addToFront(int data){
		CLLNode nodeToInsert = new CLLNode(data);

		if(lastNode == null) {
			lastNode = nodeToInsert;
		} else {
			nodeToInsert.setNext(lastNode.getNext());
		}
        lastNode.setNext(nodeToInsert);
		size++;
	}

	//https://www.youtube.com/watch?v=XtkXUcn8IH8
	public CLLNode removeFromFront(){
		if(isEmpty()){
			return null;
		}
		CLLNode removedNode = lastNode.getNext();
		if(lastNode.getNext() == lastNode) {
			lastNode = null;
		} else {
			lastNode.setNext(removedNode.getNext());
		}
		removedNode.setNext(null);
		size--;
		return removedNode;
	}
	
	//https://www.youtube.com/watch?v=PGvXsUew2IM
	public void appendToTail(int data){
		CLLNode newEndNode = new CLLNode(data);
		
		if(null == lastNode){
			lastNode = newEndNode;
			lastNode.setNext(lastNode);
		} else {
			newEndNode.setNext(lastNode.getNext());
			lastNode.setNext(newEndNode.getNext());
			lastNode = newEndNode;
		}
		size++;
		return;
	}
	
	
	public CLLNode removeFromEnd() {
		if(isEmpty()) {
			return null;
		}
		CLLNode removedNode = lastNode;
		CLLNode nextToLastNode = null;
		nextToLastNode = lastNode.getNext();
		lastNode = nextToLastNode;
		removedNode.setNext(null);
		size--;
		return removedNode;
	}

	public void insertAtPosition(int data, int position) {
		
		CLLNode positionNode = new CLLNode(data);
		CLLNode previousNode = lastNode;
	    int count = 1;
	    
	    while(count < position-1) {
            previousNode = previousNode.getNext();
	    	count++;
	    }
	    CLLNode currentNode = previousNode.getNext();
		previousNode.setNext(positionNode);
		positionNode.setNext(currentNode);
		size++;
	}
	
	public CLLNode removeNodeAtPosition(int position) {
		
		if(isEmpty() || size < position) {
			System.out.println("Pleaes check the position of Node you wanted to remove.");
			return null;
		}
		CLLNode previousNode = lastNode;
		int count = 1;
		
		while(count < position-1) {
			previousNode = previousNode.getNext();
			count++;
		}
		CLLNode removedNode = previousNode.getNext();
		previousNode.setNext(removedNode.getNext());
		removedNode.setNext(null);
		return removedNode;
	}
	
}
