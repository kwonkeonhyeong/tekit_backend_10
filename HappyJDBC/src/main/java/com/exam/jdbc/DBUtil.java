package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    // DB 접속
    public static Connection getConnection() throws Exception{
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost:3307/tekitexam";
        String user = "rjsgud1956";
        String password = "root1234";
        conn = getConnection(dbUrl,user,password);
        return conn;
    }

    public static Connection getConnection(String dbUrl, String user, String password) throws Exception{
        Connection conn = null;
        conn = DriverManager.getConnection(dbUrl,user,password);
        return conn;
    }

    // DB close
    public static void close(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void close(Connection conn, Statement statement) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn);
    }
    public static void close(Connection conn, Statement statement, ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn,statement);
    }
}
