<%@page import="com.kmyj.shopping.entity.Orders"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="com.kmyj.shopping.util.Info"%>
<jsp:useBean id="pageinfo" class="com.kmyj.shopping.util.MyPagination"
	scope="session"></jsp:useBean>
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
	<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=(List)request.getAttribute("list");
	int pagesize=5;      //指定每页显示的记录数
	list=pageinfo.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pageinfo.getPage(str);
	list=pageinfo.getAppointPage(Page);     //获取指定页的数据
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
												<td height="308" valign="top"><div align="left"></div>
													<form action="" method="post" name="f1">
														<div align="left"></div>
														<table width="92%" border=0 align="center" cellPadding=0
															cellSpacing=0>
															<tbody>
																<tr>
																	<TD><table border=0 cellSpacing=0 cellPadding=0
																			width="100%">
																			<tbody>
																				<tr>
																					<td height=10 colSpan=2 align="left"></td>
																				</tr>
																				<tr>
																					<td width=228 background="twoHands_files/ny_y3.jpg"
																						height="37" align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已发订单</strong>
																					</td>
																					<td background=twoHands_files/ny_ybj.jpg>&nbsp;</td>
																				</tr>
																			</tbody>
																		</table></td>
																</tr>
																<tr>
																	<td width="" height=38><table width="100%" border="0"
																			align="center" cellpadding="0" cellspacing="0">
																			<tr>
																				<td height="27" align="center">接收人</td>
																				<td height="27" align="center">订单信息</td>
																				<td height="27" align="center">收货人</td>
																				<td height="27" align="center">电话</td>
																				<td height="27" align="center">地址</td>
																				<td height="27" align="center">付款方式</td>
																				<td align="center">状态</td>
																			</tr>
																			<%
                         for(int i=0;i<list.size();i++){
Orders order=(Orders)list.get(i);
                            %>
																			<tr>
																				<td height="27" align="center"><%=order.getTouname() %></td>
																				<td height="27" align="center"><%=order.getDdinfo() %></td>
																				<td height="27" align="center"><%=order.getLxr() %></td>
																				<td height="27" align="center"><%=order.getLxtel() %></td>
																				<td height="27" align="center"><%=order.getAddress() %></td>
																				<td height="27" align="center"><%=order.getFkfs() %></td>
																				<td height="27" align="center"><%=order.getStatus() %></td>
																			</tr>
																			<%} %>
																		</table></td>
																</tr>
																<tr>
																	<td height="38" align="center" colspan="20"><%=pageinfo.printCtrl(Page,(String)request.getAttribute("url")) %>
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
							</tabe>
							</td>
							</td>
						</tbody>
					</table>
</body>
</html>
<script type="text/javascript">
<!--
<%if(request.getAttribute("suc")!=null){%>
alert("操作成功");
<%}%>
//-->
</script>
<script language="javascript" src='/twoHands/js/ajax.js'></script>
<script language="javascript" src='/twoHands/js/popup.js'></script>
<%@page import="com.kmyj.shopping.util.Info"%>
