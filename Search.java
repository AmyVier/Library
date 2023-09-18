import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Search {

    private static JFrame window = new JFrame("Search");
    private static LibraryOfBooks books  = null;
    private static HashMap <String, Book> bookTitles = null;

    public static void create() {
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350,400,100,40);

        JTextField search_title = new JTextField(16);  
        search_title.setBounds(350,0, 100,40);  
        window.add(search_title);

        ArrayList <JButton> buttons = new ArrayList<>();

        update();

        window.setVisible(true);

        back.addActionListener((ActionEvent e) -> {
            window.dispose();
            MainWindow.create();
        });

        search_title.addActionListener((ActionEvent e) -> {
            while (!(buttons.isEmpty())) {
                window.remove(buttons.get(0));
                buttons.remove(0);
            }

            window.repaint();

            int i = 0;
            if (search_title.getText().length() > 0) {

                for (Map.Entry<String, Book> set : bookTitles.entrySet()) {
                    if (set.getKey().length() >= search_title.getText().length() && 
                    set.getKey().substring(0, search_title.getText().length()).
                    equals(search_title.getText())) {

                        buttons.add(new JButton(set.getKey()));
                        window.add(buttons.get(i));

                        buttons.get(i).addActionListener((ActionEvent l) -> {
                            window.setVisible(false);
                            BookInformation.create(set.getValue());
                        });

                        buttons.get(i++).setBounds(350, i * 40, 100, 40);

                    }
                }
            }
        });
    }

    public static void update () {
        SavedBookData.initialize();
        books = SavedBookData.getBooks();
        bookTitles = books.getTitles();
    }

    public static void setVisible() {
        window.setVisible(true);
    }
}
