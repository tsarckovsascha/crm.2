package controller;

import DB.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import entity.Role;
import entity.User;
import entity.UserRole;
import funfactions.Functions;

@WebServlet(name = "RegistrationController", value = "/registration")
public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();
        request.setAttribute("allRole", allRole);
        request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager manager = new DBManager();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        String roleId = request.getParameter("roleId");

        ArrayList<Role> allRole = manager.getAllRole();
        request.setAttribute("allRole", allRole);
        ArrayList<User> getLogin = manager.getLogins();


        if (Functions.loginMatch(login)) {

            if (firstName.isEmpty() || lastName.isEmpty() || login.isEmpty() || password.isEmpty()) {
                request.setAttribute("error", 1);
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("login", login);
                request.setAttribute("password", password);
                request.setAttribute("id", id);
                request.setAttribute("roleId", roleId);

                request.getRequestDispatcher("JSP/registration.jsp").forward(request, response);

            }
            manager.addUser(login, password, lastName, firstName);
            User getUserId = manager.getUserId(login);
            String userId = String.valueOf(getUserId.getId());
            manager.addIds(roleId, userId);

            response.sendRedirect("/login");

        }
    }
}

