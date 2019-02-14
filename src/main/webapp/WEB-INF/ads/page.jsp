<%--@elvariable id="ad" type="org.w3c.dom.html.HTMLDocument"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<jsp:include page="/WEB-INF/partials/head.jsp">

<jsp:param name="title" value="adId"> </jsp:param>

</jsp:include>


</head>

<body>

    <h1>Hello! This is the ad information!!!</h1>

    <h1>${ad.title}</h1>



    
</body>
</html>
