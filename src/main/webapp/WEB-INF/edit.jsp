<%--
  Created by IntelliJ IDEA.
  User: leximorgan
  Date: 2/13/19
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit Profile" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Edit your Information</h1>
    <%--to chnge info--%>
    <form  id="edit-profile-form" action="/edit" method="post">
        <div class="form-group">
            <label for="updateUsername">Username</label>
            <input id="updateUsername" name="username" class="form-control" type="text" value=${sessionScope.user.username}>
        </div>
        <div class="form-group">
            <label for="updateEmail">Email</label>
            <input id="updateEmail" name="email" class="form-control" type="text" value=${sessionScope.user.email}>
            <input id= "edit-profile-button" type="submit" value="Save" class="btn btn-primary btn-block">
        </div>
    </form>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
</div>
</body>
</html>
