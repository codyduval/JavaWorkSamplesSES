
public class CreateLinkedList {

	public NodeCreate head;
	
	public void addNode(int payload) {
		if (head == null) {
			head = new NodeCreate();
			head.payload = payload;	
		}
		else {
			NodeCreate node = head;
			while (node != null && node.payload != payload) {
				if (node.nextNode == null) {
					NodeCreate followingNode = new NodeCreate();
					node.payload = payload;
					node.nextNode = followingNode;
				}
			}
			node = node.nextNode;
		}
	}
}
