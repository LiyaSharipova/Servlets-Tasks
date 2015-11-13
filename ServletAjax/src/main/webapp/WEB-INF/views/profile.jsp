<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet'
          type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
          rel='stylesheet' type='text/css'>
    <title>profile</title>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header ">
            <a class="navbar-brand" href="<c:url value="/welcome"/>">MYPROJECT</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/welcome"/>">Home</a></li>
                <li class="active"><a href="<c:url value="/profile"/>">Profile</a></li>
                <li><a href="<c:url value="/posts"/>">Posts</a></li>

                <form id="exit" action="<c:url value="/logout"/>" method="post" style="display:none;">
                </form>
                <li>
                    <a onclick='document.getElementById("exit").submit();'>Exit</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <img src="/images/ein4.jpg" class="img-circle"   width="304" height="236">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

            <div rows="4" class="post-preview">
                <h2 class="post-subtitle">Hello ${user.getEmail()} </h2>

                <p class="post-meta">Email: ${user.getEmail()}<br></p>

                <p class="post-meta">Gender:
                    <c:choose>
                        <c:when test="${user.getGender().equals('1')}">
                            Male</br>
                        </c:when>
                        <c:otherwise>
                            Female</br>
                        </c:otherwise>
                    </c:choose>
                </p>

                <p class="post-meta">Subscription: ${user.getSubscribe()}</p>

                <p class="post-meta">About me: ${user.getAboutMe()}</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
