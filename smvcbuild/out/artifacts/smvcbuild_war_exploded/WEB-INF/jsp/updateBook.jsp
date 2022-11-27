<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2022/2/21
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
</div>
<form action="${pageContext.request.contextPath}/book/updateBook" method="post">
    <div class="form-group">
        <label>书籍名称</label>
        <input type="text" name="bookName" class="form-control" />
    </div>
    <div class="form-group">
        <label >书籍数量</label>
        <input type="text" name="bookCounts" class="form-control" />
    </div>
    <div class="form-group">
        <label >书籍描述</label>
        <input type="text" name="detail" class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" class="form-control" value="修改"/>
    </div>
</form>

</body>
</html>
