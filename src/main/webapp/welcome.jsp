<%--
  Created by IntelliJ IDEA.
  User: 20897
  Date: 2023/11/16
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="User/login" method="post">
    <label>
        <input type="text" name="username" value="username">
    </label>
    <label>
        <input type="text" name="password" value="password">
    </label>
    <input type="submit" formaction="/project/User/signin" value="注册">
    <input type="submit" formaction="/project/User/logoff" value="注销">
    <input type="submit" value="登录">
</form>

</body>
</html>
