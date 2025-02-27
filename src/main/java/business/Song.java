package business;

import java.util.Objects;

/**
 * Represents a song artist & title. Contains two attributes & getters/setters.
 * @author michelle contributed by cal woods
 */
public class Song {
    //attributes
    private String artist;
    private String title;

    /**
     * Does not take any arguments and sets new Song attributes to artist, "Joe Bloggs" & title, "Mmmbop".
     */
    public Song() {
        //Set class attributes to defaults "Joe Bloggs", "Mmmbop" respectively
        this.artist = "Joe Bloggs";
        this.title = "Mmmbop";
    }

    /**
     * Sets new Song attributes to given artist & title.
     * @param artist Given artist name String
     * @param title Given title of song String
     * 
     * @throws IllegalArgumentException If given artist or title is empty/contains only spaces.
     */
    public Song(String artist, String title) {
        //Validation
        if(artist.isBlank() || title.isBlank()) throw new IllegalArgumentException("Given artist/title may be empty or have only space. Arguments must NOT be empty or contain only spaces!");

        //Set attributes to arguments
        this.artist = artist;
        this.title = title;
    }

    //Getters
    public String getArtist() {
        return this.artist;
    }

    public String getTitle() {
        return this.title;
    }

    //Setters
    /**
     * Sets artist attribute to given artist argument.
     * @param artist Given artist
     */
    public void setArtist(String artist) {
        //Validation
        if(artist.isBlank()) throw new IllegalArgumentException("Please check given artist argument as it may be empty or contain only spaces!");
        
        this.artist = artist;
    }

    /**
     * Sets title instance attribute to given title.
     * @param title Given title
     */
    public void setTitle(String title) {
        //Validation
        if(title.isBlank()) throw new IllegalArgumentException("Please check given title argument as it may be empty or contain only spaces, NOT allowed!");
        
        this.title = title;
    }


    //Override methods: 'hashCode()', 'toString()' & 'equals()'
    /**
     * Generates a hashcode using Song instance attributes.
     * 
     */
    @Override
    public int hashCode() {
        //Declare int hash to store attribute hashes
        int hash = 17;

        //Compute hash using 13 * 'Objects.hash' method on each Song attribute
        hash += 13 * Objects.hash(this.artist);
        hash += 13 * Objects.hash(this.title);

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        //Validation
        if(!(o instanceof Song)) return false;
        
        //Store copy of Song o cast as Song
        Song copy = (Song) o;

        //Check if instance attributes are the same as given o attributes using copy
        if(!this.artist.equalsIgnoreCase(copy.getArtist())) {
            return false;
        }
        if(!this.title.equalsIgnoreCase(copy.getTitle())) {
            return false;
        }

        return true;
    }
}