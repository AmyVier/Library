import java.io.*;
import java.util.Objects;

/**
 * Book class
 * Description: stores book info
 *
 * @author (Amy Vier)
 * @version (October 12, 2023)
 */
public class Book implements Serializable{

    //default info
    private String title = "No Title";
    private String description = "No Description";
    private String authors = "Authors Unknown";
    private String picture = "";
    private String publishDate = "Publish Date Unknown";

    /**
     * Creates book with default title, etc.
     */
    public Book() {
        // do nothing
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
     * @return authors
     */
    public String getAuthors () {
        return  this.authors;
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
    public void setAuthors (String authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object compare) {
        if (!(compare instanceof Book)) {
            return false;
        }

        if (!(((Book)compare).getTitle().equals(this.title))) {
            return false;
        }

        if (!(((Book)compare).getAuthors().equals(this.authors))) {
            return false;
        }

        if (!(((Book)compare).getDescription().equals(this.description))) {
            return false;
        }

        if (!(((Book)compare).getPicture().equals(this.picture))) {
            return false;
        }

        if (!(((Book)compare).getPublishDate().equals(this.publishDate))) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.authors, this.description, this.picture, 
        this.publishDate, this.title);
    }
}
