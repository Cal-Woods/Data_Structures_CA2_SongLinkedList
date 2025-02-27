package utils;

import business.Song;

/**
 *
 * @author michelle contributed by cal woods
 */
public class LinkedList {
    //Attributes
    //Tracker for numElements
    private int numElements;
    
    //Track first Node in my LinkedList
    private Node first;

    //Track last Node in my LinkedList
    private Node last;
    
    //Constructors
    
    /**
     * A constructor that sets instance to default empty LinkedList.
     */
    public LinkedList() {
        //Set attributes
        this.first = null;
        this.last = null;
        this.numElements = 0;
    }

    //'size()' method

    /**
     * Gets current number of elements in instance.
     * 
     * @return number of elements in this instance
     */
    public int size() {
        return this.numElements;
    }

    //Declare private static subclass 'Node' to contain reference to next Node and reference to prev Node
    private static class Node {
        //Attributes of 'Node'
        private Node prev;
        private Node next;
        private Song data;

        //Constructor with Song data
        public Node(Song data) {
            //Validation
            if(data == null) throw new IllegalArgumentException("Given Song data was null. This is NOT allowed here!");
            
            //Initialise attributes
            this.prev = null;
            this.next = null;
            this.data = data;
        }
    }
}
