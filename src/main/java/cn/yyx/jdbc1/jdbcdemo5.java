package cn.yyx.jdbc1;

import cn.yyx.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 练习
 *       *需求
 *           1.键入用户名密码
 *           2.判断用户是否登陆成功
 * */
public class jdbcdemo5 {

    /*
     * 登陆方法
     *
     * */
    public static void main(String[] args) throws SQLException {
        //1 键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //2 调用方法

        //3 判断结果
        if (login(username, password)) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("用户名或密码错误!");
        }

    }

    public static boolean login(String username, String password) throws SQLException {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //判断数据库连接是否成功
        //1 获取连接SELECT * FROM USER;
        try {
            conn = JDBCUtils.getConnection();
            //2 定义sql语句
            String sql = "select * from user where username = ? and password = ?";
            System.out.println(sql);
            //3 获取执行sql的对象
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            //4 执行查询
            rs = stmt.executeQuery();   //如果有下一行 rs.next();
            //5 判
        /*if(rs!=null){
                return  true;
            }else{
                return  false;
            }
        */

            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn, rs);

        }


        return false;
    }

}
