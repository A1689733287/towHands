<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
</head>
<body>
	<%
String uname=(String)session.getAttribute("admin");
String id=request.getParameter("id");
         %>
	<tr>
		<td height=70 vAlign=center align=right>
			<table border=0 cellSpacing=0 cellPadding=0 width="100%">
				<tbody>
					<tr>
						<td height="59" align="center">
							<form style="display: inline" name="f1" action="CoreServlet?ac=carxg&id=<%=id%>&uname=<%=uname %>" method="post">
								请输入数量 : <label></label> &nbsp; 
								<input type="text" size="5" name="num" style="border: 1px solid #D6E9F3;"
									id="textfield"/>&nbsp; &nbsp; 
									<input type="submit" name="button" id="button" value="确定"> &nbsp;&nbsp;&nbsp;&nbsp;
							</form> </label>
						</td>
					</tr>
				</tbody>
				</tabe>
				</td>
				</td>
</body>
</html>