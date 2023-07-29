package com.va.deliveryApplication.pk.model;

import java.sql.*;


public class AdminFormDb {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb"; // Replace with your actual database URL
    private static final String DB_USER = "root"; // Replace with your actual database username
    private static final String DB_PASSWORD = "Pavneet@2003"; // Replace with your actual database password

    // Method to insert the AdminForm data into the database
    public boolean insertAdminForm(AdminForm adminForm) {
    	 if (isUsernameTaken(adminForm.getUsernamepk())) {
             // Username is already taken
             return false;
         }

       
        try {
        
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "INSERT INTO admin_data (full_name, username, password, phone, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, adminForm.getFullNamepk());
            preparedStatement.setString(2, adminForm.getUsernamepk());
            preparedStatement.setString(3, adminForm.getPasswordpk());
            preparedStatement.setString(4, adminForm.getPhonepk());
            preparedStatement.setString(5, adminForm.getEmail());

            preparedStatement.executeUpdate();

            preparedStatement.close();
          //Execute SQL query
            int res = preparedStatement.executeUpdate();
            //Display the records inserted
            System.out.println(res + " records inserted");
          
            connection.close();
            // Return true if data was successfully saved (rowsAffected > 0), false otherwise
            return res > 0;
        } catch (SQLException e) {
        	
         // Return false if there was an error while saving the data to the database
            return false;
        }
    }

    // Method to check if a username is already taken
    public boolean isUsernameTaken(String username) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT COUNT(*) FROM admin_table WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            resultSet.close();
            preparedStatement.close();
            connection.close();

            // Return true if the username is taken (count > 0), false otherwise
            return count > 0;
        } catch (SQLException e) {
            
            // Return false if there was an error while querying the database
            return false;
        }
    }
    // Method to check if an email is already taken
    public boolean isEmailTaken(String email) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT COUNT(*) FROM admin_table WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            resultSet.close();
            preparedStatement.close();
            connection.close();

            // Return true if the email is taken (count > 0), false otherwise
            return count > 0;
        } catch (SQLException e) {
           
            // Return false if there was an error while querying the database
            return false;
        }
    }
}




