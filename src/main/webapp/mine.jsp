<%--
  Created by IntelliJ IDEA.
  User: 25872
  Date: 2022/5/7
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/body.css">
    <style type="text/css">
        #menu th{
            background-color: #cbb682;
        }
        #menu td{
            background-color: aliceblue;
        }
    </style>
</head>
<body>
<fieldset >
    <legend>${sessionScope.visitor.visitorName},欢迎您</legend>
    <div style="display:inline-block">
        <div style="display:inline-block;margin-right:20px;float: left;">
            <table class="pure-table" id="menu">
                <tr>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>
                        <a href="/B18031432_war/backServlet">返回首页</a>
                    </td>
                </tr>
            </table>
        </div>
        <div style="display:inline-block;margin-right:20px;float: left;">
            <c:if test="${sessionScope.isLikesList.size() != 0}">
                <table class="pure-table" >
                    <tr>
                        <th>发表人</th>
                        <th>评论内容</th>
                    </tr>
                    <c:forEach items="${sessionScope.isLikesList}" var="likes">
                        <tr>
                            <td>${likes.discuss.visitor.visitorName}</td>
                            <td>${likes.discuss.discussion}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
        <div style="display:inline-block;margin-right:20px;float: left;">
            <c:if test="${sessionScope.discussesOfMine.size() != 0}">
                <table class="pure-table" >
                    <tr>
                        <th>主题</th>
                        <th>评论内容</th>
                    </tr>
                    <c:forEach items="${sessionScope.discussesOfMine}" var="mydiscuss">
                        <tr>
                            <td>${mydiscuss.theme.themeTitle}</td>
                            <td>${mydiscuss.discussion}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</fieldset>
</body>
</html>
