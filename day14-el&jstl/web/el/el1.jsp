<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${3 > 4}

    \${3 > 4}

    <hr>
    <h3>算术运算符</h3>

    ${3 + 4}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>

    <h3>比较运算符</h3>
    ${3 == 4}<br>

    <h3>逻辑运算符</h3>
    ${3 > 4 && 3 < 4}<br>
    ${3 > 4 and 3 < 4}<br>

    <h4>empty运算符</h4>
    <%
        String str = "abc";
        request.setAttribute("str", str);

        List list = new ArrayList();
        request.setAttribute("list", list);
    %>
    ${empty str}<br>    <%-- 判断str是否为null，或者长度是否为0 --%>
    ${not empty str}<br>    <%-- 判断str是否不为null，并且长度大于为0 --%>

    ${empty list}<br>
    ${not empty list}<br>


</body>
</html>
