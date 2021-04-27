package com.yyx.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "add", value = "/add")
public class UserAdd extends HttpServlet {
    private UserDao udao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        user u = new user();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        u.setAddress(address);
        u.setAge(Integer.parseInt(age));
        u.setID(Integer.parseInt(id));
        u.setName(name);
        boolean b = udao.add(u);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (b) {

            out.print("添加成功,即将在三秒钟之后跳转至管理界面......");
        } else {
            out.print("添加失败,即将在三秒钟之后跳转至管理界面......");

        }
        out.print("<script type=\"text/javascript\"> \n" +
                "onload=function(){ \n" +
                "setInterval(go, 1000); \n" +
                "}; \n" +
                "var x=3; //利用了全局变量来执行 \n" +
                "function go(){ \n" +
                "x--; \n" +
                "if(x>0){ \n" +
                "}else{ \n" +
                "location.href='http://localhost:81/mms/list'; \n" +
                "} \n" +
                "} \n" +
                "</script>");
        /*self.location.href;//当前页面打开URL页面
        window.location.href;//当前页面打开URL页面
        this .location.href;//当前页面打开URL页面
        location.href;// 当前页面打开URL页面
        parent.location.href;//在父页面打开新页面
        top.location.href;//在顶层页面打开新页面 */
    }

}
