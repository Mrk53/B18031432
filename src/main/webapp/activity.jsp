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
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
<fieldset>
    <legend>${sessionScope.visitor.visitorName},欢迎您</legend>
    <div style="display:inline-block;margin-right:20px;float: left;margin-left: 0">
        <table class="pure-table" id="menu">
            <tr>
                <th>操作</th>
            </tr>
            <tr>
                <td>
                    <a href="/B18031432_war/backServlet">返 回 首 页</a>
                </td>
            </tr>
            <c:if test="${sessionScope.visitor.isMaster == 1}">
                <tr>
                    <td>
                        <a href="updateActivity.jsp">统战活动管理</a>
                    </td>
                </tr>
            </c:if>
        </table>
    </div>
    <div style="display:inline-block">
        <div style="display:inline-block;margin-right:20px;float: left;margin-left: 0">
            <table class="pure-table">
                <tr>
                    <th>统战标题</th>
                    <th>统战详细信息</th>
                    <th>统战活动经费</th>
                </tr>
                <tr>
                    <td>${sessionScope.visitorActivities[0].activity.activityTitle}</td>
                    <td>${sessionScope.visitorActivities[0].activity.activityBody}</td>
                    <td>${sessionScope.visitorActivities[0].activity.money}</td>
                </tr>
            </table>
        </div>
        <div style="display:inline-block;margin-right:20px;float: left;margin-left: 0">
            <c:if test="${sessionScope.visitorActivities[0].visitor != null}">
                <table class="pure-table">
                    <tr >
                        <th>序号</th>
                        <th>用户姓名</th>
                        <th>联系方式</th>
                    </tr>
                    <c:forEach items="${sessionScope.visitorActivities}" var="visitorActivity" varStatus="status">
                        <tr >
                            <td>${status.count}</td>
                            <td>${visitorActivity.visitor.visitorName}</td>
                            <td>${visitorActivity.visitor.phoneNumber}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</fieldset>
<hr>
</body>
</html>
