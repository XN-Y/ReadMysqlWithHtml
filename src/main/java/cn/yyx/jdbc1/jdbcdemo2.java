package cn.yyx.jdbc1;

import java.sql.*;

public class jdbcdemo2 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select * from stu";
                            /* "create table s(id int , name varchar (20))";
                            "update stu set score = 100 where id=6"
                            "insert into stu (id,name,score) values (6,'马格',60);" +
                            "insert into stu (id,name,score) values (6,'马格',60);" +
                            "insert into stu (id,name,score) values (8,'沈腾',88);" +
                             "update stu set score = 58 where id = 8;"+
                            "delete from stu where id=6;"
                    "create table nani (id int,name varchar (10))";*/

            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            stmt = conn.createStatement();


            //int count = stmt.executeUpdate(sql);
           /* if(count>0) {
                System.out.println("添加成功！");
                System.out.println(count);
            }else{
                System.out.println("添加失败！");}*/
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String score = rs.getString("score");
                String birthday = rs.getString("birthday");
                String insert_time = rs.getString("insert_time");
                String sex = rs.getString("sex");
                System.out.println("id " + id + " name " + name + " age " + age + " score " + score + " birthday " + birthday + " insert_time " + insert_time + " sex " + sex);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }

}

