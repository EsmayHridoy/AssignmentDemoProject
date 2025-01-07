package Servlets;

import Model.UserModel;
import UtilsDao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession();
        String userMail = (String) session.getAttribute("userMail");

        if (userMail == null) {
            response.sendRedirect("login.jsp");
            return;
        }


        UserDao userDao = new UserDao();
        UserModel user = userDao.getUserByEmail(userMail);




        request.setAttribute("userName", user.getUserName());
        request.setAttribute("userRole", user.getUserRole());


        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}
