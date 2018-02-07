<%@page import="com.kmyj.shopping.entity.TwoHand"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.kmyj.shopping.util.Info"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>二手交易网</title>
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
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
<script language="javascript" src='/twoHands/js/popup.js'></script>
</head>
<%
	String user = (String) session.getAttribute("admin");
	TwoHand twoh = (TwoHand) request.getAttribute("twohand");
%>
<body>
	<table border=0 cellSpacing=0 cellPadding=0 width=1002 align=center>
		<tbody>
			<tr>
				<td background=twoHands_files/bj.jpg align="center">
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
													<form action="" method="post" name="f1">
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
																						height="37" align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;信息详情</strong>
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
																							<strong> <%=twoh.getTitle()%>
																							</strong> <br />
																							<%="信息发布人:" + twoh.getUname()%>&nbsp;
																							<%="发布时间:" + twoh.getSavetime()%>
																							<br /> <IMG border=0
																								src="upfile/<%=twoh.getFilename()%>" height=124> <br />
																							<%
																								if (user != null) {
																									String car = request.getParameter("car");
																							%>
																							<a href="javascript:add();"><font color=#804000><strong>[放入购物车]</strong></font></a><br />
																							<script type="text/javascript">
 function add(){
 popheight = 430;
 pop("CoreServlet?ac=cartjn&id=<%=twoh.getId()%>","请输入数量",260,60);
																								};
																							</script>
																							<%
																								}
																							%>
																							物品类别 :
																							<%=twoh.getWptype()%>
																							<br /> 物品说明 :
																							<%=twoh.getWpdes()%>
																							<br /> 联系人 :
																							<%=twoh.getLxr()%>
																							<br /> 联系电话 :
																							<%=twoh.getLxtel()%>
																							<br /> 联系地址 :
																							<%=twoh.getLxaddress()%>
																							<br /> 联系QQ :
																							<%=twoh.getLxqq()%>
																							<br /> 物品价格" :
																							<%=twoh.getPrice()%>
																							<br />
																						</center>
																					</td>
																				</tr>
																			</tbody>
																		</table>
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
