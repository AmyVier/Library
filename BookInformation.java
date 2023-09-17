import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

public class BookInformation {

    public static void create() {
        JFrame window = new JFrame ("Menu");
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton back = new JButton("Go Back");
        window.add(back);
        back.setBounds(350,400,100,40);

        back.addActionListener((ActionEvent e) -> {
            
        });
    }

}
