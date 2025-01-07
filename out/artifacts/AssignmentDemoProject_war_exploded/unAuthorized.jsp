<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Unauthorized Access</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #f44336;
            font-size: 48px;
        }
        p {
            font-size: 24px;
            color: #333;
        }
        .back-link {
            margin-top: 30px;
        }
        .back-link a {
            font-size: 18px;
            color: #4CAF50;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h1>You Are Not Authorized</h1>
<p>You do not have permission to access this page.</p>

<div class="back-link">
    <p><a href="profilePage.jsp">Go back to Home</a></p>
</div>

</body>
</html>
