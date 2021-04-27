package cn.yyx.jdbc1;

import cn.yyx.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * 事务操作
 * */
public class jdbcdemo6 {


    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        // PreparedStatement ps = null;
        PreparedStatement ps = null;
        //1连接
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            //2定义sql
            // 1 张三 - 500
            // 2 李四 + 500
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";

            // 3 获取执行sql对象
//            int money;
//            int id;
            ps = conn.prepareStatement(sql1);
            ps.setDouble(1, 500);
            ps.setInt(2, 1);
            ps.executeUpdate();
            int i = 3 / 0;
            ps = conn.prepareStatement(sql2);
            ps.setDouble(1, 500);
            ps.setInt(2, 2);
            ps.executeUpdate();
            //conn.commit();
        } catch (Exception throwables) {
            //conn.rollback();
            throwables.printStackTrace();

        } finally {
            JDBCUtils.close(ps, conn);
        }

    }
}
