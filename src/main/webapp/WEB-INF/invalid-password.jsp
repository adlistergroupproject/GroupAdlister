<%--
  Created by IntelliJ IDEA.
  User: leximorgan
  Date: 2/18/19
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Invalid Password" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<h1>The password you entered does not match what we have on file.</h1>
<a href="/change-password"><button class="btn btn-primary btn-block">Try Again</button></a>
</body>
</html>
