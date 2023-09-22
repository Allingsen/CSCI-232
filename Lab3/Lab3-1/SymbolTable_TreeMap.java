import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolTable_TreeMap<K, V> {

    private TreeMap<K,V> tree_map = new TreeMap<K,V>();
    
    public void min() {
        if (tree_map.firstKey() == null) {
            System.out.println("The list is empty");
        }
        else {
            System.out.println("The minimum Key:Value pair is " + tree_map.firstKey() + ":" + tree_map.get(tree_map.firstKey()));
        }
    }

    public void max() {
        if (tree_map.lastKey() == null) {
            System.out.println("The list is empty");
        }
        else {
            System.out.println("The maximum Key:Value pair is " + tree_map.lastKey() + ":" + tree_map.get(tree_map.lastKey()));
        }
    }

    public void delete(K key) {
        tree_map.remove(key);
    }

    public V get(K key) {
        if (tree_map.get(key) == null) {
            System.out.println("The key is not in the symbol table.");
            return null;
        }
        else {
            System.out.println("The key " + key + " was found! Value: " + tree_map.get(key));
            return tree_map.get(key);
        }
    }

    public void put(K key, V value) {
        tree_map.put(key, value);
    }

    public void printTable() {
        System.out.println(tree_map.entrySet());
    }

    public static void main(String args[]) throws FileNotFoundException{
        
        SymbolTable_TreeMap<Integer, Integer> test_tree = new SymbolTable_TreeMap<Integer, Integer>();
        Scanner in = new Scanner(new File("lab3-1\\lab3in.txt"));

        while(in.hasNextInt()) {
            int key = in.nextInt();
            int val = in.nextInt();
            test_tree.put(key, val);
        }

        Integer search = test_tree.get(5);
        if (search.equals(null) == false) {
            test_tree.delete(5);
        }
                
        test_tree.printTable();
        test_tree.min();
        test_tree.max();
    }
}


