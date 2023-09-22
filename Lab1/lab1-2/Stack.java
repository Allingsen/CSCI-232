//Outlines a stack class using a linked list structure underneath and all its methods.

public class Stack<E> {
    private Node<E> top;
    private int size;

    //Help used from lecture slides
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    //Help used From lecture slides
    public void push(E data) {
        Node<E> old_top = top; //Remebers old top for top.next
        top = new Node<E>(data); 
        top.next = old_top; 
        size++; 
    }

    //Help used from lecture slides
    public E pop() {
        if (size == 0) { //Returns nothing if empty
            return null;
        }
        else {
            Node<E> oldTop = top; 
            top = top.next; 
            size--; 
            return(oldTop.data); 
        }
    }

    //Goes through the stack using its size and prints out the current data
    public void printStack() {
        Node<E> cur = top; 
        for (int i = 0; i < this.size; i++) { 
            System.out.print(cur.data + " ");
            cur = cur.next; 
        }
        System.out.println(); //Prints a blank line for spacing
    }
}
