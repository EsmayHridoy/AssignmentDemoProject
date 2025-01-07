package Servlets;

import UtilsDao.BookDao;
import Model.BookModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String bookId = request.getParameter("bookId");
        String bookTitle = request.getParameter("bookTitle");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookPrice = request.getParameter("bookPrice");
        String bookCount = request.getParameter("bookCount");


        if (bookId == null || bookTitle == null || bookAuthor == null || bookPrice == null || bookCount == null ||
                bookId.isEmpty() || bookTitle.isEmpty() || bookAuthor.isEmpty() || bookPrice.isEmpty() || bookCount.isEmpty()) {
            response.getWriter().println("All fields are required.");
            return;
        }

        try {

            double price = Double.parseDouble(bookPrice);
            int cnt = Integer.parseInt(bookCount);
            int id = Integer.parseInt(bookId);

            BookModel newBook = new BookModel(id, bookTitle, bookAuthor, price, cnt);


            BookDao bookDao = new BookDao();
            boolean isAdded = bookDao.addBook(newBook);

            if (isAdded) {
                response.getWriter().println("Book added successfully!");
                response.sendRedirect("profilePage.jsp");

            } else {
                response.getWriter().println("Failed to add the book. Please try again.");
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid price or amount. Please enter valid numbers.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while adding the book.");
        }
    }
}
