<%--
  Created by IntelliJ IDEA.
  User: leximorgan
  Date: 2/21/19
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Invalid Password" />
    </jsp:include>
    <title>Email Already in Use</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<h1>The email you entered is already being used. Please try again.</h1>
<a href="/register"><button class="btn btn-primary btn-block">Try Again</button></a>
</body>
</html>
