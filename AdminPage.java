import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.*;

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

        // initializing window components
        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350,500,100,40);

        JTextField title = new JTextField(16);  
        title.setBounds(350,40, 100,40);  
        window.add(title);

        JTextField cover = new JTextField(16);  
        cover.setBounds(350,80, 100,40);  
        window.add(cover);

        JTextPane author = new JTextPane();
        author.setContentType("text/plain");
        author.setEditable(true);

        JScrollPane author_scroll = new JScrollPane(author,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        window.add(author_scroll);
        author_scroll.setBounds(350, 180, 100, 50);

        JTextPane description = new JTextPane();
        description.setContentType("text/plain");
        description.setEditable(true);

        JScrollPane description_scroll = new JScrollPane(description,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        window.add(description_scroll);
        description_scroll.setBounds(350, 240, 100, 100);

        JTextField date = new JTextField(16);  
        date.setBounds(350,120, 100,40);  
        window.add(date);

        JButton add = new JButton("Add");
        window.add(add);
        add.setBounds(350,400,100,40);

        JButton change = new JButton("Change");
        window.add(change);
        change.setBounds(350,450,100,40);

        window.setVisible(true);
        window.setSize(800,800);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                LibraryOfBooks.save();
                PasswordManager.save();
                System.exit(0);
            }
        });

        //add book data
        add.addActionListener((ActionEvent e) -> {
            Book newBook = new Book();
            
            if (title.getText().length() > 0) {
                newBook.setTitle(title.getText());
            }

            if (cover.getText().length() > 0) {
                newBook.setPicture(cover.getText());
            }

            if (description.getText().length() > 0) {
                newBook.setDescription(description.getText());
            }

            if (date.getText().length() > 0) {
                newBook.setPublishDate(date.getText());
            }

            if (author.getText().length() > 0) {
                newBook.setAuthors(author.getText());
            }

            LibraryOfBooks.addBook(newBook);

            clear(title, author, cover, description, date);
        });

         //save all changes when go back to main window
        back.addActionListener((ActionEvent e) -> {
            window.dispose();
            MainWindow.setVisible();

            clear(title, author, cover, description, date);
        });

        //save all changes when go to change window
        change.addActionListener((ActionEvent e) -> {
            window.dispose();
            ChangeCatalogue.create();

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
    private static void clear(JTextField title, JTextPane author, 
    JTextField cover, JTextPane description, JTextField date) {
        title.setText(null);
        author.setText(null);
        cover.setText(null);
        description.setText(null);
        date.setText(null);
    }

    /**
   * Sets the visibility of the Admin Page to true.
   */
  public static void setVisible() {
    window.setVisible(true);
  }
}
