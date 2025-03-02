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
     * @throws IllegalArgumentException If a duplicate Song object was found in instance.
     */
    public void add(Song data) {
        //Validation - Check if data is duplicate to other values, using private static, internal method 'isDuplicate(LinkedList list, Song data)'
        if(LinkedList.isDuplicate(this, data)) throw new IllegalArgumentException("A duplicate value was found in provided LinkedList, so data cannot be added.");
        
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
            //Set last.prev to last
            this.last.prev = last;

            //Set last & last.next to insert
            this.last.next = insert;
            this.last = insert;
        }

        //Increment numElements by 1
        this.numElements++;
    }

    /**
     * Searches instance for an element with a matching Song object.
     * 
     * @param data A Song object to search for in instance
     * 
     * @return Position of element or -1 if element is NOT there
     */
    public int indexOf(Song data) {
        //Validation
        if(this.first == null) return -1;

        //Declare Node current
        Node current = this.first;
        
        //Initialise for loop to search LinkedList
        for(int i = 0; i < numElements; i++) {
            //Check if current.data is the same as given data
            if(current.data.equals(data)) {
                return i;
            }

            //Move current to next element
            current = current.next;
        }

        return -1;
    }


    public Song get(int index) {
        //Validation
        if(index < 0 || index >= this.numElements) throw new IndexOutOfBoundsException("The given index was less than 0 or greater than the actual size of the instance list, ONLY provide a value between 0 & the maximum number of elements - 1. Use 'size()' method to check.");
        if(this.isEmpty()) return null;
        
        //Declare Node current to track current Node
        Node current = this.first;

        //Initialise for loop to search list until given index
        for (int i = 0; i < index; i++) {
            //Move current to next
            current = current.next;
        }

        //return current element's Song object
        return current.data;
    }


    //Private static method
    private static boolean isDuplicate(LinkedList list,Song data) {
        //Validation - none required

        //Declare current element reference to start at first
        Node current = list.first;

        for (int i = 0; i < list.numElements; i++) {
            //Check if current data in list is equal to given data
            if(current.data.equals(data)) {
                return true;
            }

            //Move current to next
            current = current.next;
        }

        return false;
    }

    //Declare private static subclass 'Node' to contain reference to next Node and reference to prev Node
    /**
     * An internal wrapper class for provided Song objects that are stored in a LinkedList.
     */
    private static class Node {
        //Attributes of 'Node'
        private Node prev;
        private Node next;
        private Song data;

        //Constructor with Song data
        /**
         * Takes a Song data and adds it as data to a new Node.
         * @param data A Song object
         */
        public Node(Song data) {
            //Validation - None required as I am allowing nulls

            //Initialise attributes
            this.prev = null;
            this.next = null;
            this.data = data;
        }
    }
}