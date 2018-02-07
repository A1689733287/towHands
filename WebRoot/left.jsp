<%@page import="com.kmyj.shopping.serviceimpl.DataDescService"%>
<%@page import="com.kmyj.shopping.util.Info"%>
<%@page import="com.kmyj.shopping.entity.DataDesc"%>
<%@page import="com.kmyj.shopping.service.IDataDescServics"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<LINK rel=stylesheet type=text/css href="style/css.css">
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
<title>二手交易网</title>
<link rel=stylesheet type=text/css href="style/css.css">
<style type=text/css>
BODY {
	BACKGROUND-IMAGE: none;
	MARGIN: 0px
}

strong {
	font-size: 13px;
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
<script language="javascript">
	
<%if (request.getAttribute("error") != null) {%>
	alert("用户名或密码错误");
<%}%>
	
</script>
</head>
<body>
	<td vAlign=top width=196>
		<table border=0 cellSpacing=0 cellPadding=0 width="100%">
			<tbody>
				<tr>
					<td background="twoHands_files/index_zlm.jpg" height="35" align="left"><font
						color="white"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户登录</strong></font></td>
				</tr>
				<tr>
					<td background=twoHands_files/index_zlmbj.jpg align=middle>
						<form name="form1" method="post" action="/twoHands/CoreServlet?ac=mlogin">
							<table border=0 cellSpacing=0 cellPadding=0 width="90%" align=center>
								<tbody>
									<tr>
										<td class=css height=10 background=twoHands_files/index_dx.jpg
											align=left></td>
									</tr>
									<%
										String t = request.getParameter("t");
										if (t != null) {
											session.removeAttribute("admin");
									%>
									<script language="javascript">
										window.location.replace("/twoHands");
									</script>
									<%
										}
									%>
									<%
										String user = (String) session.getAttribute("admin");
										if (user == null) {
									%>
									<tr>
										<td class=css height=33 align=center>用户名: <input type="text"
											name="uname" id="uname" size="12" style="height:20px">
										</td>
									</tr>
									<tr>
										<td class=css height=33 align=center>密&nbsp;码:<input
											type="password" name="upass" id="upass" size="12" style="height:20px"></td>
									</tr>
									<tr>
										<td class=css height=33 align=center><input type="submit"
											value="登录" style="border:2px" /> &nbsp;&nbsp;&nbsp; <input
											type="button" value="注册" style="border:2px"
											onClick="window.location.replace('regedit.jsp')" /></td>
									</tr>
									<%
										} else {
									%>
									<tr>
										<td class=css height=33 align=center><br /> 欢迎你回来 : <%=user%> <br />
											<br /> <a href="regeditx.jsp">修改注册信息</a> &nbsp;&nbsp; <a
											href="index.jsp?t=t">退出</a> <br /> <br /></td>
									</tr>
									<%
										}
									%>
									<tr>
										<td class=css height=10 background=twoHands_files/index_dx.jpg
											align=left></td>
									</tr>
								</tbody>
							</table>
						</form>
					</td>
				</tr>
				<tr>
					<td align=left height="41" background="twoHands_files/index_zlm1.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><font
							color="white">联系我们</font></strong>
					</td>
				</tr>
				<tr>
					<td background=twoHands_files/index_zlmbj1.jpg align=middle><table
							border=0 cellSpacing=0 cellPadding=0 width=186 bgColor=#ffffff>
							<tbody>
								<tr>
									<td height=2></td>
								</tr>
								<tr>
									<td align=left style="padding: 5px" height="188">
										<%
											IDataDescServics datadao = new DataDescService();
											DataDesc data = datadao.find("关于我们");
											out.print(Info.subStr(Info.filterStrIgnoreCase(data.getContent()
													.toString(), "<", ">"), 115));
										%>
									</td>
								</tr>
							</tbody>
						</table></td>
				</tr>
				<tr>
					<td height=62 background=twoHands_files/index_zlmbj1.jpg align=middle>
						<div
							style="position: absolute; line-height:50px;left:340px; FONT-FAMILY:  ">
							<font color="orange" size="4"><strong> 客服中心</strong></font>
						</div>
						<IMG border=0 src="twoHands_files/index_zlm2.jpg" width=186 height=50>
					</td>
				</tr>
			</tbody>
		</table>
	</td>
</body>
</html>
