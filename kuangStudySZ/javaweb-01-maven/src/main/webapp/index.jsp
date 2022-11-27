<html>
<body>
<h2>Hello 帅哥!我是Tomcat</h2>
<%--这里提交的路径，需要寻找的项目的类路径--%>
<%--括号里面代表当前的项目--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">

</form>
</body>
</html>
