<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Spring Web MVC project</title>
</head>

<body style="background: grey">

	<!-- PAGE TITLE -->
	<div style="float: left; text-align: center">
		<h1>MOVIE SHOP</h1>
		${movieList.get(0).getCategory()}

		<!-- SELECT BOX -->
		<form action="/StoreWithMovies" method="GET">
			<select name="category">
				<option value="ANY"
					<c:if test = "${selectedCategory eq 'ANY'}">selected</c:if>>DOWOLNY</option>
				<option value="COMEDY"
					<c:if test="${selectedCategory eq 'COMEDY'}">selected</c:if>>KOMEDIA
				</option>
				<option value="DRAMA"
					<c:if test = "${selectedCategory eq 'DRAMA'}">selected</c:if>>DRAMAT</option>
				<option value="ACTION"
					<c:if test = "${selectedCategory eq 'ACTION'}">selected</c:if>>AKCJA</option>
				<option value="FAMILY"
					<c:if test = "${selectedCategory eq 'FAMILY'}">selected</c:if>>FAMILIJNY</option>
				<option value="SCI-FI"
					<c:if test = "${selectedCategory eq 'SCI-FI'}">selected</c:if>>SCI-FI</option>

			</select> <input type="submit" value="Szukaj">
		</form>

		<!-- SHOPPING CART -->
		<div style="border: dashed; padding: 10px">
			<h1>Twoj koszyk</h1>
			<ul style="padding: 0px">
				SUMA:
				<br>
				<b><c:out value="${shoppingCart.getPriceOfCartProducts()} PLN" />
					<c:out
						value="${converter.convertPLNtoEUR(shoppingCart.getPriceOfCartProducts())} EUR" /></b>
				<br>
				<br>

				<c:forEach var="movie" items="${shoppingCart.getAllProducts()}">
					<form method="POST" action="/StoreWithMovies/remove">
						<li style="list-style: none; border: solid; padding: 5px;">${movie.getTitle()}
							<br> <input type="hidden" name="movie"
							value="${movie.getId()}" /> ${movie.getPrice()} PLN <input
							type="hidden" name="currentCategory" id="currentCategory"
							value="${movie.getCategory()}" /> <input type="submit" value="-" />
							<input type="hidden" name="page" value="${currentPage}" />

						</li>
					</form>
				</c:forEach>
			</ul>
		</div>
	</div>

	<!-- LIST OF MOVIES -->
	<div style="float: left">
		<ul>
			<c:forEach var="listValue" items="${movieList}">
				<li
					style="background: orange; min-width: 450px; max-width: 450px; list-style: none; padding: 10px; border: solid;"><b>${listValue.getTitle()}</b><br>
					${listValue.getCast()} <br> <form:form method="POST">
						<input type="hidden" name="movie" value="${listValue.getId()}" />
						<input type="hidden" name="currentCategory"
							value="${listValue.getCategory()}" />
						<input type="hidden" name="page" value="${currentPage}" />
						<input type="submit" value="+" />
					</form:form>${listValue.getPrice()}$ <br></li>
				</br>
			</c:forEach>
		</ul>
	</div>

		<div style="float:left;">
			<form:form method="POST" style="float:left;" action="/StoreWithMovies/previousPage">
				<input type="hidden" name="page" value="${currentPage}" />
				<input type="hidden" name="currentCategory"
					value="${movieList.get(0).getCategory()}" />
				<input type="submit" value="<--" style="width: 90px; height: 60px;" />
			</form:form>
			<form:form method="POST" style="float:left;" action="/StoreWithMovies/nextPage">
				<input type="hidden" name="page" value="${currentPage}" />
				<input type="hidden" name="currentCategory"
					value="${movieList.get(0).getCategory()}" />
				<input type="submit" value="-->" style="width: 90px; height: 60px;"/>
			</form:form>

		</div>
	
</body>
</html>