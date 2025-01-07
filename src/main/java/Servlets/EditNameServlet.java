package Servlets;

import Model.UserModel;
import UtilsDao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EditNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String newName = request.getParameter("newName");
        String confirmPassword = request.getParameter("confirmPassword");


        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userMail = (String) session.getAttribute("userMail");


        if (userMail == null) {
            response.sendRedirect("login.jsp");
            return;
        }






        UserDao userDao = new UserDao();
        String curPass = (String) session.getAttribute("userPassword");

        String hashedConfirmPassword = hashPassword(confirmPassword);

        System.out.println("Hashed Password from form: " + hashedConfirmPassword);
        System.out.println("Stored Password in DB: " + curPass);
        if (curPass.equals(hashedConfirmPassword)) {

            boolean isUpdated = userDao.updateUserName(userMail, newName);

            session.setAttribute("userName",newName);
            if (isUpdated) {
                response.getWriter().println("Name updated successfully");
                response.sendRedirect("profilePage.jsp");
            } else {
                response.getWriter().println("Error updating name");
            }
        } else {
            // Password does not match
            response.getWriter().println("Incorrect password");
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


