package LinkedListConcepts;

public class DoubleLinkedListImpl { 
	
	private DLLNode headNode = null;
    private DLLNode tailNode = null;
	private int size = 0;
	
	
	public DLLNode getHeadNode() {
		return headNode;
	}

	public void setHeadNode(DLLNode headNode) {
		this.headNode = headNode;
	}

	public DLLNode getTailNode() {
		return tailNode;
	}

	public void setTailNode(DLLNode tailNode) {
		this.tailNode = tailNode;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void addToFront(int data){
		DLLNode newNode = new DLLNode(data);
		newNode.setNext(headNode);
		if(headNode == null){
			tailNode = newNode;
		} else {
			headNode.setPrevious(newNode);
		}
		headNode = newNode;
		size++;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return null == headNode;
	}
	
	public void printList(){
		DLLNode currentNode = headNode;
		System.out.print(" Head->");
		// End node of list node will point to Null
		while(currentNode!=null){ 
			System.out.print(currentNode.getData());
			System.out.print("->");
			currentNode = currentNode.getNext();
		}
		System.out.print("null");
	}
	
	public DLLNode removeFromFront(){
		if(isEmpty()){
			return null;
		}
		DLLNode removedNode = headNode;
		if(headNode.getNext() == null){
			tailNode = null;
		} else {
			headNode.getNext().setPrevious(null);
		}
		headNode = headNode.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}
	
	public void appendToTail(int data){
		DLLNode newNode = new DLLNode(data);
		if(tailNode == null){
			headNode = newNode;
		} else {
			tailNode.setNext(newNode);
			newNode.setPrevious(tailNode);
		}
		tailNode = newNode;
		size++;
	}
	
	public DLLNode removeFromEnd() {
		if(isEmpty()) {
			return null;
		}
		
		DLLNode removedNode = tailNode;
		DLLNode previousToLastNode = tailNode.getPrevious();
		
		previousToLastNode.setNext(null);
		removedNode.setNext(null);
		size--;
		return removedNode;
	}

	public void insertAtPosition(int data, int position) {
		
	    DLLNode positionNode = new DLLNode(data);
		DLLNode previousNode = headNode;
	    int count = 0;
	    
	    while(count < position-1) {
            previousNode = previousNode.getNext();
	    	count++;
	    }
		DLLNode currentNode = previousNode.getNext();
		previousNode.setNext(positionNode);
		positionNode.setNext(currentNode);
		size++;
	}
	
	
	//https://www.youtube.com/watch?v=2RwWsHePdr8&t=50s
	public DLLNode removeNodeAtPosition(int position) {
		
		if(isEmpty() || size < position) {
			System.out.println("Pleaes check the position of Node you wanted to remove.");
			return null;
		}
		DLLNode previousNode = headNode;
		int count = 0;
		
		while(count < position-1) {
			previousNode = previousNode.getNext();
			count++;
		}
		DLLNode removedNode = previousNode.getNext();
		previousNode.setNext(removedNode.getNext());
		removedNode.setNext(null);
		return removedNode;
	}
	
	public DLLNode reverse(DLLNode head) {
		if (head == null) {
			return null;
		}
		
		DLLNode current_node = head;
		DLLNode new_head = head;
		
		while (current_node != null) {
			
			DLLNode prev = current_node.getPrevious();
			
			current_node.setPrevious(current_node.getNext());
			current_node.setNext(prev);
			
			new_head = current_node;
			
			current_node =  current_node.getPrevious();
		}
		
		return new_head;
	}
	
	
}
