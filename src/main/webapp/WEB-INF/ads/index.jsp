<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <div class="container">
            <div>
                <h1>Here are all the Ads</h1>
                <c:forEach var="ad" items="${ads}">
                    <div>
                      <div class="row">
                                <div class="col-sm-5">
                                    <div class="card m-3">
                                        <div class="card-body">
                                              <a href="/ads/show?adId=<c:out value="${ad.id}"/>">
                                                <div class="col-sm-6">
                                                    <h2 class="card-title">${ad.title}</h2>
                                                    <p class="card-text">${ad.description}</p>
                                                </div>
                                             </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                 </c:forEach>
            </div>
        </div>

</body>
</html>

