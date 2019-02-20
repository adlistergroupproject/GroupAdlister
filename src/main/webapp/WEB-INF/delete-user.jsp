<%--
  Created by IntelliJ IDEA.
  User: leximorgan
  Date: 2/19/19
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Account</title>
</head>
<body>

    <form action="/profile/delete" method="POST">
        <input type="hidden" value="${user.id}" name="adId">
        <h1>Are you sure you want to delete your account?</h1>
        <h3>This cannot be undone. </h3>
        <button name="id" value="${user.id}" class="btn btn-danger">Delete Account</button>
    </form>

</body>
</html>
