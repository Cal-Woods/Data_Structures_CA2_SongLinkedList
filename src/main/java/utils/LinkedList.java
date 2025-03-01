package utils;

import java.util.NoSuchElementException;

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

    /**
     * States a boolean to say if instance is empty.
     * 
     * @return boolean true if this instance has a count of 0 elements
     */
    public boolean isEmpty() {
        //Returning boolean result of stating below statement
        return this.numElements == 0;
    }

    /**
     * Gets the last element's Song in instance LinkedList.
     * 
     * @return The last element's data Song object
     */
    public Song tail() {
        //Check if this.last is null
        if(this.last == null) throw new NoSuchElementException("This list's 'last' element does NOT exist. this method 'tail()' will NOT work in this case.");

        return this.last.data;
    }

    /**
     * Adds a new element to end of instance list.
     * @param data A new Song object
     * 
     * 
     * 
     * @throws IllegalArgumentException by internal class If Song object is null.
     */
    public void add(Song data) {
        //Validation - None required as Node constructor checks for null data

        //Declare a Node object to store data & possibly previous object
        Node insert = new Node(data);

        //Check if first is null, then 
        if(this.first == null) {
            //Set first to insert
            this.first = insert;
            //Set last to insert as list has no elements
            this.last = insert;
        }
        //Otherwise, first is NOT null
        else {
            //Set insert.prev to this.last
            insert.prev = this.last;
            
            //Set insert.next to insert
            insert.next = insert;

            //Set last to insert
            this.last = insert;
        }

        //Increment numElements by 1
        this.numElements++;
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
