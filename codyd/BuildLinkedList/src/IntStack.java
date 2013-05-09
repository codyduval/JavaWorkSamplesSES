
public class IntStack {
    public IntListNode firstNode;

    public void push(int value) {
        IntListNode node = new IntListNode();
        node.value = value;
        node.nextNode = firstNode;
        firstNode = node;
    }

    public int pop() {
    	firstNode = firstNode.nextNode;
        return firstNode.value;
    }

    public int size() {
    	IntListNode node = firstNode;
    	int i = 1;
    	while (true) {
        	while (node.nextNode != null) {
        		node = node.nextNode;
        		i++;
        	}
        	return i;
        }
    }
}
