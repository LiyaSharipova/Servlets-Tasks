<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Baths
  Date: 15.10.2015
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users</title>
    <style>body {
        background-color: #7babac;
    }

    .block {
        text-align: center;
        border: solid 2px #34bc85;
        padding: 15px;
        height: 150px;
        width: 300px;
        background: gainsboro;
        font-family: sans-serif;
        font-weight: 200;
        font-size: 20px;
        color: #ec8f01;
        margin: 20px;
        float: left
    }
    </style>
</head>
<body>

<c:forEach items="${users}" var="user">
    <div class="block">

            ${user.getEmail()}<br>
            ${user.getPassword()}<br>
        <c:choose>
            <c:when test="${user.getGender().equals('1')}">
                Male<br>
            </c:when>
            <c:otherwise>
                Female<br>
            </c:otherwise>
        </c:choose>
        Subscription  ${user.getSubscribe()}<br>
    </div>
</c:forEach>
</body>
</html>

