<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 2020/10/12
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>



  <%
    System.out.println("hello jsp");
    int i = 5;

    String contextPath = request.getContextPath();
    out.print(contextPath);
  %>

  <%!
    int i = 3;
  %>

  <%= "hello" %>

  <%
    response.getWriter().write("response...");
  %>

    <h1>hi~ jsp!</h1>
  </body>
</html>
