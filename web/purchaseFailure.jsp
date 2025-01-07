<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Purchase Failed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }
        .message {
            background-color: #f44336;
            color: white;
            padding: 20px;
            border-radius: 5px;
            font-size: 20px;
        }
        .back-link {
            margin-top: 20px;
            font-size: 18px;
        }
        a {
            color: #f44336;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="message">
    <h2>Sorry!</h2>
    <p>The purchase could not be completed.</p>
    <p>Please check the item availability or try again later.</p>
</div>

<div class="back-link">
    <p><a href="profilePage.jsp">Go back to Home</a></p>
</div>
</body>
</html>
