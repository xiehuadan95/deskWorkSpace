
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>
    登录
</h1>
<div style="text-align:center">
<%--    以post的方式提交表单 到我们的login请求--%>
    <form action="${pageContext.request.contextPath}/Login" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type="checkbox" name="hobby" value="girl">女孩
        <input type="checkbox" name="hobby" value="code">代码
        <input type="checkbox" name="hobby" value="sing">唱歌
        <input type="checkbox" name="hobby" value="movie">电影
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
