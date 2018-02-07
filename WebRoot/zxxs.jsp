<%@page import="com.kmyj.shopping.serviceimpl.CheckNoService"%>
<%@page import="com.kmyj.shopping.entity.TwoHand"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.kmyj.shopping.util.Info"%>
<jsp:useBean id="pageinfo" class="com.kmyj.shopping.util.MyPagination"
	scope="session"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>二手交易网</title>
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
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
<%
	String user=(String)session.getAttribute("admin");
%>
<script type="text/javascript" src="/twoHands/js/ajax.js"></script>
<script language=javascript> 
function update(no){ 
pop('CoreServlet?ac=twotoxg&id='+no,'信息修改',550,390) ;
}
</script>
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
												<jsp:include page="left.jsp"></jsp:include>
												<td valign="top"><div align="left"></div>
													<form action="CoreServlet?ac=utwotj&name=<%=user %>"
														onSubmit="return checkform()" method="post" name="f1">
														<div align="left"></div>
														<table width="92%" border=0 align="center" cellPadding=0
															cellSpacing=0>
															<tbody>
																<tr>
																	<TD><table border=0 cellSpacing=0 cellPadding=0
																			width="100%">
																			<tbody>
																				<tr>
																					<td width=228 background="twoHands_files/ny_y3.jpg"
																						height="37" align="left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二手交易</strong>
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
																				<%
																					
																					    for(int i=0;i<list.size();i++)
																					    {
																					    TwoHand twoh=(TwoHand)list.get(i);
																				%>
																				<tr>
																					<td width="13%" height=38 rowspan="3" align=left
																						vAlign="center" class=css><A
																						href="/twoHands/CoreServlet?ac=uftwocx&id=<%=twoh.getId()%>"><IMG
																							border=0 src="upfile/<%=twoh.getFilename()%>" height=54
																							width="59"></A></td>
																					<td width="87%" height="19" align=left vAlign=center
																						class=css><a
																						href="/twoHands/CoreServlet?ac=uftwocx&id=<%=twoh.getId()%>"><%=twoh.getTitle()%>&nbsp;&nbsp;<span
																							class="hu_txt"><%=twoh.getSavetime()%></span></a>
																						&nbsp;&nbsp; <%
 	if(user!=null)
              {
           if(!new CheckNoService().select("scj", "wid", String.valueOf(twoh.getId()))){
 %> <a
																						href="/twoHands/CoreServlet?ac=scjtj&uname=<%=user%>&sctype=<%=twoh.getInfotype() %>&wid=<%=twoh.getId()%>">[收藏]</a>&nbsp;&nbsp;
																						<%
																							}
																						             else{
																						%> [已收藏] <%
																							}%> <%																			
             if(user.equals(twoh.getUname()))
             {
             %> <a href="javascript:update('<%=twoh.getId()%>')">修改</a> <%
             }}
              %></td>
																				</tr>
																				<tr>
																					<td height="19" align=left vAlign=center class=css><font
																						color="orange"> 联系人:<%=twoh.getLxr()%> &nbsp; 联系QQ:<%=twoh.getLxqq()%>
																							&nbsp; 价格:<%=twoh.getPrice()%> &nbsp; 类别:<%=twoh.getInfotype()%>
																					</font></td>
																				</tr>
																				<tr>
																					<td height="19" align=left vAlign=center class=css><font
																						color="gray"> 物品说明:<%=Info.subStr(twoh.getWpdes().toString(),30)%>
																					</font></td>
																				</tr>
																				<%
																					}
																				%>
																			</tbody>
																		</table>
																<tr>
																	<td height=33 colSpan=2 align="center"><label> <%=pageinfo.printCtrl(Page,(String)request.getAttribute("url")) %>
																	</label></td>
																</tr>
																<tr>
																	<td colSpan=2 align=middle>
																		<%
																			if(user!=null){
																		%>
																		<table width="512" border="0" align="center" cellpadding="0"
																			cellspacing="0">
																			<tr>
																				<td height="30" colspan="2" align="center"
																					style="cursor: hand"><strong>发布信息</strong></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">标题</td>
																				<td width="353" height="30" align="left"><input
																					type=text class='' onblur="javascrit:checkform()"
																					id='title' name='title' size=35 /><label id='clabeltitle' /></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">物品类别</td>
																				<td width="353" height="30" align="left"><%=request.getAttribute("wpfl")%><label
																					id='clabelwptype' /></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">物品说明</td>
																				<td width="353" height="30" align="left"><textarea
																						cols='35' class='' name='wpbei'></textarea></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">联系人</td>
																				<td width="353" height="30" align="left"><input
																					type=text class='' id='lxr' onblur="javascrit:checkform()"
																					name='lxr' size=35 /><label id='clabellxr' /></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">联系电话</td>
																				<td width="353" height="30" align="left"><input
																					type=text class='' onblur="javascrit:checkform()"
																					id='lxtel' name='lxtel' size=35 /><label id='clabellxtel' /></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">联系地址</td>
																				<td width="353" height="30" align="left"><input
																					type=text class='' onblur="javascrit:checkform()"
																					id='lxaddrs' name='lxaddrs' size=35 /><label
																					id='clabellxaddrs' /></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">联系QQ</td>
																				<td width="353" height="30" align="left"><input
																					type=text class='' onblur="javascrit:checkform()" id='lxqq'
																					name='lxqq' size=35 /><label id='clabellxqq' /></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">价格</td>
																				<td width="353" height="30" align="left"><input
																					type=text size='8' onblur="javascrit:checkform()" class=''
																					id='price' name='price' /><label id='clabelprice' /></td>
																			</tr>
																			<tr>
																				<td width="159" height="30" align="center">相关图片</td>
																				<td width="353" height="30" align="left"><%=Info.getImgUpInfo(65)%></td>
																			</tr>
																			<tr>
																				<td height="30" colspan="2" align="center"><label>
																						<input type="submit" name="button" id="button" value="提交">&nbsp;&nbsp;&nbsp;
																						<input type="reset" name="button2" id="button2" value="重置">
																				</label></td>
																			</tr>
																		</table> <%}
 %>
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
					</table>
				</td>
			</tr>
		</tbody>
	</table>
	</td>
	</tr>
