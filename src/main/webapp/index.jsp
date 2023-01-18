<%--
  Created by IntelliJ IDEA.
  User: 25872
  Date: 2022/4/26
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
                            <a href="/B18031432_war/visitor.jsp" >个人信息管理</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="/B18031432_war/mineServlet" >我的议政信息</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="/B18031432_war/addTheme.jsp" >发布议政主题</a>
                        </td>
                    </tr>
                    <c:if test="${sessionScope.visitor.isMaster == 1}">
                        <tr>
                            <td>
                                <a href="/B18031432_war/addActivity.jsp" >发布统战活动</a>
                            </td>
                        </tr>
                    </c:if>
                </table>
            </div>
            <div style="display:inline-block;margin-right:20px;float: left;">
                <table  class="pure-table">
                    <tr>
                        <th>序号</th>
                        <th>信息</th>
                    </tr>
                    <c:forEach items="${sessionScope.activities}" var="activity" varStatus="status">
                        <tr align="center">
                            <td>${status.count}</td>
                            <td><a href="/B18031432_war/activityServlet?activityID=${activity.activityID}">${activity.activityTitle}</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div style="display:inline-block;margin-right:20px;float: left;">
                <table class="pure-table">
                    <tr>
                        <th>序号</th>
                        <th>发布人</th>
                        <th>主题</th>
                    </tr>
                    <c:forEach items="${sessionScope.themeList}" var="theme" varStatus="status">
                        <c:if test="${theme.isBest == 1}">
                            <tr >
                                <td>${status.count}</td>
                                <td>${theme.visitor.visitorName}</td>
                                <td><a href="/B18031432_war/discussServlet?themeID=${theme.themeID}" style="color: red">${theme.themeTitle}</a></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${sessionScope.themeList}" var="theme" varStatus="status">
                        <c:if test="${theme.isBest == 0}">
                            <tr >
                                <td>${status.count}</td>
                                <td>${theme.visitor.visitorName}</td>
                                <td><a href="/B18031432_war/discussServlet?themeID=${theme.themeID}" >${theme.themeTitle}</a></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table >
            </div>
        </div>
    </fieldset>
    <hr>
<script type="text/javascript" src="js/jquery-3.6.0.js" charset="UTF-8"></script>
<script type="text/javascript">
    // document.getElementById("addTheme").onclick = function () {
    //     location.href = "/B18031432_war/addTheme.jsp";
    // };

</script>

</body>
</html>
