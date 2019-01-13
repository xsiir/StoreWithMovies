<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Spring Web MVC project</title>
</head>

<body style="background:grey">

    <h1>MOVIE SHOP</h1>
    <form action="/StoreWithMovies" method="GET">
<select name="category">
  <option value="COMEDY" <c:if test = "${selectedCategory} == 'COMEDY'">selected</c:if>>COMEDY</option>
  <option value="DRAMA" <c:if test = "${selectedCategory} == 'DRAMA'">selected</c:if>>DRAMA</option>
  <option value="ACTION"  <c:if test = "${selectedCategory} == 'ACTION'">selected</c:if>>ACTION</option>
  <option value="FAMILY" <c:if test = "${selectedCategory} == 'FAMILY'">selected</c:if>>FAMILY</option>
    <option value="SCI-FI" <c:if test = "${selectedCategory} == 'SCI-FUN'">selected</c:if>>SCI-FI</option>
  
</select>
<input type="submit" value="Submit">
</form>

    <ul>
    <c:forEach var="listValue" items="${movieList}">
    	<div style="background:orange; max-width: 500px">
        <li>${listValue.getTitle()}</li>
        ${listValue.getCast()} <br>
        <form:form action="/StoreWithMovies/sz" method="POST"><input type="hidden" name="movie" value="${listValue.getId()}"/><input type="submit"  value="+"/></form:form>${listValue.getPrice()} $ <br>
        </div>
        </br>
    </c:forEach>
</ul>

<form action="/StoreWithMovies/movies" method="POST" modelAttribute="list">

</form>
</body>
</html>