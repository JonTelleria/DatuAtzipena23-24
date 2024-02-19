package dambi.netflix.models;

import java.util.List;

/**
 * Represents a container for holding titles and associated credits.
 */
public class DataContainer {
    private List<Titles> titles;

    /**
     * Constructs a new DataContainer object with the specified list of titles.
     * @param titles the list of titles to be contained.
     */
    public DataContainer(List<Titles> titles) {
        this.titles = titles;
    }

    /**
     * Gets the list of titles stored in the container.
     * @return the list of titles.
     */
    public List<Titles> getTitles() {
        return titles;
    }

    /**
     * Sets the list of titles in the container.
     * @param titles the list of titles to set.
     */
    public void setTitles(List<Titles> titles) {
        this.titles = titles;
    }

    /**
     * Represents a combination of a title and its associated credits.
     */
    public static class TitleWithCredits {
        private Titles title;
        private List<Credits> credits;

        /**
         * Constructs a new TitleWithCredits object.
         */
        public TitleWithCredits() {
            // Default constructor
        }

        /**
         * Gets the title associated with the credits.
         * @return the title object.
         */
        public Titles getTitle() {
            return title;
        }

        /**
         * Sets the title associated with the credits.
         * @param title the title to set.
         */
        public void setTitle(Titles title) {
            this.title = title;
        }

        /**
         * Gets the list of credits associated with the title.
         * @return the list of credits.
         */
        public List<Credits> getCredits() {
            return credits;
        }

        /**
         * Sets the list of credits associated with the title.
         * @param credits the list of credits to set.
         */
        public void setCredits(List<Credits> credits) {
            this.credits = credits;
        }
    }
}
