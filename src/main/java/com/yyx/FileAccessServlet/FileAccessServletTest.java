package com.yyx.FileAccessServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author yyx
 */
@WebServlet(name = "FileAccessServletTest", value = "/FileAccessServletTest")
public class FileAccessServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        test();

    }

    public void test() throws IOException {
        InputStream fis = this.getServletContext().getResourceAsStream("/WEB-INF/classes/jdbc.properties");
        Properties pro1 = new Properties();
        pro1.load(fis);


/*        Properties pro1 = new Properties();
        ClassLoader cl = JDBCUtils.class.getClassLoader();
        URL res = cl.getResource("jdbc.properties");*/
//          pro.load(new FileReader("D:\\Workspaces1\\yyx\\jdbc\\src\\jdbc.properties"));
/*            String path = res.getPath();
            System.out.println(path);*/
        String url = pro1.getProperty("url");
        String user = pro1.getProperty("user");
        String password = pro1.getProperty("password");
        String driver = pro1.getProperty("driver");
//      pro1.load(new FileReader(path));
        url = pro1.getProperty("url");
        user = pro1.getProperty("user");
        password = pro1.getProperty("password");
        driver = pro1.getProperty("driver");
        System.out.println("url= " + url);
        System.out.println("user= " + user);
        System.out.println("password= " + password);
        System.out.println("driver= " + driver);
    }
}
