package Servlets;

import Model.UserModel;
import UtilsDao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowUserListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<UserModel> userList = userDao.getAllUsers();

        if (userList != null) {
            request.setAttribute("userList", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Error retrieving user list.");
        }
    }
}
