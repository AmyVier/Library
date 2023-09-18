import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AdminPage {
    private static JFrame window = new JFrame("Search");

    public static void create() {
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        SavedBookData.initialize();
        LibraryOfBooks updated_catalogue = SavedBookData.getBooks();

        add.addActionListener((ActionEvent e) -> {
            Book newBook = new Book(title.getText());
            newBook.addAuthors(author.getText());
            newBook.setPicture(cover.getText());
            newBook.setDescription(description.getText());
            newBook.setPublishDate(date.getText());

            updated_catalogue.addBook(newBook);
        });

        back.addActionListener((ActionEvent e) -> {
            SavedBookData.save(updated_catalogue);
            Search.update();
            window.dispose();
            MainWindow.setVisible();
        });
    }
}
