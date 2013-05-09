import java.util.ArrayList;
import java.util.*;

public class BSTLab {
    public void printAllValues() {
        IntBST bst = new IntBST();
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();

        // Inserts 100 random values
        for (int i = 0; i < 100; i++) {
            int value = (int)(Math.random() * 100.0);
            listOfNumbers.add(value);
        }
        Collections.sort(listOfNumbers);
        System.out.print("All values (sorted): " + listOfNumbers);
        
        
        
        
        //bst.createCircularBST();
       
        //bst.printTree();
        
        int n = (int)(Math.random() * 100.0);
        //bst.printValuesLargerThan(n);
        //System.out.print("\nAll values using dfs (recursion): ");
        //bst.printValuesInOrder();
        System.out.print("\nRecursive binary search for " + n);
        bst.recursiveBinarySearch(listOfNumbers, n);
    }
    
}