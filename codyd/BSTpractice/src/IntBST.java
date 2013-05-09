import java.util.*;

import org.omg.CORBA.PUBLIC_MEMBER;




public class IntBST {
    private IntNode rootNode;
    ArrayList<Integer> valuesList = new ArrayList<Integer>();

    public void printTree() {
        LinkedList<IntNode> queue = new LinkedList<IntNode>();
        queue.add(rootNode);
        System.out.print("BFS of BST:" );

        while(!queue.isEmpty()) {
            IntNode node = queue.remove();
            node.setVisited();
            System.out.print(node.getValue() + " ");
            if ((node.getLeftChild() != null) && (!node.getLeftChild().getVisited()))
                queue.add(node.getLeftChild());
            if ((node.getRightChild() != null) && (!node.getRightChild().getVisited()))
                queue.add(node.getRightChild());
        }
    }
    
    public void printValuesLargerThan(int n) {
    	LinkedList<IntNode> queue = new LinkedList<IntNode>();
        queue.add(rootNode);
        System.out.print("\nValues greater than " + n + ":");

        while(!queue.isEmpty()) {
            IntNode node = queue.remove();
            if (node.getValue() > n) {
            	valuesList.add(node.getValue());
            }
            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
        for (int i=0; i < valuesList.size(); i++) {
        	System.out.print(" " + valuesList.get(i));
        }
    }
    
    public void inOrderTraversal(IntNode node) {
		if ((node==null) || (node.getVisited())) return;
		node.setVisited();
		inOrderTraversal(node.getLeftChild());
		System.out.print(" " + node.getValue());
		//valuesList.add(node.getValue());
		inOrderTraversal(node.getRightChild());
	}
    
    public void printValuesInOrder() {
    	inOrderTraversal(rootNode);
    }
    

    public void insertValue(int value) {
        if (rootNode == null) {
            rootNode = new IntNode(value);
        }
        else {
            IntNode currentNode = rootNode;

            while (currentNode.getValue() != value) {
                if (value > currentNode.getValue()) { // Right child path
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(new IntNode(value));
                    }
                    currentNode = currentNode.getRightChild();
                }
                else { // Left child path
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(new IntNode(value));
                    }
                    currentNode = currentNode.getLeftChild();
                }
            }
        }
    }
        public void createCircularBST() {
        	rootNode = new IntNode(1);
             IntNode nodeSecond = new IntNode(2);
             IntNode nodeThird = new IntNode(3);
             rootNode.setLeftChild(nodeSecond);
             nodeSecond.setLeftChild(nodeThird);
             nodeThird.setLeftChild(rootNode);
       
    }
        
        public void recursiveBinarySearch(List<Integer> listOfNumbers, int n) {
        	List<Integer> halfOfList = new ArrayList<Integer>();
        	int midPoint = (listOfNumbers.size()/2);
        	int endPoint = (listOfNumbers.size()-1);
        	if ((listOfNumbers.get(midPoint) == n) || (listOfNumbers.get(endPoint) == n)) {
        		System.out.print("\n***I found " + n + "!");
        		return;
        	}
        	
        	if ((endPoint <= 1) || (midPoint <= 0)) {
        		System.out.print("\nI can't find "+ n + ". I don't think it's in the list.");
        		return;
        	}
        	

        	else if (listOfNumbers.get(midPoint) > n) {
        		halfOfList = listOfNumbers.subList(0,midPoint);
        	}
        	else if (listOfNumbers.get(midPoint) < n) {
        		halfOfList = listOfNumbers.subList(midPoint, endPoint);
        		
        	}
        	recursiveBinarySearch(halfOfList,n);
        }
}