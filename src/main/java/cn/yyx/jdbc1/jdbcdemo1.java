package cn.yyx.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
      JDBC 快速入门
*/
public class jdbcdemo1 {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        //       Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");

        String sql = "update stu set score = 10 where id = 5";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        conn.close();
        stmt.close();
    }

}
