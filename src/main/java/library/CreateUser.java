package library;

import javax.swing.*;
import java.awt.event.*;

/**
 * CreateUser class
 * Description: User Creation Page of library
 *
 * @author (Amy Vier)
 * @version (October 12, 2023)
 */
public class CreateUser {
    private static JFrame window = new JFrame("Password and Username Creator");

    /**
     * Creates User Creation Page of library to users.
     */
    public static void create() {
        window.setLayout(null);

        // initializing window components
        JButton back = new JButton("Back");
        window.add(back);
        back.setBounds(350, 500, 100, 40);

        JButton create = new JButton("Create");
        window.add(create);
        create.setBounds(350, 400, 100, 40);

        JTextField password = new JTextField(16);
        password.setBounds(350, 350, 100, 40);
        window.add(password);

        JTextField username = new JTextField(16);
        username.setBounds(350, 300, 100, 40);
        window.add(username);

        JLabel status = new JLabel("");
        status.setBounds(350, 250, 100, 40);
        window.add(status);

        window.setSize(800, 800);
        window.setVisible(true);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                // save all data before exiting
                LibraryOfBooks.save();
                PasswordManager.save();
                System.exit(0);
            }
        });

        // enter right username/password, create user, else redo input
        create.addActionListener((ActionEvent e) -> {
            if (PasswordManager.findUsername(username.getText()) == false) {
                PasswordManager.addUser(username.getText(), password.getText());
                clear(username, password, status);
            } else {
                status.setText("Username already exists");
            }
        });

        // Go back to main window
        back.addActionListener((ActionEvent e) -> {
            window.dispose();
            MainWindow.setVisible();

            clear(username, password, status);
        });

    }

    /**
     * Removes text from all textboxes in create user Window.
     * 
     * @param username JTextField username
     * @param password JTextField password
     */
    private static void clear(JTextField username, JTextField password, JLabel status) {
        username.setText(null);
        password.setText(null);
        status.setText(null);
    }
}
