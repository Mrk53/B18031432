<%--
  Created by IntelliJ IDEA.
  User: 25872
  Date: 2022/5/1
  Time: 5:11
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
                    <tr>
                        <td>
                            <input type="button" value="设为精华" id="isBest">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="button" value="取消精华" id="notBest">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="button" value="删除主题" id="deleteTheme">
                        </td>
                    </tr>
                </table>
            </div>
            <div style="display:inline-block;margin-right:20px;float: left;">
                <table class="pure-table" >
                    <tr>
                        <th>修改主题标题</th>
                        <th>修改主题详细信息</th>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" value="${sessionScope.theme.themeTitle}" class="update" name="修改主题标题" >
                        </td>
                        <td>
                            <textarea name="修改主题详细信息" rows="10" cols="50" wrap="soft" class="update" >${sessionScope.theme.themeBody}</textarea>

                        </td>
                    </tr>
                </table>
            </div>
            <div style="display:inline-block;margin-right:20px;float: left;">
                <table class="pure-table">
                    <tr>
                        <th>序号</th>
                        <th>用户</th>
                        <th>评论</th>
                        <th>删除</th>
                    </tr>
                    <c:forEach items="${sessionScope.discusses}" var="discuss" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td class="nameByID" visitorID="${discuss.visitor.visitorName}"> ${discuss.visitor.visitorName} </td>
                            <td>${discuss.discussion}</td>
                            <td><input type="button" value="删除" discussID="${discuss.discussID}" class="deleteDiscuss" ></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </fieldset>

    <script type="text/javascript" src="js/jquery-3.6.0.js" charset="UTF-8"></script>
    <script type="text/javascript" >
        $("#deleteTheme").click(function () {
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateDiscussServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name:"删除主题",
                    themeID:${sessionScope.theme.themeID}
                }
            });
            location.href = "/B18031432_war/index.jsp";
        });
        $(".deleteDiscuss").click(function () {
            let discussID = $(this).attr("discussID");
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateDiscussServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name:"删除评论",
                    themeID:${sessionScope.theme.themeID},
                    discussID : discussID
                }
            });
        });
        $("#isBest").click(function () {
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateDiscussServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name:"修改为精华",
                    themeID:${sessionScope.theme.themeID},
                }
            });
        });
        $("#notBest").click(function () {
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateDiscussServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name:"取消精华",
                    themeID:${sessionScope.theme.themeID},
                }
            });
        });
        $(".update").change(function () {
            let name = $(this).attr("name");
            let value = $(this).val();
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateDiscussServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name:name,
                    themeID:${sessionScope.theme.themeID},
                    value:value
                }
            });
        })
    </script>
</body>

</html>
