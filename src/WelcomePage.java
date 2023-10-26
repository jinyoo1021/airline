import javax.swing.*;
import java.awt.*;

public class WelcomePage{

    JFrame frame = new JFrame();
    JLabel welcomeLable = new JLabel("Hello!");

    WelcomePage(String userID) {

        welcomeLable.setBounds(0,0,200,35);
        welcomeLable.setFont(new Font(null, Font.PLAIN, 25));
        welcomeLable.setText("Hello " + userID);

        frame.add(welcomeLable);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


}