</body>
</html>
<script type="text/javascript">
	
<%if(request.getAttribute("suc")!=null){%>
	alert("操作成功");
<%}%>
	
</script>
<script language="javascript">
	function checkform() {
		var titleobj = document.getElementById("title");
		if (titleobj.value == "") {
			document.getElementById("clabeltitle").innerHTML = "&nbsp;&nbsp;<font color=red>请输入标题</font>";
			return false;
		} else {
			document.getElementById("clabeltitle").innerHTML = "  ";
		}

		var wptypeobj = document.getElementById("wptype");
		if (wptypeobj.value == "") {
			document.getElementById("clabelwptype").innerHTML = "&nbsp;&nbsp;<font color=red>请输入物品类别</font>";
			return false;
		} else {
			document.getElementById("clabelwptype").innerHTML = "  ";
		}

		var lxrobj = document.getElementById("lxr");
		if (lxrobj.value == "") {
			document.getElementById("clabellxr").innerHTML = "&nbsp;&nbsp;<font color=red>请输入联系人</font>";
			return false;
		} else {
			document.getElementById("clabellxr").innerHTML = "  ";
		}

		var lxtelobj = document.getElementById("lxtel");
		if (lxtelobj.value == "") {
			document.getElementById("clabellxtel").innerHTML = "&nbsp;&nbsp;<font color=red>请输入联系电话</font>";
			return false;
		} else {
			document.getElementById("clabellxtel").innerHTML = "  ";
		}

		var lxqqobj = document.getElementById("lxqq");
		if (lxqqobj.value != "") {
			if (lxqqobj.value.length > 12 || isNaN(lxqqobj.value)) {
				document.getElementById("clabellxqq").innerHTML = "&nbsp;&nbsp;<font color=red>联系QQ必须为12位以内数字</font>";
				return false;
			} else {
				document.getElementById("clabellxqq").innerHTML = "";
			}
		}
		var priceobj = document.getElementById("price");
		if (priceobj.value != "") {
			if (isNaN(priceobj.value)) {
				document.getElementById("clabelprice").innerHTML = "&nbsp;&nbsp;<font color=red>价格只能是数字</font>";
				return false;
			} else {
				document.getElementById("clabelprice").innerHTML = "";
			}
		}
		return true;
	}
</script>
