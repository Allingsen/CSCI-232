@SuppressWarnings("unchecked")  // This removes the warnings for creating generic arrays

// Creates the MinPQ class that holds the top three cases by country. (Key value pair)
public class MinPQ<K extends Comparable<K>, V> {
    private K[] kQueue;
    private V[] vQueue;
    private int size;

    public MinPQ() {
        // Initilizes the Key array and the value array to size 1
        kQueue = (K[]) (new Comparable[1]);
        vQueue = (V[]) (new Object[1]);
        size = 0;
    }

    // Returns the size
    public int size() {
        return size;
    }

    // Gets the key using the provided index
    public K getKey(int i) {
        for (int j = 0; j < size; j++) {
            if (j == i) return kQueue[j];
        }
        return null;
    }

    // Gets the value using the provided index
    public V getValue(int i) {
        for (int j = 0; j < size; j++) {
            if (j == i) return vQueue[j];
        }
        return null;
    }

    // Inserts the key value pair into their respective arrays
    public void insert(Node<K, V> node) {
        K key = node.getKey();
        V value = node.getVal();
        for (int i = 0; i < size; i++) {    // Checks if the key (number of cases) is already in the minPQ. If so, leaves the first
            if (kQueue[i] != null && kQueue[i].compareTo(key) == 0) {
                return;
            }
        }
        upsize();
        kQueue[size -1] = key;  // Adds the key and value to their arrays
        vQueue[size -1] = value;
    }

    // Resizes the array to (size+1)
    private void upsize() {
        K[] nKQueue = (K[]) (new Comparable[size + 1]); // Creates two temp arrays that have one extra space
        V[] nVQueue = (V[]) (new Object[size + 1]);
        for (int i = 0; i < size; i++) {    // Adds the data from the old queue to the temp one
            nKQueue[i] = kQueue[i];
            nVQueue[i] = vQueue[i];
        }
        size++; // Increases the size
        kQueue = nKQueue;   // Sets the old, standard array to the temp one
        vQueue = nVQueue;
    }

    // Deletes the minimum Key value pair from the array (Using the key)
    public void delMin() {
        int smallest = 0;
        int compare;
        for (int i = size - 1; i > 0 ; i--) {   // Checks every value to find the smallest
            compare = kQueue[i].compareTo(kQueue[smallest]);
            if (compare <= 0) {
                smallest = i;
            }
        }
        kQueue[smallest] = null;    // Sets the smallest key value pair to null
        vQueue[smallest] = null;
        downsize();
    }

    //  Resizes the array to size-1
    private void downsize() {
        K[] nKQueue = (K[]) (new Comparable[size + 1]); // Creates two temp arrays
        V[] nVQueue = (V[]) (new Object[size + 1]);
        int j = 0;
        if (kQueue[size-1] == null) {    // If the last 4th element is null, make a new 
            for (int i = 0; i < size-1; i++) {  // queue without it
                nKQueue[i] = kQueue[i];
                nVQueue[i] = vQueue[i];
            }
            kQueue = nKQueue;
            vQueue = nVQueue;
            size--;
            return;
        }
        for (int i = 0; i < size; i++) {    // Brings the old data to the temp array
            if (kQueue[i] == null) {    //If the data is null, dont add it to the array
                nKQueue[j] = kQueue[i+1];
                nVQueue[j] = vQueue[i+1];
                j++;
                i++;
            }
            else{   //Copy of the data to the new, temp array
                nKQueue[j] = kQueue[i];
                nVQueue[j] = vQueue[i];
                j++;
            }
        }
        size--; //Reduce the size
        kQueue = nKQueue;   // Make the temp queues the standard queues
        vQueue = nVQueue;
    }

    // Removes all the elements from the MinPQ
    public void clearQueue() {
        K[] nKQueue = (K[]) (new Comparable[1]);    //Creates two empty temp queues
        V[] nVQueue = (V[]) (new Object[1]);
        size = 0;   // Resets the size
        kQueue = nKQueue;   //Makes the empty temp queues the standard queues
        vQueue = nVQueue;
    }
}