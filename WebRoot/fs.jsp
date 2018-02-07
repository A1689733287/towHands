<%@page import="com.kmyj.shopping.entity.GoodsCar"%>
<%@page import="com.kmyj.shopping.entity.User"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
.mytab {
	font-size: 12px;
	width: 100%;
	line-height: 150%;
	text-decoration: none;
	word-wrap: break-word;
	border: #DBE6E3 solid 1px;
	border-bottom: 0;
	border-right: 0;
	border-left: #DBE6E3 solid 1px;
	line-height: 175%;
	margin: 1px 1px;
	margin-left: 0px;
}

.mytab td {
	padding: 2px 5px;
	border: #DBE6E3 solid 1px;
	border-left: 0;
	border-top: 0;
}

body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}

.STYLE6 {
	color: #000000;
	font-size: 12;
}

.STYLE10 {
	color: #000000;
	font-size: 12px;
}

.STYLE19 {
	color: #344b50;
	font-size: 12px;
}

.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}

.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>
<script language="javascript" src='/twoHands/js/ajax.js'></script>
<script language="javascript">  
 
 function checkform(){  
var lxrobj = document.getElementById("lxr");  
if(lxrobj.value==""){  
document.getElementById("clabellxr").innerHTML="&nbsp;&nbsp;<font color=red>请输入收货人</font>";  
return false;  
}else{
document.getElementById("clabellxr").innerHTML="  ";  
}  
  
var lxtelobj = document.getElementById("lxtel");  
if(lxtelobj.value==""){  
document.getElementById("clabellxtel").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系电话</font>";  
return false;  
}else{
document.getElementById("clabellxtel").innerHTML="  ";  
}  
  
var lxtelobj = document.getElementById("lxtel");  
if(lxtelobj.value!=""){  
if(lxtelobj.value.length>11||lxtelobj.value.length<8||isNaN(lxtelobj.value)){ 
document.getElementById("clabellxtel").innerHTML="&nbsp;&nbsp;<font color=red>联系电话必须为8-11位数字</font>";  
return false;
}else{  
document.getElementById("clabellxtel").innerHTML="";  
}  
}  
var addrsobj = document.getElementById("addrs");  
if(addrsobj.value==""){  
document.getElementById("clabeladdrs").innerHTML="&nbsp;&nbsp;<font color=red>请输入送货地址</font>";  
return false;  
}else{
document.getElementById("clabeladdrs").innerHTML="  ";  
}  
  
return true;   
}   
</script>
<script type="text/javascript" src="/twoHands/js/popup.js"></script>
<script>
var  highlightcolor='#d5f4fe';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[0].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[0].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[0].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[0].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
</head>
<%
	String ddinfo = "";
	List<GoodsCar> cars = (List) request.getAttribute("goods");
	User user = (User) request.getAttribute("user");
	for (GoodsCar car : cars) {
		String touname = car.getToname();

		ddinfo += "物品:" + car.getPname() + "&nbsp;单价:" + car.getPrice()
				+ "&nbsp;*" + car.getNums() + "<br />";
		if (ddinfo.length() > 0)
			ddinfo = ddinfo.substring(0, ddinfo.length() - 6);
	}
%>
<body>
	<form
		action="CoreServlet?ac=otj&uname=<%=session.getAttribute("admin")%>&ddinfo=<%=ddinfo%>&touname=<%=request.getAttribute("touname")%>"
		name="f1" method="post" onSubmit="return checkform()">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="30"><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td height="24" bgcolor="#353c44"><table width="100%" border="0"
									cellspacing="0" cellpadding="0">
									<tr>
										<td><table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="3%" height="19" valign="bottom">&nbsp;</td>
													<td width="97%" valign="bottom"><span class="STYLE1">
															发送订单&nbsp;&nbsp;</span></td>
												</tr>
											</table></td>
										<td></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0"
						bgcolor="#a8c7ce" class="mytab" onMouseOver="changeto()"
						onmouseout="changeback()">
						<tr>
							<td width="21%" height="30" align="center" bgcolor="#FFFFFF"
								class="STYLE19">收货人</td>
							<td width="79%" height="30" align="left" bgcolor="#FFFFFF"
								class="STYLE19">&nbsp; <input type=text class='' id='lxr'
								value="<%=user.getTruename()%>" name='lxr' size=35 /><label
								id='clabellxr' /></td>
						</tr>
						<tr>
							<td width="21%" height="30" align="center" bgcolor="#FFFFFF"
								class="STYLE19">联系电话</td>
							<td width="79%" height="30" align="left" bgcolor="#FFFFFF"
								class="STYLE19">&nbsp; <input type=text class='' id='lxtel'
								value="<%=user.getPhoneno()%>" name='lxtel' size=35 /><label
								id='clabellxtel' /></td>
						</tr>
						<tr>
							<td width="21%" height="30" align="center" bgcolor="#FFFFFF"
								class="STYLE19">联系QQ</td>
							<td width="79%" height="30" align="left" bgcolor="#FFFFFF"
								class="STYLE19">&nbsp; <input type=text class='' id='lxqq'
								name='lxqq' value="<%=user.getQq()%>" size=35 /><label id='clabellxqq' /></td>
						</tr>
						<tr>
							<td width="21%" height="30" align="center" bgcolor="#FFFFFF"
								class="STYLE19">送货地址</td>
							<td width="79%" height="30" align="left" bgcolor="#FFFFFF"
								class="STYLE19">&nbsp; <input type=text class='' id='addrs'
								name='addrs' value="<%=user.getAddress()%>" size=35 /><label
								id='clabeladdrs' /></td>
						</tr>
						<tr>
							<td width="21%" height="30" align="center" bgcolor="#FFFFFF"
								class="STYLE19">付款方式</td>
							<td width="79%" height="30" align="left" bgcolor="#FFFFFF"
								class="STYLE19">&nbsp; <input type=text class='' id='fkfs'
								name='fkfs' size=35 /><label id='clabelfkfs' /></td>
						</tr>
						<tr>
							<td height="30" colspan="2" align="center" bgcolor="#FFFFFF" class=""><label>
									<input type="submit" name="Submit" value="提交信息" /> &nbsp;&nbsp;&nbsp;
									<input type=button value='返回上页' onclick='popclose();' />
							</label></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>
