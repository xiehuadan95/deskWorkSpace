<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2022/2/21
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <%-- BootStrap--%>
    <%--    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>
<h1>书籍展示</h1>

    <%--从数据库中查询出来，list遍历出来--%>
    <c:forEach items="${requestScope.list}" var="books">
        <tr>
            <td>${books.bookID}</td>
            <td>${books.bookName}</td>
            <td>${books.bookCounts}</td>
            <td>${books.detil}</td>
        </tr>
    </c:forEach>
<%--查询书籍--%>
<div class="col-md-4 column">
    <form action="" method="post">
        <input type="text" placeholder="请输入要查询的书籍名称" name="queryBookName"/>
        <input type="submit" vlue="查询" class="button">
    </form>
</div>


</body>
</html>
