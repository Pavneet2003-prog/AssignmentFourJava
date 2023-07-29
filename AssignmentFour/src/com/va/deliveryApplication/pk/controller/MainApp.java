package com.va.deliveryApplication.pk.controller;
import com.va.deliveryApplication.pk.model.*;

import com.va.deliveryApplication.jk.controller.*;
import com.va.deliveryApplication.jk.model.*;
import com.va.deliveryApplication.jk.view.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.va.deliveryApplication.pk.view.*;

import javax.swing.SwingUtilities;

public class MainApp extends JFrame {

    public MainApp() {
        setTitle("Delivery Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(Color.BLUE);

        JButton orderButton = new JButton("Register");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AdminFormView view = new AdminFormView();
            	AdminForm model = new AdminForm();
            	AdminFormController controller = new AdminFormController(view, model);

                view.setVisible(true);
                
            }
        });
        JButton productButton = new JButton("Login");
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 SwingUtilities.invokeLater(() -> new LoginFormView());
            	 
            }
        });
        JButton deliveryButton = new JButton("Delivery Info");
        // Action Listener for placeOrder button
        deliveryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new DeliveryDetailsView();

			}
		});
        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new PlaceOrderView();

			}
		});
        
        
       

        // Add your components to the panel

        // Set the panel as the content pane of the frame
        orderButton.setBackground(Color.RED);
        productButton.setBackground(Color.green);
        deliveryButton.setBackground(Color.YELLOW);
        placeOrderButton.setBackground(Color.ORANGE);
      

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.add(orderButton);
        panel.add(productButton);
     panel.add(deliveryButton);
     panel.add(placeOrderButton);
        add(panel);
        setContentPane(panel);
        setVisible(true);
    }
    public void showMainFrame() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainApp mainClass = new MainApp();
                mainClass.setVisible(true);
            }
        });
    }

}


//SwingUtilities.invokeLater(() -> {
//AdminFormView view = new AdminFormView();
//AdminForm model = new AdminForm();
//AdminFormController controller = new AdminFormController(view, model);
//});

