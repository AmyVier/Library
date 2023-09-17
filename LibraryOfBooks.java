import java.io.Serializable;
import java.util.HashSet;

public class LibraryOfBooks implements Serializable{
    private HashSet<Book> books = new HashSet<>();

    public HashSet<Book> getBooks() {
        HashSet<Book> books_copy = new HashSet<>();

        books.forEach( book -> {
            books_copy.add(book);
        });
        return books_copy;
    }

    public HashSet<String> getTitles() {
        HashSet<String> books_copy = new HashSet<>();

        books.forEach( book -> {
            books_copy.add(book.getTitle());
        });
        return books_copy;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
