<%--
  Created by IntelliJ IDEA.
  User: jiangyijie
  Date: 2018-04-15
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test File Upload Function</title>
</head>
<body>
<div>
    <%String path = request.getContextPath();%>
    <form action="<%=path%>/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" value="选择文件"/>
        <input type="submit" value="上传"/>
    </form>
</div>
</body>
</html>
