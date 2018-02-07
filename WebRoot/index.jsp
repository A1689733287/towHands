<%@page import="com.kmyj.shopping.service.IGoodsSortsService"%>
<%@page import="com.kmyj.shopping.entity.GoodsSorts"%>
<%@page import="com.kmyj.shopping.serviceimpl.GoodsSortsService"%>
<%@page import="com.kmyj.shopping.dao.IGoodsSortsDao"%>
<%@page import="com.kmyj.shopping.service.IGoodsCarService"%>
<%@page import="com.kmyj.shopping.entity.DataDesc"%>
<%@page import="com.kmyj.shopping.service.IDataDescServics"%>
<%@page import="com.kmyj.shopping.serviceimpl.DataDescService"%>
<%@page import="com.kmyj.shopping.entity.TwoHand"%>
<%@page import="com.kmyj.shopping.serviceimpl.TwoHandService"%>
<%@page import="com.kmyj.shopping.service.ITwoHandService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.kmyj.shopping.util.Info"%>
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

strong {
	font-size: 13px;
}
</style>
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
</head>
<body>
	<table border=0 cellSpacing=0 cellPadding=0 width=990 align=center>
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
												<TD>&nbsp;</td>
												<td vAlign=top width=390>
													<table border=0 cellSpacing=0 cellPadding=0 width="100%">
														<tbody>
															<tr>
																<td background="twoHands_files/index_jj.jpg" height="45"
																	align="left">
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	<strong><font color="#ffffff">网&nbsp;站&nbsp;简&nbsp;介</font></strong>
																</td>
															</tr>
															<tr>
																<TD>
																	<table border=0 cellSpacing=0 cellPadding=0 width="100%">
																		<tbody>
																			<tr>
																				<td width=8 height="143"><IMG
																					src="twoHands_files/index_jjz.jpg" width=8 height=143></td>
																				<td vAlign=top background=twoHands_files/index_jjzbj.jpg
																					align="middle">
																					<table border=0 cellSpacing=0 cellPadding=0 width="100%">
																						<tbody>
																							<tr>
																								<td vAlign="top" align="left">
																									<%
																										IDataDescServics datadao = new DataDescService();
																										DataDesc data = datadao.find("网站简介");
																										out.print(Info.subStr(Info.filterStrIgnoreCase(data.getContent()
																												.toString(), "<", ">"), 115));
																									%>
																								</td>
																							</tr>
																						</tbody>
																					</table>
																				</td>
																				<td width=8><IMG src="twoHands_files/index_jjy.jpg"
																					width=8 height=143></td>
																			</tr>
																		</tbody>
																	</table>
																</td>
															</tr>
															<tr>
																<TD><img src="twoHands_files/index_jjd.jpg" width=390
																	height=12></td>
															</tr>
															<tr>
																<td height=10></td>
															</tr>
															<tr>
																<td height="32" background="twoHands_files/index_xw.jpg"
																	align="left">
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><font
																		color="white">最新交易物品</font></strong>
																</td>
															</tr>
															<tr>
																<td height="5"></td>
															</tr>
															<tr>
																<TD>
																	<table border=0 cellSpacing=0 cellPadding=0 width="97%"
																		align=right>
																		<tbody>
																			<%
																				ITwoHandService twoDao = new TwoHandService();
																				List<TwoHand> list = twoDao.find5Top();
																				for (TwoHand twoh : list) {
																			%>
																			<tr>
																				<td width="15%" height=38 rowspan="2" align=left
																					vAlign=center class=css><A
																					href="/twoHands/CoreServlet?ac=uftwocx&id=<%=twoh.getId()%>"><IMG
																						border=0 src="upfile/<%=twoh.getFilename()%>" height=34
																						width="45"></A></td>
																				<td width="85%" height="19" align=left vAlign="center"
																					class=css><a
																					href="/twoHands/CoreServlet?ac=uftwocx&id=<%=twoh.getId()%>"><%=twoh.getTitle()%>&nbsp;&nbsp;<span
																						class="hu_txt"><%=twoh.getSavetime()%></span></a></td>
																			</tr>
																			<tr>
																				<td height="19" align=left vAlign=center class=css><font
																					color="orange"> 发布人:<%=twoh.getUname()%>
																				</font></td>
																			</tr>
																			<%
																				}
																			%>
																		</tbody>
																	</table>
																</td>
															</tr>
														</tbody>
													</table>
												</td>
												<TD>&nbsp;</td>
												<td vAlign=top width=200>
													<table border=0 cellSpacing=0 cellPadding=0 width="100%">
														<tbody>
															<tr>
																<td height="36" background="twoHands_files/index_ylm.jpg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	<strong><font color="white">网&nbsp;站&nbsp;公&nbsp;告</font></strong>
																</td>
															</tr>
															<tr>
																<td height=162 align=left style="padding: 5px">
																	&nbsp;&nbsp;&nbsp; <%
 	data = datadao.find("网站公告");
 	out.print(Info.subStr(Info.filterStrIgnoreCase(data.getContent()
 			.toString(), "<", ">"), 115));
 %>
																</td>
															</tr>
															<tr>
																<td background="twoHands_files/index_ylm2.jpg" height="34"
																	align="left">
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><font
																		color="white">物品分类</font></strong>
																</td>
															</tr>
															<tr>
																<td background=twoHands_files/index_ylmbj.jpg align=middle><table
																		border=0 cellSpacing=0 cellPadding=0 width=190 bgColor=#ffffff>
																		<tbody>
																			<tr>
																				<td height=10 align=middle></td>
																			</tr>
																			<tr>
																				<td align=middle>
																					<DIV
																						style="WIDTH: 180px; BACKGROUND: #ffffff; HEIGHT: 202px;   OVERFLOW: hidden"
																						id=demo>
																						<DIV id=demo1>
																							<DIV align=center>
																								<table border=0 cellSpacing=0 cellPadding=0 width=148>
																									<tbody>
																										<%
																											IGoodsSortsService gsdao = new GoodsSortsService();
																											List<GoodsSorts> gslist = gsdao.findAll();
																											for (GoodsSorts gs : gslist) {
																										%>
																										<tr>
																											<td align=left height="25"><a
																												href="/twoHands/CoreServlet?ac=uptwocx&wptype=<%=gs.getTypename()%>">
																													<%=gs.getTypename()%> (<%=gsdao
						.getInt("select count(*) from secondhand where wptype='"
								+ gs.getTypename() + "'")%>)
																											</a></td>
																										</tr>
																										<%
																											}
																										%>
																									</tbody>
																								</table>
																							</DIV>
																						</DIV>
																						<DIV id=demo2></DIV>
																					</DIV>
																				</td>
																			</tr>
																			<tr>
																				<td height=10 align=middle></td>
																			</tr>
																		</tbody>
																	</table></td>
															</tr>
															<tr>
																<td height=5 background=twoHands_files/index_ylmbj.jpg
																	align=middle></td>
															</tr>
														</tbody>
													</table>
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