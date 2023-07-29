package com.va.deliveryApplication.pk.view;
import javax.swing.*;

import com.va.deliveryApplication.pk.model.*;

import java.awt.*;

public class AdminFormView extends JFrame {
    private JLabel fullNameLabel, usernameLabel, passwordLabel, confirmPasswordLabel, phoneLabel, emailLabel;
    private JTextField fullNameField, usernameField, phoneField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton submitButton, resetButton;

    public AdminFormView() {
        // Set up the JFrame
        setTitle("Admin Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        // Initialize components
        fullNameLabel = new JLabel("Full Name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");
        phoneLabel = new JLabel("Phone:");
        emailLabel = new JLabel("Email:");

        fullNameField = new JTextField(20);
        usernameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);

        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");

        // Add components to the JFrame
        add(fullNameLabel);
        add(fullNameField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(phoneLabel);
        add(phoneField);
        add(emailLabel);
        add(emailField);
        add(submitButton);
        add(resetButton);

        // Set JFrame visible
        setVisible(true);
    }
    // Getter methods for the components
    public JTextField getFullNameField() {
        return fullNameField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }
    // Method to save the AdminForm data to the database
    public void saveDataToDatabase() {
        // Get the data from the UI components
        String fullName = fullNameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String phone = phoneField.getText();
        String email = emailField.getText();

        // Check if the passwords match
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create an instance of AdminForm with the user data
        AdminForm adminForm = new AdminForm(fullName, username, password, phone, email);

        // Save the data to the database
        AdminFormDb adminDAO = new AdminFormDb();
       boolean isSaved= adminDAO.insertAdminForm(adminForm);
       // Check if the data was successfully saved to the database
       if (isSaved) {
           // Show a success message
           JOptionPane.showMessageDialog(this, "Form data saved to the database!", "Success", JOptionPane.INFORMATION_MESSAGE);
           // Clear the form fields
           clearFormFields();
       } else {
           // Show an error message if the data couldn't be saved
    	   JOptionPane.showMessageDialog(this, "Form data saved to the database!", "Success", JOptionPane.INFORMATION_MESSAGE);
           // Clear the form fields
           clearFormFields();
       }
    }
    private void clearFormFields() {
        fullNameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        phoneField.setText("");
        emailField.setText("");
    } 
    

}

