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
    <form action="/edit" method="post">
        <div class="form-group">
            <label for="updateUsername">Username</label>
            <input id="updateUsername" name="username" class="form-control" type="text" value=${sessionScope.user.username}>
        </div>
        <div class="form-group">
            <label for="updateEmail">Email</label>
            <input id="updateEmail" name="email" class="form-control" type="text" value=${sessionScope.user.email}>
        </div>
        <h2>Change Password</h2>
        <h4>Current password:</h4>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="username" class="form-control" type="password">
        </div>
        <h4>New Password:</h4>
        <div class="form-group">
            <label for="newPassword">Password</label>
            <input id="newPassword" name="username" class="form-control" type="password">
        </div>
        <h4>Confirm New Password:</h4>
        <div class="form-group">
            <label for="confirmNewPassword">Password</label>
            <input id="confirmNewPassword" name="username" class="form-control" type="password">
        </div>
        <input type="submit" value="Save" class="btn btn-primary btn-block">
    </form>
</div>
</body>
</html>
