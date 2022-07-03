<%--
  Created by IntelliJ IDEA.
  User: 李芹涛
  Date: 2020/12/22
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>
<%! LocalDate date = null; %>
<html>
<head>
    <title>铁路售票系统</title>
    <link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<style type="text/css">
    #content{float:center;width:780px;border:0px;text-align:center;}
    #logo{float:center; no-repeat left bottom;}
    #data1{float:left;background:url(image/345.png);width:209px;text-align:center;color:white;}
    #login{float:left;background:url(image/346.png);width:565px;height:49px;text-align:center;}
    a:link{text-decoration:none;color:black;font-weight:bolder;}
    #middle{float:left;width:774px;height:250px;}
    #select1{float:left;width:774px;background:linear-gradient(to right,deepskyblue,white);}
    #footer{float:left;width:774px;height:100px;}
    #button1{width:66px;height:30px;color:white;background-color:cornflowerblue;border-radius:3px;border-width:0;text-align:center;cursor:pointer;}
</style>
<script type="text/javascript">
    window.onload = function() {
        var mylink = document.getElementById("mylink");
        mylink.onclick = function () {
            if (confirm("确定退出吗？"))
                return true;
            else
                return false;
        }
    }
</script>
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
            <div id="select1" class="">
                <form action="seekTrainServlet" method="post">
                    始发站：<input type="text" name="StartStation">终到站：<input type="text" name="EndStation">
                    <button type="submit" id="button1">查询</button>
                </form>
            </div>
            <div class="table-wrapper">
                <table border="1" style="text-align: center" align="center" class="fl-table">
                    <h1>车票信息:</h1>
                    <tr>
                        <td>始发站</td>
                        <td>终到站</td>
                        <td>车次</td>
                        <td>车类型</td>
                        <td>发车时间</td>
                        <td>票价</td>
                        <td>座位类型</td>
                        <td>有效日期</td>
                        <td>购买</td>
                    </tr>
                    <c:forEach var="train" items="${requestScope.trainList}" varStatus="status">
                        <tr>
                            <td>${train.startStation}</td>
                            <td>${train.endStation}</td>
                            <td>${train.trainNumber}</td>
                            <td>${train.trainType}</td>
                            <td>${train.driveTime}</td>
                            <td>${train.ticketPrice}</td>
                            <td>${train.trainSitType}</td>
                            <td>${train.dateValue}</td>
                            <form action="addOrderServlet" method="post">
                                <input type="hidden" name="TrainNumber" value="${train.trainNumber}">
                                <input type="hidden" name="UserNumber" value="${user.getUserNumber()}">
                                <td><button type="submit" onclick="return confirm('是否购买？')">购买</button></td>
                            </form>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
