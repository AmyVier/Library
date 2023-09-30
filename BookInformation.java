import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.*;
import java.awt.FontMetrics;

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

        // you can close this application from admin page
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        fitText(plot, bookInfo.getDescription(), 150);

        JTextPane authors = new JTextPane();
        authors.setContentType("text/plain");
        authors.setText(bookInfo.getAuthors());
        authors.setEditable(false);
        window.add(authors);
        authors.setBounds(300, 40, 100, 50);

        JLabel date = new JLabel(bookInfo.getPublishDate());
        date.setBounds(200, 40, 100, 40);
        window.add(date);

        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350, 400, 100, 40);

        window.setVisible(true);
        window.setSize(800, 800);

        // go back to search window
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

    /**
     * Fits text within JTextPane
     * 
     * @param textPane JTextPane
     * @param text String
     * @param width int width of JTextPane
     */
    private static void fitText(JTextPane textPane, String text,
            int width) {
        FontMetrics metrics = textPane.getFontMetrics(textPane.getFont());
        double calculation = 0; // for calculations recuiring decimals
        int before_cut = 0; //character before the text splits 
        int original_before_cut = 0; //character before the text splits (changes less frequently)
        String sentence = ""; //one line of text
        String new_text = "";// all lines of text each seperated by a \n

        while (text.length() > 0) {
            text = text.trim(); // remove any leading white spaces

            // if the text takes up mpre space than the width
            if (metrics.stringWidth(text) > width) {

                // estimates where the cut off point would be
                // (width / text size) * number of characters in the text = cut off point
                // index before cut off point = (int) cut off point  - 1
                calculation = (double) width / metrics.stringWidth(text);
                calculation = calculation * text.length();
                before_cut = (int) (calculation - 1);

                // if estimation is off
                while (metrics.stringWidth(text.substring(0,
                        before_cut + 1)) > width) {
                    before_cut--;
                }

                //saves cut off point if there is a very long word
                original_before_cut = before_cut;

                // ideally, words will not be split, except when they are very long
                while (text.charAt(before_cut + 1) != ' ') {
                    before_cut--;

                    // if word is too long, reset cut off point and add a dash
                    if (before_cut == 0) {
                        before_cut = original_before_cut;
                        while (metrics.stringWidth(text.substring(0,
                                before_cut + 1) + "-") > width) {
                            before_cut--;
                        }

                        sentence = text.substring(0, before_cut + 1) + "-";
                        break;
                    }
                }

                //if the word isn't too long resume operation
                if (sentence.charAt(sentence.length() - 1) != '-') {
                    sentence = text.substring(0, before_cut + 1);
                }

                //get rid of trailing spaces
                sentence = sentence.trim();

                //add new line
                new_text = new_text + sentence + "\n";

                //reduce text length
                text = text.substring(before_cut + 1);
            } else {

                // just add the text to the new text
                text = text.trim();
                new_text = new_text + text;
                break;
            }
        }

        textPane.setText(new_text);
    }

}
