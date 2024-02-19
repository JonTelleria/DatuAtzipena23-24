package dambi.netflix.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a movie or TV show title.
 */
@Document
public class Titles {
    // Attributes
    private String identificator;
    private String title;
    private String description;
    private int release_year;
    private int runtime;
    private List<String> genres;
    private double imdb_score;
    private List<Credits> credits;

    /**
     * Constructs a new Titles object with the specified attributes.
     * @param identificator the unique identifier of the title.
     * @param title the title of the movie or TV show.
     * @param description a brief description of the title.
     * @param release_year the release year of the title.
     * @param runtime the duration of the title in minutes.
     * @param genres the genres associated with the title.
     * @param imdb_score the IMDb score of the title.
     * @param credits the list of credits associated with the title.
     */
    public Titles(String identificator, String title, String description, int release_year, int runtime, List<String> genres, double imdb_score, List<Credits> credits) {
        this.identificator = identificator;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.runtime = runtime;
        this.genres = genres;
        this.imdb_score = imdb_score;
        this.credits = new ArrayList<>(); // Initialize the list of credits
    }

    /**
     * Default constructor for Titles.
     */
    public Titles() {
    }

    /**
     * Adds a credit to the title.
     * @param credit the credit to be added.
     */
    public void addCredit(Credits credit) {
        this.credits.add(credit);
    }

    // Getters and setters

    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public double getImdb_score() {
        return imdb_score;
    }

    public void setImdb_score(double imdb_score) {
        this.imdb_score = imdb_score;
    }

    public List<Credits> getCredits() {
        return credits;
    }

    public void setCredits(List<Credits> credits) {
        this.credits = credits;
    }

    /**
     * Adds all credits from the provided list to the title's credits.
     * @param credits the list of credits to add.
     */
    public void addAllCredits(List<Credits> credits) {
        this.credits.addAll(credits);
    }
}
