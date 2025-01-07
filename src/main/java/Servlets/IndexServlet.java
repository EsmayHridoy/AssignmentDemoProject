package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loginType = request.getParameter("loginType");
        if("Registration".equals(loginType)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/registrationForm.jsp");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/loginPage.jsp");
            dispatcher.forward(request, response);
        }

    }
}
