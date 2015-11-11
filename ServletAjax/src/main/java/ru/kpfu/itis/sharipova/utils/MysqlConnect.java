package ru.kpfu.itis.sharipova.utils;

import java.sql.*;

/**
 * Created by Baths on 04.11.2015.
 */
public class MysqlConnect {
    public Connection conn;
    private Statement statement;
    public static MysqlConnect db;
    private MysqlConnect() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "servlets_db";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "jw1668Xq";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized MysqlConnect getDbCon() {
        if ( db == null ) {
            db = new MysqlConnect();
        }
        return db;

    }
}
