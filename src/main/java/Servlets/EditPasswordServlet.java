package Servlets;

import Model.UserModel;
import UtilsDao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EditPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");

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

        String curPass = (String) session.getAttribute("userPassword");
        String hashedCurrentPassword = hashPassword(currentPassword);

        UserDao userDao = new UserDao();
        if(curPass.equals(hashedCurrentPassword) && newPassword.equals(confirmNewPassword)){
            String hashedNewPassword = hashPassword(newPassword);
            session.setAttribute("userPassword",hashedNewPassword);
            boolean isUpdated = userDao.updateUserPassword(userMail, hashedNewPassword);
            if (isUpdated) {
                response.getWriter().println("Password updated successfully");
                response.sendRedirect("profilePage.jsp");
            } else {
                response.getWriter().println("Error updating password");
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


