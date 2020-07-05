package LinkedListConcepts;

import common.Node;

public class LinkedListImpl { 
	
	private ListNode headNode = null;
	private int size = 0;
	
	
	public void addToFront(int data){
		ListNode newNode = new ListNode(data);
		newNode.setNext(headNode);
		headNode = newNode;
		size++;
	}

	public void convertArrayToLinkedList(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.addToFront(array[i]);
        }
    }
	
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return null == headNode;
	}
	
	public void printList(){
		ListNode currentNode = headNode;
		System.out.print(" Head->");
		// End node of list node will point to Null
		while(currentNode != null){ 
			System.out.print(currentNode.getData());
			System.out.print("->");
			currentNode = currentNode.getNext();
		}
		System.out.print("null");
	}
	
	public ListNode removeFromFront(){
		if(isEmpty()){
			return null;
		}
		ListNode removedNode = headNode;
		headNode = headNode.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}
	
	public void appendToTail(int data){
		ListNode newEndNode = new ListNode(data);
		
		if(isEmpty()){
			headNode = newEndNode;
		} else {
			ListNode currentNode = headNode;
			while(currentNode.getNext() != null){
				currentNode = currentNode.getNext(); 
			}
			currentNode.setNext(newEndNode);
		}
		
		size++;
		return;
	}
	
	public ListNode removeFromEnd() {
		if(isEmpty()) {
			return null;
		}
		
		ListNode removedNode = headNode;
		ListNode previousToLastNode = null;
		
		while(removedNode.getNext() != null) {
			previousToLastNode = removedNode;
			removedNode = removedNode.getNext();
		}
		
		previousToLastNode.setNext(null);
		removedNode.setNext(null);
		size--;
		return removedNode;
	}

	public void insertAtPosition(int data, int position) {
		
		ListNode positionNode = new ListNode(data);
		ListNode previousNode = headNode;
	    int count = 1;
	    
	    while(count < position-1) {
            previousNode = previousNode.getNext();
	    	count++;
	    }
		ListNode currentNode = previousNode.getNext();
		previousNode.setNext(positionNode);
		positionNode.setNext(currentNode);
		size++;
	}
	
	public ListNode removeNodeAtPosition(int position) {
		
		if(isEmpty() || size < position) {
			System.out.println("Pleaes check the position of Node you wanted to remove.");
			return null;
		}
		ListNode currentNode = headNode;
		int count = 1;
		
		while(count < position-1) {
			currentNode = currentNode.getNext();
			count++;
		}
		ListNode removedNode = currentNode.getNext();
		currentNode.setNext(removedNode.getNext());
		removedNode.setNext(null);
		return removedNode;
	}
	
	//https://www.youtube.com/watch?v=Ip4y7Inx7QY
	//https://www.youtube.com/watch?v=jY-EUKXYT20&t=9s
	public ListNode reverse(ListNode curr) {
		
		if(curr == null) {
			return null;
		} else if(curr.getNext() == null) {
			return curr;
		} else {
			ListNode nextNode = curr.getNext();
			//curr.getNext() = null;
			ListNode rest = reverse(nextNode);
			nextNode.setNext(curr);
			return rest;
		}
	}
	
	
}
