package com.yyx.user;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
 * JDBC工具类
 * */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
     * 获取连接
     * @return连接对象*/
    static {


        try {
            Properties pro = new Properties();
            ClassLoader cl = cn.yyx.util.JDBCUtils.class.getClassLoader();
            URL res = cl.getResource("jdbc.properties");
//            pro.load(new FileReader("D:\\Workspaces1\\yyx\\jdbc\\src\\jdbc.properties"));
            String path = res.getPath();
//          System.out.println(path);
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    public static void close(Statement stmt, Connection conn, ResultSet rs) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

   /* public static void close(PreparedStatement stmt, Connection conn, ResultSet rs){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }*/

}
