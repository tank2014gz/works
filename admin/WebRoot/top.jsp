<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="com.phone.commons.DateTool"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
	request.setAttribute("ctx", (String) request.getContextPath());
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<link href="${ctx}/css/top.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="70" background="${ctx}/images/main_05.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="24">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="270" height="24" background="${ctx}/images/main_03.gif">
											&nbsp;
										</td>
										<td width="505" background="${ctx}/images/main_04.gif">
											&nbsp;
										</td>
										<td>
											&nbsp;
										</td>
										<td width="21">
											<img src="${ctx}/images/main_07.gif" width="21" height="24">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="38">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="270" height="38" background="${ctx}/images/main_09.gif">
											&nbsp;
										</td>
										<td>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="77%" height="25" valign="bottom">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td width="50" height="19">
																	<div align="center">
																		<img src="${ctx}/images/main_12.gif" width="49" height="19">
																	</div>
																</td>
																<td width="50">
																	<div align="center">
																		<img src="${ctx}/images/main_14.gif" width="48" height="19">
																	</div>
																</td>
																<td width="50">
																	<div align="center">
																		<img src="${ctx}/images/main_16.gif" width="48" height="19">
																	</div>
																</td>
																<td width="50">
																	<div align="center">
																		<img src="${ctx}/images/main_18.gif" width="48" height="19">
																	</div>
																</td>
																<td width="50">
																	<div align="center">
																		<img src="${ctx}/images/main_20.gif" width="48" height="19">
																	</div>
																</td>
																<td width="26">
																	<div align="center">
																		<img src="${ctx}/images/main_21.gif" width="26" height="19">
																	</div>
																</td>
																<td width="100">
																	<div align="center">
																		<img src="${ctx}/images/main_22.gif" width="98" height="19">
																	</div>
																</td>
																<td>
																	&nbsp;
																</td>
															</tr>
														</table>
													</td>
													<td width="220" valign="bottom" nowrap="nowrap">
														<div align="right">
															<span class="STYLE1"><span class="STYLE2">*</span>
																今天是：<%=DateTool.getFormatDate(new Date(),"yyyy年MM月dd日") %> <%=DateTool.getWeekOfDate(new Date()) %></span>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="21">
											<img src="${ctx}/images/main_11.gif" width="21" height="38">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="8" style="line-height: 8px;">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="270" background="${ctx}/images/main_29.gif"
											style="line-height: 8px;">
											&nbsp;
										</td>
										<td width="505" background="${ctx}/images/main_30.gif"
											style="line-height: 8px;">
											&nbsp;
										</td>
										<td style="line-height: 8px;">
											&nbsp;
										</td>
										<td width="21" style="line-height: 8px;">
											<img src="${ctx}/images/main_31.gif" width="21" height="8">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="28" background="${ctx}/images/main_36.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="177" height="28" background="${ctx}/images/main_32.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="20%" height="22">
											&nbsp;
										</td>
										<td width="59%" valign="bottom">
											<div align="center" class="STYLE1" style="font-weight: bold;">
												当前用户：<sec:authentication property="name"/>
											</div>
										</td>
										<td width="21%">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="65" height="28">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="23" valign="bottom">
														<table width="58" border="0" align="center"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="20" style="cursor: hand"
																	onMouseOver="this.style.backgroundImage='url(${ctx}/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<div align="center" class="STYLE3">
																		业务中心
																	</div>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td width="3">
											<img src="${ctx}/images/main_34.gif" width="3" height="28">
										</td>
										<td width="63">
											<table width="58" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="20" style="cursor: hand"
														onMouseOver="this.style.backgroundImage='url(${ctx}/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
														onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
														<div align="center" class="STYLE3">
															系统管理
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td>
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
							<td width="21">
								<img src="${ctx}/images/main_37.gif" width="21" height="28">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
