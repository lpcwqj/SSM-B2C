<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body>
	<table border=1 style="border-collapse: collapse">
		<caption>
			<font size=4 face=华文新魏>商品详情</font>
		</caption>
		<tr>
			<td>名称</td>
			<td>
				${goods.gname}
			</td>
		</tr>
		<tr>
			<td>原价</td>
			<td>
				${goods.goprice }
			</td>
		</tr>
		<tr>
			<td>折扣价</td>
			<td>
				${goods.grprice }
			</td>
		</tr>
		<tr>
			<td>库存</td>
			<td>
				${goods.gstore }
			</td>
		</tr>
		<tr>
			<td>图片</td>
			<td>
				<c:if test="${goods.gpicture != '' }">
					<img alt="" width="250" height="250"
					src="/pic/${goods.gpicture}"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
				${goodsTypeName }
			</td>
		</tr>
	</table>
</body>
</html>