import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registrationForm implements ActionListener {
    JFrame frame;

    JLabel nameLabel = new JLabel("User ID");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    JLabel emailLabel = new JLabel("Email");

    JTextField nameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JTextField emailField = new JTextField();

    JButton registerButton = new JButton("Sign Up");
    JButton signupResetButton = new JButton("Reset");

    registrationForm() {
        openForm();
    }

    public void openForm() {
        frame = new JFrame();
        frame.setTitle("Sign Up");
        frame.setSize(420, 800);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        nameLabel.setBounds(50,100,75,25);
        passwordLabel.setBounds(50,150,75,25);
        confirmPasswordLabel.setBounds(50, 200, 120, 25);
        emailLabel.setBounds(50, 250, 75, 25);

        nameTextField.setBounds(200, 100, 150, 25);
        passwordField.setBounds(200, 150, 150, 25);
        confirmPasswordField.setBounds(200, 200, 150, 25);
        emailField.setBounds(200, 250, 150, 25);

        registerButton.setBounds(250,300,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        signupResetButton.setBounds(40, 300, 100, 25);
        signupResetButton.setFocusable(false);
        signupResetButton.addActionListener(this);

        frame.add(nameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(emailField);
        frame.add(registerButton);
        frame.add(signupResetButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
