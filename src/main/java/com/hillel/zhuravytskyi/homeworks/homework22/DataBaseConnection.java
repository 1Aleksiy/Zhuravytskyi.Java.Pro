package com.hillel.zhuravytskyi.homeworks.homework22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    static String userName =System.getenv("JDBC_USER") ;
    static String password = System.getenv("JDBC_PASSWORD") ;
    static String host = System.getenv("JDBC_HOST");
    static String dbName = System.getenv("JDBC_DB_NAME");
    static String url = String.format("%s/%s",host,dbName);
    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
