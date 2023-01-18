<%--
  Created by IntelliJ IDEA.
  User: 25872
  Date: 2022/4/25
  Time: 11:42
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
                        <c:if test="${sessionScope.visitor.isMaster == 1 }">
                            <tr>
                                <td>
                                    <a href="/B18031432_war/add.jsp">增加用户</a>
                                </td>
                            </tr>
                        </c:if>
                    </table>
                </div>
                <div style="display:inline-block;margin-right:20px;float: left;">
                    <table class="pure-table">
                        <tr>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>电话</th>
                            <th>密码</th>
                        </tr>
                        <tr>
                            <td><input type="text" kind="visitorName" value="${sessionScope.visitor.visitorName}" visitorID="${sessionScope.visitor.visitorID}" class="otherData"></td>
                            <td>
                                <c:if test="${sessionScope.visitor.gender eq '男'}">
                                    <input type="radio" name="myGender" kind="gender" value="男" checked="checked" visitorID="${sessionScope.visitor.visitorID}" class="otherData">男
                                    <input type="radio" name="myGender" kind="gender" value="女" visitorID="${sessionScope.visitor.visitorID}" class="otherData">女
                                </c:if>
                                <c:if test="${sessionScope.visitor.gender eq '女'}">
                                    <input type="radio" name="myGender" kind="gender" value="男" visitorID="${sessionScope.visitor.visitorID}" class="otherData">男
                                    <input type="radio" name="myGender" kind="gender" value="女" checked="checked" visitorID="${sessionScope.visitor.visitorID}" class="otherData">女
                                </c:if>
                            </td>
                            <td><input type="text" kind="phoneNumber" value="${sessionScope.visitor.phoneNumber}" visitorID="${sessionScope.visitor.visitorID}" size="9" class="otherData"></td>
                            <td><input type="text" kind="password" value="${sessionScope.visitor.password}" visitorID="${sessionScope.visitor.visitorID}" size="9" class="otherData"></td>
                        </tr>
                    </table>
                </div>
                <c:if test="${sessionScope.visitor.isMaster == 1 }">
                    <div style="display:inline-block;margin-right:20px;float: left;">
                        <table class="pure-table">
                            <tr>
                                <th>序号</th>
                                <th>用户名</th>
                                <th>密码</th>
                                <th>性别</th>
                                <th>手机号</th>
                                <th>权限</th>
                                <th>编辑</th>
                                <th>删除</th>
                            </tr>
                            <c:forEach items="${sessionScope.visitors}" var="visitorOfAll" varStatus="status">
                                <tr align="center">
                                    <td>${status.count}</td>
                                    <td><input type="text"   kind="visitorName" value="${visitorOfAll.visitorName}"  readonly="readonly"  visitorID="${visitorOfAll.visitorID}" size="5" class="otherData"></td>
                                    <td><input type="text"   kind="password" value="${visitorOfAll.password}"     readonly="readonly"  visitorID="${visitorOfAll.visitorID}" size="9" class="otherData"></td>
                                    <td>
                                        <c:if test="${visitorOfAll.gender eq '男'}">
                                            <input type="radio" name="genderOf${visitorOfAll}" kind="gender" value="男" checked="checked" readonly="readonly" visitorID="${visitorOfAll.visitorID}" class="otherData">男
                                            <input type="radio" name="genderOf${visitorOfAll}" kind="gender" value="女" readonly="readonly" visitorID="${visitorOfAll.visitorID}" class="otherData">女
                                        </c:if>
                                        <c:if test="${visitorOfAll.gender eq '女'}">
                                            <input type="radio" name="genderOf${visitorOfAll}" kind="gender" value="男"  readonly="readonly" visitorID="${visitorOfAll.visitorID}" class="otherData">男
                                            <input type="radio" name="genderOf${visitorOfAll}" kind="gender" value="女" readonly="readonly" checked="checked" visitorID="${visitorOfAll.visitorID}" class="otherData">女
                                        </c:if>
                                    </td>
                                    <td><input type="text"   kind="phoneNumber" value="${visitorOfAll.phoneNumber}"   readonly="readonly" visitorID="${visitorOfAll.visitorID}" size="9" class="otherData"></td>
                                    <td>
                                        <c:if test="${visitorOfAll.isMaster == 1}">
                                            <input type="checkbox" value="false" kind="checkMaster" checked = "checked" readonly="readonly" visitorID="${visitorOfAll.visitorID}" class="checkMaster">
                                        </c:if>
                                        <c:if test="${visitorOfAll.isMaster != 1}">
                                            <input type="checkbox" value="false" kind="checkMaster" readonly="readonly" visitorID="${visitorOfAll.visitorID}" class="checkMaster">
                                        </c:if>
                                    </td>
                                    <td><input type="button" value="编辑此用户"        visitorID="${visitorOfAll.visitorID}"   class="buttonOfChange"></td>
                                    <td><input type="button" value="删除此用户"        visitorID="${visitorOfAll.visitorID}"   class="buttonOfDelete"></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </div>
        <p id="phoneNumberMessage" style="color: red" hidden="hidden">电话号码为十一位数字，且以数字一开头</p>
        <p id="passwordMessage" style="color: red" hidden="hidden">密码6到12位数字,1到5位单词字符</p>
    </fieldset>
