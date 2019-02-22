<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <link rel="stylesheet" href="WEB-INF/css/landingPage.css">

    <%--<style>--%>
        <%--body{--%>
            <%--!important;background-color: #F0A202;--%>
        <%--}--%>
    <%--</style>--%>

</head>

<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />







    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>

</body>
</html>
