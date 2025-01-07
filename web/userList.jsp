<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List, Model.UserModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .no-users {
            text-align: center;
            font-size: 18px;
            color: #f44336;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
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

<h2>User List</h2>

<table>
    <thead>
    <tr>
        <th>User ID</th>
        <th>Email</th>
        <th>Name</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Retrieve the user list from request attributes
        List<UserModel> userList = (List<UserModel>) request.getAttribute("userList");
        if (userList != null && !userList.isEmpty()) {
            for (UserModel user : userList) {
    %>
    <tr>
        <td><%= user.getUserId() %></td>
        <td><%= user.getUserMail() %></td>
        <td><%= user.getUserName() %></td>
        <td><%= user.getUserRole() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4" class="no-users">No users available</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<!-- Back Link Section -->
<div class="back-link">
    <p><a href="profilePage.jsp">Go back to Home</a></p>
</div>

</body>
</html>
