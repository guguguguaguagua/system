<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="image/logo.png"/>
    <title>用户注册</title>
    <script type="text/javascript" src="js/register.js"></script>
</head>
<style>
    .div1{
        border: crimson solid 1px;
        height: 600px;
        width: 500px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
        background-image: linear-gradient(to right , deepskyblue, papayawhip);

    }
    .div2{
        border: 0px;
        height: content-box;
        width: content-box;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
    }
    .p1{
        text-align: center;
    }
    .p2{
        text-align: right;
        margin-right: -70px;
    }
    .input1{
        border:none;
        border-bottom: 1px solid yellow;
        width:170px;
        height:30px;
    }
    .input2{
        border: 1px solid #ccc;
        border-radius: 20px;
        height: 35px;
        width: 70px;
        background-color: darkorange;
    }
    input:focus{
        outline: none;
    }
    a:link{
        text-decoration: none;
    }
    body{
        background-image: linear-gradient(to bottom right, #7A88FF, #7AFFAF);
    }
    h2{
        text-align: center;
        color: red;
    }
</style>
<body>
<div class="div1">
    <div class="div2">
        <form action="registerServlet" onsubmit="return check()" method="post">
            <h2>Hi~ o(*￣▽￣*)ブ</h2><br>
            ${sessionScope.mess1}
            <p>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="UserNumber" placeholder="输入10位数字···" class="input1" required id="a1"></p><br>
            <p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="UserPassword" placeholder="6-16位数字或字母···" class="input1" required id="p1"></p><br>
            <p>确认密码：<input type="password" name="UserPassword1" placeholder="6-16位数字或字母···" class="input1" required id="p2"></p><br>
            <p>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="UserName" placeholder="英文名或中文名···" class="input1" required id="n1"></p><br>
            <p class="p1">
                <input type="submit" value="注册" class="input2"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置" class="input2"/>
            </p>
        </form>
    </div>
</div>
</body>
</html>
