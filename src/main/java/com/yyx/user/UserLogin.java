package com.yyx.user;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String ccsession = req.getParameter("checkCode");
        ServletConfig config = getServletConfig();
        String uname = config.getInitParameter("username");
        String upass = config.getInitParameter("userpass");
        String ccSession = null;
        if (req.getSession().getAttribute("cc_session") != null) {
            ccSession = req.getSession().getAttribute("cc_session").toString();
        } else {
            ccSession = null;
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //uname.equals(name)&&upass.equals(pass)
        if (ccsession.equalsIgnoreCase(ccSession)) {
            if (uname != null && upass != null && uname.equals(name) && upass.equals(pass)) {
                resp.sendRedirect(req.getContextPath() + "/list");
                //登陆成功
                req.getSession().removeAttribute("cc_session");
            } else {
                //登陆失败
                req.getRequestDispatcher("/login_err.jsp").forward(req, resp);
                String login_error = "账号或密码错误";
                req.getSession().setAttribute("login_error", login_error);
                req.getSession().removeAttribute("cc_session");

            }

        } else {
            String cc_error = "验证码错误";
            req.getSession().setAttribute("cc_error", cc_error);
            req.getRequestDispatcher("/login_err.jsp").forward(req, resp);
            req.getSession().removeAttribute("cc_session");

        }
    }
}
