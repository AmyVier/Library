import java.io.*;
import java.util.TreeSet;

/**
 * Book class
 * Description: stores book info
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class Book implements Serializable{

    //default info
    private String title = "No Title";
    private String description = "No Description";
    private TreeSet <String> authors = new TreeSet<>();
    private String picture = "";
    private String publishDate = "Date Unknown";

    /**
     * Creates book with default title, etc.
     */
    public Book() {
        // do nothing
    }

    /**
     * Creates book with title.
     * 
     * @param title String title
     */
    public Book(String title) {
        this.title = title;
    }

    /**
     * gets title.
     * 
     * @return String title
     */
    public String getTitle () {
        return this.title;
    }

    /**
     * gets description.
     * 
     * @return String description
     */
    public String getDescription () {
        return this.description;
    }

    /**
     * gets picture.
     * 
     * @return String path to string.
     */
    public String getPicture () {
        if (this.picture.length() > 0) {
            return this.picture;
        }

        return "NoCover.png";
    }

    /**
     * gets publish date.
     * 
     * @return String publish date
     */
    public String getPublishDate () {
        return this.publishDate;
    }

    /**
     * gets authors.
     * 
     * @return TreeSet authors
     */
    public TreeSet<String> getAuthors () {
        TreeSet <String> authors_copy = new TreeSet<>();
        authors.forEach( name -> {
            authors_copy.add(name);
        });
        return authors_copy;
    }

     /**
     * Sets title.
     * 
     * @param title String title
     */
    public void setTitle (String title) {
        this.title = title;
    }

    /**
     * Sets description.
     * 
     * @param description String description
     */
    public void setDescription (String description) {
        this.description = description;
    }

    /**
     * Sets picture.
     * 
     * @param picture String path to picture
     */
    public void setPicture (String picture) {
        this.picture = picture;
    }

    /**
     * Sets publish date.
     * 
     * @param publishDate String publish date
     */
    public void setPublishDate (String publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * Adds authors.
     * 
     * @param name String author name
     */
    public void addAuthors (String name) {
        this.authors.add(name);
    }
}
