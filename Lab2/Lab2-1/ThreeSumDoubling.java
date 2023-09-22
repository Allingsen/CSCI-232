// Taken from Algorithms, 4th edition by Segewick and Wayne

public class ThreeSumDoubling {

     private static final int MAXIMUM_INTEGER=1000000;
     
     /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    
    // Creates an array with length a and checks how many 
    public static int count(int[] a) {
        int n = a.length;   // Gets the size of the inputted array
        int count = 0;
        for (int i = 0; i < n; i++) { // Goes through the entire list
            for (int j = i+1; j < n; j++) { // This is the value one spot in front of i 
                for (int k = j+1; k < n; k++) { // This is the value one spot in front of j, or two spots in front of i
                    if (a[i] + a[j] + a[k] == 0) {  // If the values of i, j, and k combined are 0, count + 1
                        count++;
                    }
                }
            }
        }
        return count;
    } 

    // Creates a list of random numbers between -1000000 and 1000000 and uses count to preform the tests, then return the amount of
    // time it took.
    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { // For all elements in the arra
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        StopWatchCPU timer = new StopWatchCPU();
        count(a);
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) { 
        double time = 0.0;
        for (int n = 250; n < 8001; n += n) {   // Starts at 250, then doubles up to 8000 and does the timeTrial function
            time = timeTrial(n);
            System.out.printf("%7d %f\n", n, time);
            
        }
        double running_time_with_n = (time/(8000.0 * 8000.0 * 8000.0)); // Gets the time to preform one check
        System.out.println("running time compared with N = " +
                                running_time_with_n + " x N cubed");
        
    } 
    
}
