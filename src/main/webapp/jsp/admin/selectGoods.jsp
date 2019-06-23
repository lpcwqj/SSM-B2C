<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>selectGoods.jsp</title>
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
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
	</script>
</head>
<body>
	<c:if test="${allGoods.totalCount == 0 }">
		您还没有商品。
	</c:if>
	<c:if test="${allGoods.totalCount != 0 }">
		<table border="1" bordercolor="PaleGreen">
			<tr>
				<th width="100px">ID</th>
				<th width="200px">名称</th>
				<th width="200px">价格</th>
				<th width="100px">库存</th>
				<th width="200px">详情</th>
			</tr>
			<c:forEach items="${allGoods.list}" var="goods">
				<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
					<td>${goods.id}</td>
					<td>${goods.gname}</td>
					<td>${goods.grprice}</td>
					<td>${goods.gstore}</td>
					<td><a href="/adminGoods/selectAGoods?id=${goods.id}" target="_blank">详情</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${allGoods.totalCount}条记录&nbsp;&nbsp;共${allGoods.totalPage}页&nbsp;&nbsp;
					第${allGoods.currentPage}页&nbsp;&nbsp;
					<c:if test="${allGoods.currentPage != 1}">
						<a href="/adminGoods/selectGoods?currentPage=1">首页</a>&nbsp;&nbsp;
						<a href="/adminGoods/selectGoods?currentPage=${allGoods.currentPage-1}">上一页</a>&nbsp;&nbsp;
					</c:if>
					<c:if test="${allGoods.currentPage != allGoods.totalPage}">
						<a href="/adminGoods/selectGoods?currentPage=${allGoods.currentPage+1} ">下一页</a>&nbsp;&nbsp;
						<a href="/adminGoods/selectGoods?currentPage=${allGoods.totalPage}">尾页</a>
					</c:if>
				</td>
			</tr> 
		</table>
	</c:if>
</body>
</html>