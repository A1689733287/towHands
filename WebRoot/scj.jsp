<%@page import="com.kmyj.shopping.entity.Favorites"%>
<%@page import="com.kmyj.shopping.entity.TwoHand"%>
<%@page import="com.kmyj.shopping.util.Info"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="pageinfo" class="com.kmyj.shopping.util.MyPagination"
	scope="session"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>二手交易网</title>
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
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
</head>
<body>
	<%
		String str = (String) request.getParameter("Page");
		HashMap map = (HashMap) request.getAttribute("map");

		int Page = 1;
		List twohs = null;
		if (str == null) {
			twohs = (List) map.get("twoh");
			int pagesize = 5;
			twohs = pageinfo.getInitPage(twohs, Page, pagesize);
		} else {
			Page = pageinfo.getPage(str);
			twohs = pageinfo.getAppointPage(Page);
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
												<td valign="top"><div align="left"></div>
													<form method="post" name="f1">
														<div align="left"></div>
														<table width="92%" border=0 align="center" cellPadding=0
															cellSpacing=0>
															<tbody>
																<tr>
																	<TD><table border=0 cellSpacing=0 cellPadding=0
																			width="100%">
																			<tbody>
																				<tr>
																					<td height=10 colSpan=2 align="left"><br></td>
																				</tr>
																				<tr>
																					<td width=228 background="twoHands_files/ny_y3.jpg"
																						height="37" align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收藏夹</strong>
																					</td>
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
																					if (map != null) {

																						List<Favorites> favs = (List) map.get("fav");
																						for (int i = 0; i < twohs.size(); i++) {
																							TwoHand twoh = (TwoHand) twohs.get(i);
																							Favorites fav = favs.get(i);
																				%>
																				<tr>
																					<td width="13%" height=38 rowspan="3" align=left
																						vAlign=center class=css><A
																						href="CoreServlet?ac=uftwocx&id=<%=fav.getWpid()%>"><IMG
																							border=0 src="upfile/<%=twoh.getFilename()%>" height=54
																							width="59"></A></td>
																					<td width="87%" height="19" align=left vAlign=center
																						class=css><a
																						href="/twoHands/CoreServlet?ac=uftwocx&id=<%=fav.getWpid()%>"><%=twoh.getTitle()%>&nbsp;&nbsp;<span
																							class="hu_txt"><%=twoh.getSavetime()%></span></a>
																						&nbsp;&nbsp; <a
																						href="/twoHands/CoreServlet?ac=scjsc&id=<%=fav.getId()%>">[移出收藏夹]</a>
																					</td>
																				</tr>
																				<tr>
																					<td height="19" align=left vAlign=center class=css><font
																						color="orange"> 联系人:<%=twoh.getLxr()%> &nbsp; 联系QQ:<%=twoh.getLxqq()%>
																							&nbsp; 价格:<%=twoh.getPrice()%> &nbsp; 类别:<%=twoh.getWptype()%>
																					</font></td>
																				</tr>
																				<tr>
																					<td height="19" align=left vAlign=center class=css><font
																						color="gray"> 物品说明:<%=Info.subStr(twoh.getWpdes().toString(), 30)%>
																					</font></td>
																				</tr>
																				<%
																					}
																					} else {
																					}
																				%>
																			</tbody>
																		</table>
																<tr>
																	<td height=33 colSpan=2 align="center"><label> <%=pageinfo.printCtrl(Page,
					(String) request.getAttribute("url"))%></label></td>
																</tr>
															</tbody>
														</table></td>
											</tr>
										</tbody>
									</table>
					</table> <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
