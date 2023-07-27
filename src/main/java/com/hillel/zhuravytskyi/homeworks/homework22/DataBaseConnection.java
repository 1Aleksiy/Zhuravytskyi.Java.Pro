package com.hillel.zhuravytskyi.homeworks.homework22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String userName =System.getenv("JDBC_USER") ;
    private static final String password = System.getenv("JDBC_PASSWORD") ;
    private static final String host = System.getenv("JDBC_HOST");
    private static final String dbName = System.getenv("JDBC_DB_NAME");
    private static final String url = String.format("%s/%s",host,dbName);
    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
