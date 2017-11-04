package com.eda.util;

import java.sql.*;

/**
 * 公共数据库访问连接类。
 */
public class DBConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver"; // driver name
    private static final String DBURL = "jdbc:mysql://192.168.129.130:3306/db_affairmanage";
    private static final String DBUSER = "javaweb"; // user name
    private static final String DBPASSWORD = "javaweb"; // password

    // Get connection object.
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.print("Connection Dirver cant found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection info is wrong.");
            e.printStackTrace();
        }
        return conn;
    }

    // Close connection.
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();   // close connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Close preparedstatement.
    public static void close(PreparedStatement pstmt){
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Close resultset.
    public static void close(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

