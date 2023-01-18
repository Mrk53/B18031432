<%--
  Created by IntelliJ IDEA.
  User: 25872
  Date: 2022/4/28
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/body.css">

    <style type="text/css">
        #themeBody{
            width: 300px;
            height: 150px;
        }
        #themeTitle{
            width: 300px;
        }
    </style>
    <title>发布主题</title>
</head>
<body>
<form method="post" action="/B18031432_war/addThemeServlet">
    <label for ="themeTitle">请输入你要发布的主题名称：</label><br>
    <input type="text" id="themeTitle" name="themeTitle">
    <br>
    <label for ="themeBody">请输入你要发布的主题信息：</label><br>
    <input type="text" id="themeBody" name="themeBody">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
