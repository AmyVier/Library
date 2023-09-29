import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

/**
 * BookInformation class
 * Description: Book information page of library
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class BookInformation {

    private static JFrame window = new JFrame();

    /**
   * Creates a book information page to display book info
   * 
   * @param bookInfo Book book information
   */
    public static void create(Book bookInfo) {
        window.setTitle(bookInfo.getTitle());
        window.setLayout(null);

        //you can close this application from admin page
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // initializing window components
        ImageIcon cover = new ImageIcon(bookInfo.getPicture());
        JLabel cover_label = new JLabel(cover);
        window.add(cover_label);
        cover_label.setBounds(100, 100, 50, 50);


        JLabel plot = new JLabel(bookInfo.getDescription());
        window.add(plot);
        plot.setBounds(200, 100, 50, 50);

        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350,400,100,40);

        window.setVisible(true);
        window.setSize(800,800);

         //go back to search window
        back.addActionListener((ActionEvent e) -> {
            window.dispose();
            Search.setVisible();
        });
    }

    /**
     * Sets the visibility of book information window to true.
     */
    public static void setVisible() {
        window.setVisible(true);
    }

}
