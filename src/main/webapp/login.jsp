<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>信息管理登陆页</title>
    <SCRIPT>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/mms/ch?time=" + new Date().getTime();
            }
        }
    </SCRIPT>
</head>
<body>

<form action="login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="8"><img id="img" src="/mms/ch"></td>
        </tr>
        <tr>
            <td colspan="8"><input type="submit" value="登录"></td>
        </tr>
    </table>


</form>


</body>
</html>