</body>

<script type="text/javascript" src="js/jquery-3.6.0.js" charset="UTF-8"></script>
<script type="text/javascript">

    var changeFlag = true;
    let Update = $(".otherData");
    Update.change(function () {
        let kind = $(this).attr("kind");
        let value = $(this).val();
        if(kind === "password"){
            let password_regtablear = /^\d{6,12}\w{1,5}$/;
            let password_test = password_regtablear.test($(this).val().trim());
            if (!password_test){
                //验证不通过;禁止上传
                changeFlag = false;
                $(".buttonOfChange").attr({"readonly":"true"});
                $("#passwordMessage").removeAttr("hidden");
            }else {
                changeFlag = true;
                $(".buttonOfChange").removeAttr("readonly");
                $("#passwordMessage").attr({"hidden": "hidden"});
            }
        }
        if(kind === "phoneNumber"){
            let phoneNumber_regtablear = /^[1]\d{10}$/;
            let phoneNumber_test = phoneNumber_regtablear.test($(this).val().trim());
            if (!phoneNumber_test){
                //验证不通过;禁止上传
                changeFlag = false;
                $(".buttonOfChange").attr({"readonly":"true"});
                $("#phoneNumberMessage").removeAttr("hidden");
            }else {
                changeFlag = true;
                $(".buttonOfChange").removeAttr("readonly");
                $("#phoneNumberMessage").attr({"hidden": "hidden"});
            }
        }
        if (changeFlag === true){
            let visitorID = $(this).attr("visitorID");
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name : kind,
                    value : value,
                    id : visitorID
                }
            })
        }
    });
    //改变管理员权限
    let checked = $(".checkMaster");
    checked.change(function () {
        if (confirm("！！！！确认修改管理员权限吗？！！！")){
            let value = $(this).attr("checked");
            let visitorID = $(this).attr("visitorID");
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name : "管理员权限修改",
                    value : value,
                    id : visitorID
                },
            })
        }
    });

    //删除用户
    let deleted =$(".buttonOfDelete");
    deleted.click(function () {
        let visitorID = $(this).attr("visitorID");
        if (confirm("是否要删除"+visitorID+"用户")){
            $.ajax({
                type: "post",
                url: "/B18031432_war/updateServlet",
                async: "true",
                dataType: "Json",
                data: {
                    name : "删除用户",
                    value : "占位符",
                    id : visitorID
                },
                success: function (data) {
                    console.log(data);
                }
            })
        }
    });

    //绑定点击事件
    let change = $(".buttonOfChange");
    change.click(function () {
        let visitorID = $(this).attr("visitorID");
        let wantChange = $("input[visitorID = '" + visitorID +"'][type = 'text']");
        if (wantChange.attr("readonly") === undefined){
            wantChange.css("background-color","pink");
            wantChange.attr({"readonly":"true"});
        }else {
            wantChange.css("background-color","yellow");
            wantChange.removeAttr("readonly");
        }
    })
</script>
</html>
