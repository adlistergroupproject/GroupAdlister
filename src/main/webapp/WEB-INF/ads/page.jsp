<jsp:useBean id="ad" scope="request" type="sun.awt.shell.ShellFolderColumnInfo"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ad</title>
<jsp:include page="/WEB-INF/partials/head.jsp"> </jsp:include>

</head>

<body>

    <h1>Hello! This is the ad information!!!</h1>

    <h1> ${ad.title} </h1>
        <h4> ${ad.description} </h4>



    
</body>
</html>
