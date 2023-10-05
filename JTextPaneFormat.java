import javax.swing.JTextPane;
import java.awt.FontMetrics;

public class JTextPaneFormat {

    /**
     * Fits text within JTextPane
     * 
     * @param textPane JTextPane
     * @param text String
     * @param width int width of JTextPane
     */
    public static void fitText(JTextPane textPane, String text,
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
