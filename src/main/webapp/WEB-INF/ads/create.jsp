<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body>
    <div class="container">
        <!-- all the categories are places on the DOM as invsible elements -->
        <div id="create-all-categories" style="display: none">
            <c:forEach var="category" items="${categories}">
                <div id="category-${category.id}">${category.value}</div>
            </c:forEach>
        </div>
        <!-- end list of all categories -->
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">

            <div class="form-group">
                <label for="create-title">Title</label>
                <input id="create-title" name="title" class="form-control" type="text">
            </div>

            <div class="form-group">
                <label for="create-description">Description</label>
                <textarea id="create-description" name="description" class="form-control" type="text"></textarea>
            </div>

            <div class="form-group">
                <label for="create-ad-categories">Categories</label>
                <input id="create-ad-categories" name="categories" class="form-control" type="text">
                <div id="create-category-suggestions">
                    <!-- JQuery generates suggestions here -->
                </div>
            </div>

            <div class="form-group">
                <label for="create-price">Price</label>
                <input id="create-price" name="price" class="form-control">
            </div>

            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
</body>
</html>
