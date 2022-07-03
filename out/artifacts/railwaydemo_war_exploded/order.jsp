<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
     #login{float:left;background-image:url(image/346.png);width:565px;height:49px;text-align:center;}
     a:link{text-decoration:none;color:black;font-weight:bolder;}
     #middle{float:left;width:774px;height:250px;}
     #footer{float:left;width:774px;height:100px;}
     #button1{width:100px;height:30px;color:white;background-color:cornflowerblue;border-radius:3px;border-width:0;text-align:center;cursor:pointer;}
     #bt{float:left;width:774px;text-align:center;}
</style>
<script type="text/javascript">
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
        <a href="order.jsp">|我的订单</a>
        <a href="userchange.jsp">|个人设置</a>
        <a id="mylink" href="login.jsp">|退出</a>
      </p>
   </div>
   <div id="middle" class="">
     <div class="table-wrapper">
        <table border="1" style="text-align: center" align="center" class="fl-table">
            <h1>订单信息:</h1>
        <tr>
            <td>始发站</td>
            <td>终到站</td>
            <td>车次</td>
            <td>车类型</td>
            <td>发车时间</td>
            <td>票价</td>
            <td>座位类型</td>
            <td>有效日期</td>
            <td>订单号</td>
            <td>
                <form action="seekOrderServlet" method="post">
                    <input type="hidden" name="UserNumber" value="${user.getUserNumber()}">
                    <button type="submit">查询</button>
                </form>
            </td>
        </tr>
       <c:forEach var="order" items="${requestScope.orderList}">
            <tr>
                <td>${order.startStation}</td>
                <td>${order.endStation}</td>
                <td>${order.trainNumber}</td>
                <td>${order.trainType}</td>
                <td>${order.driveTime}</td>
                <td>${order.ticketPrice}</td>
                <td>${order.trainSitType}</td>
                <td>${order.dateValue}</td>
                <td>${order.orderNumber}</td>
                <td>
                <form action="deleteOrderServlet" method="post">
                    <input type="hidden" name="OrderNumber" value="${order.orderNumber}">
                    <button type="submit" onclick="return confirm('确定退票吗？')">退票</button>
                </form>
                </td>
            </tr>
        </c:forEach>
    </table>
     </div>
     <div id="bt" class="">
         <p></p>
         <button type="submit" id="button1" onclick="window.location.href='user.jsp';">返回首页</button>
     </div>
   </div>
</div>
</div>
</body>
</html>