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
	<script type="text/javascript">
  		function checkDel(id){
  			if(window.confirm("是否删除该商品类型？")){
  				window.location.href = "/adminType/deleteType?id="+id;
  			}
  		}
  </script>
</head>
<body>
	<c:if test="${allTypes.totalCount == 0 }">
		您还没有类型。
	</c:if>
	<c:if test="${allTypes.totalCount != 0 }">
		<table border="1" bordercolor="PaleGreen" >
			<tr>
				<th width="200px">类型ID</th>
				<th width="300px">类型名称</th>
				<th width="300px">删除操作</th>
			</tr>
			<c:forEach items="${allTypes.list }" var="goodsType">
				<tr>
					<td>${goodsType.id }</td>
					<td>${goodsType.typename }</td>
					<td><a href="javascript:checkDel('${goodsType.id }')">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${allTypes.totalCount}条记录&nbsp;&nbsp;共${allTypes.totalPage}页&nbsp;&nbsp;
					第${allTypes.currentPage}页&nbsp;&nbsp;
					<c:if test="${allTypes.currentPage != 1}">
						<a href="/adminType/toDeleteType?currentPage=1">首页</a>&nbsp;&nbsp;
						<a href="/adminType/toDeleteType?currentPage=${allTypes.currentPage-1}">上一页</a>&nbsp;&nbsp;
					</c:if>
					<c:if test="${allTypes.currentPage != allTypes.totalPage}">
						<a href="/adminType/toDeleteType?currentPage=${allTypes.currentPage+1} ">下一页</a>&nbsp;&nbsp;
						<a href="/adminType/toDeleteType?currentPage=${allTypes.totalPage}">尾页</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="3">${msg }</td>
			</tr>
		</table>
	</c:if>
</body>
</html>