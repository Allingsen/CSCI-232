// Example11-3
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class FindMax_11_3 {
    public static void main(String args[]) throws FileNotFoundException{

        // now we have a generic class so we have to move
        // some tasks back to main - max, and checking for 
        // number being positive
        MyList<Integer> posnumlist = new MyList<Integer>(50);
        int num;  // temporary holder
        File nums = new File("11-3\\dnums");

        Scanner in = new Scanner(nums);
        while (in.hasNextInt()) {
            num = in.nextInt(); 
            if (num >= 0) {
                posnumlist.Add(num);
            }
        }
    
        posnumlist.Delete(15);

        System.out.println("Is 10 in the list? " + posnumlist.Search(10));

        int max = 0;
        for (int i = 0; i < posnumlist.Size(); i++) {
            num = posnumlist.getElement(i);
            if (num > max) {
                max = num;
            } 
            System.out.println(posnumlist.getElement(i)); 
        }
        System.out.println("The maximum number is " + max);
    }
}
