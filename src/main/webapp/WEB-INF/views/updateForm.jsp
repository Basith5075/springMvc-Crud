<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Update the product details</h1>

				<form action="${pageContext.request.contextPath }/handle-product" method="post">
					<div class="form=group">
						<label for="name">Product ID </label> <input type="text"
							class="form-control" id="name" name="id"
							value="${product.id }" disabled="disabled">
					</div>

					<div class="form=group">
						<label for="name">Product Name </label> <input type="text"
							class="form-control" id="name" name="name"
							value="${product.name }">
					</div>
					<div class="form=group">
						<label for="name">Product Description </label> <input type="text"
							class="form-control" id="description" name="description"
							value="${product.description }">
					</div>

					<div class="form=group">
						<label for="name">Product Price </label> <input type="text"
							class="form-control" id="price" name="price"
							value="${product.price }">
					</div>
					<div class="container text-center mt-3">

						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger"> Back</a>

						<button type="submit" class="btn btn-primary">Update</button>
					</div>

				</form>

			</div>
		</div>

	</div>


</body>
</html>