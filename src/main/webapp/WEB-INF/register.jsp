<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="register-username">Username</label>
                <input id="register-username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="register-email">Email</label>
                <input id="register-email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="register-password">Password</label>
                <input id="register-password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="register-confirm-password">Confirm Password</label>
                <input id="register-confirm-password" name="confirm_password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>
