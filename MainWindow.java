import javax.swing.*;
import java.awt.event.*;

public class MainWindow {
    public static void create() {
        JFrame window = new JFrame ("Menu");
        window.setLayout(null);

        JButton logIn = new JButton("LogIn");
        window.add(logIn);
        logIn.setBounds(100,100,100,100);
        JTextField password = new JTextField(16);  
        password.setBounds(20,10, 100,100);  
        window.add(password);

        window.setSize(690,800);
        window.setVisible(true);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logIn.addActionListener((ActionEvent e) -> {
          System.out.println(password.getText());
        });
    }
}