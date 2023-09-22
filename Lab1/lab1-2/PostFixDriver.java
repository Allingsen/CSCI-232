import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Reads data from an infile and does the postfix eqaution it provides
public class PostFixDriver {
    public static void main(String args[]) throws FileNotFoundException{

        // Creates new stack and scanner
        Stack<Integer> pfStack = new Stack<Integer>();
        Scanner pfScanner = new Scanner(new File("lab1-2\\equation.txt"));

        // Checks if there is data in the file
        while (pfScanner.hasNext()) {
            String data = pfScanner.next();
            int intOne, intTwo, result;

            // These methods do the math of the equation by popping the two values and doing the operation
            if (data.equals("+")) {
                intOne = pfStack.pop();
                intTwo = pfStack.pop();
                result = intOne + intTwo;
                pfStack.push(result);
            }
            else if (data.equals("-")) {
                intOne = pfStack.pop();
                intTwo = pfStack.pop();
                result = intOne - intTwo;
                pfStack.push(result);
            }
            else if (data.equals("/")){
                intOne = pfStack.pop();
                intTwo = pfStack.pop();
                result = intOne / intTwo;
                pfStack.push(result);
            }
            else if (data.equals("*")) {
                intOne = pfStack.pop();
                intTwo = pfStack.pop();
                result = intOne * intTwo;
                pfStack.push(result);
            }
            else {
                pfStack.push(Integer.parseInt(data));
            } 
        }

        // Prints out the value of the equation
        System.out.print("The result of the postfix equation is ");
        pfStack.printStack();

    }
}
