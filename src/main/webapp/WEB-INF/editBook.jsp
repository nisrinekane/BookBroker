<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/7/22
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/styles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<html>
<head>
  <title>Book Club</title>
</head>
<body>
<h1>Change your Entry</h1>
<a href="/books" class="btn btn-primary">Back to Bookshelves</a>
<form:form action="/books/${book.id}" method="post" modelAttribute="book" class="form">
  <input type="hidden" name="_method" value="put">
  <form:label path="title">Book Title</form:label>
  <form:input path="title" />
  <div>
    <form:errors path="title" class="text-danger"/>
  </div>
  <div class="form-group">
    <form:label path="authorName">Author Name</form:label>
    <form:input path="authorName" />
    <div>
      <form:errors path="authorName" class="text-danger"/>
    </div>
  </div>
  <div class="form-group">
    <form:label path="review">Your Thoughts</form:label>
    <form:input type="textarea" path="review" />
    <div>
      <form:errors path="review" class="text-danger"/>
    </div>
  </div>
  <input type="submit" value="Submit" class="btn btn-dark" />
</form:form>
</body>
</html>


