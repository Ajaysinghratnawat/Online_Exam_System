<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ajay.dto.Question"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Examination</title>

<style>
    * {
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        margin: 0;
        background: linear-gradient(135deg, #667eea, #764ba2);
        min-height: 100vh;
        padding: 30px 0;
    }

    .exam-container {
        width: 70%;
        margin: auto;
        background: white;
        border-radius: 12px;
        padding: 30px 40px;
        box-shadow: 0 15px 35px rgba(0,0,0,0.25);
    }

    .exam-header {
        text-align: center;
        margin-bottom: 30px;
    }

    .exam-header h2 {
        margin: 0;
        font-size: 28px;
        color: #333;
    }

    .exam-header p {
        color: #666;
        margin-top: 8px;
    }

    .question-card {
        background: #f9f9f9;
        padding: 20px;
        border-radius: 10px;
        margin-bottom: 25px;
        border-left: 5px solid #667eea;
    }

    .question-card b {
        font-size: 16px;
        color: #333;
    }

    .options {
        margin-top: 15px;
    }

    .option {
        display: flex;
        align-items: center;
        background: white;
        padding: 10px 15px;
        margin-bottom: 10px;
        border-radius: 8px;
        border: 1px solid #ddd;
        cursor: pointer;
        transition: 0.3s;
    }

    .option:hover {
        background: #eef1ff;
        border-color: #667eea;
    }

    .option input {
        margin-right: 12px;
        cursor: pointer;
    }

    .submit-btn {
        display: block;
        margin: 40px auto 10px;
        padding: 14px 50px;
        background: #ff4b2b;
        color: white;
        border: none;
        border-radius: 30px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
    }

    .submit-btn:hover {
        background: #e63e22;
        transform: translateY(-2px);
        box-shadow: 0 10px 20px rgba(0,0,0,0.2);
    }

    @media (max-width: 768px) {
        .exam-container {
            width: 90%;
            padding: 20px;
        }
    }
</style>
</head>

<body>

<div class="exam-container">

    <div class="exam-header">
        <h2>📝 Online Examination</h2>
        <p>Answer all questions carefully before submitting</p>
    </div>

    <form action="exam" method="post">

    <%
        List<Question> questions = (List<Question>) request.getAttribute("questions");
        int count = 1;
        for (Question q : questions) {
    %>

        <div class="question-card">
            <b>Q<%= count++ %>. <%= q.getQuestion() %></b>

            <div class="options">
                <label class="option">
                    <input type="radio" name="q<%= q.getqId() %>" value="1" required>
                    <%= q.getOption1() %>
                </label>

                <label class="option">
                    <input type="radio" name="q<%= q.getqId() %>" value="2">
                    <%= q.getOption2() %>
                </label>

                <label class="option">
                    <input type="radio" name="q<%= q.getqId() %>" value="3">
                    <%= q.getOption3() %>
                </label>

                <label class="option">
                    <input type="radio" name="q<%= q.getqId() %>" value="4">
                    <%= q.getOption4() %>
                </label>
            </div>
        </div>

    <%
        }
    %>

        <input type="submit" value="Submit Exam" class="submit-btn">

    </form>

</div>

</body>
</html>
