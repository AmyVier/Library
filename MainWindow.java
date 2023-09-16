import javax.swing.*;
import java.awt.event.*;

public class MainWindow {
    public static void create() {
        JFrame window = new JFrame ("Menu");
        window.setSize(690,800);
        window.setVisible(true);

        JButton logIn = new JButton("LogIn");
        window.add(logIn);

        window.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
            }
          });
    }
}