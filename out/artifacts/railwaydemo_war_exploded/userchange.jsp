<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%! LocalDate date = null; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
     #content{float:center;width:780px;border:0px;text-align:center;}
     #logo{float:center; no-repeat left bottom;}
     #data1{float:left;background-image:url(image/345.png);width:209px;text-align:center;color:white;}
     #login{float:left;background-image:url(image/346.png);width:565px;height:49px;text-align:right;}
     a:link{text-decoration:none;color:black;font-weight:bolder;}
     #middle{float:left;width:774px;height:250px;}
     #footer{float:left;width:774px;height:100px;}
     #button1{width:100px;height:30px;color:white;background-color:cornflowerblue;border-radius:3px;border-width:0;text-align:center;cursor:pointer;}
     #bt{float:left;width:774px;text-align:center;}
     .center{position:absolute;top:300px;left:0;right:0;bottom:0;margin:auto;}
</style>
<script type="text/javascript">
        function xiugai(){
    	if(confirm("确定修改吗？")){
    		f1.submit();
    		return true;}
    	else
    		return false;
    	}
        window.onload = function(){
       	 var mylink = document.getElementById("mylink");
       	 mylink.onclick = function(){
       		 if(confirm("确定退出吗？"))
       			 return true;
       		 else
       			 return false;
       	 }
        }
</script>
<title>我的订单</title>
    <link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
<div align="center">
<div id="content" class="">
<% date = LocalDate.now();%>
   <div id="logo" class="">
      <img alt="" src="image/344.png" border="0" >
   </div>
   <div id="data1" class="">
      <p><%=date.toString()%></p>
   </div>
   <div id="login" class="">
      <p>
        <a href="userchange.jsp">${user.getUserName()}</a>
        <a id="mylink" href="login.jsp">|退出&nbsp;&nbsp;&nbsp;&nbsp;</a>
      </p>
   </div>
   <div id="middle" class="">
     <div style="text-align: center">
     <form action="changeUserServlet" method="post" name="f1">
        用户账号：<input type="text" name="UserNumber"><br><p></p>
        用户密码：<input type="text" name="UserPassword"><br><p></p>
        用户姓名：<input type="text" name="UserName"><br><p></p>
        <button type="button" id="button1" onclick="xiugai()">修改</button>
    </form>
</div>
     <div id="bt" class="">
         <p></p>
         <button type="button" id="button1" onclick="window.location.href='user.jsp';">返回</button>
     </div>
   </div>
</div>
</div>
</body>
</html>