package com.yyx.DownloadServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            filedownload(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    private void filedownload(HttpServletResponse response) throws Exception {
        String path = this.getServletContext().getRealPath("WEB-INF/classes/jdbc.properties");
        String fileName = path.substring(path.lastIndexOf("\\") + 1);
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(path);
            int len = 0;
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }

    }

    private void picturedownload(HttpServletResponse response) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        //实现下载图片
        //先取得资源路径，因为将来要用到文件名
        String path = this.getServletContext().getRealPath("/download/IMG-0015.JPG");
        String fileName = path.substring(path.lastIndexOf("\\") + 1);
        //response.setHeader("content-type", "image/jpg");
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(path);
            int len = 0;
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
