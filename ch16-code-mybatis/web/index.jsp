<%--
  Created by IntelliJ IDEA.
  User: 野心
  Date: 2019/11/6
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <c:forEach items="${list}" var="emp">
            <li>
                ${emp.username}
            </li>
        </c:forEach>
    </ul>
</body>
</html>
