<%@page import="com.kmyj.shopping.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="pageinfo" class="com.kmyj.shopping.util.MyPagination"
	scope="session"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
</style>
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
</head>
<body>
	<%
		String str = (String) request.getParameter("Page");
		int Page = 1;
		List list = null;
		if (str == null) {
			list = (List) request.getAttribute("list");
			int pagesize = 5; //指定每页显示的记录数
			list = pageinfo.getInitPage(list, Page, pagesize); //初始化分页信息
		} else {
			Page = pageinfo.getPage(str);
			list = pageinfo.getAppointPage(Page); //获取指定页的数据
		}
	%>
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
												<jsp:include page="left.jsp"></jsp:include>
												<td valign="top">
													<form action="" method="post" name="f1"
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
																						height="37" align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																							优惠活动</strong></td>
																					<td background=twoHands_files/ny_ybj.jpg>&nbsp;</td>
																				</tr>
																			</tbody>
																		</table></td>
																</tr>
																<tr>
																	<td height=20>&nbsp;</td>
																</tr>
																<tr>
																	<td class=css vAlign=top align=left><table border=0
																			cellSpacing=0 cellPadding=0 width="100%">
																			<tbody>
																				<%
																					for (int i = 0; i < list.size(); i++) {
																						News news = (News) list.get(i);
																				%>
																				<tr>
																					<td class=css align=left>&nbsp;&nbsp;&nbsp;&nbsp; <a
																						href="/twoHands/CoreServlet?ac=sidncx&id=<%=news.getId()%>"><%=news.getTitle()%>
																					</a> &nbsp;&nbsp;&nbsp;&nbsp; <font color=gray> <%=news.getSavetime()%></font>
																					</td>
																				</tr>
																				<tr>
																					<td class=css height="10" align="center">- - - - - - -
																						- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
																						- - - - - - - -</td>
																				</tr>
																				<%
																					}
																				%>
																			</tbody>
																		</table>
																<tr>
																	<td height=33 colSpan=2 align="center"><label><%=pageinfo.printCtrl(Page,
					(String) request.getAttribute("url"))%></label></td>
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
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
