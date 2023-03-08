package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/cars";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Util() {}
    public static Connection getconnection() throws SQLException{
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Соединение с базой данных не установлено");
            throw e;
        }
    }
}
