package com.va.deliveryApplication.pk.view;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class LoginFormView extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb"; // Replace with your actual database URL
    private static final String DB_USER = "root"; // Replace with your actual database username
    private static final String DB_PASSWORD = "Pavneet@2003"; // Replace with your actual database password


    public LoginFormView() {
        setTitle("Login Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the content pane and set its layout
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(3, 2, 10, 10)); // Add spacing between components

        // Initialize components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Add action listener to the login button
        loginButton.addActionListener(this);

        // Add components to the content pane
        contentPane.add(new JLabel("Username:"));
        contentPane.add(usernameField);
        contentPane.add(new JLabel("Password:"));
        contentPane.add(passwordField);
        contentPane.add(new JLabel()); // Empty label for spacing
        contentPane.add(loginButton);

        // Create and set a red line border around the content pane
        Border redLineBorder = BorderFactory.createLineBorder(Color.RED, 2);
        contentPane.setBorder(BorderFactory.createCompoundBorder(redLineBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Set the content pane on the JFrame
        setContentPane(contentPane);

        setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            boolean loginSuccess = validateLogin(username, password);

            if (loginSuccess) {
                showSuccessMessage();
                // Open the main application window or perform other actions on successful login
            } else {
                showErrorMessage("Invalid username or password!");
            }

            // Clear password field for security reasons
            passwordField.setText("");
        }
    }

    private boolean validateLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT * FROM admin_data WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if there's a matching user in the database
            boolean loginSuccess = resultSet.next();

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return loginSuccess;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void showSuccessMessage() {
        JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   

