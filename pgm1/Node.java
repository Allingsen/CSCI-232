
/** 
 *  The node class the holds the Key Value pair of the Country
 *      Used in the Binary Search Tree
*/
public class Node<K , V>  {
    private K key;
    private V value;
    private Node<K, V> left_child;
    private Node<K, V> right_child;

    public Node(K new_cases, V value) {
        this.key = new_cases;
        this.value = value;
        // Both the children start at empty
        this.left_child = null;
        this.right_child = null;
    }

    // Gets the key
    public K getKey() {
        return key;
    }

    // Gets the value
    public V getVal() {
        return value;
    }

    // Gets the Left Child 
    public Node<K, V> getLeftChild() {
        return left_child;
    }

    // Gets the Right Child
    public Node<K, V> getRightChild() {
        return right_child;
    }

    // Sets the Left Child
    public void left_child(Node<K, V> node) {
        this.left_child = node;
    }

    // Sets the Right Child
    public void right_child(Node<K, V> node) {
        this.right_child = node;
    }
}

