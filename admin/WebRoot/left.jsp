<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
	request.setAttribute("ctx", (String) request.getContextPath());
%>
<link href="${ctx}/css/left.css" rel="stylesheet" type="text/css" />

<script>
var he = document.body.clientHeight - 105
document.write("<div id=tt style=height:" + he + ";overflow:hidden>")
function showsubmenu(sid) {
	whichEl = eval("submenu" + sid);
	imgmenu = eval("imgmenu" + sid);
	if (whichEl.style.display == "none") {
		eval("submenu" + sid + ".style.display=\"\";");
		imgmenu.background = "${ctx}/images/main_47.gif";
	} else {
		eval("submenu" + sid + ".style.display=\"none\";");
		imgmenu.background = "${ctx}/images/main_48.gif";
	}
}
</script>

<table width="165" height="100%" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="28" background="${ctx}/images/main_40.gif">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="19%">
						&nbsp;
					</td>
					<td width="81%" height="20">
						<span class="STYLE1">操作菜单</span>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td valign="top">
			<table width="151" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="23" background="${ctx}/images/main_47.gif"
									id="imgmenu2" class="menu_title"
									onmouseover="this.className='menu_title2';"
									onclick="showsubmenu(2)"
									onmouseout="this.className='menu_title';" style="cursor: hand">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="18%">
												&nbsp;
											</td>
											<td width="82%" class="STYLE1">
												系统管理
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td background="${ctx}/images/main_51.gif" id="submenu2">
									<div class="sec_menu">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<table width="90%" border="0" align="center"
														cellpadding="0" cellspacing="0">
														<tr>
															<td width="16%" height="25">
																<div align="center">
																	<img src="${ctx}/images/left.gif" width="10"
																		height="10" />
																</div>
															</td>
															<td width="84%" height="23">
																<table width="95%" border="0" cellspacing="0"
																	cellpadding="0">
																	<tr>
																		<td height="20" style="cursor: hand"
																			onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																			onmouseout="this.style.borderStyle='none'">
																			<span class="STYLE3">用户管理</span>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td height="23">
																<div align="center">
																	<img src="${ctx}/images/left.gif" width="10"
																		height="10" />
																</div>
															</td>
															<td height="23">
																<table width="95%" border="0" cellspacing="0"
																	cellpadding="0">
																	<tr>
																		<td height="20" style="cursor: hand"
																			onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																			onmouseout="this.style.borderStyle='none'">
																			<span class="STYLE3">角色管理</span>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td height="23">
																<div align="center">
																	<img src="${ctx}/images/left.gif" width="10"
																		height="10" />
																</div>
															</td>
															<td height="23">
																<table width="95%" border="0" cellspacing="0"
																	cellpadding="0">
																	<tr>
																		<td height="20" style="cursor: hand"
																			onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																			onmouseout="this.style.borderStyle='none'">
																			<span class="STYLE3"><a href="login.jsp" target="center_right">资源管理</a></span>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td height="5">
													<img src="${ctx}/images/main_52.gif" width="151" height="5" />
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="18" background="${ctx}/images/main_58.gif">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="18" valign="bottom">
						<div align="center" class="STYLE3">
							版本：2013V1.0 By Gavin
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>