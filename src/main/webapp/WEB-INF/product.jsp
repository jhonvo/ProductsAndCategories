<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><c:out value="${product.name}"/> Details</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body class="bg-secondary bg-opacity-50">
		<div class="container bg-white p-5 rounded mt-5">
			<p class="  display-6"><c:out value="${product.name}"/></p>
			<div class="d-flex flex-row flex-wrap">
				<div class="col-md-6">
					<h4>Categories:</h4>
					<ul>
					<c:forEach var="cat" items="${current}">
						<li><c:out value="${cat.name}"/></li>
					</c:forEach>
					</ul>
				</div>
				<div class="col-md-6">
					<h4>Add Category:</h4>
					<form action="/products/${product.id}" method="POST">
					<input type="hidden" name="_method" value="put">
						<p>
							<select class="col-4 form-select" name="id" id="id">
								<c:forEach var="select" items="${available}">
									<option value="${select.id}"><c:out value="${select.name}"/></option>
								</c:forEach>
							</select>
							
						</p>
						<button class="btn btn-primary col-auto mt-4 px-3" type="submit">Add Category</button>
					</form>
				</div>
	
			</div>
			
			<p class="mt-3"><a href="/" >Home</a></p>
		 </div>
		 
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		 
	</body>
</html>