<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<jsp:include page="head.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="../../css/before/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/before/style.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
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
	//表单验证
	function checkForm(){
		var bpwd = document.registerForm.bpwd.value;
		var rebpwd = document.registerForm.rebpwd.value;
		var s = validateCode();
		if (bpwd==rebpwd && s===true) {
			document.registerForm.submit();
		}
		if(bpwd != rebpwd){
			alert("两次密码不一致！");
		}
		if (s===false){
			window.location.reload();
		}
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
			return false;
		}
		else{
			return true;
		}
	}
</script>
</head>
<body onload="createCode();">
	<div class="clearfix">
		<div class="blank20"></div>
		<div class="box4">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%" valign="bottom">
						<h2>普通会员注册</h2>
					</td>
				</tr>
			</table>
		</div>
		<div class="blank10"></div>
		<div class="box4">
			<div class="case_ll clearfix">
				<div class="regist">
					<form action="/user/register" method="post" name="registerForm">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							class="ttbb2">
							<tr>
								<td width="16%" align="right"><span class="cl_f30">*</span>
									E-mail：</td>
								<td width="59%"><input type="text" name="bemail"
									id="textfield" class="my_txt_350"/></td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
									（有效的E-mail地址才能收到激活码，帐户在激活后才能享受网站服务。）</td>
							</tr>
							<tr>
								<td align="right"><span class="cl_f30">*</span> 密码：</td>
								<td><input type="password" name="bpwd" id="textfield2"
									class="my_txt_350" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
									（为了您帐户的安全，建议使用字符+数字等多种不同类型的组合，且长度大于5位。）</td>
							</tr>
							<tr>
								<td align="right"><span class="cl_f30">*</span> 重复密码：</td>
								<td><input type="password" name="rebpwd" id="textfield3"
									class="my_txt_350" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
									（确保您记住密码。）</td>
							</tr>
							<tr>
								<td align="right"><span class="cl_f30">*</span> 验证码：</td>
								<td><input type="text" name="code"
									id="inputCode" class="my_txt_120" />
								<div class="code" id="checkCode" onclick="createCode()" ></div>
								<a onclick="createCode()">看不清换一张</a>
								</td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td colspan="2" class="cl_f30" style="font-size: 12px; padding-bottom: 25px;"></td>
							</tr>
							<tr>
								<td align="right">&nbsp;</td>
								<td height="50"><input type="button" name="button" id="button" onclick="checkForm()" value="注册账号" class="my_ann1" /></td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</form>
					<div class="blank20"></div>
				</div>
			</div>
		</div>
		<div class="blank10"></div>
	</div>
</body>
</html>
