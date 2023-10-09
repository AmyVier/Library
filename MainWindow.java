import javax.swing.*;
import java.awt.event.*;

/**
 * MainWindow class
 * Description: Main Window of library
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class MainWindow {

  private static JFrame window = new JFrame("Menu");

  /**
   * Creates Main Window of library for user login.
   */
  public static void create() {
    window.setLayout(null);

    // initializing window components
    JButton admin = new JButton("admin");
    window.add(admin);
    admin.setBounds(350, 500, 100, 40);

    JButton logIn = new JButton("LogIn");
    window.add(logIn);
    logIn.setBounds(350, 400, 100, 40);

    JTextField password = new JTextField(16);
    password.setBounds(350, 350, 100, 40);
    window.add(password);

    JTextField username = new JTextField(16);
    username.setBounds(350, 300, 100, 40);
    window.add(username);

    JButton newUser = new JButton("new?");
    newUser.setBounds(350, 250, 100, 40);
    window.add(newUser);

    window.setSize(800, 800);
    window.setVisible(true);

    // for debugging
    //users.addUser("AmyV", "LOL");

    //update();

    // initialize saved data
    PasswordManager.initialize();
    LibraryOfBooks.initialize();

    window.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent ev) {
          LibraryOfBooks.save();
          PasswordManager.save();
          System.exit(0);
      }
  });
  

    // enter right username/password, go into search window, else redo input
    logIn.addActionListener((ActionEvent e) -> {
      if (PasswordManager.findUser(username.getText(), password.getText())) {
        window.setVisible(false);
        Search.create();
        clear(username, password);
      } else {
        clear(username, password);
      }
    });

    // enter user creation page
    newUser.addActionListener((ActionEvent e) -> {
      window.setVisible(false);
      CreateUser.create();
      clear(username, password);
    });

    // enter admin page
    admin.addActionListener((ActionEvent e) -> {
      window.setVisible(false);
      AdminPage.create();
      clear(username, password);
    });
  }

  /**
   * Removes text from all textboxes in Main Window.
   * 
   * @param username JTextField username
   * @param password JTextField password
   */
  private static void clear(JTextField username, JTextField password) {
    username.setText(null);
    password.setText(null);
  }

  /**
   * Sets the visibility of main window to true.
   */
  public static void setVisible() {
    window.setVisible(true);
  }
}