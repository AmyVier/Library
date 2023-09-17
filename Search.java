import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.*;

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

        

        back.addActionListener((ActionEvent e) -> {
            
        });
    }
}
