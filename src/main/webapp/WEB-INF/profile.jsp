<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <div>
        <h2>Here are your ads:</h2>

        <c:forEach var="ad" items="${userAds}">
                <div>
                    <a href="/ads/show?adId=<c:out value="${ad.id}"/>">
                        <div class="col-md-6">
                            <h2>${ad.title}</h2>
                            <p>${ad.description}</p>
                        </div>
                    </a>
                    <a href="/edit-ad?adId=<c:out value="${ad.id}"/>">
                     Edit
                    </a>
                </div>
        </c:forEach>


    </div>

</body>
</html>
