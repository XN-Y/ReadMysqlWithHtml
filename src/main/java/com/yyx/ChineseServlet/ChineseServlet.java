package com.yyx.ChineseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChineseServlet", value = "/ChineseServlet")
public class ChineseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------");
        test2(resp);
        System.out.println("-----------------");
        test2(resp);
        System.out.println("-----------------");
        test1(resp);
        System.out.println("-----------------");
        test3(resp);
    }


    private void test1(HttpServletResponse response) throws IOException {
        String data = "河南";
        PrintWriter out = response.getWriter();
        out.println(data);
        System.out.println("河南");

    }

    private void test2(HttpServletResponse response) throws IOException {
        //response.setCharacterEncoding("UTF-8");
        // 1. response.setCharacterEncoding("UTF-8");
        //     设置内容的字符集
        // 2. response.setHeader("content-type", "text/html;charset=UTF-8");
        //    设置浏览器以UTF-8编码格式显示内容
        //单单只设置其中一个无法正常按照需求格式输出在浏览器中

        response.setHeader("content=type", "text/html;charset=UTF-8");
        String data = "中国";
        PrintWriter out = response.getWriter();
        out.println(data);
        System.out.println("中国");

    }

    private void test3(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String data = "安阳";
        PrintWriter out = response.getWriter();
        out.println(data);
        System.out.println("安阳");
    }
}
