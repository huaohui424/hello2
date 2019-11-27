<%--
  Created by IntelliJ IDEA.
  User: 野心
  Date: 2019/11/20
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
