<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<header><h1>Result page:</h1></header>
		<section>
			<h2>Status:${msg}</h2>
			<a href="/spring-mvc/films/show-films" class="general-btn">Back to main</a>
		</section>
		<footer>
			<h2>Powered by Spring Framework</h2>
			
		</footer>
	</div>
</body>
</html>