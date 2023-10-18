/** Creates the Binary Search Tree (BST) class 
 * Takes everything from the minpq and adds it to its
 * position
 */
public class BST<K extends Comparable<K>, V> {

    private Node<K, V> root;

    public BST() {
        // Initilizes root to by empty (empty tree)
        this.root = null;
    }

    // Gets the root of the tree
    public Node<K, V> getRoot() {
        return this.root;
    }
 
    // Inserts the given node into the tree
    public void insert(Node<K, V> node) {
        root = insert(this.root, node);   // Calls the private function
    }

    // Private function (Taken from lab 5)
    // Takes the key and compares it
    private Node<K, V> insert(Node<K, V> root, Node<K, V> node) { 
        if (root == null) { // Base case
            return node;    
        }
        int compare = node.getKey().compareTo(root.getKey());   //Checks to see if the key equals the key provided

        if (compare < 0) {
            root.left_child(insert(root.getLeftChild(), node));    // Goes left
        }
        else if (compare > 0) {
            root.right_child(insert(root.getRightChild(), node));  // Goes right
        }
        else {} // Do nothing (Leave the current value there)
        return root;    // Returns the root, fully set up with children (The fully set up tree)
    }
}