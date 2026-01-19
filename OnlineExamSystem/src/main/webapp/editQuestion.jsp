<%@ page import="com.ajay.dto.Question" %>
<%
    Question q = (Question) request.getAttribute("question");
    int id = Integer.parseInt(request.getParameter("id"));
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Question</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

<style>
* {
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body {
    background: linear-gradient(135deg, #667eea, #764ba2);
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 20px;
}

.card {
    background: #fff;
    width: 100%;
    max-width: 600px;
    padding: 35px;
    border-radius: 20px;
    box-shadow: 0 25px 50px rgba(0,0,0,0.15);
    animation: fadeIn 0.6s ease;
}

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(20px); }
    to { opacity: 1; transform: translateY(0); }
}

h3 {
    text-align: center;
    margin-bottom: 25px;
    color: #333;
    font-weight: 600;
}

label {
    display: block;
    margin-bottom: 6px;
    color: #555;
    font-size: 14px;
}

textarea, input[type="text"], select {
    width: 100%;
    padding: 12px 16px;
    border-radius: 12px;
    border: 1px solid #ddd;
    margin-bottom: 18px;
    font-size: 14px;
    transition: 0.3s;
}

textarea {
    resize: none;
}

textarea:focus, input:focus, select:focus {
    outline: none;
    border-color: #667eea;
    box-shadow: 0 0 0 4px rgba(102,126,234,0.15);
}

.btn {
    width: 100%;
    padding: 14px;
    border: none;
    border-radius: 50px;
    background: linear-gradient(90deg, #667eea, #764ba2);
    color: #fff;
    font-size: 16px;
    font-weight: 600;
    cursor: pointer;
    transition: 0.3s;
}

.btn:hover {
    transform: translateY(-2px);
    box-shadow: 0 12px 25px rgba(0,0,0,0.2);
}

.back {
    display: block;
    text-align: center;
    margin-top: 18px;
    text-decoration: none;
    color: #667eea;
    font-size: 14px;
}

.back:hover {
    text-decoration: underline;
}
</style>
</head>

<body>

<div class="card">
    <h3>Edit Question</h3>

    <form action="editQuestion" method="post">

        <input type="hidden" name="id" value="<%= id %>">

        <label>Question</label>
        <textarea name="question" rows="3" required></textarea>

        <label>Option 1</label>
        <input type="text" name="option1" value="" required>

        <label>Option 2</label>
        <input type="text" name="option2" value="" required>

        <label>Option 3</label>
        <input type="text" name="option3" value="" required>

        <label>Option 4</label>
        <input type="text" name="option4" value="" required>

        <label>Correct Option</label>
        <select name="correct">
            <option value="1">Option 1</option>
            <option value="2">Option 2</option>
            <option value="3">Option 3</option>
            <option value="4">Option 4</option>
        </select>

        <button type="submit" class="btn">Update Question</button>
    </form>

    <a href="admin" class="back"> Back to Admin Panel</a>
</div>

</body>
</html>