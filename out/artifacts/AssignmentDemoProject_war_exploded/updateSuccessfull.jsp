<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 100%;
            max-width: 500px;
            text-align: center;
        }

        h2 {
            color: #4CAF50;
            font-size: 24px;
            margin-bottom: 20px;
        }

        p {
            color: #333;
            font-size: 16px;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
        }

        a:hover {
            background-color: #45a049;
        }

        .message {
            margin-bottom: 20px;
            font-size: 18px;
            color: #555;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Update Successful!</h2>
    <p class="message">The user role has been updated successfully.</p>
    <div>
        <a href="profilePage.jsp">Go back to Profile</a>
    </div>
</div>

</body>
</html>
