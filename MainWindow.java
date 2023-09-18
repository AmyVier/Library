import javax.swing.*;
import java.awt.event.*;

public class MainWindow {

  private static JFrame window = new JFrame("Menu");

    public static void create() {
        window.setLayout(null);

        JButton admin = new JButton("admin");
        window.add(admin);
        admin.setBounds(350,500,100,40);

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

        PasswordManager.addUser("AmyV", "LOL");

        logIn.addActionListener((ActionEvent e) -> {
          if (PasswordManager.findUser(username.getText(), password.getText())) {
            window.dispose();
            Search.create();
            clear(username, password);
          }
        });

        admin.addActionListener((ActionEvent e) -> {
          window.dispose();
          AdminPage.create();
          clear(username, password);
        });
    }

    private static void clear(JTextField username, JTextField password) {
      username.setText(null);
      password.setText(null);
    }

    public static void setVisible() {
      window.setVisible(true);
    }
}