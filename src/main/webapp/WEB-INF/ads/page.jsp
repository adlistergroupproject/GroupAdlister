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
                <a href="/ads/edit?adId=<c:out value="${adInfo.id}"/>">
                    Edit
                </a>
            </div>

        <h5>Page view count is: ${counter}</h5>
    </div>
</body>
</html>


