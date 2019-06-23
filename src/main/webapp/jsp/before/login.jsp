<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<jsp:include page="head.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
	<link href="../../css/before/daohang.css" rel="stylesheet" type="text/css" />
	<link href="../../css/before/common.css" rel="stylesheet" type="text/css" />
	<link href="../../css/before/style.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	table{
		text-align: center;
	}
	.textSize{
		width: 200px;
		height: 20px;
	}
	.code
	{
		font-family:Arial;
		font-style:italic;
		color:blue;
		font-size:18px;
		border:0;
		padding:2px 3px;
		letter-spacing:3px;
		font-weight:bolder;
		float:left;
		cursor:pointer;
		width:100px;
		height:23px;
		line-height:23px;
		text-align:center;
		vertical-align:middle;
	}
	a
	{
		text-decoration:none;
		font-size:12px;
		color:#288bc4;
	}
	a:hover
	{
		text-decoration:underline;
	}
	</style>
	<script type="text/javascript">
		//确定按钮
		function gogo(){
			var s = validateCode();
			if (s===false){
				document.loginform.action="";
				return false;
			}
			else {
				document.loginform.submit();
			}
		}
		//取消按钮
		function cancel(){
			document.loginform.action="";
		}
		var code;
		function createCode()
		{
			code = "";
			var codeLength = 6; //验证码的长度
			var checkCode = document.getElementById("checkCode");
			var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
					'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
					'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
			for(var i = 0; i < codeLength; i++)
			{
				var charNum = Math.floor(Math.random() * 52);
				code += codeChars[charNum];
			}
			if(checkCode)
			{
				checkCode.className = "code";
				checkCode.innerHTML = code;
			}
		}
		function validateCode()
		{
			var inputCode=document.getElementById("inputCode").value;
			if(inputCode.length <= 0)
			{
				alert("请输入验证码！");
				return false;
			}
			else if(inputCode.toUpperCase() != code.toUpperCase())
			{
				alert("验证码输入有误！");
				document.getElementById("inputCode").value = "";
				createCode();
				return false;
			}
			else{
				return true;
			}
		}
	</script>
  </head>
  <body  onload="createCode()">
  <div class="blank"></div>
  	<center>
		<form action="/user/login" method="post" name="loginform">
	<table>
		<tr>
			<td colspan="2"><img src="../../images/admin/login.gif"></td>
		</tr>
		<tr>
			<td>E-Mail：</td>
			<td><input type="text" name="bemail" class="textSize" id="bemail"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="bpwd" class="textSize" id="bpwd"/></td>
		</tr>
		<tr>
			<td>验证码：</td>
			<td><input type="text" id="inputCode" class="textSize"/></td>
			<td><div class="code" id="checkCode" onclick="createCode()" ></div></td>
			<td><a onclick="createCode()">看不清换一张</a></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="image" src="../../images/admin/ok.gif" onclick="gogo()">
				<input type="image" src="../../images/admin/cancel.gif" onclick="cancel()">
			</td>
		</tr>
	</table>
		</form>
        <b style="color: red">${msg }</b>
	</center>
  </body>
</html>
