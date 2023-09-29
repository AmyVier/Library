import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SavedBookData class
 * Description: retrieves and saves book data
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class SavedBookData {
    //data of books
    private static LibraryOfBooks allBooks = null;

    /**
   * gets data of books
   * 
   * @return data of books in class LibraryOfBooks
   */
    public static LibraryOfBooks getBooks() {
        if (allBooks == null) {
            return new LibraryOfBooks();
        }
        
        return allBooks.clone();
    }

    /**
   * saves book data
   * 
   * @param updated LibraryOfBooks data of books to be saved
   */
    public static void save(LibraryOfBooks updated) {
        try {
            FileOutputStream file = new FileOutputStream("BookData.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(updated);

            out.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught in save " + ex);
        }

        allBooks = updated.clone();
    }

    /**
   * initializes book data
   */
    public static void initialize() {
        try {  
            FileInputStream file = new FileInputStream("BookData.ser");
            ObjectInputStream in = new ObjectInputStream(file);
             
            allBooks = (LibraryOfBooks)in.readObject();
             
            in.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught in initialize " + ex);
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught in initialize " + ex);
        }
    }
}
