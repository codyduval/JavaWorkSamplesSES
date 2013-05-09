public class IntNode {
    private int value;
    private IntNode leftChild;
    private IntNode rightChild;
    private Boolean visited = false;
   
    public IntNode(int value) {
        this.value = value;
        
    }

    public void setVisited(){
    	this.visited = true;
    }
    
    public Boolean getVisited(){
    	return visited;
    }
    
    public int getValue() {
        return value;
    }

    public IntNode getLeftChild() {
        return leftChild;
    }

    public IntNode getRightChild() {
        return rightChild;
    }

    public void setLeftChild(IntNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(IntNode rightChild) {
        this.rightChild = rightChild;
    }
}
