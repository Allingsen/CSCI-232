

// Used in the ordering functions
import java.util.LinkedList;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node<K, V> root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Client-side put
    public void put(K key, V value) {
        Node<K, V> node = new Node<K,V>(key, value);    //Creates a new node
        root = put(this.root, node);   // Calls the private function
    }

    // Inserts the given node in the tree
    // This was coded with heavy help from the book
    private Node<K,V> put(Node<K,V> root, Node<K, V> node) { // Root is probably not a great name for this
        if (root == null) { //If you are at where the place is null, put the node
            return node;    //Returns the node to break out after the node has been inserted
        }
        int compare = node.key().compareTo(root.key()); // Checks whether you should go right or left

        if (compare < 0) {
            root.set_left_child(put(root.left_child(), node));    // Goes left
        }
        else if (compare > 0) {
            root.set_right_child(put(root.right_child(), node));  // Goes right
        }
        else {
            root.set_value(node.value());    // Keys are the same, so change the value
        }
        return root;    // Returns the root, fully set up with children (The fully set up tree)
    }

    //PRIVATE TRAVERSALS

    // Help from Geeks for Geeks
    // Traverses the tree from the far left sub-tree across
    private void inOrder(Node<K, V> node, LinkedList<Node<K, V>> queue) {
        if (node == null) {
            return;
        }
        inOrder(node.left_child(), queue);
        queue.add(node);
        inOrder(node.right_child(), queue);
    }

    // Modified inOrder
    // Traverses the tree, starting from the root and going down the left subtrees
    private void preOrder(Node<K, V> node, LinkedList<Node<K, V>> queue) {
        if (node == null) {
            return;
        }
        queue.add(node);
        preOrder(node.left_child(), queue);
        preOrder(node.right_child(), queue);
    }

    // Modified inOrder
    // Traverses the tree starting with the lowest, left-most node, and putting the lowest node next
    private void postOrder(Node<K, V> node, LinkedList<Node<K, V>> queue) {
        if (node == null) {
            return;
        }
        postOrder(node.left_child(), queue);
        postOrder(node.right_child(), queue);
        queue.add(node);
    }

    // Used in Level order
    // Help used from Geeks for Geeks, modified to work with a queue instead of directly printing
    private void levelOrder(Node<K, V> node, int level, LinkedList<Node<K, V>> queue)   //Adds the values at whatever level to the queue
    {
        if (node == null)   //returns if at the bottom of the tree
            return;
        if (level == 1)
            queue.add(node);    //Adds to the queue if at the highest level not already added
        else if (level > 1) {
            levelOrder(node.left_child(), level - 1, queue);
            levelOrder(node.right_child(), level - 1, queue);
        }
    }

    // Used in level order
    // Help used from Geeks for Geeks
    private int height(Node<K,V> node) {    //Finds the height of the given node. 
        if (node == null) {
            return 0;   // No height if the tree is empty, or at bottom of the tree
        }
        int l_height = height(node.left_child()); //Goes to the next left child down
        int r_height = height(node.right_child());    //Goes to the next right child down
        
        if (l_height > r_height) {
            return l_height + 1;    //adds 1 to the left height
        }
        else {
            return r_height+1;  //adds 1 to the right height
        }
    }

    //PUBLIC TRAVERSALS
    public LinkedList<Node<K,V>> inOrder() {
        LinkedList<Node<K, V>> queue = new LinkedList<Node<K,V>>();
        inOrder(this.root, queue);
        return queue;
    }

    public LinkedList<Node<K,V>> preOrder() {
        LinkedList<Node<K, V>> queue = new LinkedList<Node<K,V>>();
        preOrder(this.root, queue);
        return queue;
    }

    public LinkedList<Node<K,V>> postOrder() {
        LinkedList<Node<K, V>> queue = new LinkedList<Node<K,V>>();
        postOrder(this.root, queue);
        return queue;
    }

    public LinkedList<Node<K, V>> levelOrder() {
        LinkedList<Node<K, V>> queue = new LinkedList<Node<K,V>>();
        int height = height(this.root);
        for (int i = 0; i <= height; i++) {
            levelOrder(this.root, i, queue);
        }
        return queue;
    }

    // Iterates through, prints, and finally clears the queue
    public void printQueue(LinkedList<Node<K,V>> queue) {
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i).key() +":" + queue.get(i).value() + " ");
        }
        queue.clear();
        System.out.println();
    }
}