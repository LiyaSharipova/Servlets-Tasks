<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Baths
  Date: 15.10.2015
  Time: 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>profile</title>
</head>
<body>
<h2>Hello ${user.getEmail()} </h2>
Email: ${user.getEmail()}<br>
Password: ${user.getPassword()}<br>
Gender:
<c:choose>
  <c:when test="${user.getGender().equals('1')}">
    Male<br>
  </c:when>
  <c:otherwise>
    Female<br>
  </c:otherwise>
</c:choose>
Subscription: ${user.getSubscribe()}<br>
About me: ${user.getAboutMe()}<br>
</body>
</html>
