<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HOME PAGE</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container">
    <h3>
        Welcome,
        <security:authorize access="isAnonymous()">
            Guest
            <span class="floatRight"><a href="<c:url value="/login" />">Login</a></span>
        </security:authorize>
        <!-- Print the logged in user name -->
        <security:authorize access="isAuthenticated()">
            <security:authentication property="principal.username" />
            <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
        </security:authorize>
    </h3>

</div>

</body>
</html>
