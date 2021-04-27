package com.yyx.FirstServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.log("doGET");
        this.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.log("doPost");
        this.execute(req, resp);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String requestURI = request.getRequestURL().toString();
        String method = request.getMethod();
        String param = request.getParameter("param");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("<BODY>");

        out.println("以" + method + "方式访问该页面，取到的参数为" + param + "<br/>");
        out.println("<form action ='" + requestURI + "' method='get'>");
        out.println("<input type ='text' name='param' placeholder='GET参数'>");
        out.println("<input type='submit' value='以GET方式查询页面" + requestURI + "'>");
        out.println("</form>");
        out.println("<form action ='" + requestURI + "' method='post'>");
        out.println("<input type ='text' name='param' placeholder='POST参数'>");
        out.println("<input type='submit' value='以Post方式查询页面" + requestURI + "'>");
        out.println("</form>");
        out.println("<script>document.write('本页面最后更新时间: '+document.lastModified );</script>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        this.log("执行getLastModified方法");
        return -1;
    }
}
