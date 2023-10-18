import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    /** Creates the Driver (Main) class that creates a MinPQ and BST
     * to add the specified countries top three days in terms of most
     * cases to the Binary search tree, then prints it to a file.
     * 
     * @param args (not used)
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Creates the needed structures
        Scanner in = new Scanner(new File("owid-covid-data.csv"));
        MinPQ<Integer, String> queue = new MinPQ<Integer, String>();  
        BST<Integer, String> tree = new BST<Integer, String>();

        String prev_country = "Afghanistan";    //First country is Afganistan, this will get updated immediately
        in.nextLine();  // Skips the First line

        while (in.hasNextLine()) {
            String[] arr = in.nextLine().split(",");    //Splits the CSV
            String value = arr[1] + "/" + arr[0] + " on " + arr[2] + " Total: " + Long.parseLong(arr[3]) + " Pop: " + Long.parseLong(arr[5]);   //Creates the value in the correct format
            Node<Integer, String> node = new Node<Integer, String>(Integer.parseInt(arr[4]), value);    //Creates a Node with the Key value pair
            String country_name = arr[1];   // Sets the current country name
            if (country_name.equals(prev_country)) {    //Checks to see if the country was the same as last (Used for keeping MinPQ of each country)
                queue.insert(node);
                if (queue.size() > 3) { // If there are more than three data points in the MinPQ, Delete the lowest
                    queue.delMin();
                } 
            }
            else {
                for (int i = 0; i < queue.size(); i++) {    // If we are on a different country, add all the elements in the minPQ to the tree
                    Node<Integer, String> tNode = new Node<Integer, String>(queue.getKey(i), queue.getValue(i));
                    tree.insert(tNode);    // Inserts the created node into the tee
                }
                queue.clearQueue(); // Clears the queue
                queue.insert(node); // Inserts the new element into the empty queue
            }
            prev_country = country_name;   // Updates the prev country name
        }

        for (int i = 0; i < queue.size(); i++) {    //Same as before, except specifically for Zimbabwe
            Node<Integer, String> tNode = new Node<Integer, String>(queue.getKey(i), queue.getValue(i));
            tree.insert(tNode);
        } 
        Printer p = new Printer(tree);  // Creates the printer object and prints to the output file
        p.printTree("output.txt");
    }
}