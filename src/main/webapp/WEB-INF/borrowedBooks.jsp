<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/7/22
  Time: 12:07 PM
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

<html>
<head>
    <title>Book Broker</title>
</head>
<body>
  <h1>Hello, <c:out value="${user.name}" /> </h1>
  <h4>Your Borrowed Books</h4>
  <a href="/logout" class="btn btn-danger books-btn">Logout</a>
  <a href="/books/new" class="btn btn-primary books-btn">Add a book to my shelf</a>

  <table class="table mt-5">
      <thead>
      <tr>
          <th scope="col">Id</th>
          <th scope="col">Title</th>
          <th scope="col">Author Name</th>
          <th scope="col">Owner</th>
      </tr>
      </thead>
      <tbody>
      <!-- loop over all the ninjas to show the details as in the wireframe! -->
      <jsp:useBean id="borrowedBooks" scope="request" type="java.util.List"/>
      <c:forEach items="${borrowedBooks}" var="borrowedBook">
          <tr>
              <td><c:out value="${borrowedBook.id}"/></td>
              <td><a href="/books/${borrowedBook.id}"><c:out value="${borrowedBook.title}" /></a></td>
              <td><c:out value="${borrowedBook.authorName}" /></td>
              <td><c:out value="${borrowedBook.owner.name}" /></td>
          </tr>
      </c:forEach>
      </tbody>
  </table>
  <a href="/books" class="btn btn-primary">Back to Bookshelves</a>
</body>
</html>
