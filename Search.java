import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Search class
 * Description: Search Window of library
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class Search {

    private static JFrame window = new JFrame("Search");
    private static ArrayList<JButton> buttons = new ArrayList<>(); //buttons directing to book windows

    /**
   * Creates Main Window of search, allowing the user to search for books
   */
    public static void create() {
        window.setLayout(null);

        // initializing window components
        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350, 400, 100, 40);

        JTextField search_title = new JTextField(16);
        search_title.setBounds(350, 0, 100, 40);
        window.add(search_title);

        window.setVisible(true);
        window.setSize(800, 800);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                LibraryOfBooks.save();
                PasswordManager.save();
                System.exit(0);
            }
        });

        back.addActionListener((ActionEvent e) -> {
            window.dispose();
            MainWindow.create();
        });

        //go back to previous page
        search_title.addActionListener((ActionEvent e) -> {
            //get rid of search results/buttons from previous search
            while (!(buttons.isEmpty())) {
                window.remove(buttons.get(0));
                buttons.remove(0);
            }

            //show changes to the window (if some buttons were removed)
            window.repaint();

            int i = 0;// location of button in terms of y axis

            //if there is input look for seach results
            if (search_title.getText().length() > 0) {

                //look through every title
                for (Book book : LibraryOfBooks.getBooks()) {

                    //if the title is partially similar show title
                    if (book.getTitle().length() >= search_title.getText().length() &&
                            book.getTitle().substring(0, search_title.getText().length()).
                            equalsIgnoreCase(search_title.getText())) {

                        buttons.add(new JButton(book.getTitle()));
                        window.add(buttons.get(i));

                        //add a book window
                        buttons.get(i).addActionListener((ActionEvent l) -> {
                            window.setVisible(false);
                            BookInformation.create(book); // create window based on book info
                            clear(search_title);
                        });

                        //every button is 40 pixles down from one another
                        buttons.get(i++).setBounds(350, i * 40, 100, 40);

                    }
                }
            }
        });
    }

    /**
     * remove all search results and text in the seach bar
     * 
     * @param search_title JTextField search bar
     */
    private static void clear(JTextField search_title) {
        while (!(buttons.isEmpty())) {
            window.remove(buttons.get(0));
            buttons.remove(0);
        }

        search_title.setText(null);
    }

    /**
     * Sets the visibility of search window to true.
     */
    public static void setVisible() {
        window.setVisible(true);
    }
}
