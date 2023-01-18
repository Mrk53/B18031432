<%--
  Created by IntelliJ IDEA.
  User: 25872
  Date: 2022/5/1
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" href="css/body.css">

</head>
<body>
<form action="/B18031432_war/addActivityServlet" method="post">
    <div class="center-in-center">
        <table class="pure-table">
            <tr>
                <th><label for ="activityTitle">统战标题：</label> </th>
                <td><input type="text" name="activityTitle" id="activityTitle"></td>
            </tr>
            <tr>
                <th><label for ="money">统战经费：</label> </th>
                <td><input type="text" name="money" id="money"></td>
            </tr>
            <tr>
                <th>   <label for ="activityBody">统战详细内容：</label></th>
                <td><input type="text" name="activityBody" id="activityBody"></td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" value="提交"></td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
