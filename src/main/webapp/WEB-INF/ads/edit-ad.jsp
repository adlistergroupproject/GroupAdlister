<%--
  Created by IntelliJ IDEA.
  User: leximorgan
  Date: 2/18/19
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Edit Ad" />
    </jsp:include>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="adId"/>
        <jsp:param name="adTitle" value="ad.title"/>
        <jsp:param name="adDescription" value="ad.description"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<body>
<div class="container">
    <h1>Edit Your Ad</h1>
    <form action="/edit-ad" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value=${adInfo.title}>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text" value=${adInfo.description}></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</body>
</html>
