package com.yyx.checkCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/ch")
public class CheckCode extends HttpServlet {
    /*
     * 需求：给网站登陆加一项验证码操作
     * 1 添加验证码模块到login.html ProduceCode  用response.getDispatcher("").forward();   通过session的功能以及append获得验证码
     * 2 增加校验验证码功能         CheckCode   用response.getDispatcher("").forward();  通过request的获取参数功能校验
     *
     * 步骤
     * 1 写验证码并实现刷新功能
     * 2 输出验证码
     * 3 获得生成的验证码
     * 4 先校验验证码，再校验账号密码，验证码错误则刷新当前页面并显示验证码错误，账号或密码错误则显示账号或密码错误
     * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 500;
        int heigh = 300;

        Random random = new Random();


        //1 创建对象，在内存中的图片
        BufferedImage image = new BufferedImage(width, heigh, BufferedImage.TYPE_INT_RGB);
        //2 美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();
        g.setColor(cl());
        Color cc = g.getColor();
        g.fillRect(0, 0, width, heigh);
        //2.2边框
        g.setColor(cl());
        g.drawRect(0, 0, width - 1, heigh - 1);
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm023456789";
        //生成随机角标

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char c = str.charAt(index);
            builder.append(c);
            //2.3验证码 &HFFFFFF
            g.setColor(new Color(0xFFFFFF - cc.getRGB()));
            g.drawString(c + "", width / 6 * i + 15, heigh / 2);
        }
        String cc_session = builder.toString();
        //存入session
        req.getSession().setAttribute("cc_session", cc_session);
        //2.4干扰线段
        g.setColor(cl());
        //随机坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(heigh);
            int y2 = random.nextInt(heigh);
            g.drawLine(x1, y1, x2, y2);
        }

        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    public Color cl() {
        int x = 0;
        int y = 0;
        int z = 0;
        int n = 0;
        Random random = new Random();
        x = random.nextInt(255);
        y = random.nextInt(255);
        z = random.nextInt(255);
        Color c = new Color(x, y, z);
        return c;
    }

}
