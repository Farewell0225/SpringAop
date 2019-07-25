<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

    </script>
</head>
<%

    String resName = (String)request.getAttribute("user");
    out.print("返回值为 ：" + resName);

%>

<body>

        share



</body>
</html>
