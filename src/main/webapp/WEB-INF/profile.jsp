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

        <div>
            <h2>Here are your ads:</h2>

            <c:forEach var="ad" items="${userAds}">
                <div>
                    <div class="row">
                        <div class="col-sm-5">
                            <div class="card m-3">
                                <div class="card-body">
                                    <a href="/ads/show?adId=<c:out value="${ad.id}"/>">
                                        <h2 class="card-title">${ad.title}</h2>
                                        <p class="card-text">${ad.description}</p>
                                    </a>
                                    <a class="btn btn-info btn-sm" href="/ads/edit?adId=<c:out value="${ad.id}"/>">Edit</a>
                                    <a class="btn btn-danger btn-sm" href="/ads/delete?adId=<c:out value="${ad.id}"/>">Delete</a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


    <script type="text/javascript" src="/js/jquery.js"></script>
</body>
</html>


