<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">

        <a class="navbar-brand" href="/ads"><i class="fas fa-dog"></i></a>

        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

            <c:choose>

                <c:when test="${!empty sessionScope.user}">

            <li class="nav-item"><a class="nav-link" href="/ads/create">Create Ad</a></li>

            <li class="nav-item"><a class="nav-link" href="/profile">Profile</a></li>

            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>

                </c:when>

                <c:otherwise>

            <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>

            <li class="nav-item"><a class="nav-link" href="/register">Register</a></li>

                </c:otherwise>

            </c:choose>
        </ul>

        <form class="form-inline my-2 my-lg-0" method="get" action="/search">
            <input class="form-control mr-sm-2" type="text" name="query" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fas fa-search"></i></button>
        </form>
    </div>
</nav>

<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark">--%>
    <%--<a class="navbar-brand" href="/ads">Home</a>--%>
    <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"--%>
            <%--aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--<span class="navbar-toggler-icon"></span>--%>
    <%--</button>--%>

    <%--<div class="collapse navbar-collapse" id="navbarSupportedContent">--%>


        <%--<form class="form-inline my-2 my-lg-0" method="get" action="/search">--%>
            <%--<input class="form-control mr-sm-2" type="text" name="query" placeholder="Search" aria-label="Search">--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
        <%--</form>--%>

        <%--<ul class="navbar-nav mr-auto">--%>
            <%--<c:choose>--%>
                <%--<c:when test="${!empty sessionScope.user}">--%>
                    <%--<li class="nav-item"><a href="/ads/create">Create Ad</a></li>--%>
                    <%--<li class="nav-item"><a href="/profile">Profile</a></li>--%>
                    <%--<li class="nav-item"><a href="/logout">Logout</a></li>--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<li class="nav-item"><a href="/login">Login</a></li>--%>
                    <%--<li class="nav-item"><a href="/register">Register</a></li>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        <%--</ul>--%>
    <%--</div>--%>
<%--</nav>--%>
