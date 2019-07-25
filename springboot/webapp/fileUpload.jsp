<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

    </script>
</head>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    out.write(basePath);

%>



<body>

    <form action="upload.do" method="post" enctype="multipart/form-data">
            <input type="hidden" name="tuzi" value="tuzi"><br>
    上传文件：<input type="file" name="uploadfile">
            <input type="submit" value="上传">
    </form>

1111


</body>
</html>
