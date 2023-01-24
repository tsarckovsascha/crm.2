package controller;

import DB.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationController", value = "/registration")
public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (firstName.isEmpty() || lastName.isEmpty() || login.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", 1);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("login", login);
            request.setAttribute("password", password);


            request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);

        }
        DBManager manager = new DBManager();
        manager.registration(firstName, lastName, login, password);

        response.sendRedirect("/login");
    }
}

