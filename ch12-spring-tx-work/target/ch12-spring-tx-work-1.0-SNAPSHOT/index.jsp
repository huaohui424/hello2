<%--
  Created by IntelliJ IDEA.
  User: 野心
  Date: 2019/10/31
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
        </tr>
        </thead>

        <tbody>
            <c:forEach items="${pageInfo.list}" var="pageinfo">
                <tr>
                    <td>${pageinfo.id}</td>
                    <td>${pageinfo.name}</td>
                    <td>
                        <a href="delete?id=${pageinfo.id}"><input type="button" value="删除"></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

    <a href="/index?page=1&pageSize=${pageInfo.pageSize}">首页</a>
    <a href="/index?page=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}">上一页</a>
    <a href="/index?page=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}">下一页</a>
    <a href="/index?page=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">尾页</a>
</body>
</html>
