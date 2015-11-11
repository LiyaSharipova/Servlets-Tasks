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
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $( document ).ready(function() {
            $('#exitButton').on('click', function() {
                location.href = '<c:url value="/logout"/>';
            });
            $('#postButton').on('click', function() {
                location.href = '<c:url value="/posts"/>';
            });
        });
    </script>
</head>
<body>
<h2>Hello ${user.getEmail()} </h2>
<p>Email: ${user.getEmail()}<br></p>
<p>Gender:
<c:choose>
    <c:when test="${user.getGender().equals('1')}">
        Male</br>
    </c:when>
    <c:otherwise>
        Female</br>
    </c:otherwise>
</c:choose>
    </p>
<p>Subscription: ${user.getSubscribe()}</p>
<p>About me: ${user.getAboutMe()}</p>
<button id="exitButton" class="float-left submit-button">Log out</button>
<button id="postButton" class="float-left submit-button">Posts</button>

</body>
</html>
