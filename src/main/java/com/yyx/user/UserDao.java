package com.yyx.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private ResultSet rs;
    private PreparedStatement pst;
    private Connection conn;

    public List<user> querrAll() { //在数据库中取值，并返回。
        //建立一个集合存放取出的值
        List<user> ulist = new ArrayList<user>();
        try {
            //调用工具类中的getConnection()方法连接数据库。
            conn = JDBCUtils.getConnection();
            //声明需要对数据库进行的
            pst = conn.prepareStatement("select * from tuser");
            //从数据库中取值。
            rs = pst.executeQuery();
            while (rs.next()) {
                //调用user里面的set方法给u赋值
                user u = new user();
                u.setAddress(rs.getString("address"));
                u.setAge(rs.getInt("age"));
                u.setID(rs.getInt("iD"));
                u.setName(rs.getString("name"));
                //将从数据库取到的值放入ulist中。
                ulist.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //调用工具类中的close()方法关闭资源。
            JDBCUtils.close(pst, conn, rs);
        }
        //将从数据库中取到的值输出。
        return ulist;

    }

    public boolean add(user u) {
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement("insert into tuser values(?,?,?,?)");
            pst.setInt(1, u.getID());
            pst.setString(2, u.getName());
            pst.setInt(3, u.getAge());
            pst.setString(4, u.getAddress());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pst, conn);
        }
        return false;
    }

    public boolean del(int id) {
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement("delete from tuser where id= ? ");
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pst, conn);
        }
        return false;

    }

    public user querryById(int id) {
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement("select * from tuser where id=" + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                user u = new user();
                u.setAddress(rs.getString("address"));
                u.setAge(rs.getInt("age"));
                u.setID(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pst, conn, rs);
        }
        return null;
    }

    public boolean update(user u) {
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement("update tuser set name=?,age=?,address=? where id=" + u.getID());
            pst.setString(1, u.getName());
            pst.setInt(2, u.getAge());
            pst.setString(3, u.getAddress());
            pst.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pst, conn);
        }
        return false;
    }
}