<%@include file="/WEB-INF/views/base.jsp"%>


<html>
<body>

	<div class="container">

		<div class="row">

			<div class="col-md-12">

				<h1 class="text-center mb-3 mt-2">Welcome to Product App</h1>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">S No</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Product Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products }" var="prod">
							<tr>
								<th scope="row">${prod.id }</th>
								<td>${prod.name}</td>
								<td>${prod.description }</td>
								<td>${prod.price }</td>
								<td><a href="deletePost/${prod.id }" class="btn btn-primary">Delete</a>
									<a href="updatePost/${prod.id }" class="btn btn-primary">Update</a>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center">
					<a href="addproduct" class="btn btn-outline-primary">Add
						Product</a>
				</div>

			</div>

		</div>

	</div>

</body>
</html>
