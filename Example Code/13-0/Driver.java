import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Driver {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("13-0\\in.txt");
        Scanner in = new Scanner(file);

        LinkedList<String> ll = new LinkedList<String>();

        int i = 0;
        while(in.hasNext()){
           ll.insert(in.next());
        }
        System.out.print("List is ");
        while (ll.getCurData() != null) {
            System.out.print(ll.getCurData() + " ");
            if (ll.nextData() == false) {
                break;
            }
            
        } 
    }
}
