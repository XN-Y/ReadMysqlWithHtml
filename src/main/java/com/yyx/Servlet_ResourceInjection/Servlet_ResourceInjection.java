package com.yyx.Servlet_ResourceInjection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResourceInjection", value = "/ResourceInjection")
public class Servlet_ResourceInjection extends HttpServlet {
    @Resource(name = "persons")
    private String persons;
    @Resource(name = "i")
    private int i;
    @Resource(name = "hello")
    private String hello;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>资源注入</TITLE></HEAD>");
        out.println("<style>body {font-size:12px;}</style>");

        out.println("<b>注入的字符串</b>：<br/>&nbsp;&nbsp;-&nbsp" + hello + "<br/>");
        out.println("<b>注入的整数</b>: <br/>&nbsp;&nbsp;-&nbsp;" + i + "<br/>");
        out.println("<b>注入的字符串数组</b>: <br/>");
        for (String person : persons.split(",")) {
            out.println("&nbsp;&nbsp;-&nbsp;" + person + "<br/>");
        }

        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}
