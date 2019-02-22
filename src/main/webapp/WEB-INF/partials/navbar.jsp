<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">

    <div class="container-fluid">

        <!-- Brand and toggle get grouped for better mobile display -->

        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">HOME</a>
        </div>

        <form class="form-inline navbar-left mt-2" method="get" action="/search">
            <input class="form-control mr-sm-2" type="text" name="query" placeholder="Search">
        </form>

        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${!empty sessionScope.user}">
                    <li><a class="nav-item" href="/ads/create">Create Ad</a></li>
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->


</nav>

<%--<li><a href="/login">Login</a></li>--%>
<%--<li><a href="/register">Register</a></li>--%>

<%--<li><a href="/profile">Profile</a></li>--%>
<%--<li><a href="/logout">Logout</a></li>--%>
