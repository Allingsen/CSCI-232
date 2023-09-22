// Example11-2
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class FindMax_11_2 {
    public static void main(String args[]) throws FileNotFoundException{

        PositiveNumsList pnl = new PositiveNumsList(50);
        File nums = new File("11-2\\nums.txt");

        Scanner in = new Scanner(nums);
        while (in.hasNextInt()) {
            pnl.Add(in.nextInt());
        }
    
        System.out.println("The maximum number is " + pnl.Max());
        pnl.Delete(pnl.Max());
        System.out.println("The maximum number is " + pnl.Max());

        System.out.println("Is 10 in the list? " + pnl.Search(10));
    }
}
