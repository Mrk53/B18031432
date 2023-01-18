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
    <title>标题</title>
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
                <c:if test="${sessionScope.visitor.isMaster == 1}">
                    <tr>
                        <td>
                            <a href="/B18031432_war/updateDiscuss.jsp">议政信息管理</a>
                        </td>
                    </tr>
                </c:if>
            </table>
        </div>
        <div style="display:inline-block;margin-right:20px;float: left;">
            <table class="pure-table" >
                <tr>
                    <th>主题</th>
                    <th>主题详细信息</th>
                </tr>
                <tr>
                    <td>${sessionScope.theme.themeTitle}</td>
                    <td>
                        <textarea  rows="5" cols="40" wrap="soft">${sessionScope.theme.themeBody}</textarea>
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <c:if test="${sessionScope.discusses.size() != 0}">
            <div style="display:inline-block;margin-right:20px;float: left; margin-top: 20px">
                <table class="pure-table" >
                    <tr>
                        <th>序号</th>
                        <th>用户</th>
                        <th>评论</th>
                        <th>点赞</th>
                    </tr>
                    <c:forEach items="${sessionScope.discusses}" var="discuss" varStatus="status">
                        <tr>
                            <td >${status.count}</td>
                            <td class="nameByID" visitorID="${discuss.visitor.visitorName}"> ${discuss.visitor.visitorName} </td>
                            <td>${discuss.discussion}</td>
                            <td>
                                <% int flag = 0;%>
                                <c:forEach items="${sessionScope.isLikesList}" var="likes">
                                    <c:if test="${likes.discuss.discussID == discuss.discussID}">
                                        <input type="checkbox" discussID="${discuss.discussID}" class="like" checked="checked">
                                        <% flag = 1;%>
                                    </c:if>
                                </c:forEach>
                                <%
                                    if (flag == 0 ){
                                %>
                                <input type="checkbox" discussID="${discuss.discussID}" class="like" >
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <div style="display:inline-block;margin-right:20px;float: left;margin-top: 20px;">
            <table class="pure-table" >
                <tr>
                    <th>发表议政信息</th>
                </tr>
                <td>
                    <textarea name="discussOfMine" rows="10" cols="50" wrap="soft"  id="discussOfMine"></textarea>
                </td>
            </table>
        </div>
    </div>
</fieldset>
<script type="text/javascript" src="js/jquery-3.6.0.js" charset="UTF-8"></script>
<script type="text/javascript">
<%--   评论功能 --%>
    $("#discussOfMine").change(function () {
        $.ajax({
            type: "post",
            url: "/B18031432_war/discussServlet",
            async: "true",
            dataType: "Json",
            data:{
                name:"发评论",
                discuss:$(this).val()
            }

        })
    });
    $(".like").change(function () {
       let like = $(this).prop("checked");
        $.ajax({
            type: "post",
            url: "/B18031432_war/discussServlet",
            async: "true",
            dataType: "Json",
            data:{
                name:"点赞",
                discuss:$(this).attr("discussID"),
                isLike:like
            }
        })
    })

</script>
</body>
</html>
