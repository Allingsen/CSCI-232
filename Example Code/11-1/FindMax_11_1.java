// Example 11-1
import java.util.Scanner;

/** 
* The FindMax program finds the maximum integer in a list of integers
*
* @author Mary Ann Cummings 
*/

public class FindMax_11_1 {

 /** 
 * This is the main (and only) method in this
 * program.  It will perform the following tasks.
 * Create a scanner object to read from the console.
 * Read each number and place them in an array of integers.
 * Search through the list (from the first element to the last,
 *    comparing each the current maximum number found.
 * Print the maximum number.
 *
 * @param args Unused.
 */

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        // Initialize our max variable to zero
        int max = 0;  // max holds the largest number in the list
        int[] nums = new int[50];  // used array for list
        int i = 0;

        // read in our list of numbers
        while (in.hasNextInt()) {      
            nums[i] = in.nextInt();
            // only add positive numbers to the list
            if (nums[i] >= 0) {
                ++i;
            }
        }   
        // Compare each number in our list (array) to our current
        // max number
        int num_ints = i;
        for (i = 0; i < num_ints; ++i) {
            // if our current number in the list is larger
            // than our current max, change our max numbers
            if (max < nums[i]) {
                max = nums[i];
            }
        }
    
        System.out.println("The maximum number is " + max);
    }
}
