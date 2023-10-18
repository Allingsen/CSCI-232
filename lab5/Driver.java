

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException{
        
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();

        // Creates a scanner and sets up the loc value
        Scanner in = new Scanner(new File("lab4in.txt"));
        int loc = 1;

        while(in.hasNext()) {
            String key = in.next();
            int val = loc * 5;  // value is location * 5, per assignment 
            loc+=1;
            bst.put(key, val);
        }
        
        System.out.print("In-order Traversal: ");
        bst.printQueue(bst.inOrder());

        System.out.print("Pre-order Traversal: ");
        bst.printQueue(bst.preOrder());
        
        System.out.print("Post-order Traversal: ");
        bst.printQueue(bst.postOrder());
        
        System.out.print("Level-order Traversal: ");
        bst.printQueue(bst.levelOrder());
    }
}
