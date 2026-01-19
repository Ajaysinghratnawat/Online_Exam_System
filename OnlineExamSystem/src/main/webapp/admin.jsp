<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ajay.dto.Question"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Panel - Online Examination System</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">
<style>
/* Global Styles */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Roboto', sans-serif;
}

body {
	background: #f4f7f9;
	padding: 30px;
}

h2, h3 {
	color: #333;
}

h2 {
	text-align: center;
	margin-bottom: 40px;
}

/* Form Card */
.card {
	background: #fff;
	padding: 30px;
	border-radius: 15px;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
	margin-bottom: 40px;
}

label {
	font-weight: 500;
	margin-top: 10px;
	display: block;
	color: #555;
}

textarea, input[type="text"], select {
	width: 100%;
	padding: 12px 15px;
	margin-top: 5px;
	margin-bottom: 15px;
	border-radius: 50px;
	border: 1px solid #ddd;
	font-size: 16px;
	transition: 0.3s;
}

textarea:focus, input[type="text"]:focus, select:focus {
	outline: none;
	border-color: #2575fc;
	box-shadow: 0 0 8px rgba(37, 117, 252, 0.2);
}

.btn {
	padding: 12px 30px;
	background: linear-gradient(90deg, #2575fc, #6a11cb);
	border: none;
	border-radius: 50px;
	color: #fff;
	font-weight: 700;
	cursor: pointer;
	transition: 0.3s;
	font-size: 16px;
}

.btn:hover {
	transform: scale(1.05);
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
}

/* Table */
table {
	width: 100%;
	border-collapse: collapse;
	background: #fff;
	border-radius: 15px;
	overflow: hidden;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.05);
}

th, td {
	padding: 15px;
	text-align: left;
}

th {
	background: #2575fc;
	color: #fff;
}

tr:nth-child(even) {
	background: #f9f9f9;
}

tr:hover {
	background: #e6f0ff;
}

@media ( max-width : 768px) {
	body {
		padding: 20px;
	}
	.card {
		padding: 20px;
	}
	th, td {
		padding: 12px;
	}
}
</style>
</head>
<body>

	<h2>Admin Panel - Online Examination System</h2>

	<!-- ADD QUESTION FORM -->
	<div class="card">
		<h3>Add New Question</h3>
		<form action="addQuestion" method="post">
			<label>Question:</label>
			<textarea name="question" rows="3" required></textarea>

			<label>Option 1:</label> <input type="text" name="option1" required>

			<label>Option 2:</label> <input type="text" name="option2" required>

			<label>Option 3:</label> <input type="text" name="option3" required>

			<label>Option 4:</label> <input type="text" name="option4" required>

			<label>Correct Option:</label> <select name="correct">
				<option value="1">Option 1</option>
				<option value="2">Option 2</option>
				<option value="3">Option 3</option>
				<option value="4">Option 4</option>
			</select>

			<button type="submit" class="btn">Add Question</button>
		</form>
	</div>

	<!-- VIEW QUESTIONS -->
	<div class="card">
		<h3>All Questions</h3>
		<table>
			<tr>
				<!-- <th>ID</th> -->
				<th>Question</th>
				<th>Correct Option</th>
			</tr>
			<%
			List<Question> list = (List<Question>) request.getAttribute("questions");
			if (list != null) {
				for (Question q : list) {
			%>
			<tr>
				<%-- <%int id = q.getqId();
				ServletContext ctx = request.getServletContext();
				ctx.setAttribute("id", id);
				%> --%>
				<%-- <td><%=q.getqId()%></td> --%>
				<td><%=q.getQuestion()%></td>
				<td>Option <%=q.getCorrectOption()%></td>
				<td>
					<form action="editQuestion.jsp" method="get" style="display:inline;">
    					<input type="hidden" name="id" value="<%=q.getqId()%>">
    					<button type="submit" class="btn">Edit</button>
					</form>
					
					<form action="./DeleteQuestion" method="get" style="display:inline;">
    					<input type="hidden" name="id" value="<%=q.getqId()%>">
    					<button type="submit" class="btn">Delete</button>
					</form>
				</td>
			</tr>
			<%
			}
			}
			%>
		</table>
	</div>

</body>
</html>
