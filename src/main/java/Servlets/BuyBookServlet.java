package Servlets;

import UtilsDao.BookDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BuyBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the book ID from the request parameter
        String bookIdStr = request.getParameter("bookId");

        if (bookIdStr != null && !bookIdStr.isEmpty()) {
            try {
                int bookId = Integer.parseInt(bookIdStr);

                // Call the DAO to decrement the book count
                BookDao bookDao = new BookDao();
                boolean success = bookDao.decrementBookCount(bookId);

                // Show success or failure message
                if (success) {
                    response.sendRedirect("purchaseSuccess.jsp");
                } else {
                    response.sendRedirect("purchaseFailure.jsp");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid Book ID.");
            }
        } else {
            response.sendRedirect("purchaseFailure.jsp");
        }
    }
}
