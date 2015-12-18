package utilities;

/**
 * Created by Daniel Shchepetov on 21.11.2015.
 */
import java.sql.*;
import java.util.ArrayList;

public class DBService {

    private static Connection connection;
    private static final String URI = "jdbc:sqlserver://localhost:1433;databaseName=semest_db;integratedSecurity=true;";

    public static Connection connect() {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


            connection = DriverManager.getConnection(URI);
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

}