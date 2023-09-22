import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Creates a driver to collect data from an infile and put it in a linked list, then prints it out. The head is then removed,
// and it is printed again.
public class Lab_Driver {
    public static void main(String args[]) throws FileNotFoundException{
        
        //Double Driver
        Scanner inNumsFile = new Scanner(new File("Lab1-1\\dnums.txt"));
        LinkedList<Double> numsLinkedList = new LinkedList<Double>();

        // Used 13-0 code for reference (Gets the data from the file)
        while (inNumsFile.hasNextDouble()) {
            numsLinkedList.insert(inNumsFile.nextDouble());
        }

        //Prints out the data type of the list
        numsLinkedList.printListDataType();
        
        //Loops through the list and deletes the head until it is empty
        while(numsLinkedList.isEmpty() != true) {
            numsLinkedList.printList();
            numsLinkedList.goToHead();
            numsLinkedList.delete();
        }

        //Adds an open line for readability
        System.out.println("");


        //String Driver
        Scanner inStrFile = new Scanner(new File("Lab1-1\\strings.txt"));
        LinkedList<String> strLinkedList = new LinkedList<String>();

        // Used 13-0 code for reference (Gets the data from the file)
        while (inStrFile.hasNext()) {
            strLinkedList.insert(inStrFile.next());
        }

        //Prints out the data type of the list
        strLinkedList.printListDataType();
        
        //Loops through the list and deletes the head until it is empty
        while(strLinkedList.isEmpty() != true) {
            strLinkedList.printList();
            strLinkedList.goToHead();
            strLinkedList.delete();
        }
        
    }
}