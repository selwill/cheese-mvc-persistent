<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Media List</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
  <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <h2>Media List</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Id</th>
     <th scope="row">Title</th>
     <th scope="row">Category</th>
     <th scope="row">Format</th>
     <th scope="row">Description</th>
     <th scope="row">Update</th>
     <th scope="row">Delete</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${medialist }" var="media" >
     <tr>
      <td>${media.id }</td>
      <td>${media.title }</td>
      <td>${media.category }</td>
      <td>${media.format }</td>
      <td>${media.description }</td>
      <td>
       <spring:url value="/media/updateMedia/${media.id }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button" >Update</a>
      </td>
      <td>
       <spring:url value="/media/deleteMedia/${media.id }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/media/addMedia/" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button" >Add New Media</a>
 </div>
</body>
</html>