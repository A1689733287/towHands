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

font {
	font-size: 13px;
}
</style>
<link rel=stylesheet type=text/css href="twoHands_files/style.css">
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
</head>
<body>
	<%String user=(String)session.getAttribute("admin");%>
	<tr>
		<td height=70 vAlign=center align=right>
			<table border=0 cellSpacing=0 cellPadding=0 width="100%">
				<tbody>
					<tr>
						<td width="19%" height="80" rowspan="2" align="center"
							onClick="window.location.replace('/twoHands')"><img
							src="twoHands_files/logo.png" height="40" /></td>
						<td width="81%" height="42" align="center">
							<%
								if (user == null) {
							%> <font color="#804000"> 欢迎您光临本站，您还没有登录，请 <label
								onClick="form1.uname.focus();"> <font color="red">登录</font>
							</label> 或 <a href="regedit.jsp"><font color="red">免费注册</font></a>
						</font> <%
 	} else {
 %> <%=user%>，欢迎您回来 &nbsp; <a
							href="/twoHands/CoreServlet?ac=untwocx&uname=<%=user%>"><font
								color="#804000">我的二手交易</font></a> &nbsp; <a
							href="/twoHands/CoreServlet?ac=uocx&uname=<%=user%>"><font
								color="#804000">已发订单</font></a> &nbsp; <a
							href="/twoHands/CoreServlet?ac=ufocx&uname=<%=user%>"><font
								color="#804000">已收订单</font></a> &nbsp; <a
							href="CoreServlet?ac=carcx&uname=<%=user%>"><font color="#804000">购物车</font></a>
							&nbsp; <a href="CoreServlet?ac=scjcx&uname=<%=user%>"><font
								color="#804000">收藏夹</font></a> &nbsp;&nbsp; <a href="index.jsp?t=t">退出</a> <%
								}
							%>
						</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<td height=47 vAlign=top>
			<table border=0 cellSpacing=0 cellPadding=0 width="100%" height=40>
				<tbody>
					<tr>
						<td width=16><IMG src="twoHands_files/dh_z.jpg" width=16 height=40></td>
						<td class=bold_txt background=twoHands_files/dh_bj.jpg align=middle>
							<A href="/twoHands">首页</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<A href="/twoHands/CoreServlet?ac=zcx&datatype=网站简介">网站简介</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<A href="/twoHands/CoreServlet?ac=utwocx">二手交易</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<A href="/twoHands/CoreServlet?ac=uncx">优惠活动</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<A href="/twoHands/CoreServlet?ac=zcx&datatype=关于我们">关于我们</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<A href="CoreServlet?ac=umsgcx">留言板</A>
						</td>
						<td width=16><IMG src="twoHands_files/dh_y.jpg" width=16 height=40></td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<td height=160 vAlign=top width="100%"><img
			src="/twoHands/twoHands_files/gg.png" width="799" height="160"></img></td>
	</tr>
	<tr>
		<td height="3"></td>
	</tr>
	<tr>
		<td height=34 vAlign=top>
			<table width="100%" height="34" border=0 cellPadding=0 cellSpacing=0>
				<tbody>
					<tr>
						<td width=200 height=30 align=middle valign="middle" bgColor=#4990ce><SPAN
							class=wit_txt>
								<div style="font-size:13px" align=center>
									<SCRIPT language=JavaScript>
				var date=new Date()
				year=date.getFullYear()
				month=date.getMonth()
				date=date.getDate()
				document.write('今天是 '+year+'-'+(month+1)+'-'+date)
		      </SCRIPT>
								</div>
						</SPAN></td>
						<td width=56 valign="top"><IMG
							src="/twoHands/twoHands_files/gg_zj.jpg" width=56 height=34></td>
						<td align=left valign="middle" height="30"
							background=twoHands_files/gg_bj.jpg><SPAN class=css>欢迎光临本站，本站致力于二手交易事业的发展，有疑问请留言或联系
								<a href="tencent://message/?uin=88888888">QQ88888888</a>
						</SPAN></td>
						<td width=16 height="30" background="twoHands_files/gg_y.jpg"></td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<td height="5"></td>
	</tr>
</body>
</html>
