<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f7fa;
        }

        header {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        header h1 {
            margin: 0;
            font-size: 24px;
        }

        header form button {
            background-color: white;
            color: #007bff;
            border: none;
            padding: 8px 12px;
            border-radius: 4px;
            cursor: pointer;
        }

        header form button:hover {
            background-color: #0056b3;
            color: white;
        }

        main {
            padding: 20px;
        }

        .section {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .section h2 {
            margin-bottom: 15px;
            font-size: 20px;
            color: #333;
        }

        .section p {
            margin-bottom: 15px;
            color: #555;
        }

        .section form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .section form label {
            font-weight: bold;
            color: #555;
        }

        .section form input {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        .section form button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        .section form button:hover {
            background-color: #0056b3;
        }

        @media (max-width: 768px) {
            header, main {
                padding: 10px;
            }

            .section {
                padding: 15px;
            }

            .section form {
                gap: 8px;
            }
        }
    </style>
</head>
<body>

<header>
    <h1>Profile Page</h1>
    <form action="logout" method="post">
        <button type="submit">Logout</button>
    </form>
</header>

<main>
    <!-- Welcome Section -->
    <div class="section">
        <h2>Welcome</h2>
        <p>Hello, ${sessionScope.userName} (${sessionScope.userRole})</p>
    </div>

    <!-- Edit Name Section -->
    <div class="section">
        <h2>Edit Name</h2>
        <form action="editName" method="post">
            <label for="newName">New Name:</label>
            <input type="text" id="newName" name="newName" required>
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
            <button type="submit">Submit</button>
        </form>
    </div>

    <!-- Edit Password Section -->
    <div class="section">
        <h2>Edit Password</h2>
        <form action="editPassword" method="post">
            <label for="currentPassword">Current Password:</label>
            <input type="password" id="currentPassword" name="currentPassword" required>
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>
            <label for="confirmNewPassword">Confirm New Password:</label>
            <input type="password" id="confirmNewPassword" name="confirmNewPassword" required>
            <button type="submit">Submit</button>
        </form>
    </div>

    <!-- Purchase History Section -->
    <div class="section">
        <h2>Purchase History</h2>
        <p>Your purchase history will be displayed here.</p>
        <form action="viewPurchaseHistory" method="get">
            <button type="submit">View History</button>
        </form>
    </div>

    <!-- Buy Book Section -->
    <div class="section">
        <h2>Show Book List</h2>
        <form action="showBook" method="get">
            <button type="submit">Buy Book</button>
        </form>
    </div>



    <!-- User List Section -->
    <div class="section">
        <h2>User List</h2>
        <form action="ShowUserListServlet" method="get">
            <button type="submit">View User List</button>
        </form>
    </div>

    <!-- Change User Role Section -->
    <div class="section">
        <h2>Change User Role</h2>
        <form action="changeUserRole" method="post">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required>
            <label for="newRole">New Role:</label>
            <input type="text" id="newRole" name="newRole" required>
            <button type="submit">Change Role</button>
        </form>
    </div>
</main>

</body>
</html>
