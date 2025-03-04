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

        //Tests
        Song expected1 = new Song("Eminem", "Lose Yourself"), actual1 = list.get(0);
        int expected2 = 0, actual2 = list.indexOf(new Song("Eminem", "Lose Yourself"));
        
        //Implement tests
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }

    /**
     * Tests that adding a null Song object to a LinkedList is successful.
     */
    @Test
    public void testAddOneNullElementDataToBlankListIsSuccessful() {
        LinkedList list = new LinkedList();

        list.add(null);

        assertEquals(null, list.get(0));
        assertEquals(0, list.indexOf(null));
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


    @Test
    public void testAddOneElementChangesNumElementsFromZeroToOne() {
        LinkedList list = new LinkedList();

        assertEquals(0, list.size());

        list.add(new Song());
        
        assertEquals(1, list.size());
    }

    @Test
    public void testAddFourElementsChangesNumElementsFromZeroToFour() {
        LinkedList list = new LinkedList();

        assertEquals(0, list.size());

        list.add(new Song());
        list.add(null);
        list.add(new Song("One Republic", "Counting Stars"));
        list.add(new Song("NF", "The Search"));
        
        assertEquals(4, list.size());
    }

    @Test
    public void testAddAllWithNullArrayThrowsIllegalArgumentException() {
        LinkedList list = new LinkedList();

        assertThrows(IllegalArgumentException.class, () -> {
            list.addAll(null);
        });
    }

    @Test
    public void testAddAllWithValidSongArrayThatSizeChangesCorrectly() {
        LinkedList list = new LinkedList();

        list.size();

        assertEquals(0, list.size());

        Song[] data = {new Song("Bruno Mars", "Uptown Funk"), new Song("Kanye West", "Power"), new Song("Akon Ft Eminem", "Smack That"), new Song("Taylor Swift", "Shake It Off")};

        list.addAll(data);

        assertEquals(4, list.size());
    }

    @Test
    public void testAddAllWithArrayWithANullAndOtherSongsAreAllInCorrectPlaces() {
        LinkedList list = new LinkedList();

        Song[] data = {null, new Song("Garth Brooks", "Standing Outside The Fire"), new Song("Billy Ocean", "Love Really Hurts Without You")};

        list.addAll(data);

        //Tests
        assertEquals(null, list.get(0));
        assertEquals(new Song("Garth Brooks", "standing outside the fire"), list.get(1));
        assertEquals(new Song("billy ocean", "love Really hurts wIthout YOU"), list.get(2));
    }
}