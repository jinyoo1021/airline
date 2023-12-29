import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegistrationForm extends JFrame {
    /* Frame */
    JFrame frame = new JFrame();

    /* Label */
    JLabel idLabel = new JLabel("User ID");
    JLabel pwLabel = new JLabel("Password");
    JLabel confirmPwLabel = new JLabel("Confirm Password");
//    JLabel emailLabel = new JLabel("Email");

    /* TextField */
    JTextField idField = new JTextField();
    JPasswordField pwField = new JPasswordField();
    JPasswordField confirmPwField = new JPasswordField();
//    JTextField emailField = new JTextField();

    /* Button */
    JButton signupButton = new JButton("Sign Up");
    JButton signupResetButton = new JButton("Reset");

    Main o = null;

    RegistrationForm(Main _o) {
        o = _o;

        /* Set frame*/
        frame.setTitle("Sign Up");
        frame.setSize(420, 800);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* set Location and Size */
        idLabel.setBounds(50,100,75,25);
        pwLabel.setBounds(50,150,75,25);
        confirmPwLabel.setBounds(50, 200, 120, 25);
//        emailLabel.setBounds(50, 250, 75, 25);

        idField.setBounds(200, 100, 150, 25);
        pwField.setBounds(200, 150, 150, 25);
        confirmPwField.setBounds(200, 200, 150, 25);
//        emailField.setBounds(200, 250, 150, 25);

        signupButton.setBounds(250,300,100,25);
        signupButton.setFocusable(false);

        signupResetButton.setBounds(40, 300, 100, 25);
        signupResetButton.setFocusable(false);

        /* add compton */
        frame.add(idLabel);
        frame.add(pwLabel);
        frame.add(confirmPwLabel);
//        frame.add(emailLabel);
        frame.add(idField);
        frame.add(pwField);
        frame.add(confirmPwField);
//        frame.add(emailField);
        frame.add(signupButton);
        frame.add(signupResetButton);

        /* ButtonEventListener */
        ButtonListener bl = new ButtonListener();
        signupButton.addActionListener(bl);
        signupResetButton.addActionListener(bl);
    }

    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            /* get strings */
            String uid = idField.getText();
            String upass = String.valueOf(pwField.getPassword());
            String ucfpass = String.valueOf(confirmPwField.getPassword());

            /* reset Button */
            if(e.getSource() == signupResetButton) {
                idField.setText("");
                pwField.setText("");
                confirmPwField.setText("");
//            emailField.setText("");
            }

            /* Sign up Button*/
            if(e.getSource() == signupButton) {
                if (uid.isEmpty() || upass.isEmpty() || ucfpass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "not enough info", "sign up failed", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Sign Up Failed, not enough info");
                }
                else if (!(upass.equals(ucfpass))) {
                    JOptionPane.showMessageDialog(null, "double check password and confirm password", "sign up failed", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Sign Up Failed, def password and confirm");
                }
                else if (!uid.isEmpty() && !upass.isEmpty() && !ucfpass.isEmpty()){
                    if (o.db.joinCheck(uid, upass)) {
                        System.out.println("Sign up Success");
                        JOptionPane.showMessageDialog(null, "Sign up Successful");
                        frame.dispose();
                    } else {
                        System.out.println("Sign up Fail in form");
                        JOptionPane.showMessageDialog(null, "Sign up Failed");
                        idField.setText("");
                        pwField.setText("");
                        confirmPwField.setText("");
                    }
                }
            }
        }
    }
}
