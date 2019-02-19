<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Change Password" />
    </jsp:include>
</head>
<body>
<%--to change the password--%>
<div class="container">
<form action="/change-password" method="post">
    <h2>Change Password</h2>
    <p>${invalidPassword}</p>
    <div class="form-group">
        <label for="password">Current password:</label>
        <input id="password" name="password" class="form-control" type="password">
    </div>
    <p>${newPasswordDoesntMatch}</p>
    <p>${passwordsMatch}</p>
    <div class="form-group">
        <label for="new_password">New Password:</label>
        <input id="new_password" name="new_password" class="form-control" type="password">
    </div>
    <div class="form-group">
        <label for="confirm_password">Confirm New Password:</label>
        <input id="confirm_password" name="confirm_password" class="form-control" type="password">
    </div>
    <input type="submit" value="Save" class="btn btn-primary btn-block">
</form>
</div>
</body>
</html>