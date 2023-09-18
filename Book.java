import java.io.*;
import java.util.TreeSet;

public class Book implements Serializable{
    private String title = "No Title";
    private String description = "No Description";
    private TreeSet <String> authors = new TreeSet<>();
    private String picture = "";
    private String publishDate = "Date Unknown";

    public Book(String title) {
        this.title = title;
    }

    public String getTitle () {
        return this.title;
    }

    public String getDescription () {
        return this.description;
    }

    public String getPicture () {
        if (this.picture.length() > 0) {
            return this.picture;
        }

        return "NoCover.png";
    }

    public String getPublishDate () {
        return this.publishDate;
    }

    public TreeSet<String> getAuthors () {
        TreeSet <String> authors_copy = new TreeSet<>();
        authors.forEach( name -> {
            authors_copy.add(name);
        });
        return authors_copy;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public void setPicture (String picture) {
        this.picture = picture;
    }

    public void setPublishDate (String publishDate) {
        this.publishDate = publishDate;
    }

    public void addAuthors (String name) {
        this.authors.add(name);
    }
}
