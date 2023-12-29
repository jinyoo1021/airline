import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    

    /* Label */
    JLabel userIdLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    
    /* TextField */
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    /* Button */
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton signupButton = new JButton("Sign Up");
    JButton exitButton = new JButton("exit");

    Main o = null;

    LoginPage(Main _o) {
        o = _o;

        frame.setTitle("Login");

        /* Label size */
        userIdLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        /* TextField size */
        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        /* Login Button setup */
        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        /* reset Button setup */
        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        /* signup Button setup */
        signupButton.setBounds(125,230,100,25);
        signupButton.setFocusable(false);
        signupButton.addActionListener(this);

        /* exit Button setup */
        exitButton.setBounds(225, 230, 100, 25);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        /* add in frame */
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(signupButton);
        frame.add(exitButton);

        /* base frame setup */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String uid = userIDField.getText();
        String upass = String.valueOf(userPasswordField.getPassword());

        /* reset Button */
        if(e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        /* exit Button */
        else if(e.getSource() == exitButton) {
            System.out.println("exit program");
            System.exit(0);
        }

        /* signup Button */
        else if(e.getSource() == signupButton) {
            o.rf.frame.setVisible(true);
        }

        /* login Button */
        else if(e.getSource() == loginButton) {
            if (uid.isEmpty() || upass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill in both", "login failed", JOptionPane.ERROR_MESSAGE);
                System.out.println("login failed for empty");
            }

            else if(uid != null && upass != null) {
                if(o.db.logincheck(uid, upass)) {
                    System.out.println("Login Success");
                    JOptionPane.showMessageDialog(null, "Login Successful");
//                    o.wp.gettext(uid);
//                    o.wp.frame.setVisible(true);
                } else {
                    System.out.println("Login Fail > info doesn't match");
                    JOptionPane.showMessageDialog(null, "Login Failed");
                }
            }
        }
    }
}
