// Describes the Linked List class and all its methods


// taken from Algorithms, 4th edition by Sedgewick and Wayne
// Linked List taken from Example 13-0, modified by me
public class LinkedList<E>{
//Linked List and Node generics will always be the same
    private Node<E> head;  
    private Node<E> cur;

    private static class Node<E> {
        private E item; //Generic class for whatever is stored in the node
        private Node<E> next;

        public Node(E item) {
            // item is left in for clarity -- I found it confusing to use uppercase E and lowercase e 
            this.item = item; 
            this.next = null;
        }
    }

    // All of these methods (to insert) from 13-0
    public LinkedList() {
        head = null;
        cur = head;
    }

    public E getCurData() {
        if (cur != null) {
            return cur.item;
        }
        else {
            return null;
        } 
    }
        
    public boolean nextData() {
        if (cur != null) {
            cur = cur.next;
        }
        return (cur != null); // false means no next data to move to
                              // in other words, at end of list
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(E item) {
        Node<E> oldhead = head;
        head = new Node<E>(item);
        head.next = oldhead;
        cur = head;
    }

    //Uses the nextData method in a while loop to check what is at the end of the list
    public void atEndOfList() {
        Node<E> end = cur;
        while (nextData() != false) { //This checks if there is data after cur
            cur = cur.next;
            end = cur;
        }
        System.out.println(end.item + " is at the end of the list");
    }

    //Moves cur to the head
    public void goToHead() {
        cur = head;             //Sets the cur to the head and cur.next to the next value
        cur.next = head.next;
    }

    //Deletes whatever cur is from the list
    public void delete() {
        Node<E> toBeDeleted = cur;
        goToHead(); //Brings cur to the head
        if (toBeDeleted == head) {
            head = cur.next;    //Removes the old head and sets cur to the new one
            cur = head;
        }
        else {
            while (cur.next != toBeDeleted) {
                cur = cur.next;
            }
            cur.next = toBeDeleted.next;    //Sets the Node previous to cur .next value to be toBeDeleted.next, essentially deleting it from the list
            toBeDeleted.next = null;     //Makes sure that toBeDeleted.next is not pointing at anything
        }   
    }

    //Prints the data type of the List
    public void printListDataType() {
        String type = head.item.getClass().getSimpleName(); //This method is from class
        System.out.println("The data type for the data in this linked list is " + type + "\n");
    }

    //Prints out the list starting from the head
    public void printList() {
        goToHead(); //Brings the cur to the front
        System.out.print("List is ");
        while (getCurData() != null) { //Makes sure there is data to print
            System.out.print(getCurData() + " ");
            nextData();
        }
        System.out.println(""); //Prints a blank line for spacing
    }
}
