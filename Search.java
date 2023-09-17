import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Search {
     public static void create() {
        JFrame window = new JFrame ("Search");
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350,400,100,40);

        JTextField search_title = new JTextField(16);  
        search_title.setBounds(350,0, 100,40);  
        window.add(search_title);

        ArrayList <JButton> buttons = new ArrayList<>();

        LibraryOfBooks books = new LibraryOfBooks();
        Book AAA = new Book("AAA");
        Book AABS = new Book("AABS");
        Book AASS = new Book("AASS");
        books.addBook(AAA);
        books.addBook(AABS);
        books.addBook(AASS);
        HashMap <String, Book> bookTitles = books.getTitles();

        window.setVisible(true);

        search_title.addActionListener((ActionEvent e) -> {
            int i = 0;
            if (search_title.getText().length() > 0) {
                for (Map.Entry<String, Book> set : bookTitles.entrySet()) {
                    if (set.getKey().length() >= search_title.getText().length() && 
                    set.getKey().substring(0, search_title.getText().length()).
                    equals(search_title.getText())) {
                        System.out.println(set.getKey());
                        buttons.add(new JButton(set.getKey()));
                        window.add(buttons.get(i));
                        buttons.get(i++).setBounds(350, i * 40, 100, 40);
                    }
                }
            }
        });
    }
}
