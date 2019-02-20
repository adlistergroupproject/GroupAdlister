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



            <div class="col-md-6">
                    <h2>${adInfo.title}</h2>
                    <p>${adInfo.description}</p>

            <c:choose>
                <c:when test="${showEditDeleteButtons}">
                    <a href="/ads/edit?adId=<c:out value="${adInfo.id}"/>">Edit</a>
                    <a href="/ads/delete?adId=<c:out value="${adInfo.id}"/>">Delete</a>
                </c:when>
                <c:otherwise>
                   <p> </p>
                </c:otherwise>
            </c:choose>
            </div>
    </div>


</body>

</html>


