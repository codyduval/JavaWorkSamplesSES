import java.util.*;




public class IntBST {
    private IntNode rootNode;
    ArrayList<Integer> valuesList = new ArrayList<Integer>();

    public void printTree() {
        LinkedList<IntNode> queue = new LinkedList<IntNode>();
        queue.add(rootNode);
        System.out.print("BFS of BST:" );

        while(!queue.isEmpty()) {
            IntNode node = queue.remove();
            System.out.print(node.getValue() + " ");
            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
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
		if (node==null) return;
		inOrderTraversal(node.getLeftChild());
		System.out.print(" " + node.getValue());
		valuesList.add(node.getValue());
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
}
