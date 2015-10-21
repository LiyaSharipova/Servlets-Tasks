<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
<form action="" name="regForm" form method="POST" onsubmit="return formCheck()">
    <p >Email:<br><input type="text" name="email"></p>

    <p>Password:<br><input type="password" name="password"></p>

    <input type="radio" name="gender" value="1">Male</br>
    <input type="radio" name="gender" value="0">Female </br>


    <p><input type="checkbox" name="subscribe" value="on" checked>I want to receive the latest news</p>

    <p>About me <br> <textarea rows="5" cols="25" name="aboutMe" oninput="count(value)" maxlength="50"></textarea></p>

    <p style="font-family: cursive; font-size: small ">Symbols <span id="symbols">0</span>/50</p>

    <p><input type="submit" value="Registrate">

</form>
<script type="text/javascript" src="js/check.js"></script>
</body>
</html>
