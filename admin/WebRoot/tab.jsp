<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
	request.setAttribute("ctx", (String) request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<link href="${ctx}/css/tab.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30"  style="back" background="${ctx}/images/tab/tab_05.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30">
								<img src="${ctx}/images/tab/tab_03.gif" width="12" height="30" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46%" valign="middle">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="5%">
														<div align="center">
															<img src="${ctx}/images/tab/tb.gif" width="16" height="16" />
														</div>
													</td>
													<td width="95%" class="STYLE1">
														<span class="STYLE3">你当前的位置</span>：[业务中心]-[我的邮件]
													</td>
												</tr>
											</table>
										</td>
										<td width="54%">
											<table border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="60">
														<table width="87%" border="0" cellpadding="0"
															cellspacing="0">
															<tr>
																<td class="STYLE1">
																	<div align="center">
																		<input type="checkbox" name="checkbox62"
																			value="checkbox" />
																	</div>
																</td>
																<td class="STYLE1">
																	<div align="center">
																		全选
																	</div>
																</td>
															</tr>
														</table>
													</td>
													<td width="60">
														<table width="90%" border="0" cellpadding="0"
															cellspacing="0">
															<tr>
																<td class="STYLE1">
																	<div align="center">
																		<img src="${ctx}/images/tab/22.gif" width="14" height="14" />
																	</div>
																</td>
																<td class="STYLE1">
																	<div align="center">
																		新增
																	</div>
																</td>
															</tr>
														</table>
													</td>
													<td width="60">
														<table width="90%" border="0" cellpadding="0"
															cellspacing="0">
															<tr>
																<td class="STYLE1">
																	<div align="center">
																		<img src="${ctx}/images/tab/33.gif" width="14" height="14" />
																	</div>
																</td>
																<td class="STYLE1">
																	<div align="center">
																		修改
																	</div>
																</td>
															</tr>
														</table>
													</td>
													<td width="52">
														<table width="88%" border="0" cellpadding="0"
															cellspacing="0">
															<tr>
																<td class="STYLE1">
																	<div align="center">
																		<img src="${ctx}/images/tab/11.gif" width="14" height="14" />
																	</div>
																</td>
																<td class="STYLE1">
																	<div align="center">
																		删除
																	</div>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td width="16">
								<img src="${ctx}/images/tab/tab_07.gif" width="16" height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="8" background="${ctx}/images/tab/tab_12.gif">
								&nbsp;
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="1"
									bgcolor="b5d6e6" onmouseover="changeto()"
									onmouseout="changeback()">
									<tr>
										<td width="3%" height="22" background="${ctx}/images/tab/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<input type="checkbox" name="checkbox" value="checkbox" />
											</div>
										</td>
										<td width="3%" height="22" background="${ctx}/images/tab/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">序号</span>
											</div>
										</td>
										<td width="12%" height="22" background="${ctx}/images/tab/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">接收号码</span>
											</div>
										</td>
										<td width="14%" height="22" background="${ctx}/images/tab/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">发送时间</span>
											</div>
										</td>
										<td width="18%" background="${ctx}/images/tab/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">邮件地址</span>
											</div>
										</td>
										<td width="23%" height="22" background="${ctx}/images/tab/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">内容</span>
											</div>
										</td>
										<td width="15%" height="22" background="${ctx}/images/tab/bg.gif"
											bgcolor="#FFFFFF" class="STYLE1">
											<div align="center">
												基本操作
											</div>
										</td>
									</tr>
									<tr>
										<td height="20" bgcolor="#FFFFFF">
											<div align="center">
												<input type="checkbox" name="checkbox2" value="checkbox" />
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF">
											<div align="center" class="STYLE1">
												<div align="center">
													01
												</div>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">13813916585</span>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">2007-11-16 15:00:20 </span>
											</div>
										</td>
										<td bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">tiezhu0902@163.com</span>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">南京科技股份有限公司…</span>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE4"><img src="${ctx}/images/tab/edt.gif"
														width="16" height="16" />编辑&nbsp; &nbsp;<img
														src="${ctx}/images/tab/del.gif" width="16" height="16" />删除</span>
											</div>
										</td>
									</tr>
								</table>
							</td>
							<td width="8" background="${ctx}/images/tab/tab_15.gif">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="35" background="${ctx}/images/tab/tab_19.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35">
								<img src="${ctx}/images/tab/tab_18.gif" width="12" height="35" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="STYLE4">
											&nbsp;&nbsp;共有 120 条记录，当前第 1/10 页
										</td>
										<td>
											<table border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="40">
														<img src="${ctx}/images/tab/first.gif" width="37" height="15" />
													</td>
													<td width="45">
														<img src="${ctx}/images/tab/back.gif" width="43" height="15" />
													</td>
													<td width="45">
														<img src="${ctx}/images/tab/next.gif" width="43" height="15" />
													</td>
													<td width="40">
														<img src="${ctx}/images/tab/last.gif" width="37" height="15" />
													</td>
													<td width="100">
														<div align="center">
															<span class="STYLE1">转到第 <input name="textfield"
																	type="text" size="4"
																	style="height: 12px; width: 20px; border: 1px solid #999999;" />
																页 </span>
														</div>
													</td>
													<td width="40">
														<img src="${ctx}/images/tab/go.gif" width="37" height="15" />
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td width="16">
								<img src="${ctx}/images/tab/tab_20.gif" width="16" height="35" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
