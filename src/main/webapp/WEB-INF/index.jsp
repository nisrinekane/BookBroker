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
  <title>Login and Registration</title>
</head>
<body>
<h1>Book Broker</h1>
<h4>A place for friends to share thoughts on books</h4>
<div class="flexed">
  <div class="register">
    <h2>Register</h2>
    <form:form action="/register" method="POST" modelAttribute="newUser" class="form-horizontal">
      <div class="form-group">
        <form:label path="name">name</form:label>
        <form:input path="name" />
        <div>
          <form:errors path="name" class="text-danger"/>
        </div>
      </div>
      <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input path="email" />
        <div>
          <form:errors path="email" class="text-danger"/>
        </div>
      </div>
      <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:input type="password" path="password" />
        <div>
          <form:errors path="password" class="text-danger"/>
        </div>
      </div>
      <div class="form-group">
        <form:label path="confirm">Confirm Password</form:label>
        <form:input type="password" path="confirm" />
        <div>
          <form:errors path="confirm" class="text-danger" />
        </div>
      </div>
      <input type="submit" value="Submit" class="btn btn-dark btn-block" />
    </form:form>
  </div>
  <div class="login">
    <h2>Login</h2>
    <form:form action="/login" method="POST" modelAttribute="newLogin">
      <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input path="email"  />
        <div>
          <form:errors path="email" class="text-danger"/>
        </div>
      </div>
      <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:input type="password" path="password" />
        <div>
          <form:errors path="password" class="text-danger"/>
        </div>
      </div>
      <input type="submit" value="Submit" class="btn btn-dark btn-block" />
    </form:form>
  </div>
</div>
</body>
</html>
