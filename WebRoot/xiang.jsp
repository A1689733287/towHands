<%@page import="com.kmyj.shopping.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
</head>
<title>二手交易网</title>
<link rel=stylesheet type=text/css href="style/css.css">
<style type=text/css>
BODY {
	BACKGROUND-IMAGE: none;
	MARGIN: 0px
}
</style>
<link rel=stylesheet type=text/css href="twoHands_files/style.css">
<style type=text/css>
.STYLE3 {
	COLOR: #333333;
	FONT-SIZE: 12px
}

A:link {
	TEXT-DECORATION: none
}

A:visited {
	TEXT-DECORATION: none
}

A:hover {
	TEXT-DECORATION: none
}

A:active {
	TEXT-DECORATION: none
}

strong {
	font-size: 13px;
}
</style>
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
</head>
<body>
	<table border=0 cellSpacing=0 cellPadding=0 width=1002 align=center>
		<tbody>
			<tr>
				<td background=twoHands_files/bj.jpg align=middle>
					<table border=0 cellSpacing=0 cellPadding=0 width=800>
						<tbody>
							<jsp:include page="top.jsp"></jsp:include>
							<tr>
								<td vAlign=top>
									<table border=0 cellSpacing=0 cellPadding=0 width="100%">
										<tbody>
											<tr>
												<%
     News news=(News)request.getAttribute("news");
 %>
												<jsp:include page="left.jsp"></jsp:include>
												<td valign="top">
													<form action="" onSubmit="return check();" method="post" name="f1"
														enctype="multipart/form-data">
														<table width="92%" border=0 align="center" cellPadding=0
															cellSpacing=0>
															<tbody>
																<tr>
																	<TD><table border=0 cellSpacing=0 cellPadding=0
																			width="100%">
																			<tbody>
																				<tr>
																					<td height=10 colSpan=2></td>
																				</tr>
																				<tr>
																					<td width=228 background="twoHands_files/ny_y3.jpg"
																						height="37" align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网站公告</strong>
																					</td>
																					<td background=twoHands_files/ny_ybj.jpg>&nbsp;</td>
																				</tr>
																			</tbody>
																		</table></td>
																</tr>
																<tr>
																	<td height=10 align="center"></td>
																</tr>
																<tr>
																	<td class=css vAlign=top align=left><table border=0
																			cellSpacing=0 cellPadding=0 width="100%">
																			<tbody>
																				<tr>
																					<td class=css height=32 align=left>
																						<center>
																							<strong> <%=news.getTitle() %>
																							</strong> <br />
																							<%="作者:" +news.getAuthor() %>
																							&nbsp;&nbsp;
																							<%="发布时间:"+ news.getSavetime()%>
																							<br /> <img src="upfile/<%=news.getFilename() %>"
																								height="120" />
																						</center> <%=news.getContent() %>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																<tr>
																	<td height=33 colSpan=2 align="center"><label></label></td>
																</tr>
																<tr>
																	<td colSpan=2 align=middle>&nbsp;</td>
																</tr>
															</tbody>
														</table>
													</form>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<jsp:include page="foot.jsp"></jsp:include>
							</tabe>
							</td>
							</td>
						</tbody>
					</table>
</body>
</html>