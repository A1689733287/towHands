<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
</head>
<title>上传</title>
<script type="text/javascript" src="/twoHands/js/popup.js"></script>
<meta content="MSHTML 6.00.2900.5726" name=GENERATOR>
</head>
<body>
	<%
String filename = request.getParameter("filename");
if(filename!=null)
{
 %>
	<script type="text/javascript">
 var txt = parent.document.getElementById("txt");
 var filename = parent.document.getElementById("filename");
 filename.value="<%=filename%>";
 txt.src="/twoHands/upfile/<%=filename%>";
 popclose();
 </script>
	<%} %>
	<form action="/twoHands/CoreServlet?ac=uploadimg" enctype="multipart/form-data"
		name="f1" method="post">
		<table cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
			<tr>
				<td align="center" class=forumrow><label> <input name="txt"
						type="file" size="27">
				</label></td>
			</tr>
			<tr>
				<td height=31 align="center" class=forumrow><input type="submit"
					name="Submit" value="提交信息">&nbsp;&nbsp;&nbsp;<input type="reset"
					name="Submit" value="重新填写"></td>
			</tr>
		</table>
	</form>
</body>
</html>