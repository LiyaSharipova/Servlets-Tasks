<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.kpfu.itis.sharipova.repositories.DataRepository" %>
<%--
  Created by IntelliJ IDEA.
  User: Baths
  Date: 14.10.2015
  Time: 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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

<c:forEach items="${List}" var="list">
    <div class="block">
        <c:forEach items="${list}" var="entry">
            <c:choose>
                <c:when test="${entry=='1'}">
                    Male<br>
                </c:when>
                <c:when test="${entry=='0'}">
                    Female<br>
                </c:when>
                <c:when test="${entry=='on'||entry=='off'}">
                Subscription ${entry}<br>
                </c:when>
                <c:otherwise>
                    ${entry}<br>
                </c:otherwise>
            </c:choose>


        </c:forEach>
    </div>
</c:forEach>

</body>
</html>


