<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙...</h1>
    <%
        String message = exception.getMessage();    //需要设置isErrorPage="true"，isErrorPage默认值为false
        out.print(message);
    %>

</body>
</html>
