package com.yyx.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "update", value = "/update")
public class UserUpdate extends HttpServlet {
    private UserDao udao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        user u = new user();
        u.setID(Integer.parseInt(id));
        u.setAddress(address);
        u.setName(name);
        u.setAge(Integer.parseInt(age));
        boolean b = udao.update(u);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (b) {
            req.getRequestDispatcher("/list").forward(req, resp);//重定向，转到/list这个servlet去处理请求
        }
        out.print("修改失败");
    }
}
