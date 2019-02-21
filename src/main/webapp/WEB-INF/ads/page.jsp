<%--@elvariable id="ad" type="org.w3c.dom.html.HTMLDocument"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="adId"/>
        <jsp:param name="adTitle" value="ad.title"/>
        <jsp:param name="adDescription" value="ad.description"/>
    </jsp:include>

</head>

<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>


    <div class="container">


        <h1>Ad Info.</h1>

            <div class="row">
                <div class="col-sm-5">
                    <div class="card m-3">
                        <div class="card-body">
                            <h2 class="card-title">${adInfo.title}</h2>
                            <p class="card-text">${adInfo.description}</p>
                            <c:choose>
                                <c:when test="${showEditDeleteButtons}">
                                    <a class="btn btn-info btn-sm" href="/ads/edit?adId=<c:out value="${adInfo.id}"/>">Edit</a>
                                    <a class="btn btn-danger btn-sm" href="/ads/delete?adId=<c:out value="${adInfo.id}"/>">Delete</a>
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        </div>
                </div>
            </div>

        <h5>Page view count is: ${adInfo.viewCount}</h5>
    </div>
</body>
</html>


