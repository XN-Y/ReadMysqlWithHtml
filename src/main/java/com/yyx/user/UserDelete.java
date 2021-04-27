package com.yyx.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "delete", value = "/delete")
public class UserDelete extends HttpServlet {
    private UserDao udao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        user u = udao.querryById(id);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (u == null) {
            out.print("所删除的人信息不存在！！");
            return;
        }
        out.print("<html>");
        out.print("<head>");
        out.print("</head>");
        out.print("<body>");
        out.print("<form action='del' method='post'>");
        out.print("ID:<input type='text' value='" + u.getID() + "'readonly name='id'/><br>");
        out.print("name:<input type='text' value='" + u.getName() + "'name='name'/><br>");
        out.print("age:<input type='text' value='" + u.getAge() + "'name='age'/><br>");
        out.print("address:<input type='text' value='" + u.getAddress() + "' name='address'/><br>");
        out.print("<input type='submit' value='删除'/><br>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }
}
