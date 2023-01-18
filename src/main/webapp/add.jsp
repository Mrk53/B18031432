<%--
  Created by InteltrJ IDEA.
  User: 25872
  Date: 2022/4/26
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" href="css/body.css">
</head>
<body>

<div class="center-in-center">
    <form action="/B18031432_war/addServlet" method="post">
        <table class="pure-table">
            <tr>
                <td>
                    <label for ="visitorName">用户名：</label>
                    <input type="text" name="visitorName" id="visitorName">
                </td>
            </tr>
            <tr>
                <td>
                    <p style="color: red" >${requestScope.add_message}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <label for ="password">账户密码：</label>
                    <input type="password" name="password" id="password">
                </td>
            </tr>
            <tr>
                <td>
                    <p id="passwordMessage" style="color: red" hidden="hidden">不能以0开头,6到12位数字，1到5位单词字符</p>
                </td>
            </tr>
            <tr>
                <td>
                    <label for ="gender">性别：</label>
                    <input type="text" name="gender" id="gender">
                </td>
            </tr>
            <tr>
                <td>
                    <p id="genderMessage" style="color: red" hidden="hidden">性别只能为男或女</p>
                </td>
            </tr>
            <tr>
                <td>
                    <label for ="phoneNumber">电话：</label>
                    <input type="text" name="phoneNumber" id="phoneNumber">
                </td>
            </tr>
            <tr>
                <td>
                    <p id="phoneNumberMessage" style="color: red" hidden="hidden">电话号码为十一位数字，且以数字一开头</p>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交" id="submit" disabled="disabled">
                </td>
            </tr>
            <tr>
                <td>
                    <a href="/B18031432_war/login.jsp">已有账号？去登录</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript" src="js/jquery-3.6.0.js" charset="UTF-8"></script>
<script type="text/javascript" >
    var phoneNumber_test;
    var gender_test;
    var password_test;

    function testSubmit() {
        if (phoneNumber_test && password_test && gender_test){
            //验证通过可以提交注册
            $("#submit").removeAttr("disabled");
        }
    }


    $("#password").change(function () {
        //不能以0开头,6到12位数字，1到5位单词字符
        let password_regtablear = /^[1,2,3,4,5,6,7,8,9]\d{6,12}\w{1,5}$/;
         password_test = password_regtablear.test($(this).val().trim());
        if (!password_test){
            //验证不通过;禁止上传
            $("#submit").attr({"disabled":"disabled"});
            $("#passwordMessage").removeAttr("hidden");
        }else {
            $("#passwordMessage").attr({"hidden": "hidden"});
        }
        testSubmit();
    });


    $("#gender").change(function () {
        //只能为男或女
        let gender_regtablear = /^[男,女]$/;
         gender_test = gender_regtablear.test($(this).val().trim());
        if (!gender_test){
            //验证不通过;禁止上传
            $("#submit").attr({"disabled":"disabled"});
            $("#genderMessage").removeAttr("hidden");
        }else {
            $("#genderMessage").attr({"hidden":"hidden"});
        }
        testSubmit();
    });


    $("#phoneNumber").change(function () {
        //一共十一位数字，且以一开头
        let phoneNumber_regtablear = /^[1]\d{10}$/;
         phoneNumber_test = phoneNumber_regtablear.test($(this).val().trim());
        if (!phoneNumber_test){
            //验证不通过;禁止上传
            $("#submit").attr({"disabled":"disabled"});
            $("#phoneNumberMessage").removeAttr("hidden");
        }else {
            //验证通过可以上传
            $("#phoneNumberMessage").attr({"hidden":"hidden"});
        }
        testSubmit();
    });
</script>
</body>
</html>
