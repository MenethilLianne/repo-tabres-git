<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        .flex-box {
        	display:flex;
        	flex-direction: column;
        	justify-content: center;
        	align-items:center;
        }
        
        table, th, td {
        	border: 1px solid black;
        }
        
        a {
        	text-decoration: none;
        	color:black;
        }
        
        a:hover {
        	color:white;
    
        }
        .button:hover {
        	background:red;
        }
        
        .button-big {
        	padding: 10px;
        	border: 1px solid black;
        }
        
        .button-big:hover {
        	background:red;
        }
        </style>
</head>
<body>
	<header>
		<h1>Get user by id</h1>
	</header>
	<section>
		<h2>${user}</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Last NAme</th>
				<th>Age</th>
				<th>Gender</th>
			</tr>
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.lastName}</td>
				<td>${user.age}</td>
				<td>${user.gender}</td>
				<td><a href="/spring-mvc/users/removeUser?id=${user.id}" class="button">Remove</a></td>
        		<td><a href="/spring-mvc/users/updateUser?id=${user.id}" class="button">Update</a></td>
			</tr>
			
		</table>
	</section>
	
</body>
</html>