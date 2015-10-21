<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <script>
        function formCheck() {

            var email = document.getElementById("email");
            var reg = /^((?:\w+(?:\-|\.)?)+)@((?:\w{2,}\.)+\w{2,6})$/;
            if (!reg.test(email)) {
                alert("Invalid Email")
            }

            var pass = document.getElementById("pass");
            if (pass.length < 6) {
                alert("Password is too short");
            }

            document.getElementById('symbols').innerHTML = s.length;
            var radio = document.getElementsByName("gender");
            if (!radio[0].checked && !radio[1].checked) {
                alert("Choose gender")
            }
        }
    </script>
</head>
<body>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
<form action="" form method="POST" onsubmit="formCheck()">
    <p id="email">Email:<br><input type="text" name="email"></p>

    <p id="pass">Password:<br><input type="password" name="password"></p>

    <input type="radio" name="gender" value="1">Male</br>
    <input type="radio" name="gender" value="0">Female </br>


    <p><input type="checkbox" name="subscribe" value="on" checked>I want to receive the latest news</p>

    <p>About me <br> <textarea rows="5" cols="25" name="aboutMe" oninput="count(value)" maxlength="50"></textarea></p>

    <p style="font-family: cursive; font-size: small ">Symbols <span id="symbols">0</span>/50</p>

    <p><input type="submit" value="Registrate">

</form>
</body>
</html>
