<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="shortcut icon" href="image/logo.png"/>
  <title>铁路售票系统登录</title>
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
  <h2>欢迎登录铁路售票系统（づ￣3￣）づ╭❤～</h2><br>
  <div class="div2"><br><br><br>
    <form action="loginServlet" method="post">
      <p>账号：<input type="text" name="UserNumber" placeholder="例：1806034110" class="input1" required></p>
      ${sessionScope.mess}
      <br><br>
      <p>密码：<input type="password" name="UserPassword" placeholder="请输入密码···" class="input1"  required></p>
      <br>
      <br>
      <p class="p1">
        <input type="submit" value="登录" class="input2"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重置" class="input2"/>
      </p>
      <p class="p2"><a href="addUser.jsp">注册账号</a></p>
    </form>
  </div>
</div>
</body>
</html>
