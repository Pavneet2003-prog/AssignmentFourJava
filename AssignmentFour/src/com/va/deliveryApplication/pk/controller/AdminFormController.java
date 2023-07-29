package com.va.deliveryApplication.pk.controller;
import com.va.deliveryApplication.pk.model.*;
import com.va.deliveryApplication.pk.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AdminFormController {
    private AdminFormView view;
    private AdminForm model;

    public AdminFormController(AdminFormView view, AdminForm model) {
        this.view = view;
        this.model = model;

        // Add action listeners to buttons
        view.getSubmitButton().addActionListener(new SubmitButtonListener());
        view.getResetButton().addActionListener(new ResetButtonListener());
    }

    // ActionListener for the Submit button
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get data from the view and update the model
            model.setFullNamepk(view.getFullNameField().getText());
            model.setUsernamepk(view.getUsernameField().getText());
            model.setPasswordpk(new String(view.getPasswordField().getPassword()));
            model.setPhonepk(view.getPhoneField().getText());
            model.setEmail(view.getEmailField().getText());

            // Perform any validation or processing here if needed
            // For example, check if the passwords match, validate email, etc.
            view.saveDataToDatabase();
            // Display a message dialog with the entered data
            String message = "Full Name: " + model.getFullNamepk() + "\n"
                    + "Username: " + model.getUsernamepk() + "\n"
                    + "Phone: " + model.getPhonepk() + "\n"
                    + "Email: " + model.getEmail();

            JOptionPane.showMessageDialog(view, message, "Data Entered", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ActionListener for the Reset button
    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear all fields in the view
            view.getFullNameField().setText("");
            view.getUsernameField().setText("");
            view.getPasswordField().setText("");
            view.getConfirmPasswordField().setText("");
            view.getPhoneField().setText("");
            view.getEmailField().setText("");
        }
    }
}

