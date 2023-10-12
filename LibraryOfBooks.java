import java.util.HashSet;

/**
 * LibraryOfBooks class
 * Description: stores books
 *
 * @author (Amy Vier)
 * @version (October 12, 2023)
 */
public class LibraryOfBooks extends SavedBookData {
    /**
     * get set of books.
     * 
     * @return HashSet<Book> of books
     */
    public static HashSet<Book> getBooks() {
        HashSet<Book> books_copy = new HashSet<>();

        books.forEach( book -> {
            books_copy.add(book);
        });
        return books_copy;
    }

    /**
     * adds a book to the book set
     * 
     * @param book Book
     */
    public static void addBook(Book book) {
        books.add(book);
    }

    /**
     * remove book
     * 
     * @param book Book
     */
    public static void removeBook(Book book) {
        books.remove(book);
    }

}