import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinearithmicSort {

    // Gets the data from the file, puts it into an ArrayList and sorts it
    public static ArrayList<Double> toSortedList() throws FileNotFoundException{
        Scanner in = new Scanner(new File("lab2-2\\lab2in.txt"));
        ArrayList<Double> inList = new ArrayList<Double>();

        while (in.hasNextDouble()) {
            inList.add(in.nextDouble());
        }

        // The run time of this is O(N log(N)), via official Mozilla docs.
        // When a list is fully randomized, as it is in the input, the sort preforms as a tradtional merge sort,
        // giving it the big O of O(N log(N)), or linearithmic time
        // (LINK: https://docs.oracle.com/javase/8/docs/api/java/util/List.html#sort-java.util.Comparator-)
        inList.sort(null);

        return(inList);
    }

    // Takes the two numbers next to each other, compares the difference, and saves them if it is the smallest.
    public static void getSmallestDif(ArrayList<Double> inList) {
        double firstNum, lastNum;

        // These are placeholder values; they will always get changed.
        double keptNumFirst = -1;
        double keptNumLast = -1;
        double smallestDif = 1;
        
        for(int i = 0; i < inList.size()-1; i++) {
            firstNum = inList.get(i);
            lastNum = inList.get(i+1);
            
            //Checks if the difference is the smallest so far and keeps it if it is
            if (lastNum - firstNum < smallestDif) {
                smallestDif = lastNum - firstNum;
                keptNumLast  = lastNum;
                keptNumFirst = firstNum;
            }
        }

        System.out.println("The numbers "+ keptNumFirst + " and " + keptNumLast + " are the closest pair with a difference of " + String.format("%,.6f", smallestDif));
    }

    public static void main(String[] args) throws FileNotFoundException{
        
        ArrayList<Double> inList = toSortedList();
        getSmallestDif(inList);

        // The worst-case runtime of this program is linearithmic, or O(N log(N)). This is because the sort algotithim
        // I used has a linearithmic big O, and there is nothing else inside of it. Then the getSmallestDif() function
        // has a O(N) time, so it gets cancelled out as it is a smaller run time.
    }
}
