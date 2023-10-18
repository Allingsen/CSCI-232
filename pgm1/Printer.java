import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/* Creates the printer object, which will print the data to a file
 * 
 */
public class Printer {
    
    private Node<Integer, String> root;

    public Printer(BST<Integer, String> tree) {
        // Grabs the entire tree, then takes the root
        this.root = tree.getRoot();
    }

    // Places the nodes into a queue using inOrder Traversal (Taken from lab 4)
    private void inOrder(Node<Integer, String> node, LinkedList<String> queue) {
        if (node == null) { //Base case
            return;
        }
        inOrder(node.getLeftChild(), queue);    //Goes left first
        queue.add("New cases: " + node.getKey() + " at " + node.getVal());  // Adds the bottom of the left tree first in proper format
        inOrder(node.getRightChild(), queue);   // Goes right
    }

    // Prints to the file provided as a parameter
    public void printTree(String file_name) throws IOException{
        LinkedList<String> list = new LinkedList<String>();
        FileWriter output = new FileWriter(file_name);
        inOrder(root, list);    // Puts the nodes in order
        for (int i = 0; i < list.size(); i++) { //Iterate through the queue and prints the value to the file
            output.write(list.get(i) +  "\n");
        }
        output.close(); //Closes the writer
    }

}
