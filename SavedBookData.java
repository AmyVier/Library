import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SavedBookData {
    private static LibraryOfBooks allBooks = null;

    public static LibraryOfBooks getBooks() {
        if (allBooks == null) {
            return new LibraryOfBooks();
        }
        
        return allBooks.clone();
    }

    public static void save(LibraryOfBooks updated) {
        try {
            FileOutputStream file = new FileOutputStream("BookData.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(updated);

            out.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught in save");
        }

        allBooks = updated.clone();
    }

    public static void initialize() {
        try {  
            FileInputStream file = new FileInputStream("BookData.ser");
            ObjectInputStream in = new ObjectInputStream(file);
             
            allBooks = (LibraryOfBooks)in.readObject();
             
            in.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
