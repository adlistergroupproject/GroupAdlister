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
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <h1>Search</h1>
    <div>
        <c:forEach var="ad" items="${searchResults}">
            <hr>
            <div>
                <h3>${ad.title}</h3>
            </div>
            <div>
                <p>${ad.description}</p>
            </div>
            <br>
        </c:forEach>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>