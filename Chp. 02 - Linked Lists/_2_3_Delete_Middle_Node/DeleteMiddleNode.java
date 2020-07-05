// github.com/RodneyShag

package _2_3_Delete_Middle_Node;

import common.Node;

public class DeleteMiddleNode {
    public static boolean deleteMid(Node n) {
    	// this algorithm only works if we are deleting an element that's not the last element.
    	// Otherwise, we can maybe just mark that last element as a "Dummy", according to textbook.
        if (n == null || n.next == null) { 
            return false;                  
        }
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }
}

// Time Complexity: O(1) - simply move the data
