<%--
  Created by IntelliJ IDEA.
  User: 25872
  Date: 2022/4/30
  Time: 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改统战信息</title>
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
<%--待修改--%>
<fieldset>
    <legend>${sessionScope.visitor.visitorName},欢迎您</legend>
    <div style="display:inline-block">
        <div style="display:inline-block;margin-right:20px;float: left;">
            <form action="/B18031432_war/updateActivityServlet" method="post">
                <div style="display:inline-block;margin-right:20px;float: left;">
                    <table class="pure-table" id="menu">
                        <tr>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="提交修改数据">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="button" value="删除统战活动" id="delete">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="hidden" value="${sessionScope.visitorActivities[0].activity.activityID}" name="activityID" >
                            </td>
                        </tr>
                    </table>
                </div>
                <div style="display:inline-block;margin-right:20px;float: left;">
                    <table class="pure-table">
                        <tr>
                            <th>统战标题</th>
                            <th>统战详细信息</th>
                            <th>统战经费</th>
                        </tr>
                        <tr>
                            <td><input type="text" value="${sessionScope.visitorActivities[0].activity.activityTitle}" name="activityTitle" ></td>
<%--                            <td><input type="text" value="${sessionScope.visitorActivities[0].activity.activityBody}" name="activityBody"  class="dis" style="width: 300px;height: 150px;"></td>--%>
                            <td >
                                <textarea class="dis" name="activityBody" id="activityBody" rows="5" cols="40" wrap="soft">${sessionScope.visitorActivities[0].activity.activityBody}</textarea>
                            </td>
                            <td><input type="text" value="${sessionScope.visitorActivities[0].activity.money}" name="money" size="7"></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
        <div style="display:inline-block;margin-right:20px;float: left;">
            <table class="pure-table">
                <tr>
                    <th>用户名</th>
                    <th>性别</th>
                    <th>选中框</th>
                </tr>
                <c:forEach items="${sessionScope.visitors}" var="visitor" >
                    <tr>
                        <td>${visitor.visitorName}</td>
                        <td>${visitor.gender}</td>
                        <td>
                            <% int flag = 0;%>
                            <c:forEach items="${sessionScope.visitorActivities}" var="visitorlist" >
                                <c:if test="${visitorlist.visitor eq visitor}">
                                    <input type="checkbox" name="isVisitor" visitorID ="${visitor.visitorID}" checked="checked">
                                    <% flag = 1;%>
                                </c:if>
                            </c:forEach>
                            <%
                                if (flag == 0 ){
                                    %>
                            <input type="checkbox" name="isVisitor" visitorID ="${visitor.visitorID}">
                            <%
                                }
                            %>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</fieldset>

<script type="text/javascript" src="js/jquery-3.6.0.js" charset="UTF-8"></script>
<script type="text/javascript" >
    let checked = $(":checkbox");
    checked.click(function () {
            let value = $(this).prop("checked");
            let visitorID = $(this).attr("visitorID");
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateActivityServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name : "增加或减少统战人员",
                    value : value,
                    id : visitorID
                }
            })
        }
    );
    $("#delete").click(function () {
        $.ajax({
            type: "post",
            url: "/B18031432_war/updateActivityServlet",
            async: "false",
            dataType: "Json",
            data: {
                name : "删除统战活动"
            }
        });
        location.href = "/B18031432_war/index.jsp";
    });
    $("#activityBody").change(function () {
        let activityBody = $(this).val();
        $.ajax({
            type: "post",
            url: "/B18031432_war/updateActivityServlet",
            async: "true",
            dataType: "Json",
            data: {
                name : "改变统战信息",
                value: activityBody
            }
        });
        location.href = "/B18031432_war/index.jsp";
    })
</script>
</body>
</html>
