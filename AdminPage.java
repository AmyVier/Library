import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * AdminPage class
 * Description: Admin Page of library
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class AdminPage {

    private static JFrame window = new JFrame("Search");

    /**
   * Creates Admin Page of library to add books.
   */
    public static void create() {
        window.setLayout(null);

        // you can close this application from admin page
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initializing window components
        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350,400,100,40);

        JTextField title = new JTextField(16);  
        title.setBounds(350,40, 100,40);  
        window.add(title);

        JTextField author = new JTextField(16);  
        author.setBounds(350,80, 100,40);  
        window.add(author);

        JTextField cover = new JTextField(16);  
        cover.setBounds(350,120, 100,40);  
        window.add(cover);

        JTextField description = new JTextField(16);  
        description.setBounds(350,160, 100,40);  
        window.add(description);

       JTextField date = new JTextField(16);  
        date.setBounds(350,200, 100,40);  
        window.add(date);

        JButton add = new JButton("Add");
        window.add(add);
        add.setBounds(350,240,100,40);

        window.setVisible(true);
        window.setSize(800,800);

        //initialize book data and retrieve data for changes
        SavedBookData.initialize();
        LibraryOfBooks updated_catalogue = SavedBookData.getBooks(); // book data

        //add book data
        add.addActionListener((ActionEvent e) -> {
            Book newBook = new Book(title.getText());
            newBook.addAuthors(author.getText());
            newBook.setPicture(cover.getText());
            newBook.setDescription(description.getText());
            newBook.setPublishDate(date.getText());

            updated_catalogue.addBook(newBook);

            clear(title, author, cover, description, date);
        });

         //save all changes when go back to main window
        back.addActionListener((ActionEvent e) -> {
            SavedBookData.save(updated_catalogue);
            Search.update(); //updata data for Search browser
            window.dispose();
            MainWindow.setVisible();

            clear(title, author, cover, description, date);
        });
    }
    
    /**
   * clears all textboxes.
   * 
   * @param title JTextField title textbox
   * @param author JTextField author textbox
   * @param cover JTextField cover textbox
   * @param description JTextField description textbox
   * @param date JTextField date textbox
   */
    private static void clear(JTextField title, JTextField author, 
    JTextField cover, JTextField description, JTextField date) {
        title.setText(null);
        author.setText(null);
        cover.setText(null);
        description.setText(null);
        date.setText(null);
    }
}
