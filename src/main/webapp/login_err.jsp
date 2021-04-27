<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="refresh" content="3;URL=http://localhost:81/mms/login.jsp">
<!DOCTYPE html>
<html>
<head>
    <style>
        div {
            color: red;
        }

    </style>
    <meta charset="UTF-8">
    <title>信息错误</title>
</head>
<body>
<h1>
    <div><%=request.getSession().getAttribute("cc_error") == null ? "" : request.getSession().getAttribute("cc_error")%>
    </div>
    <div><%=request.getSession().getAttribute("login_error") == null ? "" : request.getSession().getAttribute("login_error") %>
    </div>
    <div><%request.getSession().removeAttribute("cc_error");%>
    </div>
    <div><%request.getSession().removeAttribute("login_error");%>
    </div>
    请重新<a href="login.jsp"> 登陆</a><br/>
    页面将在三秒钟之后自动跳转至登陆界面.......
</h1>

</body>
</html>