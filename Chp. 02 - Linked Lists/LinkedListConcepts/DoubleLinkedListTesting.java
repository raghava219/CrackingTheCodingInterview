package LinkedListConcepts;

public class DoubleLinkedListTesting {

	public static void main(String[] args) {
		
		int data1 = 40;
		int data2 = 7;
		int data3 = 15;
		
 
		
		DoubleLinkedListImpl listObj = new DoubleLinkedListImpl();
                                            		
		System.out.println(" LinkedList is Empty "+listObj.isEmpty());
		
		listObj.addToFront(data1);
		
		listObj.addToFront(data2);
		
		listObj.addToFront(data3);
		
		System.out.println(" LinkedList is Empty "+listObj.isEmpty());
		
		System.out.println(" LinkedList size "+listObj.getSize());
		
		System.out.println(" LinkedList contents ");
		listObj.printList();
		
		listObj.removeFromFront();
		
		System.out.println(" \n After Removal from Front, LinkedList contents ");
		listObj.printList();
		System.out.println(" LinkedList size "+listObj.getSize());
		
		int newDataAtEnd1 = 50;
		int newDataAtEnd2 = 51;
		int newDataAtEnd3 = 52;
		
		int newDataAtEnd4 = 54;
		int newDataAtEnd5 = 55;
		int newDataAtEnd6 = 56;
		listObj.appendToTail(newDataAtEnd1);
		listObj.appendToTail(newDataAtEnd2);
		listObj.appendToTail(newDataAtEnd3);
		listObj.appendToTail(newDataAtEnd4);
		listObj.appendToTail(newDataAtEnd5);
		listObj.appendToTail(newDataAtEnd6);
		
		
		System.out.println(" \n After Adding at End, LinkedList contents ");
		listObj.printList();
		
		System.out.println(" LinkedList size "+listObj.getSize());
		
		listObj.removeFromEnd();
		
		System.out.println(" \n After Removing from End, LinkedList contents ");
		listObj.printList();
		
		System.out.println(" LinkedList size "+listObj.getSize());
		
		int newInsertDataAtEnd4 = 53;
		listObj.insertAtPosition(newInsertDataAtEnd4, 3);

		System.out.println(" \n After Adding at position 3, LinkedList contents ");
		listObj.printList();
		
		listObj.removeNodeAtPosition(5);
		System.out.println(" \n After Removing at position 5, LinkedList contents ");
		listObj.printList();
		
		listObj.reverse(listObj.getHeadNode());
		System.out.println(" \n After Reversing Double Linked List ");
		listObj.printList();
		
		
	}

}
