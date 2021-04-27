package com.yyx.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "del", value = "/del")
public class UserDel extends HttpServlet {
    private UserDao udao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转换成整数
        int id = Integer.parseInt(req.getParameter("id"));
        user u = udao.querryById(id);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (u == null) {
            out.println("查无此人,删除失败");
        } else {
            boolean b = udao.del(id);
            if (!b) {
                out.print("删除失败");
            } else {
                req.getRequestDispatcher("/list").forward(req, resp);

            }
        }

    }
}
