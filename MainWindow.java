import javax.swing.*;
import java.awt.event.*;

public class MainWindow {
    public static void create() {
        JFrame window = new JFrame ("Menu");
        window.setLayout(null);

        JButton logIn = new JButton("LogIn");
        window.add(logIn);
        logIn.setBounds(350,400,100,40);

        JTextField password = new JTextField(16);  
        password.setBounds(350,350, 100,40);  
        window.add(password);

        JTextField username = new JTextField(16);  
        username.setBounds(350,300, 100,40);  
        window.add(username);

        window.setSize(800,800);
        window.setVisible(true);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PasswordManager users = new PasswordManager();
        users.addUser("AmyV", "LOL");

        logIn.addActionListener((ActionEvent e) -> {
          if (users.findUser(username.getText(), password.getText())) {
            System.out.println("HELL YEAH");
          }
        });
    }
}