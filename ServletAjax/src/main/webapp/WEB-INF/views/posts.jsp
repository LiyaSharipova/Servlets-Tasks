<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <title>Blog</title>

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
    <script>
        $(document).ready(function () {
            $('#exitButton').on('click', function () {
                location.href = '<c:url value="/logout"/>';
            });
            $('#profileButton').on('click', function () {
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
                                    "<div class=\"post-preview\">"+
                                        "<h3 class=\"post-subtitle\">"+
                                         response.postText+
                                        "</h3>"+
                                        "<p class=\"post-meta\">Posted by <b>"+response.userName+"</b> on"+response.pTime+"</p>"+
                                    "</div>"+
                                    "<hr>"
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
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header ">
            <a class="navbar-brand" href="<c:url value="/welcome"/>">MYPROJECT</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/welcome"/>">Home</a></li>
                <li><a href="<c:url value="/profile"/>">Profile</a></li>
                <li class="active"><a href="<c:url value="/posts"/>">Posts</a></li>

                <form id="exit" action="<c:url value="/logout"/>" method="post" style="display:none;">
                </form>
                <li>
                    <a onclick='document.getElementById("exit").submit();'>Exit</a>
                </li>

            </ul>
        </div>
    </div>
</nav>


<header class="intro-header" style="background-image: url('/images/home-bg.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>Great Blog</h1>
                    <hr class="small">
                    <span class="subheading">See other peoples thoughts</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">

        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div id="postPlace">
                <c:forEach items="${posts}" var="p">
                    <div class="post-preview">
                        <h3 class="post-subtitle">
                                ${p.getText()}
                        </h3>

                        <p class="post-meta">Posted by <b>${p.getUserName()}</b> on ${p.getPublishedTime()}</p>
                    </div>
                    <hr>
                </c:forEach>
                </div>
                <div >
                    <textarea rows="5" class="form-control" id="textPost" placeholder="Add your post "></textarea>
                </div>
                <button id="myButton" type="submit" class="btn btn-default">Send</button>

            </div>

        </div>


</div>
</body>
</html>
