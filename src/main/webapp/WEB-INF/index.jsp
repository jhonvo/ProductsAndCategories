<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Products and Categories</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
	</head>
	<body class="bg-secondary bg-opacity-50">
		<div class="container col-md-6 mx-auto bg-white p-5 rounded mt-5">
		
		<p class="  display-6 text-center">Products and Categories</p>
		<div class="d-flex flex-row justify-content-evenly mt-5">
		<a class="btn btn-primary col-4" href="/products/new">Create Product</a>
		<a class="btn btn-info col-4" href="/categories/new">Create Category</a>
		</div>
		<div class="d-flex flex-row justify-content-evenly mt-5">
			<div class="col-6">
			<h6 class="text-center">Products</h6>
			<c:forEach var="prod" items="${products}">
				<p><a href="/products/${prod.id}"><c:out value="${prod.name}"/></a></p>
			</c:forEach>
			</div>
			<div class="col-6">
			<h6 class="text-center">Categories</h6>
			<c:forEach var="cat" items="${categories}">
				<p><a href="/categories/${cat.id}"><c:out value="${cat.name}"/></a></p>
			</c:forEach>
			</div>
		</div>
		</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	</body>
</html>