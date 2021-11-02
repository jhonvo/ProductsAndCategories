<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Category</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body class="bg-secondary bg-opacity-50">
		<div class="container col-md-6  mx-auto bg-white p-5 rounded mt-5">
		<p class="  display-6">Create new category</p>
		<form:form class="mt-4" action="/categories/new" method="POST" modelAttribute="category">
			<div class="form-group  col-6">
				<form:label class="col-2 form-label" path="name">Name</form:label>
				<form:input class="col-4 form-control" path="name"/>
				<form:errors class="text-secondary" path="name"/>
			</div>
			
			<button  class="btn btn-info col-auto mt-4 px-3" type="submit">Add Category</button>
		</form:form>
		<p class="mt-3"><a href="/" >Home</a></p>
		 </div>
		 
		 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		 
	</body>
</html>