import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String [] args) {
       //MainWindow.create();
        Search.create();


        Book newBook = new Book("HEY");
        
        LibraryOfBooks new_library = new LibraryOfBooks();
        new_library.addBook(newBook);

        try {
            FileOutputStream file = new FileOutputStream("file.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(new_library);

            out.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        }

        LibraryOfBooks new_library2 = null;

        try {  
            FileInputStream file = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file);
             
            new_library2 = (LibraryOfBooks)in.readObject();
             
            in.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        for (Book book : new_library2.getBooks()) {
            System.out.println(book.getTitle());
        }
    }
}
