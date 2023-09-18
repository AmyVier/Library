import java.io.Serializable;
import java.util.HashSet;
import java.util.HashMap;

public class LibraryOfBooks implements Serializable, Cloneable {
    private HashSet<Book> books = new HashSet<>();

    public HashSet<Book> getBooks() {
        HashSet<Book> books_copy = new HashSet<>();

        books.forEach( book -> {
            books_copy.add(book);
        });
        return books_copy;
    }

    public HashMap<String, Book> getTitles() {
        HashMap<String, Book> books_copy = new HashMap<>();

        books.forEach( book -> {
            books_copy.put(book.getTitle(), book);
        });
        return books_copy;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public LibraryOfBooks clone() {
        LibraryOfBooks copy = new LibraryOfBooks();

        if (books == null) {
            return copy;
        }

        this.getBooks().forEach((book) -> {
            copy.addBook(book);
        });

        return copy;
    }

}
