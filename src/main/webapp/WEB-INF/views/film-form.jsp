<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Film form</title>
<style>
.flex-box {
	display: flex;
	flex-flow: column;
	justify-content: space-between;
	align-items: center;
	background:gray;
	height:100vh;
	color:white;
}


input {
	height:40px;
	width: 350px;
	margin-top:10px;
	font-size:15px;
	margin-bottom:15px;
}

.submit-btn {
	color:white;
	width:70px;
	background:darkgray;
}

.submit-btn:hover {
	background:#778899;
	border-radius:3px;
}

a.general-btn {
	text-decoration:none;
	color:white;
	border: 1px solid white;
	padding: 8px;
}

.general-btn:hover {
	background:#778899;
}

header {
	display:inline-block;
	margin-top:50px;
}

footer {
	display:inline-block;
	margin-bottom:50px;
}

</style>
</head>
<body>
	<div class = "flex-box">
		<header><h1>Fill The Form:</h1></header>
		<section>
			<form:form method="post" modelAttribute="film" action="/spring-mvc/films/save-film/">
				<form:input path="name" name="film-name" type="text" placeholder="Enter film name"/><br>
				<form:input path="genre" name="film-genre" type="text" placeholder="Enter film genre"/><br>
				<form:input path="year" name="film-year" type="text" placeholder="Enter film year"/><br>
				<input type="submit" value = "Submit" class = "submit-btn">
			</form:form>
		</section>
		<footer>
			<h2>Powered by Spring Framework</h2>
			<a href="/spring-mvc/films/show-films" class="general-btn">Back to main</a>
		</footer>
	</div>
</body>
</html>