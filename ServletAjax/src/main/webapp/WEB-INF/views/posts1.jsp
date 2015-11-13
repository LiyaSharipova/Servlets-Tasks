<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Baths
  Date: 12.11.2015
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Blog</title>

  <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/clean-blog.min.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

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
        <li><a href="<c:url value="/login"/>">Log in</a></li>
        <li class="active"><a href="<c:url value="/posts"/>">Posts</a></li>
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
      <c:forEach items="${posts}" var="p">
        <div class="post-preview">
          <h3 class="post-subtitle">
            ${p.getText()}
          </h3>
          <p class="post-meta">Posted by <b>${p.getUserName()}</b> on ${p.getPublishedTime()}</p>
        </div>
        <hr>
      </c:forEach>
      <p><a href="/login" class="alert-success">To add post please log in</a> </p>
    </div>

  </div>
</div>

</body>
</html>
