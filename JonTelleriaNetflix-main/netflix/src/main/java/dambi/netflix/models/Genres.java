package dambi.netflix.models;

/**
 * Represents a genre of a movie or TV show.
 */
public class Genres {
    // Attribute
    private String nameofgenre;

    /**
     * Constructs a new Genres object with the specified genre name.
     * @param nameofgenre the name of the genre.
     */
    public Genres(String nameofgenre) {
        this.nameofgenre = nameofgenre;
    }

    /**
     * Default constructor for Genres.
     */
    public Genres() {
    }

    /**
     * Gets the name of the genre.
     * @return the name of the genre.
     */
    public String getNameofgenre() {
        return nameofgenre;
    }

    /**
     * Sets the name of the genre.
     * @param nameofgenre the name of the genre to set.
     */
    public void setNameofgenre(String nameofgenre) {
        this.nameofgenre = nameofgenre;
    }
}
