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

public class PlaceOrderView extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel itemName, orderId, quantity, price;
    JTextField jkItemName, jkOrderId, jkQuantity, jkPrice;
    JButton display;
    JTextArea displayData;
    JScrollPane scrollPane;

  public  PlaceOrderView() {
        setVisible(true);
        setLayout(null);
        setTitle("Please place your order");
        setSize(500, 500);
        setLocationRelativeTo(null);

        // label
        itemName = new JLabel("Item Name");
        orderId = new JLabel("Order Id");
        quantity = new JLabel("Quantity");
        price = new JLabel("Price");

        add(itemName);
        add(orderId);
        add(quantity);
        add(price);

        itemName.setBounds(50, 100, 80, 20);
        orderId.setBounds(50, 140, 80, 20);
        quantity.setBounds(50, 180, 80, 20);
        price.setBounds(50, 220, 80, 20);

        // textField
        jkItemName = new JTextField();
        jkOrderId = new JTextField();
        jkQuantity = new JTextField();
        jkPrice = new JTextField();

        add(jkItemName);
        add(jkOrderId);
        add(jkQuantity);
        add(jkPrice);

        jkItemName.setBounds(160, 100, 120, 20);
        jkOrderId.setBounds(160, 140, 120, 20);
        jkQuantity.setBounds(160, 180, 120, 20);
        jkPrice.setBounds(160, 220, 120, 20);

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
                    String jk_ItemName = jkItemName.getText();
                    String jk_OrderId = jkOrderId.getText();
                    int jk_Quantity = Integer.parseInt(jkQuantity.getText());
                    double jk_Price = Double.parseDouble(jkPrice.getText());

                    // Additional exception handling for parsing integers and doubles
                    if (jk_ItemName.isEmpty()) {
                        throw new IllegalArgumentException("Item Name cannot be empty.");
                    }
                    if (jk_OrderId.isEmpty()) {
                        throw new IllegalArgumentException("Order ID cannot be empty.");
                    }
                    if (jk_Quantity <= 0) {
                        throw new IllegalArgumentException("Quantity must be a positive number.");
                    }
                    if (jk_Price <= 0) {
                        throw new IllegalArgumentException("Price must be a positive number.");
                    }

                    insertOrderData(jk_ItemName, jk_OrderId, jk_Quantity, jk_Price);

                    displayData.append(jk_ItemName + "\n" + jk_OrderId + "\n" + jk_Quantity + "\n" + jk_Price + "\n");
                } catch (NumberFormatException ex) {
                    // Handle the exception caused by invalid input for quantity or price
                    displayData.append("Error: Invalid quantity or price. Please enter valid numbers.\n");
                } catch (IllegalArgumentException ex) {
                    // Handle the exception caused by other validation issues
                    displayData.append("Error: " + ex.getMessage() + "\n");
                }
            }
        });
    }

    private void insertOrderData(String itemName, String orderId, int quantity, double price) {
        try {
            // Connect to the database
            String dbUrl = "jdbc:mysql://localhost:3306/jasmine";
            String username = "root";
            String password = "Jass#benipal2012";
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Insert data into the orders table
            String insertOrderQuery = "INSERT INTO PlaceOrders (item_name, order_id, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement orderStatement = connection.prepareStatement(insertOrderQuery);
            orderStatement.setString(1, itemName);
            orderStatement.setString(2, orderId);
            orderStatement.setInt(3, quantity);
            orderStatement.setDouble(4, price);
            orderStatement.executeUpdate();

            // Close the order statement
            orderStatement.close();

            // Close the database connection
            connection.close();

        } catch (SQLException ex) {
            displayData.append("Error: Failed to connect to the database or insert data.\n");
            ex.printStackTrace();
        }
    }
}

