package utils;

import org.junit.jupiter.api.Test;

import business.Song;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michelle contributed by cal woods
 */
public class LinkedListExtraTests {

    public LinkedListExtraTests() {
    }

    //Cal's code from here

    /**
     * Tests adding one element to a list is at the correct index
     */
    @Test
    public void testAddOneValidElementToBlankListIsThereWithGetPos0() {
        LinkedList list = new LinkedList();

        list.add(new Song("Eminem", "Lose Yourself"));

        Song expected = new Song("Eminem", "Lose Yourself");
        Song actual = list.get(0);

        assertEquals(expected, actual);
    }

    /**
     * Tests that adding a null Song object throws an IllegalArgumentException.
     */
    @Test
    public void testAddOneInvalidElementToBlankListThrowsIllegalArgumentException() {
        LinkedList list = new LinkedList();

        assertThrows(IllegalArgumentException.class, () -> {
            list.add(null);
        });
    }

    /**
     * Tests that more than one added element are in the correct places.
     */
    @Test
    public void testAddMoreThanOneValidElementIsSuccessfullyAddedInCorrectPlaces() {
        LinkedList list = new LinkedList();

        list.add(new Song("Eminem", "Sing for The Moment"));
        list.add(new Song("Frank Sinatra", "My Way"));

        Song expected1 = new Song("Eminem", "Sing for The Moment"), expected2 = new Song("Frank Sinatra", "My Way");
        Song actual1 = list.get(0), actual2 = list.get(1);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
}