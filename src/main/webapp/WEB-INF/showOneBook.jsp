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
  <title>Book CLub</title>
</head>
<body>
<h1>${book.title}</h1>
<a href="/books" class="btn btn-primary">Back to Bookshelves</a>
<div>
  <c:choose>
    <c:when test="${book.owner.getId() == book.owner.getId()}">
      <span style="color:hotpink">You</span> read <span style="color:mediumpurple">${book.title}</span> by <span style="color:yellowgreen">${book.authorName}</span>
      Here are your thoughts:
    </c:when>
    <c:when test="${book.owner.getId() != book.owner.getId()}">
      <span style="color:hotpink">${book.owner.name}</span> read <span style="color:mediumpurple">${book.title}</span> by <span style="color:yellowgreen">${book.authorName}</span>
    </c:when>
  </c:choose>
  <div class="card review-card">
    ${book.review}
  </div>
  <c:if test="${user.getId() == book.owner.getId()}">
    <a href="/books/edit/${book.id}" class="btn btn-warning">Edit</a>
    <a href="/books/delete/${book.id}" class="btn btn-danger">Delete</
  </c:if>
</div>
</body>
</html>

