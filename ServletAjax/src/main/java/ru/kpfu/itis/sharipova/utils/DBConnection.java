package ru.kpfu.itis.sharipova.utils;

import java.sql.*;

/**
 * Created by Baths on 03.11.2015.
 */
public class DBConnection {
    public static Connection getDBConnection()
    {
        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/servlets_db",
                    "root",
                    "jw1668Xq");

        }
        catch (SQLException e)
        {
            e.getLocalizedMessage();
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
        return connection;
    }
}
