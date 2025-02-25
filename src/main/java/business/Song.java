package business;

/**
 * Represents a song artist & title. Contains two attributes & getters/setters.
 * @author michelle contributed by cal woods
 */
public class Song {
    //attributes
    private String artist;
    private String title;

    //constructor - no argument
    /**
     * 
     */
    public Song() {
        //Set class attributes to defaults "Joe Bloggs", "Mmmbop" respectively
        this.artist = "Joe Bloggs";
        this.title = "Mmmbop";
    }

    public Song(String artist, String title) {
        //Validation
        if(artist.isBlank() || title.isBlank()) throw new IllegalArgumentException("Given artist/title must NOT be empty or contain only spaces!");
        
        //Set attributes to arguments
        this.artist = artist;
        this.title = title;
    }
}
