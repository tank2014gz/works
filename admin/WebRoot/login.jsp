<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%> 
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%
request.setAttribute("ctx",request.getContextPath()); 
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>用户登录</title>
		<script type=text/javascript src="js/jquery-1.10.2.min.js"></script>
		<link href="css/login.css" rel="stylesheet" type="text/css" />
		<script>
				function userLogin() {
					var name = $('input[name=name]').val();
					name = $.trim(name);
					var pwd = $('input[name=pwd]').val();
					pwd = $.trim(pwd);
					if(name==''){
						alert('请输入用户');
						return;
					}
					if(pwd==''){
						alert('请输入密码');
						return;
					}
					$('input[name=name]').val(name);
					$('input[name=pwd]').val(pwd);
					$('form').submit();
				}
				$(document).ready(function(){
					var msg = $('#errorMsg').val();
					if($.trim(msg)!=''){
						alert(msg);
					}
				});
		</script>
	</head>

	<body>
	    
		<form method="post" action="${ctx}/login">
			<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td>
						<table width="962" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="235" background="images/login_03.gif">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td height="53">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="320" height="53" background="images/login_05.gif">
												&nbsp;
											</td>
											<td width="280" background="images/login_06.gif">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="16%" height="25">
															<div align="right">
																<span class="STYLE1">用户：</span>
															</div>
														</td>
														<td width="45%" height="25">
															<div align="center">
																<input type="text" name="name" class="input_text">
															</div>
														</td>
														<td height="25" >
															<span class="STYLE1" style="width: 100px;margin-left: 10px;">
															  <input type="checkbox">二周自动登录
														    </span>
														</td>
													</tr>
													<tr>
														<td height="25">
															<div align="right">
																<span class="STYLE1">密码：</span>
															</div>
														</td>
														<td height="25">
															<div align="center">
																<input type="password" name="pwd" class="input_text">
															</div>
														</td>
														<td height="25">
															<div style="margin-left: 10px;">
																<a href="javascript:void(0);" onclick="userLogin();"><img
																		src="images/dl.gif" width="49" height="18" border="0">
																</a>
															</div>
														</td>
													</tr>
												
												</table>
											</td>
											<td width="362" background="images/login_07.gif">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="213" background="images/login_08.gif">
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<input type="hidden" name="errorMsg" id="errorMsg" value="${SPRING_SECURITY_LAST_EXCEPTION.message}">
		</form>
	</body>
</html>
