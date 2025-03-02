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
}