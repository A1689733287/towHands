<%@page import="com.kmyj.shopping.serviceimpl.FriendLinkService"%>
<%@page import="com.kmyj.shopping.entity.FriendLink"%>
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
</style>
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
</head>
<body>
	<tr>
		<td height=12></td>
	</tr>
	<tr>
		<td bgColor=#006699 height=28 align=middle><SPAN class=bold_txt><A
				style="CURSOR: hand"
				onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://localhost:8080/twoHands')"
				href="http://localhost:8080/twoHands">设为首页</A>&nbsp;&nbsp;|&nbsp;&nbsp;<A
				href="javascript:window.external.AddFavorite('http://localhost:8080/twoHands','企业与企业家')">加入收藏</A>
		</SPAN></td>
	</tr>
	<tr>
		<td class=css height=110 align=middle>
			<%
				for (FriendLink flk : new FriendLinkService().findAll()) {
			%> <a href="<%=flk.getLinkurl()%>"><font color=gray><%=flk.getLinkname()%></font></a>
			&nbsp;&nbsp;&nbsp; <%
 	}
 %> <br /> 联系地址 : 昆明冶金高等专科学校 <br /> 联系电话 : 0278888888 <br />
		</td>
	</tr>
</body>
</html>
