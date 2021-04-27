package cn.yyx.jdbc1;

import cn.yyx.trylist.Stu;
import cn.yyx.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcdemo4 {
    /*
     *查询所有stu对象
     *
     */
    ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    List<Stu> list = null;

    public static void main(String[] args) {
        List<Stu> list = new jdbcdemo4().findAll2();
        System.out.println(list);
    }

    public List<Stu> findAll2() {
        //1.注册驱动

        //2.获取连接
        //Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from stu";
            //4.获取执行sql的对象
            stmt = this.conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Stu stu = null;
            list = new ArrayList<Stu>();
            while (rs.next()) {
                //获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                Date birthday = rs.getDate("birthday");
                Date insert_time = rs.getDate("insert_time");//子类给父类装载，父类类型可以接收子类对象
                String sex = rs.getString("sex");
                stu = new Stu();
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                stu.setScore(score);
                stu.setBirthday(birthday);
                stu.setInsert_time(insert_time);
                stu.setSex(sex);
                //装载集合
                list.add(stu);

            }
            JDBCUtils.close(stmt, conn, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
