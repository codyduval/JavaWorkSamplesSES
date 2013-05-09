// This class stores a linked-list of unique int values
public class IntLinkedList {
    // When a new IntLinkedList is created, Java makes firstNode == null by default
    public IntListNode firstNode;
    int counter = 0;
    // Add the integer, or take no action if it's already in the list
    public void insert(int value) {
        if (firstNode == null) {
            // This was an empty, newly created list, so set the first node and its value
            firstNode = new IntListNode();
            firstNode.value = value;
            incrementCount();
        }
        else {
            // There was a first node, so find the 'terminal' node,
            // which is the node that has a nextNode == null
            IntListNode node = firstNode;
            while (node != null && node.value != value) {
                if (node.nextNode == null) {
                    IntListNode nextNode = new IntListNode();
                    nextNode.value = value;
                    node.nextNode = nextNode;
                    incrementCount();
                }

                node = node.nextNode;
             }
        }
    }

    // TODO: For this Thursday
    public void print() {
        // This should step through each node
        // and print out the value in each, from first to last
        // Order for the print-out of list containing 1, 2, 3, 4, 5, 6: "1 2 3 4 5 6"
        IntListNode node = firstNode;
        System.out.println("There are " + showCount() + " numbers in the list.");
        while (true) {
        	if (node==null) {
        		System.out.print("Empty list!");
        		break;
        	}
        	System.out.print(" " + node.value);
        	if (node.nextNode != null) {
        		node = node.nextNode;
        	}
        	else {
        		break;
        	}
        }
    }

    // TODO: For next Tuesday
    public void remove(int value) {
        // Remove the node that contains this value from the list
        // If no such node exists in the list, no action should be taken
    	IntListNode node = firstNode;
    	IntListNode previousNode = firstNode;
    	while(node != null) {
    		if (node == previousNode && node.value == value){
    			firstNode = node.nextNode;
    			node.nextNode = null;
    			decrementCount();
    			break;
    		}
	    	if (node != null && node.value == value) {
	    		previousNode.nextNode = node.nextNode;
	    		node.nextNode = null;
	    		decrementCount();
	    		break;
	    	}
	    	else {
	    		previousNode = node;
	    		if (node.nextNode == null) {
	    			System.out.println("Sorry, I can't find that number in the list!");
	    			System.out.print("The numbers in the list are: ");
	    			break;
	    		}
	    		node = node.nextNode;
	    		
	    	}
    	}
    }

    // TODO: Optional Challenge HW Question for next Tuesday:
    public int showCount() {
    	return counter;
        // This method should return an int with the current count of objects in the list
        // Leave a comment with the Big-O complexity of this method
        // This counter is O(1) in complexity - it fires once every time a number is entered.
    }
    
    public void incrementCount() {
    	counter++;
    }
    
    public void decrementCount() {
    	counter--;
    }

    // TODO: Optional Challenge HW Question for next Tuesday:
    public void reverse() {
    	IntListNode node = firstNode;
    	firstNode = null;
    	while (node != null) {
    		IntListNode temp = node;
    		node = temp.nextNode;
    		temp.nextNode = firstNode;
    		firstNode = temp;
    	}
    	return;
        // This method should completely reverse the linked list
        // Leave a comment with the Big-O complexity of this method
        // (note: extremely popular interview question)
    }
}
