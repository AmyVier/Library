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
    private String title = "";
    private String description = "";
    private TreeSet <String> authors = new TreeSet<>();
    private String picture = "";
    private String publishDate = "";

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
        if (this.title.length() == 0) {
            return "No Title";
        }

        return this.title;
    }

    /**
     * gets description.
     * 
     * @return String description
     */
    public String getDescription () {
        if (this.description.length() == 0) {
            return "No Description";
        }

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
        if (this.publishDate.length() > 0) {
            return "Date Unknown";
        }

        return this.publishDate;
    }

    /**
     * gets authors.
     * 
     * @return TreeSet authors
     */
    public String getAuthors () {
        String author_list_string = "";

        if (this.authors.size() == 0) {
            return "No Author";
        }

        for (String name : this.authors) {
            author_list_string = author_list_string + name + ", ";
        }

        return author_list_string.substring(0, 
        author_list_string.length() - 2);
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
        if (name.length() > 0) {
            this.authors.add(name);
        }
    }
}
