<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <title>thenewboston</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
<div class="container-fluid">
    <button type="button" onclick="loadXMLDoc()">
        Get secret info from Server
    </button>
    <p>Secret info is:

    <div id="myDiv"></div>
    </p>
    <div class="embed-responsive embed-responsive-16by9">
        <iframe class="embed-responsive-item" src="http://www.youtube.com/embed/ClHu3XQBnGU&list=PL6gx4Cwl9DGBPw1sFodruZUPheWVKchlM&index=4"
    </div>
    <%--<div class="row">--%>
        <%--<div class="col-md-8" style="background-color: #34bc85">left</div>--%>
        <%--<div class="col-md-2" style="background-color: aliceblue">mid</div>--%>
        <%--<div class="col-md-2" style="background-color: aqua">right</div>--%>
    <%--</div>--%>
</div>
</body>
</html>
