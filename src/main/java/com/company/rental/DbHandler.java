package com.company.rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler {

    public static Connection connection = null;

    public static void  connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DbHandler.connection = DriverManager.getConnection("jdbc:mysql://192.168.203.130:3306/carsrent?user=root&password=MyNewPass4!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
