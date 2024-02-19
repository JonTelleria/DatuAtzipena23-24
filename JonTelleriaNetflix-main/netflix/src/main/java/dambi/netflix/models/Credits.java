package dambi.netflix.models;

/**
 * Represents the credits associated with a title, including information about the person, their character, and role.
 */
public class Credits {
    // Attribute definitions
    private int person_id;
    private String id;
    private String name;
    private String character;
    private String role;

    /**
     * Constructs a new Credits object with the specified attributes.
     * @param person_id the ID of the person associated with the credit.
     * @param id the unique identifier for the credit.
     * @param name the name of the person.
     * @param character the character played by the person.
     * @param role the role of the person in the credit.
     */
    public Credits(int person_id, String id, String name, String character, String role) {
        this.person_id = person_id;
        this.id = id;
        this.name = name;
        this.character = character;
        this.role = role;
    }

    /**
     * Constructs a new empty Credits object.
     */
    public Credits() {
    }

    // Getter and setter methods

    /**
     * Gets the ID of the person associated with the credit.
     * @return the person ID.
     */
    public int getPerson_Id() {
        return person_id;
    }

    /**
     * Gets the unique identifier for the credit.
     * @return the credit ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the person.
     * @return the person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the character played by the person.
     * @return the character name.
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Gets the role of the person in the credit.
     * @return the person's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the ID of the person associated with the credit.
     * @param person_id the person ID to set.
     */
    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    /**
     * Sets the unique identifier for the credit.
     * @param id the credit ID to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the name of the person.
     * @param name the person's name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the character played by the person.
     * @param character the character name to set.
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * Sets the role of the person in the credit.
     * @param role the person's role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }
}
