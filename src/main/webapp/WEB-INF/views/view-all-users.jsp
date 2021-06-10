<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View all users</title>
        <style type="text/css">
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
        
        </style>
    </head>
    <body>
    <div class="flex-box">
    	<header>
    		<h1>Users. Status:<c:out value="${msg}"/></h1><br>
    	</header>
    	<section>
    		<table>
        		<tr>
        			<th>User Id</th>
        			<th>User Name</th>
        			<th>User LastName</th>
        			<th>User age</th>
        			<th>User gender</th>
        		</tr>
        		<c:forEach var="user" items="${users}">
        		<tr>
        			<td>${user.id}</td>
        			<td>${user.name}</td>
        			<td>${user.lastName}</td>
        			<td>${user.age}</td>
        			<td>${user.gender}</td>
        			<td><a href="/spring-mvc-danger/users/removeUser?id=${user.id}" class="button">Remove</a></td>
        			<td><a href="/spring-mvc-danger/users/getUser?id=${user.id}" class="button">Focus</a></td>
        			<td><a href="/spring-mvc-danger/users/updateUser?id=${user.id}" class="button">Update</a></td>
        		</tr>
        		</c:forEach>
        	</table>
        	<footer><h3>Powered by Spring</h3></footer>
    	</section>
    </div>  
    </body>
</html>