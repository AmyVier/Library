import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.*;

public class ChangeBookInfo {
    
    private static JFrame window = new JFrame();

    /**
     * Creates a book information page to display book info
     * 
     * @param bookInfo Book book information
     */
    public static void create(Book bookInfo) {
        window.setTitle(bookInfo.getTitle());
        window.setLayout(null);

        // initializing window components
        ImageIcon cover = new ImageIcon(bookInfo.getPicture());
        JLabel cover_label = new JLabel(cover);
        window.add(cover_label);
        cover_label.setBounds(100, 100, 50, 50);

        JTextPane plot = new JTextPane();
        plot.setContentType("text/plain");
        plot.setEditable(false);

        JScrollPane plot_scroll = new JScrollPane(plot,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        window.add(plot_scroll);
        plot_scroll.setBounds(300, 100, 170, 150);

        JTextPaneFormat.fitText(plot, bookInfo.getDescription(), 150);

        JTextPane authors = new JTextPane();
        authors.setContentType("text/plain");
        authors.setText(bookInfo.getAuthors());
        authors.setEditable(false);

        JScrollPane authors_scroll = new JScrollPane(authors,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        window.add(authors_scroll);
        authors_scroll.setBounds(300, 40, 100, 50);

        JLabel date = new JLabel(bookInfo.getPublishDate());
        date.setBounds(200, 40, 100, 40);
        window.add(date);

        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350, 400, 100, 40);

        window.setVisible(true);
        window.setSize(800, 800);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                LibraryOfBooks.save();
                PasswordManager.save();
                System.exit(0);
            }
        });

        // go back to search window
        back.addActionListener((ActionEvent e) -> {
            window.dispose();
            ChangeCatalogue.setVisible();
        });
    }

    /**
     * Sets the visibility of book information window to true.
     */
    public static void setVisible() {
        window.setVisible(true);
    }
}
