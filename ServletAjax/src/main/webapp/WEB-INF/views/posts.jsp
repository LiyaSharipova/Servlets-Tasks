<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Baths
  Date: 10.11.2015
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#exitButton').on('click', function() {
                location.href = '<c:url value="/logout"/>';
            });
            $('#profileButton').on('click', function() {
                location.href = '<c:url value="/profile"/>';
            });
            $('#myButton').click(function (e) {
                e.preventDefault();
                var textForPost = $('textarea').val();
                if (!textForPost) {
                    alert("Write down at least one symbol");
                    return false;
                }
                $.post("<c:url value="/posts"/>", {"post": textForPost}, function (response) {
                            $('#myButton').text("send").attr("disabled", false);
                            $('textarea#text').val('');
                            $('#postPlace').append(
                                    "<div style='float: left; margin: 20px' >" +
                                    "<p>" + response.userName + "</p>" +
                                    "<p>" + response.postText + "</p>" +

                                    "Published time : " +
                                    "<p>" + response.pTime + "</p>" +
                                    "</div>"
                            )

                        },
                        'json'
                ).fail(function () {
                            alert("Sorry, can't send a post. Try again!");
                        })
            });
        });
    </script>

    <title>posts</title>


</head>
<body>
<div id="postPlace">
    <c:forEach items="${posts}" var="p">
        <div style='float: left; margin: 20px'>
            <c:out value="${p.getUserName()}"/>


            <p><c:out value="${p.getText()}"/></p>


            <p>Published time :<br> <c:out value="${p.getPublishedTime()}"/></p>

        </div>
    </c:forEach>

</div>
<textarea rows="5" cols="25" id="text" placeholder="Введите текст "></textarea>
<button id="myButton">Send</button>
<button id="profileButton" class="float-left submit-button">Profile</button>
<button id="exitButton" class="float-left submit-button">Log out</button>
</body>
</html>
