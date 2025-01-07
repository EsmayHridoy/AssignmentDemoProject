<%--
  Created by IntelliJ IDEA.
  User: divineit
  Date: 12/26/24
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        .form-container h1 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
            text-align: center;
        }
        .form-container label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        .form-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Registration Form</h1>
    <form action="RegistrationServlet" method="post">
        <label for="userId">User ID:</label>
        <input type="number" id="userId" name="userId" required>

        <label for="userMail">User Email:</label>
        <input type="email" id="userMail" name="userMail" required>

        <label for="userName">User Name:</label>
        <input type="text" id="userName" name="userName" required>

        <label for="userPassword">Password:</label>
        <input type="password" id="userPassword" name="userPassword" required>

        <button type="submit" id="userRole" name="userRole" value="General">Submit</button>
    </form>
</div>
</body>
</html>
