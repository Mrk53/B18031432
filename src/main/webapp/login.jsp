<%--
  Created by IntelliJ IDEA.
  User: 25872
  Date: 2022/4/26
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/body.css">
    <style type="text/css">
    </style>
</head>
<body>
<form action="/B18031432_war/loginServlet" method="post">
    <div class="center-in-center">
        <table class="pure-table">
            <tr>
                <td><label for ="visitorName">账户名称：</label></td>
                <td><input type="text" name="visitorName" id="visitorName" value="${cookie.visitorName.value}" size="9"></td>
            </tr>
            <tr>
                <td><label for ="password">账户密码：</label></td>
                <td><input type="password" name="password" id="password" value="${cookie.password.value}" size="9"></td>
            </tr>
            <tr>
                <td><input type="submit" class="button" value="登录"></td>
                <td><input type="reset" class="button"  value="重置"></td>
            </tr>
            <tr>
                <td colspan="2">记住我<input type="checkbox" name="remember" value="1">
            </tr>
            <tr>
                <td colspan="2">
                   <p>${requestScope.login_message}</p>
                </td>
            </tr>
            <tr>
                <td colspan="2"><a href="/B18031432_war/add.jsp">没有账号，点我注册</a></td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
