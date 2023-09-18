import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.*;

public class BookInformation {

    private static JFrame window = new JFrame();

    public static void create(Book bookInfo) {
        window.setTitle(bookInfo.getTitle());
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        back.addActionListener((ActionEvent e) -> {
            window.dispose();
            Search.setVisible();
        });
    }

    public static void setVisible() {
        window.setVisible(true);
    }

}
