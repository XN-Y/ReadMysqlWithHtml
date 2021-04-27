package com.yyx.ServletConfigTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletConfigTest", value = "/ServletConfigTest")
public class ServletConfigTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        ServletConfig config = this.getServletConfig();
        String info = this.getServletInfo();
        String name = this.getServletName();
        System.out.println("全局变量=" + context);
        System.out.println("单个servlet名=" + name);
        System.out.println("ServletInfo=NULL" + info);
        System.out.println("单个servlet配置=" + config);
        Enumeration<String> names = config.getInitParameterNames();
        System.out.println("---------------------------------");
        System.out.println("单个servlet配置");
        while (names.hasMoreElements()) {
            String s = names.nextElement();
            String s1 = config.getInitParameter(s);
            System.out.println(s + " = " + s1);
        }
        System.out.println("---------------------------------");
        Enumeration<String> names1 = context.getInitParameterNames();
        System.out.println("全局servlet变量");
        while (names1.hasMoreElements()) {
            String s1 = names1.nextElement();
            String s11 = context.getInitParameter(s1);
            System.out.println(s1 + " = " + s11);
        }
        System.out.println("---------------------------------");
        String path = config.getServletContext().getContextPath();
        System.out.println("路径" + path);
        String realPath = config.getServletContext().getRealPath("ServletConfigTest");
        System.out.println("真实路径" + realPath);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
