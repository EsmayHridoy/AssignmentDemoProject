package Servlets;

import Model.UserModel;
import UtilsDao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userMail = request.getParameter("userMail");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userRole = request.getParameter("userRole");


        String hashedPassword = hashPassword(userPassword);

        UserModel user
                = new UserModel(userId, userMail, userName, hashedPassword, userRole);

        UserDao userDao = new UserDao();

        if(userDao.addUser(user)){
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("loginPage.jsp");
        }
        else{
            response.getWriter().println("Registration Unsuccessful");
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
