package com.yyx.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "edit", value = "/edit")
public class UserEdit extends HttpServlet {
    private UserDao udao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();


        user u = udao.querryById(Integer.parseInt(req.getParameter("id")));
        if (u == null) {
            out.print("查无此人");
        }
        out.print("<html>");
        out.print("<head>");
        out.print("</head>");
        out.print("<body>");
        out.print("<form action='update' method='post'>");
        out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type='text' value='" + u.getID() + "'readonly name='id'/><br>");
        out.print("&nbsp;&nbsp;name&nbsp;&nbsp;:<input type='text' value='" + u.getName() + "'name='name'/><br>");
        out.print("&nbsp;&nbsp;&nbsp;age&nbsp;&nbsp;&nbsp;&nbsp;:<input type='text' value='" + u.getAge() + "'name='age'/><br>");
        out.print("address:<input type='text' value='" + u.getAddress() + "' name='address'/><br>");
        out.print("<input type='submit' value='修改'/><br>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");

    }
}
