<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/20
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>



<form method="post" action="/user/login">
用户名：<input name="name" type="text"><br/>
密码： <input name="password" type="password"><br/>
    <input type="submit" value="登录">

</form>
</body>
</html>
