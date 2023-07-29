//package com.va.deliveryApplication.pk.controller;
//
//
//import com.va.deliveryApplication.pk.view.LoginFormView;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JOptionPane;
//
//public class LoginFormController {
//    private LoginFormView view;
//
//    public LoginFormController(LoginFormView view) {
//        this.view = view;
//        initializeListeners();
//    }
//
//    private void initializeListeners() {
//        // Add action listener to the "Login" button
//        view.getLoginButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // When the "Login" button is clicked, you can perform the login logic here
//                // For now, let's just show a message indicating successful login
//                String username = view.getUsernameField().getText();
//                String password = new String(view.getPasswordField().getPassword());
//
//                if (isValidLogin(username, password)) {
//                    showSuccessMessage();
//                } else {
//                    showErrorMessage();
//                }
//            }
//        });
//    }
//
//    // You can implement the actual login logic here (e.g., validating credentials against a database).
//    private boolean isValidLogin(String username, String password) {
//        // For this example, let's consider any non-empty username and password as a valid login.
//        return !username.trim().isEmpty() && password.length() > 0;
//    }
//
//    private void showSuccessMessage() {
//        // Show a success message indicating successful login.
//        // In a real-world application, this would lead to opening the main application window.
//    	 JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
//    }
//
//    private void showErrorMessage() {
//        // Show an error message indicating unsuccessful login.
//    	 JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
//    }
//}
//
