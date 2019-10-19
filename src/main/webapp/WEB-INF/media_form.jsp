<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Employees</title>
 <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
  <spring:url value="/media/save" var="saveURL" />
  <h2>Media</h2>
  <form:form modelAttribute="mediaForm" method="post" action="${saveURL }" cssClass="form">
   <form:hidden path="mediaId"/>
   <div class="form-group">
    <label for="title">Title</label>
    <form:input path="title" cssClass="form-control" id="title" />
   </div>
   <div class="form-group">
    <label for="category">Category</label>
    <form:input path="category" cssClass="form-control" id="category" />
   </div>
   <div class="form-group">
    <label for="format">Email</lable>
    <form:input path="format" cssClass="form-control" id="format" />
   </div>
   <div class="form-group">
    <label for="description">Phone</label>
    <form:input path="description" cssClass="form-control" id="description" />
   </div>
   <button type="submit" class="btn btn-primary">Save</button>
  </form:form>
 </div>
</body>
</html>