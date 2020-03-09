<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Password</title>
    <%@include file="common/head.jsp" %>

    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=password], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button[type=submit] {
            width: 100%;
            background-color: #4bc9c8;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type=submit]:hover {
            background-color: #4ed2d1;
        }

        button[type=button] {
            width: 100%;
            background-color: #4bc9c8;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type=button]:hover {
            background-color: #4ed2d1;
        }
    </style>
</head>
<body style="background: url(https://images.pexels.com/photos/158056/water-mountain-moon-river-158056.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940) no-repeat center center fixed; background-size: 100%;">

<div class="modal-dialog" style="margin-top: 10%;">
    <div class="modal-content" style="filter:alpha(Opacity=80);-moz-opacity:0.5;opacity: 0.85;">

        <div class="header-panel text-center">
            <h2>Modify the Password</h2>
        </div>

        <div class="panel-body" style="margin:auto; width:400px; height:380px">
            <form name="input" action="${pageContext.request.contextPath}/supervision/password" method="post">
                <input type="text" name="name" id="name" placeholder="Username"><br>
                <input type="text" name="password" id="password"
                       placeholder="The last six of your ID card  /  The current password"><br>
                <input type="text" name="new_password" id="new_password" placeholder="New Password"><br>
                <input type="text" name="new_password_again" id="new_password_again"
                       placeholder="New Password again"><br>
                <button type="submit" id="submit_btn">Confirm</button>
            </form>
        </div>
    </div>
</div>
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%--toast提示框--%>
<link href="https://cdn.bootcss.com/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/toastr.js/latest/css/toastr.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/toastr.js/latest/toastr.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/toastr.js/latest/toastr.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/toastr.js/latest/js/toastr.min.js"></script>
<script src="https://cdn.bootcss.com/toastr.js/latest/toastr.min.js"></script>

<script>
    $("#submit_btn").click(function () {
        toastr.success('将转至登录页面', '若成功');
        toastr.warning('请重新修改', '若失败');
    });
</script>
</html>