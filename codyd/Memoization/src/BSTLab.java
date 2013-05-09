public class BSTLab {
    public void printAllValues() {
        IntBST bst = new IntBST();

        // Inserts 100 random values
        for (int i = 0; i < 100; i++) {
            int value = (int)(Math.random() * 100.0);
            bst.insertValue(value);
        }
        
        bst.printTree();
        
        int n = (int)(Math.random() * 100.0);
        bst.printValuesLargerThan(n);
        System.out.print("\nAll values in order using in order traversal (recursion): ");
        bst.printValuesInOrder();
    }

}
