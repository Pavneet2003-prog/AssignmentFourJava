package com.va.deliveryApplication.jk.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeliveryDetailsView extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel paymentMethod, cardNumber, promoCode, address;
    JTextField jkPaymentMethod, jkCardNumber, jkPromoCode, jkAddress;
    JButton display;
    JTextArea displayData;
    JScrollPane scrollPane;

    public DeliveryDetailsView() {
        setVisible(true);
        setLayout(null);
        setTitle("Please provide your details for the delivery");
        setSize(500, 500);
        setLocationRelativeTo(null);

        // label
        paymentMethod = new JLabel("Payment Method");
        cardNumber = new JLabel("Card Number");
        promoCode = new JLabel("Promo Code");
        address = new JLabel("Address");

        add(paymentMethod);
        add(cardNumber);
        add(promoCode);
        add(address);

        paymentMethod.setBounds(50, 100, 80, 20);
        cardNumber.setBounds(50, 140, 80, 20);
        promoCode.setBounds(50, 180, 80, 20);
        address.setBounds(50, 220, 80, 20);

        // textField

        jkPaymentMethod = new JTextField();
        jkCardNumber = new JTextField();
        jkPromoCode = new JTextField();
        jkAddress = new JTextField();

        add(jkPaymentMethod);
        add(jkCardNumber);
        add(jkPromoCode);
        add(jkAddress);

        jkPaymentMethod.setBounds(160, 100, 120, 20);
        jkCardNumber.setBounds(160, 140, 120, 20);
        jkPromoCode.setBounds(160, 180, 120, 20);
        jkAddress.setBounds(160, 220, 120, 20);

        // button
        display = new JButton("Display");

        add(display);

        display.setBounds(100, 280, 100, 20);

        // textArea
        displayData = new JTextArea();
        scrollPane = new JScrollPane(displayData);

        add(scrollPane);

        scrollPane.setBounds(2, 350, 498, 100);

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String paymentMethod = jkPaymentMethod.getText().trim();
                    String cardNumber = jkCardNumber.getText().trim();
                    String promoCode = jkPromoCode.getText().trim();
                    String address = jkAddress.getText().trim();

                    // Validate payment method
                    if (paymentMethod.isEmpty()) {
                        throw new Exception("Please choose the payment method.");
                    }

                    // Validate card number (should be a valid 16-digit number)
                    if (!cardNumber.matches("\\d{16}")) {
                        throw new Exception("Card number should be a valid 16-digit number.");
                    }

                    // Validate promo code (should not be empty)
                    if (promoCode.isEmpty()) {
                        throw new Exception("Please enter the promo code.");
                    }

                    // Validate address (should not be empty)
                    if (address.isEmpty()) {
                        throw new Exception("Please enter the address.");
                    }

                    insertDeliveryData(paymentMethod, cardNumber, promoCode, address);

                    // If all validations pass, display the data in the text area
                    displayData.setText(
                            "Payment Method: " + paymentMethod + "\n" +
                            "Card Number: " + cardNumber + "\n" +
                            "Promo Code: " + promoCode + "\n" +
                            "Address: " + address
                    );

                } catch (Exception ex) {
                    // If an exception is caught, show an error message in the text area
                    displayData.setText("Error: " + ex.getMessage());
                }
            }
        });
    }

    private void insertDeliveryData(String paymentMethod, String cardNumber, String promoCode, String address) {
        try {
            // Connect to the database
            String dbUrl = "jdbc:mysql://localhost:3306/jasmine";
            String username = "root";
            String password = "Jass#benipal2012";
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Insert data into the delivery_details table
            String insertDeliveryQuery = "INSERT INTO delivery (payment_method, card_number, promo_code, address) VALUES (?, ?, ?, ?)";
            PreparedStatement deliveryStatement = connection.prepareStatement(insertDeliveryQuery);
            deliveryStatement.setString(1, paymentMethod);
            deliveryStatement.setString(2, cardNumber);
            deliveryStatement.setString(3, promoCode);
            deliveryStatement.setString(4, address);
            deliveryStatement.executeUpdate();

            // Close the delivery statement
            deliveryStatement.close();

            // Close the database connection
            connection.close();

        } catch (SQLException ex) {
            displayData.setText("Error: Failed to connect to the database or insert data.\n");
            ex.printStackTrace();
        }
    }
}

