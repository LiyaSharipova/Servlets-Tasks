<%--
  Created by IntelliJ IDEA.
  User: Baths
  Date: 05.11.2015
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function loadXMLDoc() {
            var xmlhttp;
            if (window.XMLHttpRequest) {
//for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
                console.log("chrome");
            } else {
// for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlhttp.onreadystatechange = function () {
                console.log(xmlhttp.readyState);
                console.log(xmlhttp.status);
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    console.log(document.getElementById("myDiv"));
                    console.log(xmlhttp.responseText);
                    document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET", "/ajaxtestXml", true); // открывается соединение
            xmlhttp.send(""); // посылает запрос
        }
    </script>
</head>
<body>
<button type="button" onclick="loadXMLDoc()">
    Get secret info from Server
</button>
<p>Secret info is:

<div id="myDiv"></div>
</p>
</body>
</html>
