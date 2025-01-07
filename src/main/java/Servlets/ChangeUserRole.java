package Servlets;

import UtilsDao.UserDao;
import Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUserRole extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from the form
        int userId = Integer.parseInt(request.getParameter("userId"));
        String newRole = request.getParameter("newRole");

        // Create UserDao object
        UserDao userDao = new UserDao();

        // Update the user's role
        boolean isUpdated = userDao.changeUserRole(userId, newRole);

        response.sendRedirect("updateSuccessfull.jsp");



    }
}
