package Servlets;

import UtilsDao.BookDao;
import Model.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        List<BookModel> bookList = bookDao.getAllBooks();
        System.out.println(bookList.size());
        if (bookList != null) {
            request.setAttribute("bookList", bookList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("showBooks.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Error retrieving book list.");
        }
    }
}
