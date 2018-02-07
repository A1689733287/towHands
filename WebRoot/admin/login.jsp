<%@ page language="java" pageEncoding="utf-8"%>
<jsp:directive.page import="java.util.ArrayList" />
<jsp:directive.page import="java.util.List" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>二手交易网后台管理 - 登 录</title>
<meta content="MSHTML 6.00.6000.16809" name=GENERATOR>
<script src="/twoHands/js/jquery-1.8.1.min.js"></script>
<script language=Javascript>
	function VF_loginform() {
		var theForm = document.loginform;
		var errMsg = "";
		var setfocus = "";

		if (theForm['upass'].value =="") {
			errMsg = "请填写登录密码！";
			setfocus = "['upass']";
			return false;
		}
		if (theForm['uname'].value == "") {
			errMsg = "请填写登录用户名！";
			setfocus = "['uname']";
			return false;
		}
		if (errMsg != "") {
			alert(errMsg);
			eval("theForm" + setfocus + ".focus()");
		}

	}
</script>
</head>
<BODY 
	background="/twoHands/admin/images/bj.gif">
	<P>&nbsp;</P>
	<P>&nbsp;</P>
	<form name="loginform"  action="/twoHands/CoreServlet?ac=login" method="post" onSubmit="return VF_loginform()">
		<table id=Table1
			style="BORDER-RIGHT: 1px outset; BORDER-TOP: 1px outset; BORDER-LEFT: 1px outset; BORDER-BOTTOM: 1px outset"
			cellspacing=0 cellpadding=0 width=380 align=center>
			<tbody>
				<tr>
					<td
						style="PADDING-RIGHT: 3px; PADDING-LEFT: 3px; FONT-SIZE: 13px; PADDING-BOTTOM: 3px; COLOR: white; PADDING-TOP: 3px; BACKGROUND-COLOR: blue">用户登录
					</td>
				</tr>
				<tr valign=top>
					<td><img height=60 src="/twoHands/admin/images/admin_title.gif"
						width=378></td>
				</tr>
				<tr>
					<td height="60"
						style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px">
						<table border=0>
							<tbody>
								<tr id="tr1">
									<td><span style="WIDTH: 80px ;height: 25px">用户名：</span></td>
									<td><input id=a style="WIDTH: 200px;height: 25px" tabindex=1
										maxlength=20 name=uname></td>
								</tr>
								<tr id="tr2">
									<td><span style="WIDTH: 80px; height: 25px">密 码：</span></td>
									<td><input id=b style="WIDTH: 200px;height: 24px" type=password
										maxlength=20 name=upass></td>
								</tr>
								<tr>
									<td height="35" colspan="2" align="right"><span
										style="cursor: hand; font-size: 12px" onClick="register();"></span> <label></label>
										&nbsp; <input id=Submit1 style="FONT: menu; WIDTH: 80px" type=submit
										onMouseDown="VF_loginform()" value="登 录" name=btnSubmit></td>
									<%
										String err = (String) request.getAttribute("error");
										if (err != null) {
									%>
									<script language="javascript">
										alert("帐号或密码不正确");
									</script>
									<%
										}
									%>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td height="33" align=right
						style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FONT-SIZE: 13px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px">二手交易网后台管理
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>