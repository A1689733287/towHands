<%@page import="com.kmyj.shopping.entity.TwoHand"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
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
<meta content="text/html; charset=UTF-8" http-equiv=Content-Type>
</head>
<body>
	<%
        TwoHand twoh=(TwoHand)request.getAttribute("twoh");
         %>
	<tr>
		<td height=70 vAlign=center align=right>
			<table border=0 cellSpacing=0 cellPadding=0 width="100%">
				<tbody>
					<tr>
						<td height="59" align="center">
							<form style="display: inline" name="f2" method="post">
								请输入数量 : <label></label> &nbsp; <input type="text" size="5" name="nums"
									value=1 onkeyup='clearNoNum(this);' onblur='clearNoNum(this);'
									onmouseup='clearNoNum(this);' style="border: 1px solid #D6E9F3;"
									id="textfield">&nbsp; &nbsp; <input type="button"
									onClick="search();" name="button" id="button" value="确定">
								&nbsp;&nbsp;&nbsp;&nbsp;
								<script type="text/javascript">
                 function search()
                 { 
                 var nums = f2.nums.value;
                 if(nums=="")nums="1";
                 parent.location.replace("CoreServlet?ac=cartj&id=<%=twoh.getId() %>&filename=<%=twoh.getFilename()%>&pname=<%=twoh.getTitle()%>&price=<%=twoh.getPrice() %>&touname=<%=twoh.getUname() %>&uname=<%=session.getAttribute("admin") %>&nums="+nums); 
                 
                 }
                 </script>
							</form> </label>
						</td>
					</tr>
				</tbody>
				</tabe>
				</td>
				</td>
</body>
</html>
