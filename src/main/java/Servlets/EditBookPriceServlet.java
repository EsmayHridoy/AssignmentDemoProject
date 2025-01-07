package Servlets;

import UtilsDao.BookDao;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class EditBookPriceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("bookId");
        String updatedPrice = request.getParameter("updatedPrice");


        if (bookId != null && !bookId.isEmpty() && updatedPrice != null && !updatedPrice.isEmpty()) {
            try {

                int bookIdInt = Integer.parseInt(bookId);
                double updatedPriceDouble = Double.parseDouble(updatedPrice);


                BookDao bookDao = new BookDao();
                boolean isUpdated = bookDao.updateBookPrice(bookIdInt, updatedPriceDouble);

                if (isUpdated) {
                    response.sendRedirect("profile.jsp?message=Price+updated+successfully");
                } else {

                    response.sendRedirect("profile.jsp?message=Error+updating+price");
                }
            } catch (NumberFormatException e) {

                response.sendRedirect("profile.jsp?message=Invalid+input");
            }
        } else {
            response.sendRedirect("profile.jsp?message=All+fields+are+required");
        }
    }
}
