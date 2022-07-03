<%--
  Created by IntelliJ IDEA.
  User: 李芹涛
  Date: 2021/1/4
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加一个车次</title>
    <script src="./js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://at.alicdn.com/t/font_1632750_204xwxiwzht.css?1583918713" />
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <link rel="stylesheet" type="text/css" href="css/input.css">
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
                            <button>
                                <a href="newUser.jsp" target="_self"></a>
                            </button>
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
                            <button>
                                <a href="newStation.jsp"></a>
                            </button>
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
                            <button>
                                <a href="newTrain.jsp"></a>
                            </button>
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
                            <button>
                                <a href="changeAdmin.jsp"></a>
                            </button>
                        </label>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="body_right">
        <div class="table-wrapper">
            <table class="fl-table">
                <caption>添加一个车次：</caption>
                <thead>
                <tr>
                    <td>始发站</td>
                    <td>终点站</td>
                    <td>车次</td>
                    <td>车类型</td>
                    <td>发车时间</td>
                    <td>票价</td>
                    <td>座位类型</td>
                    <td>有效日期</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <form action="addTrainServlet" method="post">
                        <td><input type="text" name="StartStation"></td>
                        <td><input type="text" name="EndStation"></td>
                        <td><input type="text" name="TrainNumber"></td>
                        <td><input type="text" name="TrainType"></td>
                        <td><input type="text" name="DriveTime"></td>
                        <td><input type="text" name="TicketPrice"></td>
                        <td><input type="text" name="TrainSitType"></td>
                        <td><input type="text" name="DateValue"></td>
                        <td><button type="submit" onclick="return confirm('您确定要添加么')">添加</button></td>
                    </form>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
