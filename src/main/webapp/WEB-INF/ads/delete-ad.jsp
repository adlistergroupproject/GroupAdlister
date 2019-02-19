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


    <h1>Are you sure you want to delete this ad?</h1>
    <div class="col-md-6">
        <form action="/ads/delete" method="POST">
        <input type="hidden" value="${adInfo.id}" name="adId">
        <h2>${adInfo.title}</h2>
     <%--will need to ad the price in here once its in the db:--%>
        <h5>$ Price will go here</h5>
        <p>${adInfo.description}</p>
        <button name="id" value="${adInfo.id}" class="btn btn-danger">Delete</button>
        </form>
    </div>
</div>


</body>

</html>