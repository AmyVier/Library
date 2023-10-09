import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

@SuppressWarnings("unchecked")

/**
 * SavedBookData class
 * Description: retrieves and saves book data
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class SavedBookData {
    //data of books
    protected static HashSet<Book> books = new HashSet<>(); // book set

    /**
   * saves book data
   * 
   * @param updated LibraryOfBooks data of books to be saved
   */
    public static void save() {
        try {
            FileOutputStream file = new FileOutputStream("BookData.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(books);

            out.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught in save " + ex);
        }
    }

    /**
   * initializes book data
   */
    public static void initialize() {
        try {  
            FileInputStream file = new FileInputStream("BookData.ser");
            ObjectInputStream in = new ObjectInputStream(file);
             
            books = (HashSet<Book>)in.readObject();
             
            in.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught in initialize " + ex);
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught in initialize " + ex);
        }
    }
}
