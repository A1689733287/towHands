<%@page import="com.kmyj.shopping.util.Info"%>
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
<!-- <link rel=stylesheet type=text/css href="twoHands_files/style.css"> -->
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
												<jsp:include page="left.jsp"></jsp:include>
												<td valign="top">
													<form
														action="/twoHands/CoreServlet?ac=regeditxg&name=<%=session.getAttribute("admin")%>"
														onSubmit="return checkform()" method="post" name="f1">
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
																						height="37" align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改注册信息</strong>
																					</td>
																					<td background=twoHands_files/ny_ybj.jpg>&nbsp;</td>
																				</tr>
																			</tbody>
																		</table></td>
																</tr>
																<tr>
																	<td height=20>&nbsp;</td>
																</tr>
																<tr>
																	<td class=css vAlign=top align=left><table border=0
																			cellSpacing=0 cellPadding=0 width="100%">
																			<tbody>
																				<tr>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="23%" align=center>用户名</td>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="77%" align=left><%=session.getAttribute("admin")%>
																					</td>
																				</tr>
																				<tr>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="23%" align=center>密码</td>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="77%" align=left><input type=text class=''
																						onblur="javascrit:checkform()" id='userpass'
																						name='userpass' size=35 /><label id='clabeluserpass' /></td>
																				</tr>
																				<tr>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="23%" align=center>姓名</td>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="77%" align=left><input type=text
																						onblur="javascrit:checkform()" class='' id='truename'
																						name='truename' size=35 /><label id='clabeltruename' /></td>
																				</tr>
																				<tr>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="23%" align=center>性别</td>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="77%" align=left><span id="sexdanx"><label><input
																								type=radio name='sex' value='男' />&nbsp;男 </label> <label><input
																								type=radio name='sex' value='女' />&nbsp;女 </label> </span></td>
																				</tr>
																				<tr>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="23%" align=center>QQ</td>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="77%" align=left><input type=text
																						onblur="javascrit:checkform()" class='' id='qq' name='qq'
																						size=35 /><label id='clabelqq' /></td>
																				</tr>
																				<tr>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="23%" align=center>电话号码</td>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="77%" align=left><input type=text
																						onblur="javascrit:checkform()" class='' id='phoneno'
																						name='phoneno' size=35 /><label id='clabelphoneno' /></td>
																				</tr>
																				<tr>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="23%" align=center>email</td>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="77%" align=left><input type=text
																						onblur="javascrit:checkform()" class='' id='email'
																						name='email' size=35 /><label id='clabelemail' /></td>
																				</tr>
																				<tr>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="23%" align=center>家庭住址</td>
																					<td class=css height=32 background=twoHands_files/ny_xt.jpg
																						width="77%" align=left><input type=text
																						onblur="javascrit:checkform()" class='' id='dizhi'
																						name='dizhi' size=35 /><label id='clabeldizhi' /></td>
																				</tr>
																				<tr>
																					<td class=css height=32
																						background=twoHands_files/ny_xt.jpgg width="23%"
																						align=center>头像</td>
																					<td class=css height=32
																						background=twoHands_files/ny_xt.jpgg width="77%"
																						align=left><%=Info.getImgUpInfo(65)%></td>
																				</tr>
																			</tbody>
																		</table>
																<tr>
																	<td height=33 colSpan=2 align="center"><label> <input
																			type="submit" name="button" id="button" value="提交">&nbsp;&nbsp;&nbsp;
																			<input type=reset value='重置' />
																	</label></td>
																</tr>
																<tr>
																	<td colSpan=2 align=middle>&nbsp;</td>
																</tr>
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
							</tabe>
							</td>
							</td>
						</tbody>
					</table>
</body>
</html>
<%
	String unames = "";
%>
<script language="javascript" src='/twoHands/js/ajax.js'></script>
<script language="javascript">
	function checkform() {
		var userpassobj = document.getElementById("userpass");
		if (userpassobj.value == "") {
			document.getElementById("clabeluserpass").innerHTML = "&nbsp;&nbsp;<font color=red>请输入密码</font>";
			return false;
		} else {
			document.getElementById("clabeluserpass").innerHTML = "  ";
		}
		var qqobj = document.getElementById("qq");
		if (qqobj.value != "") {
			if (qqobj.value.length > 12 || isNaN(qqobj.value)) {
				document.getElementById("clabelqq").innerHTML = "&nbsp;&nbsp;<font color=red>QQ必须为12位以内数字</font>";
				return false;
			} else {
				document.getElementById("clabelqq").innerHTML = "";
			}
		}
		var phonenoobj = document.getElementById("phoneno");
		if (phonenoobj.value != "") {
			if (phonenoobj.value.length > 11 || phonenoobj.value.length < 8
					|| isNaN(phonenoobj.value)) {
				document.getElementById("clabelphoneno").innerHTML = "&nbsp;&nbsp;<font color=red>电话号码必须为8-11位数字</font>";
				return false;
			} else {
				document.getElementById("clabelphoneno").innerHTML = "";
			}
		}
		var emailobj = document.getElementById("email");
		if (emailobj.value != "") {
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if (!myreg.test(emailobj.value)) {
				document.getElementById("clabelemail").innerHTML = "&nbsp;&nbsp;<font color=red>email格式不正确</font>";
				return false;
			} else {
				document.getElementById("clabelemail").innerHTML = "";
			}
		}
		return true;
	}
</script>
