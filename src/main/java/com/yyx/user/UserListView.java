package com.yyx.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "listView", value = "/listView")
public class UserListView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设定网页的编码格式。
        resp.setContentType("text/html;charset=utf-8");
        List<user> ulist = (List<user>) req.getAttribute("ulist");
        //获得输出流
        PrintWriter out = resp.getWriter();
        //开始往网页上输出。
        out.print("<html>");
        out.print("<head>");
        out.print("</head>");
        out.print("<body>");
        out.print("<a href='add.html'>添加</a>");
        out.print("<table with='80%' border='1'>");
        out.print("<tr><td>ID</td><td>名字</td><td>年龄</td><td>地址</td><td>操作</td><td>操作</td></tr>");
        for (user u : ulist) {
            out.print("<tr><td>" + u.getID() + "</td><td>" + u.getName() + "</td><td>" + u.getAge() + "</td><td>"
                    + u.getAddress() + "</td><td><a href=edit?id=" + u.getID() + ">修改</a></td><td><a href=delete?id=" + u.getID() + ">删除</a></td></tr>");

        }
        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    }
}