import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;

/**
 * ChangeCatalogue class
 * Description: Change Catalogue Page of library
 *
 * @author (Amy Vier)
 * @version (October 12, 2023)
 */
public class ChangeCatalogue {
    private static JFrame window = new JFrame("Change Catalogue");
    private static ArrayList<JButton> buttons = new ArrayList<>(); //buttons directing to book windows
    //list of array containing remove buttons
    private static ArrayList<JButton> remove_buttons = new ArrayList<>();  

    /**
   * Creates Change Catalogue Page of library to remove books.
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
                // save all data before exiting
                LibraryOfBooks.save();
                PasswordManager.save();
                System.exit(0);
            }
        });

        back.addActionListener((ActionEvent e) -> {
            window.dispose();
            AdminPage.setVisible();
        });

        //go back to previous page
        search_title.addActionListener((ActionEvent e) -> {
            //get rid of search results/buttons from previous search
            while (!(buttons.isEmpty())) {
                window.remove(buttons.get(0));
                buttons.remove(0);

                window.remove(remove_buttons.get(0));
                remove_buttons.remove(0);
            }

            //show changes to the window (if some buttons were removed)
            window.repaint();

            int book_index = 0;// location of button in terms of y axis

            //if there is input look for seach results
            if (search_title.getText().length() > 0) {

                //look through every title
                for (Book book : LibraryOfBooks.getBooks()) {

                    //if the title is partially similar show title
                    if (book.getTitle().length() >= search_title.getText().length() &&
                            book.getTitle().substring(0, search_title.getText().length()).
                            equalsIgnoreCase(search_title.getText())) {

                        buttons.add(new JButton(book.getTitle()));
                        window.add(buttons.get(book_index));

                        remove_buttons.add(new JButton("remove"));
                        window.add(remove_buttons.get(book_index));

                        //add a book window
                        buttons.get(book_index).addActionListener((ActionEvent l) -> {
                            window.setVisible(false);
                            ChangeBookInfo.create(book); // create window based on book info
                            clear(search_title);
                        });

                        final int number = book_index;

                        remove_buttons.get(book_index).addActionListener((ActionEvent l) -> {
                            remove(number, remove_buttons, buttons);
                            LibraryOfBooks.removeBook(book);
                        });

                        //every button is 40 pixles down from one another
                        buttons.get(book_index).setBounds(350, (book_index + 1) * 40, 100, 40);
                        remove_buttons.get(book_index).setBounds(500, (book_index + 1) * 40, 100, 40);

                        book_index++;

                    }
                }
            }
        });
    }

    /**
     * remove all search results and text in the seach bar
     * 
     * @param index int index of the button being removed
     * @param buttons ArrayList<JButton> array of buttons redirecting to book information
     * @param remove_buttons ArrayList<JButton> array of buttons to remove books 
     */
    private static void remove (int index, ArrayList<JButton> buttons, 
    ArrayList<JButton> remove_buttons) {
        window.remove(buttons.get(index));
        buttons.remove(index);

        window.remove(remove_buttons.get(index));
        remove_buttons.remove(index);

        for (int i = index; i < buttons.size(); i++) {
            buttons.get(i).setBounds(350, (i + 1) * 40, 100, 40);
            remove_buttons.get(i).setBounds(500, (i + 1) * 40, 100, 40);
        }

        window.repaint();
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

            window.remove(remove_buttons.get(0));
            remove_buttons.remove(0);
        }

        search_title.setText(null);
    }

     /**
     * Sets the visibility of Change Catalogue window to true.
     */
    public static void setVisible() {
        window.setVisible(true);
    }
}
