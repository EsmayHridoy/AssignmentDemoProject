package Servlets;

import Model.UserModel;
import UtilsDao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginServlet extends HttpServlet {


    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userMail = request.getParameter("userMail");
        String userPassword = request.getParameter("userPassword");

        try {

            String hashedPassword = hashPassword(userPassword);


            UserDao userDao = new UserDao();
            UserModel user = userDao.authenticateUser(userMail, hashedPassword);

            if (user != null) {

                HttpSession session = request.getSession();
                session.setAttribute("userMail", user.getUserMail());
                session.setAttribute("userRole", user.getUserRole());
                session.setAttribute("userName", user.getUserName());
                session.setAttribute("userPassword",user.getUserPassword());
                RequestDispatcher dispatcher = request.getRequestDispatcher("profilePage.jsp");
                dispatcher.forward(request, response);

            } else {

                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while processing password.");
        }
    }
}
