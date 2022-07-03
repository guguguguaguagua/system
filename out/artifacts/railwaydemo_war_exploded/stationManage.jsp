<%--
  Created by IntelliJ IDEA.
  User: 李芹涛
  Date: 2021/1/4
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>站点信息管理</title>
    <script src="./js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://at.alicdn.com/t/font_1632750_204xwxiwzht.css?1583918713" />
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
<div class="body_con">
    <div class="body_top">${admin.getAdminName()}欢迎使用铁路售票管理系统</div>
    <div class="body_left">
        <ul class="body_left_list">
            <li>
                <label>
                    <span>用户管理</span>
                    <i class="iconfont iconxiajiantou"></i>
                </label>
                <ul>
                    <li>
                        <label>
                            <i class="iconfont iconYYGK"></i>
                            <span>查询所有用户</span>
                            <form action="seekAllUserServlet" method="post">
                                <button type="submit">查询所有用户</button>
                            </form>
                        </label>
                    </li>
                    <li>
                        <label>
                            <i class="iconfont iconYYGK"></i>
                            <span>添加一个用户</span>
                            <a href="newUser.jsp" target="_self"></a>
                        </label>
                    </li>
                </ul>
            </li>
            <li>
                <label>
                    <span>站点管理</span>
                    <i class="iconfont iconxiajiantou"></i>
                </label>
                <ul>
                    <li>
                        <label>
                            <i class="iconfont iconYYGK"></i>
                            <span>查询所有站点</span>
                            <form action="seekAllStationServlet" method="post">
                                <button type="submit">查询所有站点</button>
                            </form>
                        </label>
                    </li>
                    <li>
                        <label>
                            <i class="iconfont iconYYGK"></i>
                            <span>添加一个站点</span>
                            <a href="newStation.jsp"></a>
                        </label>
                    </li>
                </ul>
            </li>
            <li>
                <label>
                    <span>车次管理</span>
                    <i class="iconfont iconxiajiantou"></i>
                </label>
                <ul>
                    <li>
                        <label>
                            <i class="iconfont iconYYGK"></i>
                            <span>查询所有车次</span>
                            <form action="seekAllTrainServlet" method="post">
                                <button type="submit">查询所有车次</button>
                            </form>
                        </label>
                    </li>
                    <li>
                        <label>
                            <i class="iconfont iconYYGK"></i>
                            <span>添加一个车次</span>
                            <a href="newTrain.jsp"></a>
                        </label>
                    </li>
                </ul>
            </li>
            <li>
                <label>
                    <span>信息管理</span>
                    <i class="iconfont iconxiajiantou"></i>
                </label>
                <ul>
                    <li>
                        <label>
                            <i class="iconfont iconYYGK"></i>
                            <span>修改管理员信息</span>
                            <a href="changeAdmin.jsp"></a>
                        </label>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="body_right">
        <div class="table-wrapper">
            <table border="1" class="fl-table">
                <caption>所有车站信息</caption>
                <thead>
                <tr>
                    <td>车站编号</td>
                    <td>车站名称</td>
                    <td colspan="2">操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="station" items="${requestScope.stationList}" varStatus="status">
                    <tr>
                        <td>${station.stationNumber}</td>
                        <td>${station.stationName}</td>
                        <td>
                            <button type="submit"><a href="changeStation.jsp">修改</a></button>
                        </td>
                        <td>
                            <form action="deleteStationServlet" method="post">
                                <input type="hidden" name="StationNumber" value="${station.stationNumber}">
                                <button type="submit" onclick="return confirm('您确定要删除么')">删除</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
