package controller;

import DB.DBManager;
import entity.Role;
import entity.User;
import entity.UserRole;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();
        request.setAttribute("allRole", allRole);

        request.getRequestDispatcher("JSP/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String RoleId = request.getParameter("RoleId");

        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();



        if (login.isEmpty() || password.isEmpty() || RoleId.isEmpty()) {
            request.setAttribute("errorEmpty", 1);
            request.setAttribute("login", login);
            request.setAttribute("password", password);
            request.setAttribute("allRole", allRole);

            request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
        }


            if (manager.isLogin(login, password, RoleId)) {
                UserRole userFull = manager.getUserFull(login, RoleId);

                request.getSession().setAttribute("isLogin", 1);
                request.getSession().setAttribute("RoleId", RoleId);
                request.getSession().setAttribute("RoleName", userFull.getName());
                request.getSession().setAttribute("FirstName", userFull.getFirstName());
                request.getSession().setAttribute("LastName", userFull.getLastName());

                response.sendRedirect("/home");
            } else {

                request.setAttribute("errorLogin", 1);
                request.setAttribute("allRole", allRole);
                request.getRequestDispatcher("JSP/login.jsp").forward(request, response);

            }
        }
    }

