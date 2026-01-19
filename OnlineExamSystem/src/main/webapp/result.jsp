<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exam Result</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        /* Global Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Card Container */
        .result-card {
            background: #fff;
            padding: 40px 30px;
            border-radius: 15px;
            box-shadow: 0 15px 25px rgba(0,0,0,0.2);
            text-align: center;
            max-width: 400px;
            width: 100%;
            animation: fadeIn 1s ease-in-out;
        }

        /* Title */
        h2 {
            color: #333;
            margin-bottom: 20px;
            font-size: 28px;
        }

        /* Result Text */
        p {
            font-size: 18px;
            color: #555;
            margin-bottom: 30px;
        }

        p b {
            color: #2575fc;
        }

        /* Logout Button */
        .logout-btn {
            display: inline-block;
            padding: 12px 25px;
            border-radius: 50px;
            background: linear-gradient(90deg, #2575fc, #6a11cb);
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            transition: 0.3s;
        }

        .logout-btn:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }

        /* Fade In Animation */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px);}
            to { opacity: 1; transform: translateY(0);}
        }

        /* Responsive */
        @media (max-width: 500px) {
            .result-card {
                padding: 30px 20px;
            }

            h2 {
                font-size: 24px;
            }

            p {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>

<div class="result-card">
    <h2>Exam Result</h2>
    <p>
        <b>Total Questions:</b> ${total}<br>
        <b>Your Score:</b> ${score}
    </p>
    <a href="login.html" class="logout-btn">Logout</a>
</div>

</body>
</html>
