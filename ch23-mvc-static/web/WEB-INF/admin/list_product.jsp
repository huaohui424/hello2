<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<style>
	.pic {
		width:50px;
		height:50px;
	}
</style>
</head>
<body>

	<h1 style="text-align:center">商品管理xxxx</h1>
	

	<table border="1" width="80%" align="center">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>类型</th>
			<th>描述</th>
			<th>价格</th>
			<th>库存</th>
			<th>图片</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.list}">
				<tr style="color:red">
					<td colspan="9" align="center">
						数据为空！
					</td>
				</tr>
			</c:when>
		
			<c:otherwise>
				<c:forEach var="p" items="${requestScope.list}">
					<tr align="center">
						<td>${p.id }</td>
						<td>${p.productName }</td>
						<td>${p.productType }</td>
						<td align="left" title="${p.productDesc }">
							<!-- ${fn:length(p.productDesc)>=10?(p.productDesc.substring(0,10)):p.productDesc}... -->
							<c:choose>
								<c:when test="${fn:length(p.productDesc)>=10}">
									${p.productDesc.substring(0,10) }...
								</c:when>
								<c:otherwise>
									${p.productDesc}
								</c:otherwise>
							</c:choose>
						</td>
						<td>${p.productPrice }</td>
						<td>${p.productNumber }</td>
						<td><img class="pic" src="${pageContext.request.contextPath }/images/${p.productPicture}"/></td>
						<td>
							${p.productStatus==1?"上架":"下架" }
						</td>
						<td>修改|删除</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>