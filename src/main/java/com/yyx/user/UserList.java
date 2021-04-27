package com.yyx.user;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "list", value = "/list")

public class UserList implements Servlet {
    private UserDao dao = new UserDao();//创建userDAO的对象，用来调用userDAO中的方法，实现对user表的操作。

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        List<user> ulist = dao.querrAll();//将调用userDAO的方法返回的值放入ulist中，方便面后面遍历在网页中显示。
        req.setAttribute("ulist", ulist);
        req.getRequestDispatcher("/listView").forward(req, resp);
    }

    @Override
    public void destroy() {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void init(ServletConfig arg0) {
    }
}
