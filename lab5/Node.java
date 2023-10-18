

public class Node<K, V> {
   
    private K key;
    private V value;
    private Node<K, V> left_child;
    private Node<K, V> right_child;
    
    public Node(K key, V value) {
    this.key = key;
    this.value = value;
    this.left_child = null;
    this.right_child = null;
    }

    // getters
    public K key() {
        return this.key;
    }

    public V value() {
        return this.value;
    }

    public Node<K, V> left_child() {
        return this.left_child;
    }

    public Node<K, V> right_child() {
        return this.right_child;
    }

    // Setters
    public void set_left_child(Node<K, V> lc) {
        this.left_child = lc;
    }

    public void set_right_child(Node<K, V> rc) {
        this.right_child = rc;
    }

    public void set_value(V val) {
        this.value = val;
    }
}
