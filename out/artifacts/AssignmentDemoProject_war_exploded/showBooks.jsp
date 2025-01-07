<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List, Model.BookModel" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            color: #333;
        }

        h2 {
            text-align: center;
            color: #007bff;
            margin-top: 20px;
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #ffffff;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #dee2e6;
        }

        th {
            background-color: #007bff;
            color: #ffffff;
        }

        tbody tr:nth-child(odd) {
            background-color: #f1f3f5;
        }

        tbody tr:hover {
            background-color: #e9ecef;
        }

        .container {
            width: 90%;
            margin: 20px auto;
            text-align: center;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #ffffff;
        }

        label {
            font-weight: bold;
        }

        input, button {
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ced4da;
            border-radius: 4px;
            font-size: 16px;
        }

        button {
            background-color: #007bff;
            color: #ffffff;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        p {
            margin: 0 0 10px 0;
            color: #555;
        }
    </style>
</head>
<body>
<h2>Available Books</h2>
<table>
    <thead>
    <tr>
        <th>Book ID</th>
        <th>Book Title</th>
        <th>Book Author</th>
        <th>Price</th>
        <th>Available Amount</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Retrieve the list of books from the request
        List<BookModel> bookList = (List<BookModel>) request.getAttribute("bookList");
        if (bookList != null) {
            for (BookModel book : bookList) {
    %>
    <tr>
        <td><%= book.getBookId() %></td>
        <td><%= book.getBookName() %></td>
        <td><%= book.getBookAuthor() %></td>
        <td><%= book.getBookPrice() %></td>
        <td><%= book.getBookCount() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5" style="text-align: center;">No books available</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<!-- Buy Book Section -->
<div class="container">
    <h2>Buy a Book</h2>
    <p>Enter the Book ID below to buy a book:</p>
    <form action="buyBook" method="get">
        <label for="bookId">Book ID:</label>
        <input type="number" id="bookId" name="bookId" required>
        <button type="submit">Buy Book</button>
    </form>
</div>




<!-- Add Book Section -->
<div class="container">
    <h2>Add Book</h2>
    <form action="AddBookServlet" method="post">
        <label for="bookId">Book Id:</label>
        <input type="text" id="bookId" name="bookId" required>
        <label for="bookTitle">Book Title:</label>
        <input type="text" id="bookTitle" name="bookTitle" required>
        <label for="bookAuthor">Book Author:</label>
        <input type="text" id="bookAuthor" name="bookAuthor" required>
        <label for="bookPrice">Book Price:</label>
        <input type="text" id="bookPrice" name="bookPrice" required>
        <label for="bookCount">Book Amount:</label>
        <input type="number" id="bookCount" name="bookCount" required>
        <button type="submit">Add Book</button>
    </form>
</div>

<!-- Edit Book Price Section -->
<div class="container">
    <h2>Edit Book Price</h2>
    <form action="editBookPrice" method="post">
        <label for="bookId">Book Id:</label>
        <input type="text" id="bookId" name="bookId" required>
        <label for="updatedPrice">Updated Price:</label>
        <input type="text" id="updatedPrice" name="updatedPrice" required>
        <button type="submit">Update Price</button>
    </form>
</div>
</body>
</html>
