import java.util.ArrayList;
import java.util.HashSet;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ChangeCatalogue {
    private static JFrame window = new JFrame("Change Catalogue");
    private static LibraryOfBooks books = null; //where book data is stores
    private static HashSet<Book> bookList = null; //titles directing to book data
    private static ArrayList<JButton> buttons = new ArrayList<>(); //buttons directing to book windows


    public static void create() { 
        window.setLayout(null);

        //you can close this application from search window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initializing window components
        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350, 400, 100, 40);

        JTextField search_title = new JTextField(16);
        search_title.setBounds(350, 0, 100, 40);
        window.add(search_title);

        window.setVisible(true);
        window.setSize(800, 800);

        //update book data (if some books were added/removed)
        update();

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
            }

            //show changes to the window (if some buttons were removed)
            window.repaint();

            int i = 0;// location of button in terms of y axis

            //if there is input look for seach results
            if (search_title.getText().length() > 0) {

                //look through every title
                for (Book book : bookList) {

                    //if the title is partially similar show title
                    if (book.getTitle().length() >= search_title.getText().length() &&
                            book.getTitle().substring(0, search_title.getText().length()).
                            equalsIgnoreCase(search_title.getText())) {

                        buttons.add(new JButton(book.getTitle()));
                        window.add(buttons.get(i));

                        //add a book window
                        buttons.get(i).addActionListener((ActionEvent l) -> {
                            window.setVisible(false);
                            ChangeBookInfo.create(book); // create window based on book info
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
     * updates book data
     */
    public static void update() {
        SavedBookData.initialize();
        books = SavedBookData.getBooks();
        bookList = books.getBooks();
    }

     /**
     * Sets the visibility of Change Catalogue window to true.
     */
    public static void setVisible() {
        window.setVisible(true);
    }
}
