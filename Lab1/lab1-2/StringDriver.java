import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Takes in an infile and adds all data to a stack, then pops the head if an $ is read
public class StringDriver {
    public static void main(String args[]) throws FileNotFoundException{
        
        Stack<String> stringStack = new Stack<String>();
        Scanner stringScanner = new Scanner(new File("lab1-2\\hamlet.txt"));
        
        // Checks if there is a $. If so, pop the head
        while (stringScanner.hasNext()) {
            String data = stringScanner.next();
            if (data.equals("$")) {
                System.out.print(stringStack.pop() + " ");
            }
            else {
                stringStack.push(data);
            }
        }
        System.out.print("\nLeft on Stack: ");
        stringStack.printStack();
    }
}