<%@page import="com.kmyj.shopping.entity.GoodsCar"%>
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
<meta content="text/html; charset=gb2312" http-equiv=Content-Type>
</head>
<body>
	<script type="text/javascript">
<%if (request.getAttribute("suc") != null) {%>
alert("操作成功");
<%}%>
	
</script>
	<script language="javascript" src='/twoHands/js/popup.js'></script>

	<%
		String touname = "";
		String str = (String) request.getParameter("Page");
		int Page = 1;
		List list = null;
		if (str == null) {
			list = (List) request.getAttribute("list");
			int pagesize = 5;
			list = pageinfo.getInitPage(list, Page, pagesize);
		} else {
			Page = pageinfo.getPage(str);
			list = pageinfo.getAppointPage(Page);
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
												<td height="308" valign="top"><div align="left"></div>
													<form action="car.jsp" onSubmit="return checkform()" method="post"
														name="f1">
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
																						height="37" align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;购物车</strong>
																					</td>
																					<td background=twoHands_files/ny_ybj.jpg>&nbsp;</td>
																				</tr>
																			</tbody>
																		</table></td>
																</tr>
																<%
																	int allp = 0;
																	for (int i = 0; i < list.size(); i++) {
																		GoodsCar car = (GoodsCar) list.get(i);

																		allp += (int) Float.parseFloat(car.getPrice()) * car.getNums();
																%>
																<tr>
																	<td height=20>&nbsp;</td>
																</tr>
																<tr>
																	<td class=css vAlign=top align=left width="33.3%"><table
																			border=0 cellPadding=0 cellSpacing=0>
																			<tbody>
																				<tr>
																					<td width="19%" height=38 rowspan="3" align=left
																						vAlign=center class=css><A
																						href="CoreServlet?ac=uftwocx&id=<%=car.getWid()%>"><IMG
																							border=0 src="upfile/<%=car.getFilename()%>" height=54
																							width="59" style="padding-right: 5px"></A></td>
																					<td width="87%" height="19" align=left vAlign=center
																						class=css><%=car.getPname()%> <a
																						href="javascript:update('<%=car.getId()%>')">(*<%=car.getNums()%>)
																					</a></td>
																				</tr>
																				<tr>
																					<td height="19" align=left vAlign=center class=css><font
																						color="orange"> 发布人:<%=car.getToname()%>
																					</font></td>
																				</tr>
																				<tr>
																					<td height="19" align=left vAlign=center class=css><font
																						color="orange"> 价格:<%=car.getPrice()%>&nbsp;
																					</font> <a
																						href="CoreServlet?ac=carsc&id=<%=car.getId()%>&uname=<%=car.getUname()%>"><font
																							color=gray>移出</font></a></td>
																				</tr>
																			</tbody>
																		</table></td>
																	<%
																		touname = car.getToname();
																		}
																	%>
																</tr>
																<tr>
																	<td height="42" align="center" colspan="20">共计 : <%=allp%>
																		元 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
																		href="CoreServlet?ac=clear&uname=<%=session.getAttribute("admin")%>">清空购物车</a>
																		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
																		href="javascript:fs();">发送订单</a> <script
																			type="text/javascript">
         	            							  function fs()
                    	 											  {popheight="300";
                    	 					 			 pop('CoreServlet?ac=ofs&uname=<%=session.getAttribute("admin")%>&touname=<%=touname%>','信息发送',550,216);
																				}
																			</script>
																	</td>
																</tr>
															</tbody>
														</table>
													</form></td>
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
	<script type="text/javascript">

	function update(no) {
		popheight = 310;
		pop("upnum.jsp?id=" + no, "修改数量", 260, 60);
	}

</script>