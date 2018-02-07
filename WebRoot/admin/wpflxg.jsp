<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String id = request.getParameter("id");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="/twoHands/js/popup.js"></script>
<script language="javascript" src='/twoHands/js/ajax.js'></script>
<script language="javascript">  
 function checkform(){  
var typenameobj = document.getElementById("typename");  
if(typenameobj.value==""){  
document.getElementById("clabeltypename").innerHTML="&nbsp;&nbsp;<font color=red>请输入类别名称</font>";  
return false;  
}else{ 
document.getElementById("clabeltypename").innerHTML="  ";  
}  
var typenameobj = document.getElementById("typename");  
if(typenameobj.value!=""){  
var ajax = new AJAX(); 
ajax.post("/twoHands/CoreServlet?ac=checkno&table=wpfl&col=typename&value="+typenameobj.value+""); 
var msg = ajax.getValue(); 
if(msg.indexOf('Y')>-1){ 
document.getElementById("clabeltypename").innerHTML="&nbsp;&nbsp;<font color=red>类别名称已存在</font>";  
return false; 
}else{ 
document.getElementById("clabeltypename").innerHTML="  ";  
}  
}  
return true;   
}   
</script>
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
<body>
	<form action="/twoHands/CoreServlet?ac=gxg&id=<%=id%>" name="f1" method="post"
		onSubmit="return checkform()">
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
															修改分类&nbsp;&nbsp;</span></td>
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
								class="STYLE19">类别名称</td>
							<td width="79%" height="30" align="left" bgcolor="#FFFFFF"
								class="STYLE19">&nbsp; <input type=text class='' id='typename'
								name='typename' onblur="return checkform()" size=35 /><label
								id='clabeltypename' /></td>
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
