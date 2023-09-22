import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolTable_Created<K extends Comparable<K>, V> {
    private Node<K, V> first;
    private Node<K, V> cur;

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {   // Creating a linked list
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public SymbolTable_Created() {
        first = null;
        cur = first;
    }

    //Finds and returns the lowest key
    public K min() {
        K lowest = this.first.key;
        this.cur = first;   //Resets the cur to first
        while (this.cur != null) {
            if (this.cur.key.compareTo(lowest) < 0) {   //Checks if the value is lower than cur
                lowest = this.cur.key; 
            }
            this.cur = this.cur.next;
        }
        V value = get(lowest);  // Gets the value of the lowest key
        System.out.println("The minimum Key:Value pair is " + lowest +":"+ value); 
        return lowest;
    }

    // Find and return the highest key
    public K max() {
        K highest = this.first.key;
        this.cur = first;   //Resets the cur to first
        while (this.cur != null) {
            if (this.cur.key.compareTo(highest) > 0) {  //Checks if the value is higher than cur
                highest = this.cur.key;
            }
            this.cur = this.cur.next;
        }
        V value = get(highest); // Gets the value of the highest key
        System.out.println("The maximum Key:Value pair is " + highest +":"+ value);
        return highest;
    }

    // Deletes the Key:Value pair from the tree
    public void delete(K key) {
        Node<K, V> before = this.cur;
        this.cur = this.first;  // Returns cur to first
        while (this.cur.next != null) {
            if (this.cur.key.compareTo(key) == 0) { //Checks if the keys are the same
                before.next = this.cur.next;    // Removes it from the list and breaks out of the loop
                this.cur.next = null;
                return;
            }
            before = this.cur;
            this.cur = this.cur.next;
        }
    }

    // Takes in a key and returns its associated value
    public V get(K key) {
        this.cur = this.first;    // Resets cur back to head
        if (this.cur == null) { // Checks if the list is empty
            return null;
        }
        while (this.cur.next != null) {
            if (this.cur.key.compareTo(key) == 0) { // If the key is the one provided, return the value
                return(this.cur.value);
            }
            this.cur = this.cur.next;
        }
        return null;    // Returns null if the key is not in the table
    }

    public void put(K key, V value) {
        if (get(key) == null) { //If the key is not in the list, add it at the head
            Node<K, V> old_head = this.first;
            this.first = new Node<K, V>(key, value);
            this.first.next = old_head;
        }
        else {  //Changes current value to the correct one 
            this.cur.value = value;
        }
    }

    // Prints out all values in the table
    public void printTable() {
        this.cur = first;
        while (this.cur.next != null) {
            System.out.print(this.cur.key + ":" + this.cur.value + " ");
            this.cur = this.cur.next;
        }
        System.out.println(""); // For spacing
    }

    public static void main(String args[]) throws FileNotFoundException{

        SymbolTable_Created<Integer, Integer> test_tree = new SymbolTable_Created<Integer, Integer>();
        Scanner in = new Scanner(new File("lab3-1\\lab3in.txt"));

        while(in.hasNextInt()) {
            int key = in.nextInt();
            int val = in.nextInt();
            test_tree.put(key, val);
        }

        Integer key = 5;
        Integer search = test_tree.get(key);
        if (search != null) {
            System.out.println("The value "+ key + " was found! Value: " + search);
        }
        if (search.equals(null) == false) {
            test_tree.delete(5);
        }
                
        test_tree.printTable();
        test_tree.min();
        test_tree.max();
    }
}
