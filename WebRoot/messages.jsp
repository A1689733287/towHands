<%@page import="com.kmyj.shopping.daoimp.UserDao"%>
<%@page import="com.kmyj.shopping.entity.User"%>
<%@page import="com.kmyj.shopping.entity.Messages"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
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
<%
	String uname = (String) session.getAttribute("admin");
	if (uname == null) {
%>
<script type="text/javascript">
	alert("请先登录");
	window.location.replace("/twoHands/index.jsp");
</script>
<%
	}
%>
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
</head>
<body>
	<%
		String str = (String) request.getParameter("Page");
		int Page = 1;
		List list = null;
		if (str == null) {
			list = (List) request.getAttribute("list");
			int pagesize = 3; //指定每页显示的记录数
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
													<form action="/twoHands/CoreServlet?ac=msgtj&uname=<%=uname%>"
														method="post" name="f1">
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
																							留言板</strong></td>
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
																						Messages msg = (Messages) list.get(i);
																						
																						User user = new UserDao().find(msg.getSaver());
																				%>
																				<tr>
																					<td width="16%" height="50" align=center class=css><img
																						src="upfile/<%=user.getFilename()%>" width="50"
																						height="40"></td>
																					<td width="84%" height="50" align=left valign="middle"
																						class=css><%=msg.getSaver()%> ( <%=msg.getSavetime()%>
																						) : <br /> <%=msg.getContent()%> <%
																							if (!msg.getResaver().equals("")) {
																									User user2 = new UserDao().find(msg.getResaver());
																						%></td>
																				</tr>
																				<tr>
																					<td height="50" align=center class=css><font
																						color=grey><img
																							src="upfile/<%=user2.getFilename()%>" width="50"
																							height="40"></font></td>
																					<td height="50" align=left valign="middle" class=css><font
																						color=grey> <%=msg.getResaver()%> ( <%=msg.getResavetime()%>
																							) : <br /> <%=msg.getRecontent()%>
																					</font> <%
 	}
 %></td>
																				</tr>
																				<tr>
																					<td height="10" colspan="2" align="center" class=css>-
																						- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
																						- - - - - - - - - - - - - -</td>
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
																	<td height=33 colSpan=2 align="center"><label> <textarea
																				rows="3" cols="40" name="content"></textarea>
																	</label></td>
																</tr>
																<tr>
																	<td height=33 colSpan=2 align="center"><label> <input
																			type="submit" value="提交留言">
																	</label></td>
																</tr>
																<script language="javascript" src="js/popups.js"></script>
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
