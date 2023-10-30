import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Arrays;


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
        setLocationAndSize();
        addComptoFream();
        actionEvent();
    }

    public void openForm() {
        frame = new JFrame();
        frame.setTitle("Sign Up");
        frame.setSize(420, 800);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setLocationAndSize() {
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

    }

    public void addComptoFream() {
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

    public void actionEvent() {
        registerButton.addActionListener(this);
        signupResetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == signupResetButton) {
            nameTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            emailField.setText("");
        }
        
        if(e.getSource() == registerButton) {

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234");
                PreparedStatement Pstatement = connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");

                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2, Arrays.toString(passwordField.getPassword()));
                Pstatement.setString(3, Arrays.toString(confirmPasswordField.getPassword()));
                Pstatement.setString(4,emailField.getText());

                //Checking for the Password match
                if(Arrays.equals(passwordField.getPassword(), confirmPasswordField.getPassword())){
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Registered Successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Password did not match");
                }
            }
            catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }
}
