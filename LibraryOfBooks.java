import java.io.Serializable;
import java.util.HashSet;
import java.util.HashMap;

/**
 * LibraryOfBooks class
 * Description: stores books
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class LibraryOfBooks implements Serializable, Cloneable {
    private HashSet<Book> books = new HashSet<>(); // book set

    /**
     * get set of books.
     * 
     * @return HashSet<Book> of books
     */
    public HashSet<Book> getBooks() {
        HashSet<Book> books_copy = new HashSet<>();

        books.forEach( book -> {
            books_copy.add(book);
        });
        return books_copy;
    }

    /**
     * get titles of books with book info.
     * 
     * @return HashMap<String, Book> of book titles and books
     */
    public HashMap<String, Book> getTitles() {
        HashMap<String, Book> books_copy = new HashMap<>();

        books.forEach( book -> {
            books_copy.put(book.getTitle(), book);
        });
        return books_copy;
    }

    /**
     * adds a book to the book set
     * 
     * @param book Book
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * clones LibraryOfBooks class
     * 
     * @return LibraryOfBooks clone
     */
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
