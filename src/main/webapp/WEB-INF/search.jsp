<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <h1>Search</h1>
    <div>
        <c:forEach var="ad" items="${searchResults}">
            <div>${ad.id}</div>
            <div>${ad.title}</div>
            <div>${ad.description}</div>
        </c:forEach>
    </div>
</body>
</html>
