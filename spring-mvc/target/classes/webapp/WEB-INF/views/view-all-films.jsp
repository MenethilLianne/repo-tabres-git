<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All films</title>

<style type="text/css">
.flex-box {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	background:gray;
	height:100vh;
	color:white;
}

table {
	border-spacing: 10px 20px;
	text-align: center;
	border-collapse: collapse;
	border: 3px solid white;
	width:600px;
}

table.table-nav {
	border-spacing: 10px 20px;
	text-align: center;
	border-collapse: collapse;
	border: 1px solid gray;
	width:600px;
}


tr {
	text-align: center;
	border-collapse: collapse;
	border: 2px solid white;
	height: 30px;
}

tr.table-nav {
	text-align: center;
	border-collapse: collapse;
	border: 1px solid gray;
	height: 30px;
}

td {
	text-align: center;
	border-collapse: collapse;
	border: 2px solid white;
	height: 30px;
}

td.table-nav {
	text-align: center;
	border-collapse: collapse;
	border: 1px solid gray;
	height: 30px;
}

a {
	text-decoration: none;
}


a.button {
	text-decoration:none;
	color:white;
	border: 1px solid white;
	padding: 8px;	
}
.button:hover {
	background:#778899;
}

#pagination {
	display: flex;
	justify-content: center;
	align-items: center;
	list-style-type: none;
	color:white;
}

#pagination li {
	margin-right: 5px;
	padding: 10px;
	border: 1px solid white;
}

#pagination li:hover, #pagination li.active {
	cursor: pointer;
	color: black;
	border: 1px solid black;
}

footer {
	margin-top:60px;
}

.simple-button {
	color:white;
	
}
.simple-button:hover{
	background: darkblue;
	
}
</style>


</head>
<body>
	<div class="flex-box">
		<header>
			<table class="table-nav">
				<tr class="table-nav">
					<td class="table-nav"><h1>View All Films</h1></td>
					<td class="table-nav"><a href="/spring-mvc/films/show-film-form" class="button">Add film</a></td>
				</tr>
			</table>
			
		</header>
		<section>
			<table id = "table"></table>
		</section>
		<footer>
			<ul id= "pagination"></ul>
			<h2>Powered by Spring Framework</h2>
		</footer>
	</div>
	<script type="text/javascript">
	films = [${jsonCode}]

	let table = document.querySelector('#table');
	
	let pagination = document.querySelector('#pagination');

	let notesOnPage = 4;

	let countOfItems = Math.ceil(films.length / notesOnPage);

	let showPage = ( function() {
		let active;
		return function(item) {
			if (active) {
				active.classList.remove('active');
			}
			active = item;
			item.classList.add('active');
			let pageNum = +item.innerHTML;
			
			let start = (pageNum - 1) * notesOnPage;
			let end = start + notesOnPage;
			
			let notes = films.slice(start, end);
			
			table.innerHTML = '';
			/* draw table headers row*/
			let tr = document.createElement('tr');
			table.appendChild(tr);
			createCell("ID", tr);
			createCell("Film Name", tr);
			createCell("Film Genre", tr);
			createCell("Year", tr);
			createCell("Delete:", tr);
			createCell("Update:", tr);
		
			/*draw rows from array */
			for(let note of notes) {
				tr = document.createElement('tr');
				table.appendChild(tr);
				
				createCell(note.id, tr);
				createCell(note.name, tr);
				createCell(note.genre, tr);
				createCell(note.year, tr);
				createCell("<a href='/spring-mvc/films/remove-film/"+note.id +"' class='simple-button'" + ">Remove</a>",tr);
				createCell("<a href='/spring-mvc/films/update-film/"+note.id +"' class='simple-button'" + ">Update</a>",tr);
			
			}
			
		}
	}());

	let items = [];
	for (let i = 1; i <= countOfItems; i++) {
		let li = document.createElement('li');
		li.innerHTML = i;
		pagination.appendChild(li);
		items.push(li);
	}

	showPage(items[0]);

	for(let item of items) {
		item.addEventListener('click', function() {
			showPage(this);
		});
	}

	function createCell(text, tr) {
		let td = document.createElement('td');
		td.innerHTML = text;
		tr.appendChild(td);
	}

	</script>
</body>
</html>