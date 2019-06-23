<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../css/admin/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse;
		}
		.bgcolor{
		  	background-color: #F08080;
		}
	</style>
</head>
<body>
	<c:if test="${allTypes.totalCount == 0 }">
		您还没有类型。
	</c:if>
	<c:if test="${allTypes.totalCount != 0 }">
		<table border="1" bordercolor="PaleGreen" >
			<tr>
				<th width="200px">类型ID</th>
				<th width="600px">类型名称</th>
			</tr>
			<c:forEach items="${allTypes.list }" var="goodsType">
				<tr>
					<td>${goodsType.id }</td>
					<td>${goodsType.typename }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${allTypes.totalCount}条记录&nbsp;&nbsp;共${allTypes.totalPage}页&nbsp;&nbsp;
					第${allTypes.currentPage}页&nbsp;&nbsp;
					<c:if test="${allTypes.currentPage != 1}">
						<a href="/adminType/toAddType?currentPage=1">首页</a>&nbsp;&nbsp;
						<a href="/adminType/toAddType?currentPage=${allTypes.currentPage-1}">上一页</a>&nbsp;&nbsp;
					</c:if>
					<c:if test="${allTypes.currentPage != allTypes.totalPage}">
						<a href="/adminType/toAddType?currentPage=${allTypes.currentPage+1} ">下一页</a>&nbsp;&nbsp;
						<a href="/adminType/toAddType?currentPage=${allTypes.totalPage}">尾页</a>
					</c:if>
				</td>
			</tr>
		</table>
	</c:if>
	<form action="/adminType/addType" method="post">
		类型名称：
		<input type="text" name="typename"/>
		<input type="submit" value="添加"/>
	</form>
</body>
</html>